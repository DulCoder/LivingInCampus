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
import android.widget.RadioGroup;
import android.widget.Spinner;

import com.fafu.zhengxianyou.livingincampus.Constants.Constant;
import com.fafu.zhengxianyou.livingincampus.utils.Utils;

public class LibraryActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener, RadioGroup.OnCheckedChangeListener, View.OnClickListener {
    private RadioGroup rg_lib;
    private RadioGroup rg_type;
    private Spinner spinner_lib;
    private EditText et_lib;
    private Button btn_lib;
    private int position = 0;
    private String TEXT = "Android", TITLE = "title", TYPE = "ALL",url;

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
        spinner_lib = (Spinner) findViewById(R.id.spinner_lib);
        et_lib = (EditText) findViewById(R.id.et_lib);
        btn_lib = (Button) findViewById(R.id.btn_lib);
        mAdapter = new ArrayAdapter<>(this, R.layout.item_spinner, item_spinner);

        //设置下拉列表的风格
        mAdapter.setDropDownViewResource(R.layout.item_spinner);
        //mAdapter 添加到spinner中
        spinner_lib.setAdapter(mAdapter);
        //添加事件Spinner事件监听
        spinner_lib.setOnItemSelectedListener(this);
        rg_lib.check(R.id.rb_native);
        rg_type.check(R.id.rb_all);
        btn_lib.setOnClickListener(this);
    }

    /**
     * RadioButton点击事件
     */
    private void setListener() {
        rg_lib.setOnCheckedChangeListener(this);

        rg_type.setOnCheckedChangeListener(this);
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
                break;
            case R.id.rb_fulink:
                position = 1;
                break;
            case R.id.rb_baidu:
                position = 2;
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

        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_lib:
                TEXT = et_lib.getText().toString();
                if (!TextUtils.isEmpty(TEXT)){
                    TEXT = et_lib.getText().toString();
                    url = Constant.LIBRARY_NATIVE+TITLE+Constant.LIBRARY_NATIVE_TEXT+TEXT+Constant.LIBRARY_NATIVE_TYPE+TYPE;
                    Intent intent = new Intent(this,WebInfoActivity.class);
                    intent.putExtra("url",url);
                    startActivity(intent);
                }else {
                    Utils.toast(this,"请输入要搜索的内容");

                }


                break;
        }
    }
}
