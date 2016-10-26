package cn.com.mutual.traveller.tools;

import android.content.Context;
import android.content.SharedPreferences;

import cn.com.mutual.traveller.args.TrvConstans;

/**
 * Created by Kern on 2016/9/7.
 */
public class ShareprefHelper {

    private static ShareprefHelper helper = null;
    private SharedPreferences preferences = null;
    private SharedPreferences.Editor editor = null;

    public ShareprefHelper(Context context) {

        preferences = context.getSharedPreferences(TrvConstans.PATH_TRV, Context.MODE_PRIVATE);
    }

    public static ShareprefHelper getInstance(Context context) {

        if (helper == null) {
            helper = new ShareprefHelper(context);
        }

        return helper;
    }

    public int getInt(String key, int def) {

        return preferences.getInt(key, def);
    }

    public void setIntExtra(String key, int value) {

        editor = preferences.edit();
        editor.putInt(key, value);
        editor.commit();
    }


}
