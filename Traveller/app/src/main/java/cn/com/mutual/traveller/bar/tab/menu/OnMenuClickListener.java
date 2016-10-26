package cn.com.mutual.traveller.bar.tab.menu;

import android.view.View;
import android.widget.AdapterView;

/**
 * Created by Kern on 2016/9/13.
 */
public interface OnMenuClickListener {

    void onMenuClick(AdapterView<?> adapterView, View view, int i, long l, MenuItemInfo info);
}
