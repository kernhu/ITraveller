package cn.com.mutual.traveller.bar.tab;

import android.content.Context;
import android.graphics.drawable.Drawable;

import cn.com.mutual.traveller.R;


/**
 * Created by Kern on 2016/8/29.
 */
public class TabInfo {

    private Drawable drawableRes;
    private String title;

    public TabInfo(Context context) {
        this.drawableRes = context.getResources().getDrawable(R.drawable.selector_home);
        this.title = "Home";
    }

    public TabInfo(Drawable drawableRes, String title) {
        this.drawableRes = drawableRes;
        this.title = title;
    }

    public Drawable getDrawableRes() {
        return drawableRes;
    }

    public void setDrawableRes(Drawable drawableRes) {
        this.drawableRes = drawableRes;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
