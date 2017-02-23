package com.crown.bookofsongs.main.activity;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.crown.bookofsongs.R;
import com.crown.bookofsongs.base.activity.BaseActivity;
import com.crown.bookofsongs.password.GraphicLockActivity;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;


public class MainActivity extends BaseActivity {

    @Bind(R.id.bt_button)
    Button btButton;
    private String crash = "热更新";
//    private String crash;

    /**
     * 设置布局文件之前处理的逻辑
     * e.g 获取bundle或者intent传递的数据
     */
    @Override
    public void beforeSetContentView() {

    }

    /**
     * 设置布局文件
     * e.g 初始化ButterKnife等
     */
    @Override
    public void setContentView() {
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    /**
     * 设置布局文件之后处理的逻辑
     * e.g 网络请求等
     */
    @Override
    public void afterSetContentView() {

    }

    /**
     * onClick方法的封装，在此方法中处理点击
     * e.g 不同控件的点击事件统一位置处理
     *
     * @param view
     */
    @OnClick({R.id.bt_button})
    @Override
    public void setOnClickEvent(View view) {
        switch (view.getId()) {
            case R.id.bt_button:
                Toast.makeText(this, "测试热更新" + crash.length(), Toast.LENGTH_SHORT).show();
                startActivity(new Intent(MainActivity.this, GraphicLockActivity.class));
                break;
        }
    }
}
