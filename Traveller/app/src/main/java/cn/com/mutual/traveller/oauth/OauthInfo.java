package cn.com.mutual.traveller.oauth;

/**
 * Created by Kern on 2016/9/10.
 */
public class OauthInfo {

    public static final int OAUTH_QQ = 10;
    public static final int OAUTH_KJ = 11;

    public static final int OAUTH_WX = 20;
    public static final int OAUTH_PYQ = 21;

    public static final int OAUTH_ZFB = 30;

    public static final int OAUTH_WB = 40;

    public String name;
    public int iamge;
    public int code;
    public boolean isInstall;

    public OauthInfo() {
    }

    public OauthInfo(String name, int iamge, int code, boolean isInstall) {
        this.name = name;
        this.iamge = iamge;
        this.code = code;
        this.isInstall = isInstall;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getIamge() {
        return iamge;
    }

    public void setIamge(int iamge) {
        this.iamge = iamge;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public boolean isInstall() {
        return isInstall;
    }

    public void setInstall(boolean install) {
        isInstall = install;
    }
}
