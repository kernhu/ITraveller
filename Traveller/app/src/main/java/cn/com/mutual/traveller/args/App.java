package cn.com.mutual.traveller.args;

import android.app.Application;
import android.os.Bundle;


import com.umeng.socialize.PlatformConfig;

/**
 * Created by ntop on 15/7/8.
 */
public class App extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
    }

    //各个平台的配置，建议放在全局Application或者程序入口
    {
        //微信 wx12342956d1cab4f9,a5ae111de7d9ea137e88a5e02c07c94d
        PlatformConfig.setWeixin("wx967daebe835fbeac", "5bb696d9ccd75a38c8a0bfe0675559b3");
        //新浪微博
        PlatformConfig.setSinaWeibo("3921700954", "04b48b094faeb16683c32669824ebdad");
        PlatformConfig.setQQZone("100424468", "c7394704798a158208a74ab60104f0ba");
        PlatformConfig.setAlipay("2015111700822536");
    }
}
