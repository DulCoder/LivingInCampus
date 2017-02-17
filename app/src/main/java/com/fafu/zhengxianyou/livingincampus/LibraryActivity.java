package com.fafu.zhengxianyou.livingincampus;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import android.widget.Spinner;

import com.fafu.zhengxianyou.livingincampus.Constants.Constant;
import com.fafu.zhengxianyou.livingincampus.utils.Utils;

public class LibraryActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener, RadioGroup.OnCheckedChangeListener, View.OnClickListener {
    private RadioGroup rg_lib;
    private RadioGroup rg_type,rg_link_type;
    private Spinner spinner_lib;
    private EditText et_lib,et_baidu,et_link;
    private Button btn_lib,btn_baidu,btn_chn,btn_for;
    private int position = 0;
    private LinearLayout ll_native,ll_fulink,ll_baidu;
    private String TEXT_NATIVE = "Android", TITLE = "title", TYPE = "ALL",url;
    private String TEXT_BAIDU,TEXT_FULINK;

    private ArrayAdapter<String> mAdapter;
    private String[] item_spinner = {"题 名", "责任者", "主题词", "ISBN/ISSN", "订购号", "分类号", "检索号", "出版社", "丛书名", "题名拼音", "责任者拼音"};
    private String[] item_title = {"title", "author","keyword","isbn","asordno","coden","callno","publisher","series","tpinyin","apinyin"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_library);

        initView();
        setListener();
    }

    /**
     * 初始化View
     */
    private void initView() {
        rg_lib = (RadioGroup) findViewById(R.id.rg_lib);
        rg_type = (RadioGroup) findViewById(R.id.rg_type);
        rg_link_type = (RadioGroup) findViewById(R.id.rg_link_type);
        spinner_lib = (Spinner) findViewById(R.id.spinner_lib);
        et_lib = (EditText) findViewById(R.id.et_lib);
        et_baidu = (EditText) findViewById(R.id.et_baidu);
        et_link = (EditText) findViewById(R.id.et_link);
        btn_lib = (Button) findViewById(R.id.btn_lib);
        btn_baidu = (Button) findViewById(R.id.btn_baidu);
        btn_chn = (Button) findViewById(R.id.btn_chn);
        btn_for = (Button) findViewById(R.id.btn_for);
        ll_native = (LinearLayout) findViewById(R.id.ll_native);
        ll_baidu = (LinearLayout) findViewById(R.id.ll_baidu);
        ll_fulink = (LinearLayout) findViewById(R.id.ll_fulink);
        mAdapter = new ArrayAdapter<>(this, R.layout.item_spinner, item_spinner);

        //设置下拉列表的风格
        mAdapter.setDropDownViewResource(R.layout.item_spinner);
        //mAdapter 添加到spinner中
        spinner_lib.setAdapter(mAdapter);

        rg_lib.check(R.id.rb_native);
        rg_type.check(R.id.rb_all);
        rg_link_type.check(R.id.rb_link_all);

    }

    /**
     * 点击事件
     */
    private void setListener() {
        rg_lib.setOnCheckedChangeListener(this);
        rg_type.setOnCheckedChangeListener(this);
        rg_link_type.setOnCheckedChangeListener(this);

        //添加事件Spinner事件监听
        spinner_lib.setOnItemSelectedListener(this);

        btn_lib.setOnClickListener(this);
        btn_baidu.setOnClickListener(this);
        btn_chn.setOnClickListener(this);
        btn_for.setOnClickListener(this);

    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        TITLE = item_title[position];

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    /**
     * RadioGroup的点击事件
     * @param group
     * @param checkedId
     */
    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        switch (checkedId) {
            case R.id.rb_native:
                position = 0;
                ll_native.setVisibility(View.VISIBLE);
                ll_fulink.setVisibility(View.GONE);
                ll_baidu.setVisibility(View.GONE);
                break;
            case R.id.rb_fulink:
                position = 1;
                ll_native.setVisibility(View.GONE);
                ll_fulink.setVisibility(View.VISIBLE);
                ll_baidu.setVisibility(View.GONE);
                break;
            case R.id.rb_baidu:
                position = 2;
                ll_native.setVisibility(View.GONE);
                ll_fulink.setVisibility(View.GONE);
                ll_baidu.setVisibility(View.VISIBLE);
                break;
            case R.id.rb_all:
                TYPE = "ALL";
                break;
            case R.id.rb_01:
                TYPE = "01";
                break;
            case R.id.rb_02:
                TYPE = "02";
                break;
            case R.id.rb_11:
                TYPE = "11";
                break;
            case R.id.rb_12:
                TYPE = "12";
                break;
            case R.id.rb_link_all:           //Fulink布局

                break;
            case R.id.rb_book:

                break;
            case R.id.rb_magazine:

                break;
            case R.id.rb_news:

                break;
            case R.id.rb_thesis:

                break;
            case R.id.rb_patent:

                break;
            case R.id.rb_video:

                break;

        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_lib:
                TEXT_NATIVE = et_lib.getText().toString();
                if (!TextUtils.isEmpty(TEXT_NATIVE)){
                    url = Constant.LIBRARY_NATIVE+TITLE+Constant.LIBRARY_NATIVE_TEXT+TEXT_NATIVE+Constant.LIBRARY_NATIVE_TYPE+TYPE;
                    Intent intent = new Intent(this,WebInfoActivity.class);
                    intent.putExtra("url",url);
                    startActivity(intent);
                }else {
                    Utils.toast(this,"请输入要搜索的内容");

                }
                break;
            case R.id.btn_baidu:               //百度一下
                TEXT_BAIDU = et_baidu.getText().toString();
                if (!TextUtils.isEmpty(TEXT_BAIDU)){
                    url = Constant.BAIDU_ACADEMIC+TEXT_BAIDU+Constant.BAIDU_TEXT;
                    Intent intent = new Intent(this,WebInfoActivity.class);
                    intent.putExtra("url",url);
                    startActivity(intent);
                }else {
                    Utils.toast(this,"请输入要搜索的内容");
                }

                break;
             case R.id.btn_chn:                //中文搜索
                TEXT_FULINK = et_link.getText().toString();

                break;
             case R.id.btn_for:                //外文搜索
                 TEXT_FULINK = et_link.getText().toString();

                 break;


        }
    }
}
