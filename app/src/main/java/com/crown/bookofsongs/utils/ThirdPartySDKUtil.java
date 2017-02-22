package com.crown.bookofsongs.utils;


import android.content.Context;
import android.text.TextUtils;

import com.crown.bookofsongs.config.Config;
import com.tencent.bugly.Bugly;
import com.tencent.bugly.crashreport.CrashReport;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by Machenike on 2017/2/22.
 */

public class ThirdPartySDKUtil {
    public static ThirdPartySDKUtil instance;
    private String packageName;
    private String processName;

    /**
     * 获取第三方SDK工具类的单例对象
     * @return
     */
    public static ThirdPartySDKUtil getInstance() {
        if (instance == null) {
            synchronized (ThirdPartySDKUtil.class) {
                if (instance == null) {
                    instance = new ThirdPartySDKUtil();
                }
            }
        }
        return instance;
    }

    /**
     * 初始化Bugly的方法
     */
    public void initBugly(Context context) {
       
        // 获取当前包名
        packageName = context.getPackageName();
        // 获取当前进程名
        processName = getProcessName(android.os.Process.myPid());
        //腾讯Bugly集成初始化
        // 设置是否为上报进程
        CrashReport.UserStrategy strategy = new CrashReport.UserStrategy(context);
        strategy.setUploadProcess(processName == null || processName.equals(packageName));
        // 初始化Bugly
        Bugly.init(context, "e0c7e9768d", Config.isDebug, strategy);
    }

    /**
     * 获取进程号对应的进程名
     *
     * @param pid 进程号
     * @return 进程名
     */
    private  String getProcessName(int pid) {
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader("/proc/" + pid + "/cmdline"));
            String processName = reader.readLine();
            if (!TextUtils.isEmpty(processName)) {
                processName = processName.trim();
            }
            return processName;
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        } finally {
            try {
                if (reader != null) {
                    reader.close();
                }
            } catch (IOException exception) {
                exception.printStackTrace();
            }
        }
        return null;
    }
}
