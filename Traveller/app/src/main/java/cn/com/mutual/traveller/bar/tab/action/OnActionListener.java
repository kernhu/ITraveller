package cn.com.mutual.traveller.bar.tab.action;

import android.view.View;
import android.widget.CheckBox;

/**
 * Created by Kern on 2016/8/30.
 */
public interface OnActionListener {

    void onLeftClick(View view);

    void onRightClick(View view,CheckBox checkBox);

    void onTitleClick(View view);
}
