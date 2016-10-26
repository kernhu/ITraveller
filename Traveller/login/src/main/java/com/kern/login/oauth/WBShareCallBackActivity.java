package com.kern.login.oauth;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.umeng.socialize.UMAuthListener;
import com.umeng.socialize.UMShareAPI;
import com.umeng.socialize.bean.SHARE_MEDIA;

import java.util.Map;

/**
 * Created by Kern on 2016/9/13.
 */
public class WBShareCallBackActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }


    UMShareAPI umShareAPI;
    SHARE_MEDIA platform = SHARE_MEDIA.SINA;

    private Context context;


    public void oauth() {

        //授权接口
        umShareAPI.doOauthVerify(WBShareCallBackActivity.this, platform, umAuthListener);
        //删除已经授权接口
        umShareAPI.deleteOauth(WBShareCallBackActivity.this, platform, umdelAuthListener);
    }

    /**
     * 授权回调
     */
    private UMAuthListener umAuthListener = new UMAuthListener() {
        @Override
        public void onComplete(SHARE_MEDIA platform, int action, Map<String, String> data) {
            Toast.makeText(WBShareCallBackActivity.this, "Authorize succeed", Toast.LENGTH_SHORT).show();
            //授权成功了之后在此获取用户信息
            //Map<String, String> data


        }

        @Override
        public void onError(SHARE_MEDIA platform, int action, Throwable t) {
            Toast.makeText(WBShareCallBackActivity.this, "Authorize fail", Toast.LENGTH_SHORT).show();
        }

        @Override
        public void onCancel(SHARE_MEDIA platform, int action) {
            Toast.makeText(WBShareCallBackActivity.this, "Authorize cancel", Toast.LENGTH_SHORT).show();
        }
    };
    /**
     * 删除授权回调与授权回调是相同的接口和参数
     */
    private UMAuthListener umdelAuthListener = new UMAuthListener() {
        @Override
        public void onComplete(SHARE_MEDIA platform, int action, Map<String, String> data) {
            Toast.makeText(WBShareCallBackActivity.this, "Deleted succeed", Toast.LENGTH_SHORT).show();
        }

        @Override
        public void onError(SHARE_MEDIA platform, int action, Throwable t) {
            Toast.makeText(WBShareCallBackActivity.this, "Deleted fail", Toast.LENGTH_SHORT).show();
        }

        @Override
        public void onCancel(SHARE_MEDIA platform, int action) {
            Toast.makeText(WBShareCallBackActivity.this, "Deleted cancel", Toast.LENGTH_SHORT).show();
        }
    };


    //微信是否安装
    public boolean isWXInstall() {

        return umShareAPI.isInstall(this, SHARE_MEDIA.WEIXIN);
    }

    //QQ是否安装
    public boolean isQQInstall() {

        return umShareAPI.isInstall(this, SHARE_MEDIA.QQ);
    }

    //支付宝是否安装
    public boolean isZFBInstall() {

        return umShareAPI.isInstall(this, SHARE_MEDIA.ALIPAY);
    }


    //获取用户信息，只有认证授权过的才能获取到
    public void getUserInfo() {

        //已授权的平台，可以获取用户信息（新浪微博可以获取用户好友列表） 实现的方法与授权和解除授权类似：
        umShareAPI = UMShareAPI.get(this);
       // 初始化UMShareAPI，然后进行用户信息获取：
        umShareAPI.getPlatformInfo(this, platform, umAuthListener);
    }


    /**
     * @param requestCode
     * @param resultCode
     * @param data
     */
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        umShareAPI.onActivityResult(requestCode, resultCode, data);
    }
}
