package com.fafu.zhengxianyou.livingincampus;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.io.UnsupportedEncodingException;

public class CourseActivity extends Activity implements View.OnClickListener {
    private EditText userName,passWord;
    private Button login;
//    private OkHttpClient okHttpClient;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_course);

        initView();
    }

    /**
     * 初始化view
     */
    private void initView() {
//        okHttpClient = new OkHttpClient();
        userName = (EditText) findViewById(R.id.username);
        passWord = (EditText) findViewById(R.id.password);
        login = (Button) findViewById(R.id.login);
        login.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.login:
                try {
                    login();
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
                break;
        }
    }

    /**
     * 登录相关逻辑
     */
    private void login() throws UnsupportedEncodingException {
//        String user = userName.getText().toString();
//        String password = passWord.getText().toString();
//        if (!TextUtils.isEmpty(user)&&!TextUtils.isEmpty(password)){
//            String loginUrl = "http://jwgl.fafu.edu.cn/(disjmfjtbgg3hnbgmw3cb4n5)/default2.aspx";
//
////            构建表单数据
//            FormEncodingBuilder builder = new FormEncodingBuilder();
//            builder.add("Button1", "");
//            builder.add("RadioButtonList1", URLEncoder.encode("学生", "gbk"));
//            builder.add("TextBox2", password);
//            builder.add("__VIEWSTATE", "dDwyODE2NTM0OTg7Oz5xQU1YXNHacgTbKvSXBd9SngM+XA==");
//            builder.add("__VIEWSTATEGENERATOR","92719903");
//            builder.add("hidPdrs", "");
//            builder.add("hidsc", "");
//            builder.add("lbLanguage", "");
//            builder.add("txtSecretCode", "");
//            builder.add("txtUserName", user);
//
//            RequestBody requestBody = builder.build();
//            //发送post请求
//            final Request request = new Request.Builder().url(loginUrl).post(requestBody).build();
//            okHttpClient.newCall(request).enqueue(new Callback() {
//                @Override
//                public void onFailure(Request request, IOException e) {
//
//                }
//
//                //获得相应后会执行的方法
//                @Override
//                public void onResponse(Response response) throws IOException {
//                    if (response.isSuccessful()) {
//                        String urlString = response.request().urlString();
//                        //登陆查询
//                        loginScore(urlString);
//                    }
//                }
//            });
//        }else {
//            Utils.toast(this,"请把信息填写完整");
//        }

    }

    private void loginScore(String urlString) {
//        String loginScoreUrl = "http://jwgl.fafu.edu.cn/(bx01nz55jvuxd055gohnru55)/xscjcx_dq.aspx?xh=3135706002&xm=%D6%A3%CF%D6%D3%D1&gnmkdm=N121605";
//        Request request = new Request.Builder()
//                .url(loginScoreUrl)
//                .addHeader("Referer", urlString)
//                .addHeader("Host", "jwgl.fafu.edu.cn")
//                .build();
//
//        okHttpClient.newCall(request).enqueue(new Callback() {
//            @Override
//            public void onFailure(Request request, IOException e) {
//            }
//
//            @Override
//            public void onResponse(Response response) throws IOException {
//                if (response.isSuccessful()) {
//                    //此时登陆成功后我们就可以开始查成绩了
//                    searchScore();
//                }
//            }
//        });
//        Log.e("TTTT",urlString);
    }

    private void searchScore() throws UnsupportedEncodingException {
//        FormEncodingBuilder builder = new FormEncodingBuilder();
//        RequestBody requestBody =
//                builder.add("__EVENTARGUMENT", "")
//                        .add("__EVENTTARGET", "")
//                        .add("__VIEWSTATE", "dDwxMDk5MDkzODA4O3Q8cDxsPHRqcXI7PjtsPDA7Pj47bDxpPDE+Oz47bDx0PDtsPGk8MT47aTw3PjtpPDk+Oz47bDx0PHQ8O3Q8aTwxOD47QDzlhajpg6g7MjAwMS0yMDAyOzIwMDItMjAwMzsyMDAzLTIwMDQ7MjAwNC0yMDA1OzIwMDUtMjAwNjsyMDA2LTIwMDc7MjAwNy0yMDA4OzIwMDgtMjAwOTsyMDA5LTIwMTA7MjAxMC0yMDExOzIwMTEtMjAxMjsyMDEyLTIwMTM7MjAxMy0yMDE0OzIwMTQtMjAxNTsyMDE1LTIwMTY7MjAxNi0yMDE3OzIwMTctMjAxODs+O0A85YWo6YOoOzIwMDEtMjAwMjsyMDAyLTIwMDM7MjAwMy0yMDA0OzIwMDQtMjAwNTsyMDA1LTIwMDY7MjAwNi0yMDA3OzIwMDctMjAwODsyMDA4LTIwMDk7MjAwOS0yMDEwOzIwMTAtMjAxMTsyMDExLTIwMTI7MjAxMi0yMDEzOzIwMTMtMjAxNDsyMDE0LTIwMTU7MjAxNS0yMDE2OzIwMTYtMjAxNzsyMDE3LTIwMTg7Pj47Pjs7Pjt0PDtsPGk8MD47aTwxPjtpPDI+Oz47bDx0PDtsPGk8MD47PjtsPHQ8cDxsPGlubmVyaHRtbDs+O2w8MjAxNi0yMDE35a2m5bm056ysMeWtpuacn+WtpuS5oOaIkOe7qTs+Pjs7Pjs+Pjt0PDtsPGk8MD47aTwxPjtpPDI+Oz47bDx0PHA8bDxpbm5lcmh0bWw7PjtsPOWtpuWPt++8mjMxMzU3MDYwMDI7Pj47Oz47dDxwPGw8aW5uZXJodG1sOz47bDzlp5PlkI3vvJrpg5HnjrDlj4s7Pj47Oz47dDxwPGw8aW5uZXJodG1sOz47bDzlrabpmaLvvJrotYTmupDkuI7njq/looPlrabpmaI7Pj47Oz47Pj47dDw7bDxpPDA+O2k8MT47PjtsPHQ8cDxsPGlubmVyaHRtbDs+O2w85LiT5Lia77ya56m66Ze05L+h5oGv5LiO5pWw5a2X5oqA5pyvOz4+Ozs+O3Q8cDxsPGlubmVyaHRtbDs+O2w86KGM5pS/54+t77yaMTPnqbrpl7TmlbDlrZcx54+tOz4+Ozs+Oz4+Oz4+O3Q8QDA8cDxwPGw8UGFnZUNvdW50O18hSXRlbUNvdW50O18hRGF0YVNvdXJjZUl0ZW1Db3VudDtEYXRhS2V5czs+O2w8aTwxPjtpPDM+O2k8Mz47bDw+Oz4+Oz47QDA8Ozs7Ozs7Ozs7Ozs7Ozs7OztAMDxwPGw8VmlzaWJsZTs+O2w8bzxmPjs+Pjs7Ozs+Ozs7Ozs+Ozs7Ozs7Ozs7PjtsPGk8MD47PjtsPHQ8O2w8aTwxPjtpPDI+O2k8Mz47PjtsPHQ8O2w8aTwwPjtpPDE+O2k8Mj47aTwzPjtpPDQ+O2k8NT47aTw2PjtpPDc+O2k8OD47aTw5PjtpPDEwPjtpPDExPjtpPDEyPjtpPDEzPjtpPDE0PjtpPDE1PjtpPDE2PjtpPDE3PjtpPDE4PjtpPDE5PjtpPDIwPjtpPDIxPjs+O2w8dDxwPHA8bDxUZXh0Oz47bDwoMjAxNi0yMDE3LTEpLTU3MDE4MDIyLTE5NjkwMDAyLTE7Pj47Pjs7Pjt0PHA8cDxsPFRleHQ7PjtsPDIwMTYtMjAxNzs+Pjs+Ozs+O3Q8cDxwPGw8VGV4dDs+O2w8MTs+Pjs+Ozs+O3Q8cDxwPGw8VGV4dDs+O2w8NTcwMTgwMjI7Pj47Pjs7Pjt0PHA8cDxsPFRleHQ7PjtsPOW3peeoi+a1i+mHjzs+Pjs+Ozs+O3Q8cDxwPGw8VGV4dDs+O2w856eR57G75Z+656GA6K++Oz4+Oz47Oz47dDxwPHA8bDxUZXh0Oz47bDwmbmJzcFw7Oz4+Oz47Oz47dDxwPHA8bDxUZXh0Oz47bDwzLjA7Pj47Pjs7Pjt0PHA8cDxsPFRleHQ7PjtsPCZuYnNwXDs7Pj47Pjs7Pjt0PHA8cDxsPFRleHQ7PjtsPCZuYnNwXDs7Pj47Pjs7Pjt0PHA8cDxsPFRleHQ7PjtsPDQ3Oz4+Oz47Oz47dDxwPHA8bDxUZXh0Oz47bDw5MTs+Pjs+Ozs+O3Q8cDxwPGw8VGV4dDs+O2w8NjA7Pj47Pjs7Pjt0PHA8cDxsPFRleHQ 7PjtsPCZuYnNwXDs7Pj47Pjs7Pjt0PHA8cDxsPFRleHQ7PjtsPCZuYnNwXDs7Pj47Pjs7Pjt0PHA8cDxsPFRleHQ7PjtsPCZuYnNwXDs7Pj47Pjs7Pjt0PHA8cDxsPFRleHQ7PjtsPOi1hOa6kOS4jueOr +Wig+WtpumZojs+Pjs+Ozs+O3Q8cDxwPGw8VGV4dDs+O2w8MTs+Pjs+Ozs+O3Q8cDxwPGw8VGV4dDs+O2w8Jm5ic3BcOzs+Pjs+Ozs +O3Q8cDxwPGw8VGV4dDs+O2w8Jm5ic3BcOzs+Pjs+Ozs+O3Q8cDxwPGw8VGV4dDs+O2w8Jm5ic3BcOzs+Pjs+Ozs+O3Q8cDxwPGw8VGV4dDs +O2w8Jm5ic3BcOzs+Pjs+Ozs+Oz4+O3Q8O2w8aTwwPjtpPDE+O2k8Mj47aTwzPjtpPDQ+O2k8NT47aTw2PjtpPDc+O2k8OD47aTw 5PjtpPDEwPjtpPDExPjtpPDEyPjtpPDEzPjtpPDE0PjtpPDE1PjtpPDE2PjtpPDE3PjtpPDE4PjtpPDE5PjtpPDIwPjtpPDIxPjs +O2w8dDxwPHA8bDxUZXh0Oz47bDwoMjAxNi0yMDE3LTEpLTA5MDIxMDAzLTIwMTAwMDQ1LTQ7Pj47Pjs7Pjt0PHA8cDxsPFRleHQ7PjtsPDIwMTYtMjAxNzs +Pjs+Ozs+O3Q8cDxwPGw8VGV4dDs+O2w8MTs+Pjs+Ozs+O3Q8cDxwPGw8VGV4dDs+O2w8MDkwMjEwMDM7Pj47Pjs7Pjt0PHA8cDxsPFRleHQ7PjtsPOWIm +S4muWwseS4muWunui3tTs+Pjs+Ozs+O3Q8cDxwPGw8VGV4dDs+O2w85a6e6Le15pWZ5a2mOz4+Oz47Oz47dDxwPHA8bDxUZXh0Oz47bDwmbmJzcFw7Oz4 +Oz47Oz47dDxwPHA8bDxUZXh0Oz47bDwxLjA7Pj47Pjs7Pjt0PHA8cDxsPFRleHQ7PjtsPCZuYnNwXDs7Pj47Pjs7Pjt0PHA8cDxsPFRleHQ7PjtsPCZuYnNwXDs7Pj47Pjs7Pjt0PHA8cDxsPFRleHQ7PjtsPDg2Oz4 +Oz47Oz47dDxwPHA8bDxUZXh0Oz47bDwmbmJzcFw7Oz4+Oz47Oz47dDxwPHA8bDxUZXh0Oz47bDw4Njs+Pjs+Ozs+O3Q8cDxwPGw8VGV4dDs +O2w8Jm5ic3BcOzs+Pjs+Ozs+O3Q8cDxwPGw8VGV4dDs+O2w8Jm5ic3BcOzs+Pjs+Ozs+O3Q8cDxwPGw8VGV4dDs+O2w8Jm5ic3BcOzs +Pjs+Ozs+O3Q8cDxwPGw8VGV4dDs+O2w85a2m5bel6YOo44CB5a2m55Sf5aSE77yI5ZCI572y77yJOz4+Oz47Oz47dDxwPHA8bDxUZXh0Oz47bDwzLjYwOz4 +Oz47Oz47dDxwPHA8bDxUZXh0Oz47bDwmbmJzcFw7Oz4+Oz47Oz47dDxwPHA8bDxUZXh0Oz47bDwmbmJzcFw7Oz4+Oz47Oz47dDxwPHA8bDxUZXh0Oz47bDwmbmJzcFw7Oz4 +Oz47Oz47dDxwPHA8bDxUZXh0Oz47bDwmbmJzcFw7Oz4+Oz47Oz47Pj47dDw7bDxpPDA+O2k8MT47aTwyPjtpPDM+O2k8ND47aTw1PjtpPDY +O2k8Nz47aTw4PjtpPDk+O2k8MTA+O2k8MTE+O2k8MTI+O2k8MTM+O2k8MTQ+O2k8MTU+O2k8MTY+O2k8MTc+O2k8MTg+O2k8MTk +O2k8MjA+O2k8MjE+Oz47bDx0PHA8cDxsPFRleHQ7PjtsPCgyMDE2LTIwMTctMSktNTcwMTYwNzktMTk5NzAwNDctMTs+Pjs+Ozs +O3Q8cDxwPGw8VGV4dDs+O2w8MjAxNi0yMDE3Oz4+Oz47Oz47dDxwPHA8bDxUZXh0Oz47bDwxOz4+Oz47Oz47dDxwPHA8bDxUZXh0Oz47bDw1NzAxNjA3OTs +Pjs+Ozs+O3Q8cDxwPGw8VGV4dDs+O2w85LiT5Lia6Iux6K+tOz4+Oz47Oz47dDxwPHA8bDxUZXh0Oz47bDzlrabnp5Eo5LiT5LiaKemAieS /ruivvjs+Pjs+Ozs+O3Q8cDxwPGw8VGV4dDs+O2w8Jm5ic3BcOzs+Pjs+Ozs+O3Q8cDxwPGw8VGV4dDs+O2w8Mi4wOz4+Oz47Oz47dDxwPHA8bDxUZXh0Oz47bDw5Mjs +Pjs+Ozs+O3Q8cDxwPGw8VGV4dDs+O2w8Jm5ic3BcOzs+Pjs+Ozs+O3Q8cDxwPGw8VGV4dDs+O2w8Nzg7Pj47Pjs7Pjt0PHA8cDxsPFRleHQ7PjtsPCZuYnNwXDs7Pj47Pjs7Pjt0PHA8cDxsPFRleHQ7PjtsPDg0Oz4 +Oz47Oz47dDxwPHA8bDxUZXh0Oz47bDwmbmJzcFw7Oz4+Oz47Oz47dDxwPHA8bDxUZXh0Oz47bDwmbmJzcFw7Oz4+Oz47Oz47dDxwPHA8bDxUZXh0Oz47bDwmbmJzcFw7Oz4 +Oz47Oz47dDxwPHA8bDxUZXh0Oz47bDzotYTmupDkuI7njq/looPlrabpmaI7Pj47Pjs7Pjt0PHA8cDxsPFRleHQ7PjtsPDMuNDA 7Pj47Pjs7Pjt0PHA8cDxsPFRleHQ7PjtsPCZuYnNwXDs7Pj47Pjs7Pjt0PHA8cDxsPFRleHQ7PjtsPCZuYnNwXDs7Pj47Pjs7Pjt0PHA8cDxsPFRleHQ7PjtsPCZuYnNwXDs7Pj47Pjs7Pjt0PHA8cDxsPFRleHQ7PjtsPCZuYnNwXDs7Pj47Pjs7Pjs +Pjs+Pjs+Pjs+Pjs+Pjs+r8sdFdq98LyqPu8bMinP9UWGPt4=")
//                        .add("__VIEWSTATEGENERATOR", "EC2DE6FD")
//                        .add("btnCx", "+%B2%E9++%D1%AF+")
//                        .add("ddlXN", "2016-2017")
//                        .add("ddlxq", "1").build();
//        String loginScoreUrl = "http://jwgl.fafu.edu.cn/(bx01nz55jvuxd055gohnru55)/xscjcx_dq.aspx?xh=3135706002&xm=%D6%A3%CF%D6%D3%D1&gnmkdm=N121605";
//        final Request request = new Request.Builder()
//                .url(loginScoreUrl)
//                .addHeader("Referer", "http://jwgl.fafu.edu.cn/(bx01nz55jvuxd055gohnru55)/xscjcx_dq.aspx?xh=3135706002&xm=%D6%A3%CF%D6%D3%D1&gnmkdm=N121605")
//                .addHeader("Host", "jwgl.fafu.edu.cn")
//                .post(requestBody).build();
//        okHttpClient.newCall(request).enqueue(new Callback() {
//            @Override
//            public void onFailure(Request request, IOException e) {
//
//            }
//
//            @Override
//            public void onResponse(Response response) throws IOException {
//                BufferedReader br = new BufferedReader(new InputStreamReader(response.body().byteStream(), "gb2312"));
//                StringBuilder sb=new StringBuilder();
//                String line;
//                while ((line = br.readLine()) != null) {
//                    sb.append(line);
//                }
//                br.close();
////                parseHtml(sb.toString());
//                Log.e("TTT",sb.toString());
//            }
//        });
    }
}
