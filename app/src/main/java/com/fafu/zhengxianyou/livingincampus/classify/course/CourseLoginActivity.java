package com.fafu.zhengxianyou.livingincampus.classify.course;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;

import com.fafu.zhengxianyou.livingincampus.R;
import com.fafu.zhengxianyou.livingincampus.bean.Score;
import com.fafu.zhengxianyou.livingincampus.config.Config;
import com.fafu.zhengxianyou.livingincampus.constant.Constants;
import com.fafu.zhengxianyou.livingincampus.utils.JsoupUtil;
import com.fafu.zhengxianyou.livingincampus.utils.OkHttpUtil;
import com.fafu.zhengxianyou.livingincampus.utils.Utils;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Calendar;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import okhttp3.Call;

import static com.fafu.zhengxianyou.livingincampus.app.MyApplication.editor;

public class CourseLoginActivity extends Activity implements View.OnClickListener{
    private static final String TAG = CourseLoginActivity.class.getSimpleName();
    private EditText et_userName, et_passWord, et_inputVerificationCode;
    private Button login;
    private ImageView iv_VerificationCode, iv_reload;
    private Spinner sp_school_year, sp_term;
    private String[] year = new String[6];
    private String[] term = {1 + "", 2 + ""};
    private static String selectedYear, selectedTerm;
    private ArrayAdapter<String> yearAdapter, termAdapter;

    /**
     * 要查询的信息的类型
     */
    private int type = Constants.SEARCH_SCHEDULE;
    /**
     * 验证码图片数据
     */
    private byte[] verificationCode;
    /**
     * 登录状态
     */
    private static boolean isLogin = false;
    /**
     * 学生姓名
     */
    private String studentName;
    /**
     * url编码的学生姓名
     */
    private static String urlEncodeStudentName = null;
    /**
     * 登录的用户名， 即学号
     */
    private static String userName;
    /**
     * 用于存放请求头和请求参数
     */
    private static Map<String, String> requestHeadersMap, loginRequestBodyMap, scheduleRequestBodyMap, scoreRequestBodyMap;

    /**
     * 通过调用这个方法启动CourseLoginActivity
     */
    public static void actionStart(Context context, int type) {
        Intent intent = new Intent(context,CourseLoginActivity.class);
        intent.putExtra("type", type);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_course);

