package cn.com.mutual.traveller.tools;

import android.app.Activity;
import android.app.Service;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;

/**
 * Created by Kern on 2016/9/13.
 */
public class HideSoftInput {

    private Activity activity;

    public HideSoftInput(Activity activity) {
        this.activity = activity;
    }

    /**
     * @param activity 隐藏软键盘
     */
    public void hide(Activity activity) {
        InputMethodManager manager = (InputMethodManager) activity.getSystemService(Service.INPUT_METHOD_SERVICE);
        manager.hideSoftInputFromWindow(activity.getCurrentFocus().getWindowToken(), 0);

    }

    /**
     * @param view 递归
     */
    public void setBaseView(View view) {
        if (!(view instanceof EditText)) {
            if (view != null) {
                view.setOnTouchListener(new View.OnTouchListener() {
                    @Override
                    public boolean onTouch(View view, MotionEvent motionEvent) {
                        hide(activity);
                        return false;
                    }
                });
            }
        }
        if (view instanceof ViewGroup) {
            for (int i = 0; i < ((ViewGroup) ((ViewGroup) view)).getChildCount(); i++) {
                View inView = ((ViewGroup) ((ViewGroup) view)).getChildAt(i);
                setBaseView(inView);
            }
        }
    }
}
