package cn.com.mutual.traveller;

import android.content.pm.ActivityInfo;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.CheckBox;
import android.widget.Toast;

import cn.com.mutual.traveller.bar.tab.action.ActionBarFactory;
import cn.com.mutual.traveller.bar.tab.action.OnActionListener;

/**
 * Created by Kern on 2016/9/7.
 */
public class BaseActivity extends AppCompatActivity implements OnActionListener {


    private long backTime = 0;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
    }

    /**
     * @return SDK higher than 5.0 or not
     */
    public boolean isSupportLollipop() {

        return Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP;
    }

    /**
     * @param isTitle       if true then hide title,otherwise show
     * @param isStatus      if true then hide status,otherwise show
     * @param isNavigattion if true then hide navigattion,otherwise show
     */
    public void setFlatStyleColoredBars(boolean isTitle, boolean isStatus, boolean isNavigattion) {

        if (isTitle) {
            this.getWindow().requestFeature(Window.FEATURE_NO_TITLE);
        }
        if (isSupportLollipop()) {

            Window window = this.getWindow();
            if (isStatus) {
                window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
                window.getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                        | View.SYSTEM_UI_FLAG_LAYOUT_STABLE);
                window.setStatusBarColor(Color.TRANSPARENT);
            } else if (isNavigattion) {
                window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
                window.getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                        | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION);
                window.setNavigationBarColor(Color.TRANSPARENT);
            } else if (isStatus && isNavigattion) {
                window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS | WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
                window.getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                        | View.SYSTEM_UI_FLAG_LAYOUT_STABLE | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION);
                window.setStatusBarColor(Color.TRANSPARENT);
                window.setNavigationBarColor(Color.TRANSPARENT);
            }
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        }
    }


    /**
     * @param position
     */
    public void setActionBar(ViewGroup parent, int position, String title) {

        ActionBarFactory factory = new ActionBarFactory(this);
        factory.setActionBar(parent, position, title);
        factory.setActionListener(this);

    }

    /**
     * show toast
     *
     * @param message
     */
    public void showToast(String message) {

        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }


    @Override
    public void onLeftClick(View view) {

    }

    @Override
    public void onRightClick(View view, CheckBox checkBox) {

    }


    @Override
    public void onTitleClick(View view) {

    }
}
