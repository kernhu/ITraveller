package cn.com.mutual.traveller.bar.tab;

import android.content.Context;
import java.util.ArrayList;
import java.util.List;

import cn.com.mutual.traveller.R;

/**
 * Created by Kern on 2016/8/29.
 */
public class TabBarInfo {

    private int tabBackgroudColor;
    private int tabTextColor;
    private List<TabInfo> tabs;

    public TabBarInfo(Context context) {
        this.tabBackgroudColor = R.color.bgc_tab_bar;
        this.tabTextColor = R.color.color_tab_text;
        this.tabs = new ArrayList<TabInfo>();
    }
    public TabBarInfo(int tabBackgroudColor, int tabTextColor, List<TabInfo> tabs) {
        this.tabBackgroudColor = tabBackgroudColor;
        this.tabTextColor = tabTextColor;
        this.tabs = tabs;
    }

    public int getTabBackgroudColor() {
        return tabBackgroudColor;
    }

    public void setTabBackgroudColor(int tabBackgroudColor) {
        this.tabBackgroudColor = tabBackgroudColor;
    }

    public int getTabTextColor() {
        return tabTextColor;
    }

    public void setTabTextColor(int tabTextColor) {
        this.tabTextColor = tabTextColor;
    }

    public List<TabInfo> getTabs() {
        return tabs;
    }

    public void setTabs(List<TabInfo> tabs) {
        this.tabs = tabs;
    }
}


