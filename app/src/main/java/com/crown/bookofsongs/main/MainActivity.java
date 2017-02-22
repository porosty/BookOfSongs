package com.crown.bookofsongs.main;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.crown.bookofsongs.R;
import com.crown.bookofsongs.base.BaseActivity;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;


public class MainActivity extends BaseActivity {

    @Bind(R.id.bt_button)
    Button btButton;
    private String crash="热更新";
//    private String crash;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

    }

    @OnClick({R.id.bt_button})
    public void setOnClick(View v) {
        switch (v.getId()) {
            case R.id.bt_button:
                Toast.makeText(this,"测试热更新"+crash.length(),Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