        initIntent();
        initView();
        reload();
        initRequestData();

    }

    private void initIntent() {
        Intent intent = getIntent();
        type = intent.getIntExtra("type", 1);
    }

    /**
     * 初始化View
     */
    private void initView() {
        et_userName = (EditText) findViewById(R.id.username);
        et_passWord = (EditText) findViewById(R.id.password);
        et_inputVerificationCode = (EditText) findViewById(R.id.et_inputVerificationCode);

        login = (Button) findViewById(R.id.login);

        iv_VerificationCode = (ImageView) findViewById(R.id.iv_VerificationCode);
        iv_reload = (ImageView) findViewById(R.id.iv_reload);

        sp_school_year = (Spinner) findViewById(R.id.sp_school_year);
        sp_term = (Spinner) findViewById(R.id.sp_term);

        setTime();
        login.setOnClickListener(this);
        iv_reload.setOnClickListener(this);
    }

    /**
     * 设置查询的学年学期
     */
    private void setTime() {
        Calendar calendar = Calendar.getInstance();
        int y = calendar.get(Calendar.YEAR);
        int m = calendar.get(Calendar.MONTH);

        if (m > 8) {
            year[0] = "" + y + "-" + y + 1;
            for (int i = 1; i < 6; i++) {
                year[i] = y - i + "-" + (y - i + 1) + "";
            }
        } else {
            for (int i = 0; i < 6; i++) {
              String str  = y - i - 1 + "-" + (y - i) + "";
                year[i] = str;
            }
        }

        yearAdapter = new ArrayAdapter<>(this, R.layout.item_spinner, year);
        termAdapter = new ArrayAdapter<>(this, R.layout.item_spinner, term);
        yearAdapter.setDropDownViewResource(R.layout.item_spinner);
        termAdapter.setDropDownViewResource(R.layout.item_spinner);
        sp_school_year.setAdapter(yearAdapter);
        sp_term.setAdapter(termAdapter);

        /**
         * 设置Spinner点击事件
         */
        sp_school_year.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                selectedYear = year[position];
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                selectedYear = year[0];
            }
        });

        sp_term.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                selectedTerm = term[position];
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                selectedTerm = term[0];
            }
        });

    }

    /**
     * 初始化请求需要的工具
     */
    private void initRequestData() {
        requestHeadersMap = new LinkedHashMap<>();
        loginRequestBodyMap = new LinkedHashMap<>(); // java 1.7 开始可以通过这种写法初始化集合
        scheduleRequestBodyMap = new LinkedHashMap<>();
        scoreRequestBodyMap = new LinkedHashMap<>();

        requestHeadersMap.put(Constants.HEADER_NAME_HOST, Constants.HEADER_VALUE_HOST);
        requestHeadersMap.put(Constants.HEADER_NAME_REFERER, Constants.HEADER_VALUE_REFERER);
        requestHeadersMap.put(Constants.HEADER_NAME_AGENT, Constants.HEADER_VALUE_AGENT);

        initLoginRequestBody();
        initScheduleRequestBody();
        initScoreRequestBody();
    }

    /**
     * 模拟登录
     */
    private void initLoginRequestBody() {
        OkHttpUtil.getAsync(Constants.EDUCATION_SYSTEM_LOGIN_URL, new OkHttpUtil.ResultCallback() {

            @Override
            public void onError(Call call, Exception e) {
                loginRequestBodyMap.put(Constants.LOGIN_BODY_NAME_VIEWSTATE, Constants.LOGIN_BODY_VALUE_VIEWSTATE);
                loginRequestBodyMap.put(Constants.LOGIN_BODY_NAME_VIEWSTATEGENERATOR, Constants.LOGIN_BODY_VALUE_VIEWSTATEGENERATOR);
            }

            @Override
            public void onResponse(byte[] response) {
                if (null == response) {
                    loginRequestBodyMap.put(Constants.LOGIN_BODY_NAME_VIEWSTATE, Constants.LOGIN_BODY_VALUE_VIEWSTATE);
                    loginRequestBodyMap.put(Constants.LOGIN_BODY_NAME_VIEWSTATEGENERATOR, Constants.LOGIN_BODY_VALUE_VIEWSTATEGENERATOR);
                }
                String result = null;
                String viewState = null;
                String viewStateGenerator = null;
                try {
                    result = new String(response, "gb2312");
                    Map<String, String> viewStateValue = JsoupUtil.getViewStateValue(result);
                    viewState = viewStateValue.get(Constants.LOGIN_BODY_NAME_VIEWSTATE);
                    viewStateGenerator = viewStateValue.get(Constants.LOGIN_BODY_NAME_VIEWSTATEGENERATOR);
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                } finally {
                    if (null != viewState) {
                        loginRequestBodyMap.put(Constants.LOGIN_BODY_NAME_VIEWSTATE, viewState);
                    } else {
                        loginRequestBodyMap.put(Constants.LOGIN_BODY_NAME_VIEWSTATE, Constants.LOGIN_BODY_VALUE_VIEWSTATE);
                    }
                    if (null != viewStateGenerator) {
                        loginRequestBodyMap.put(Constants.LOGIN_BODY_NAME_VIEWSTATEGENERATOR, viewStateGenerator);
                    } else {
                        loginRequestBodyMap.put(Constants.LOGIN_BODY_NAME_VIEWSTATEGENERATOR, Constants.LOGIN_BODY_VALUE_VIEWSTATEGENERATOR);
                    }
                }
            }
        });
        loginRequestBodyMap.put(Constants.LOGIN_BODY_NAME_BUTTON1, Constants.LOGIN_BODY_VALUE_BUTTON1);
        loginRequestBodyMap.put(Constants.LOGIN_BODY_NAME_HIDPDRS, Constants.LOGIN_BODY_VALUE_HIDPDRS);
        loginRequestBodyMap.put(Constants.LOGIN_BODY_NAME_HIDSC, Constants.LOGIN_BODY_VALUE_HIDSC);
        loginRequestBodyMap.put(Constants.LOGIN_BODY_NAME_LANGUAGE, Constants.LOGIN_BODY_VALUE_LANGUAGE);
        loginRequestBodyMap.put(Constants.LOGIN_BODY_NAME_TYPE, Constants.LOGIN_BODY_VALUE_TYPE);
    }

    /**
     * 获取课程表
     */
    private void initScheduleRequestBody() {
        scheduleRequestBodyMap.put(Constants.SCHEDULE_BODY_NAME_EVENTARGUMENT, Constants.SCHEDULE_BODY_VALUE_EVENTARGUMENT);
        scheduleRequestBodyMap.put(Constants.SCHEDULE_BODY_NAME_EVENTTARGET, Constants.SCHEDULE_BODY_VALUE_EVENTTARGET);
        scheduleRequestBodyMap.put(Constants.SCHEDULE_BODY_NAME_VIEWSTATE, Constants.SCHEDULE_BODY_VALUE_VIEWSTATE);
        scheduleRequestBodyMap.put(Constants.SCHEDULE_BODY_NAME_VIEWSTATEGENERATOR, Constants.SCHEDULE_BODY_VALUE_VIEWSTATEGENERATOR);
        scheduleRequestBodyMap.put(Constants.SCHEDULE_BODY_NAME_SCHOOLYEAR, selectedYear);
        scheduleRequestBodyMap.put(Constants.SCHEDULE_BODY_NAME_TERM, selectedTerm);
    }

    /**
     * 获取成绩
     */
    private void initScoreRequestBody() {
        scoreRequestBodyMap.put(Constants.SCORE_BODY_NAME_EVENTARGUMENT, Constants.SCORE_BODY_VALUE_EVENTARGUMENT);
        scoreRequestBodyMap.put(Constants.SCORE_BODY_NAME_EVENTTARGET, Constants.SCORE_BODY_VALUE_EVENTTARGET);
        scoreRequestBodyMap.put(Constants.SCORE_BODY_NAME_VIEWSTATE, Constants.SCORE_BODY_VALUE_VIEWSTATE);
        scoreRequestBodyMap.put(Constants.SCORE_BODY_NAME_VIEWSTATEGENERATOR, Constants.SCORE_BODY_VALUE_VIEWSTATEGENERATOR);
        scoreRequestBodyMap.put(Constants.SCORE_BODY_NAME_BTNCX, Constants.SCORE_BODY_VALUE_BTNCX);
        scoreRequestBodyMap.put(Constants.SCORE_BODY_NAME_SCHOOLYEAR, selectedYear);
        scoreRequestBodyMap.put(Constants.SCORE_BODY_NAME_TERM, selectedTerm);
    }

    /**
     * View点击事件
     * @param v
     */
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.login:
                login();
                break;
            case R.id.iv_reload:
                reload();
                break;
        }
    }

    /**
     * 刷新验证码
     */
    private void reload() {
        OkHttpUtil.getAsync(Constants.VERIFICATION_CODE_URL, new OkHttpUtil.ResultCallback() {
            @Override
            public void onError(Call call, Exception e) {
                verificationCode = null;
                setVerificationCodeBg();
            }

            @Override
            public void onResponse(byte[] response) {
                verificationCode = response;
                setVerificationCodeBg();
            }
        });
    }

    /**
     * 设置验证码图片
     */
    private void setVerificationCodeBg() {
        if (verificationCode != null && verificationCode.length > 0) {
            Bitmap bitmap = BitmapFactory.decodeByteArray(verificationCode, 0, verificationCode.length);
            Bitmap resizeBitmap = changeBitmapSize(bitmap, 140, 60);
            //iv_VerificationCode.setImageBitmap(resizeBitmap);
            iv_VerificationCode.setBackground(new BitmapDrawable(getResources(), resizeBitmap));
            verificationCode = null;
        } else {
            iv_VerificationCode.setBackgroundResource(R.drawable.loading_failed);
        }
    }

    /**
     * 用于改变验证码图片尺寸
     */
    private Bitmap changeBitmapSize(Bitmap bitmap,float width,float height) {
        int w = bitmap.getWidth();
        int h = bitmap.getHeight();
        Matrix matrix = new Matrix();
        float scaleX = (float) width / w;
        float scaleY = (float) height / h;
        matrix.postScale(scaleX, scaleY);
        Bitmap resizeBitmap = Bitmap.createBitmap(bitmap, 0, 0, w, h, matrix, true);
        return resizeBitmap;
    }

    /**
     * 通过解析post请求返回的数据，判断是否登录成功了
     */
    private void parseResponseFromLogin(byte[] response) {
        setLoginState(false);
        String result = null;
        String outputInfo = null;
        try {
            result = new String(response, "gb2312");
            Log.e("test", result);
            Map<String, String> returnInfo = JsoupUtil.getNameOrFailedInfo(result);
            studentName = returnInfo.get(Constants.STUDENTNAME);
            if (null != studentName) {
                // 将gb2312编码的学生姓名转为url编码的字符串
                urlEncodeStudentName = URLEncoder.encode(studentName, "gb2312");
                outputInfo = "登录成功";

                setLoginState(true);
            } else {
                String failedInfo = returnInfo.get(Constants.FAILEDINFO);
                if (null != failedInfo) {
                    outputInfo = failedInfo;
                } else {
                    outputInfo = "服务器错误，请重试!";
                }
            }
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            outputInfo = "服务器错误，请重试!";
        } finally {
            Utils.toast(CourseLoginActivity.this, outputInfo);
        }
    }

    /**
     * 登录相关逻辑
     */
    private void login() {
        userName = et_userName.getText().toString();
        requestHeadersMap.put(Constants.HEADER_NAME_REFERER, Constants.HEADER_VALUE_REFERER + userName);

        loginRequestBodyMap.put(Constants.LOGIN_BODY_NAME_USERNAME, userName);
        loginRequestBodyMap.put(Constants.LOGIN_BODY_NAME_PASSWORD, et_passWord.getText().toString());
        loginRequestBodyMap.put(Constants.LOGIN_BODY_NAME_SECRETCODE, et_inputVerificationCode.getText().toString());

        OkHttpUtil.postAsync(Constants.EDUCATION_SYSTEM_LOGIN_URL, new OkHttpUtil.ResultCallback() {
            @Override
            public void onError(Call call, Exception e) {
                setLoginState(false);
                Utils.toast(CourseLoginActivity.this, "登录失败!");
                CourseLoginActivity.this.finish();
            }

            @Override
            public void onResponse(byte[] response) {
                if (null != response) {
                    parseResponseFromLogin(response);
                    CourseLoginActivity.this.finish();
                    if (isLoginSuccessful()) {
                        switch (type) {
                            case Constants.SEARCH_SCHEDULE:
                                editor.putBoolean("isAddCourse",false);
                                editor.commit();
                                    Config.getDatabaseAdapter().rawDelete();
                                searchScheduleOperation(CourseLoginActivity.this);
                                break;
                            case Constants.SEARCH_SCORE:
                                searchScoreOperation(CourseLoginActivity.this);
                                break;
                            default:
                                break;
                        }
                    }
                } else {
                   Utils.toast(CourseLoginActivity.this, "服务器错误，请重试!");
                    CourseLoginActivity.this.finish();
                }
            }
        }, loginRequestBodyMap, requestHeadersMap);
    }

    /**
     * 设置登录状态
     */
    public static void setLoginState(boolean loginState) {
        isLogin = loginState;
    }

    /**
     * 返回当前登录状态
     */
    public static boolean isLoginSuccessful() {
        return isLogin;
    }

    /**
     * 查询课表的一系列操作
     */
    public static void searchScheduleOperation(final Context context) {
        // 重新拼接好网址
        String newScheduleUrl = Constants.SEARCH_SCHEDULE_URL
                .replace(Constants.LOGIN_BODY_NAME_USERNAME, userName)
                .replace(Constants.STUDENTNAME, urlEncodeStudentName);

        // 这里需要注意，OkHttp这里设置requestHeader的Referer时，如果出现中文，会报错。所以之前就对学生姓名进行了url编码
        requestHeadersMap.put(Constants.HEADER_NAME_REFERER, newScheduleUrl);

        scheduleRequestBodyMap.put(Constants.SCHEDULE_BODY_NAME_SCHOOLYEAR,selectedYear);
        scheduleRequestBodyMap.put(Constants.SCHEDULE_BODY_NAME_TERM, selectedTerm);

        // 这里的请求地址和Referer一样，不过这里学生姓名直接用中文也没问题。就和之前的Referer保持一致了，也用那个使用率url编码的地址
        OkHttpUtil.postAsync(newScheduleUrl, new OkHttpUtil.ResultCallback() {
            @Override
            public void onError(Call call, Exception e) {
                Utils.toast(context, "获取课表失败,请重试!");
            }

            @Override
            public void onResponse(byte[] response) {
                    if (null != response) {
                        String result = null;
                        try {
                            result = new String(response, "gb2312");
                        } catch (UnsupportedEncodingException e) {
                            e.printStackTrace();
                        }

                        JsoupUtil.getCourseList(result);
                           CourseActivity.actionStart(context);

                }
            }
        }, scheduleRequestBodyMap, requestHeadersMap);
    }

    /**
     * 查询成绩的一系列操作
     */
    public static void searchScoreOperation(final Context context) {

        // 重新拼接好网址
        String newScoreUrl = Constants.SEARCH_SCORE_URL
                .replace(Constants.LOGIN_BODY_NAME_USERNAME, userName)
                .replace(Constants.STUDENTNAME, urlEncodeStudentName);

        // 这里和查询课表一样的，之前就对学生姓名进行了url编码
        requestHeadersMap.put(Constants.HEADER_NAME_REFERER, newScoreUrl);

        scoreRequestBodyMap.put(Constants.SCORE_BODY_NAME_SCHOOLYEAR, selectedYear);
        scoreRequestBodyMap.put(Constants.SCORE_BODY_NAME_TERM,selectedTerm);

        OkHttpUtil.postAsync(newScoreUrl, new OkHttpUtil.ResultCallback() {
            @Override
            public void onError(Call call, Exception e) {

                Utils.toast(context, "获取成绩失败,请重试!");
            }

            @Override
            public void onResponse(byte[] response) {
                String message = null;
                try {
                    if (null != response) {
                        String result = new String(response, "gb2312");
                        Log.e("test", result);
                        List<Score> scoreList = JsoupUtil.getScoreList(result);
                        if (null != scoreList) {
                            message = "获取成绩成功!";

                            ScoreActivity.actionStart(context, scoreList);
                        } else {
                            message = "获取成绩失败,请重试!";
                        }
                    } else {
                        message = "获取成绩失败,请重试!";
                    }
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                    message = "获取成绩失败,请重试!";
                } finally {
                   Utils.toast(context, message);
                }
            }
        }, scoreRequestBodyMap, requestHeadersMap);
    }

}
