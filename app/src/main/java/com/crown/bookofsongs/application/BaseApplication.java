package com.crown.bookofsongs.application;

import android.app.Application;
import android.content.Context;
import android.support.multidex.MultiDex;

import com.crown.bookofsongs.utils.ThirdPartySDKUtil;
import com.tencent.bugly.beta.Beta;
/**
 * Created by Machenike on 2017/2/17.
 * 用于初始化第三方框架
 */

public class BaseApplication extends Application {

    private Context context;

    @Override
    public void onCreate() {
        super.onCreate();
        context = getApplicationContext();
        //初始化Bugly热更新和升级SDK
        ThirdPartySDKUtil.getInstance().initBugly(context);
    }


    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        // you must install multiDex whatever tinker is installed!
        MultiDex.install(base);
        // 安装tinker
        Beta.installTinker();
    }
}
