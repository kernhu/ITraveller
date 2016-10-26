package cn.com.mutual.traveller.tools;

import android.util.Log;

/**
 * Created by Kern on 2016/7/29.
 * Log日志管理工具；可以一键屏蔽所以Log日志；
 */
public class LogTool {

    public static final String LOG_V = "v";
    public static final String LOG_D = "d";
    public static final String LOG_I = "i";
    public static final String LOG_W = "w";
    public static final String LOG_E = "e";

    public static final String TAG_K = "sos";
    //Kern's log manager
    private static boolean kernShow = true;
    //private static boolean kernShow = false;


    /**
     * logK 为 Kern个人的Log日志输出函数
     * type为log类型
     * tag为TAG
     * msg为打印log信息
     */
    public static void logK(String type, String tag, String msg) {

        if (kernShow) {
            switch (type) {
                case LOG_V:
                    Log.v(tag, msg);
                    break;
                case LOG_D:
                    Log.d(tag, msg);
                    break;
                case LOG_I:
                    Log.i(tag, msg);
                    break;
                case LOG_W:
                    Log.w(tag, msg);
                    break;
                case LOG_E:
                    Log.e(tag, msg);
                    break;
            }
        }
    }
}
