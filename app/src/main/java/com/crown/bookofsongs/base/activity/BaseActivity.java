package com.crown.bookofsongs.base.activity;

import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;

/**
 * Created by Machenike on 2017/2/17.
 */

public abstract class BaseActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        beforeSetContentView();
        setContentView();
        afterSetContentView();
    }

    /**
     * 设置布局文件之前处理的逻辑
     * e.g 获取bundle或者intent传递的数据
     */
    public abstract void beforeSetContentView();

    /**
     * 设置布局文件
     * e.g 初始化ButterKnife等
     */
    public abstract void setContentView();

    /**
     * 设置布局文件之后处理的逻辑
     * e.g 网络请求等
     */
    public abstract void afterSetContentView();
    /**
     * onClick方法的封装，在此方法中处理点击
     * e.g 不同控件的点击事件统一位置处理
     */
    public abstract void setOnClickEvent(View view);
    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

}
