package cn.com.mutual.traveller.bar.tab.menu;

/**
 * Created by Kern on 2016/8/29.
 */
public class MenuItemInfo {

    private int icon;
    private String title;

    public MenuItemInfo(int icon, String title) {
        this.icon = icon;
        this.title = title;
    }

    public int getIcon() {
        return icon;
    }

    public void setIcon(int icon) {
        this.icon = icon;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
