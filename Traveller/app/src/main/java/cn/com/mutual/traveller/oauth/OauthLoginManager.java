package cn.com.mutual.traveller.oauth;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.ActivityCompat;
import android.widget.Toast;

import com.umeng.socialize.UMAuthListener;
import com.umeng.socialize.UMShareAPI;
import com.umeng.socialize.bean.SHARE_MEDIA;
import com.umeng.socialize.utils.Log;

import java.util.Map;

/**
 * 第三方登陆管理类：
 * <b>QQ登陆</b>
 * <b>微信登陆</b>
 * <b>支付宝登陆</b>
 * <b>微博登陆</b>
 * Created by Kern on 2016/9/10.
 */
public class OauthLoginManager {

    private Context context;
    private static OauthLoginManager manager = null;
    private UMShareAPI mShareAPI = null;
    private SHARE_MEDIA platform = null;

    public OauthLoginManager(Context context) {
        this.context = context;

        initPermission();
        /** init auth api**/
        mShareAPI = UMShareAPI.get(context);
    }

    public static OauthLoginManager getInstance(Context context) {

        manager = new OauthLoginManager(context);
        return manager;
    }

    /**
     * 打开权限
     */
    public void initPermission() {

        //可以将一下代码加到你的MainActivity中，或者在任意一个需要调用分享功能的activity当中
        String[] mPermissionList = new String[]{Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.CALL_PHONE, Manifest.permission.READ_LOGS, Manifest.permission.READ_PHONE_STATE, Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.SET_DEBUG_APP, Manifest.permission.SYSTEM_ALERT_WINDOW, Manifest.permission.GET_ACCOUNTS};
        ActivityCompat.requestPermissions((Activity) context, mPermissionList, 100);

    }


    /**
     * 认证授权登陆
     *
     * @param oauthCode
     */
    public void oauthLogin(int oauthCode) {

        switch (oauthCode) {

            case OauthInfo.OAUTH_QQ:
                platform = SHARE_MEDIA.QQ;
                break;
            case OauthInfo.OAUTH_WX:
                platform = SHARE_MEDIA.WEIXIN;
                break;

            case OauthInfo.OAUTH_ZFB:
                platform = SHARE_MEDIA.ALIPAY;
                break;

            case OauthInfo.OAUTH_WB:
                platform = SHARE_MEDIA.SINA;
                break;
        }
        //授权
        mShareAPI.doOauthVerify((Activity) context, platform, umAuthListener);
    }


    /**
     * 取消授权，退出登陆
     *
     * @param oauthCode
     */
    public void extiLogin(int oauthCode) {

        switch (oauthCode) {

            case OauthInfo.OAUTH_QQ:
                platform = SHARE_MEDIA.QQ;
                break;
            case OauthInfo.OAUTH_WX:
                platform = SHARE_MEDIA.WEIXIN;
                break;

            case OauthInfo.OAUTH_ZFB:
                platform = SHARE_MEDIA.ALIPAY;
                break;

            case OauthInfo.OAUTH_WB:
                platform = SHARE_MEDIA.SINA;
                break;
        }
        //取消授权
        mShareAPI.deleteOauth((Activity) context, platform, umdelAuthListener);
    }

    /**
     * 该方法在Activity的onActivityResult中执行，必须
     *
     * @param requestCode
     * @param resultCode
     * @param data
     */
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        mShareAPI.onActivityResult(requestCode, resultCode, data);
    }
    /************************************/

    /**
     * auth callback interface
     **/
    private UMAuthListener umAuthListener = new UMAuthListener() {
        @Override
        public void onComplete(SHARE_MEDIA platform, int action, Map<String, String> data) {
            Toast.makeText(context, "Authorize succeed", Toast.LENGTH_SHORT).show();
            Log.d("user info", "user info:" + data.toString());
        }

        @Override
        public void onError(SHARE_MEDIA platform, int action, Throwable t) {
            Toast.makeText(context, "Authorize fail", Toast.LENGTH_SHORT).show();
        }

        @Override
        public void onCancel(SHARE_MEDIA platform, int action) {
            Toast.makeText(context, "Authorize cancel", Toast.LENGTH_SHORT).show();
        }
    };
    /**
     * delauth callback interface
     **/
    private UMAuthListener umdelAuthListener = new UMAuthListener() {
        @Override
        public void onComplete(SHARE_MEDIA platform, int action, Map<String, String> data) {
            Toast.makeText(context, "delete Authorize succeed", Toast.LENGTH_SHORT).show();
        }

        @Override
        public void onError(SHARE_MEDIA platform, int action, Throwable t) {
            Toast.makeText(context, "delete Authorize fail", Toast.LENGTH_SHORT).show();
        }

        @Override
        public void onCancel(SHARE_MEDIA platform, int action) {
            Toast.makeText(context, "delete Authorize cancel", Toast.LENGTH_SHORT).show();
        }
    };
}
