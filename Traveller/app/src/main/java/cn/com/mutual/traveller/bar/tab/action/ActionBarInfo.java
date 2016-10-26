package cn.com.mutual.traveller.bar.tab.action;

import android.content.Context;

import cn.com.mutual.traveller.R;

/**
 * Created by Kern on 2016/8/29.
 */
public class ActionBarInfo {

    //title
    private String title;
    private int titleColor;
    private int titleBackgroudColor;
    private boolean isTitleHide;

    //left button
    private int leftImage;
    private boolean isLeftHide;

    //right button
    private int rightImage;
    private boolean isRightHide;

    public ActionBarInfo(Context context) {

        this.title = "APP";
        this.titleColor =context.getResources().getColor(R.color.bgc_withe);
        this.titleBackgroudColor=context.getResources().getColor(R.color.bgc_action_bar);
        this.isTitleHide=false;
        this.leftImage=R.drawable.selector_action_menu;
        this.isLeftHide =false;
        this.rightImage = R.drawable.selector_action_menu;
        this.isRightHide = false;
    }

    public ActionBarInfo(String title, int titleColor, int titleBackgroudColor, boolean isTitleHide, int leftImage, boolean isLeftHide, int rightImage, boolean isRightHide) {
        this.title = title;
        this.titleColor = titleColor;
        this.titleBackgroudColor = titleBackgroudColor;
        this.isTitleHide = isTitleHide;
        this.leftImage = leftImage;
        this.isLeftHide = isLeftHide;
        this.rightImage = rightImage;
        this.isRightHide = isRightHide;
    }

    public String getTitle() {
        return title;
    }

    public int getTitleColor() {
        return titleColor;
    }

    public int getTitleBackgroudColor() {
        return titleBackgroudColor;
    }

    public boolean isTitleHide() {
        return isTitleHide;
    }

    public int getLeftImage() {
        return leftImage;
    }

    public boolean isLeftHide() {
        return isLeftHide;
    }

    public int getRightImage() {
        return rightImage;
    }

    public boolean isRightHide() {
        return isRightHide;
    }


    public void setTitle(String title) {
        this.title = title;
    }

    public void setTitleColor(int titleColor) {
        this.titleColor = titleColor;
    }

    public void setTitleBackgroudColor(int titleBackgroudColor) {
        this.titleBackgroudColor = titleBackgroudColor;
    }

    public void setTitleHide(boolean titleHide) {
        isTitleHide = titleHide;
    }

    public void setLeftImage(int leftImage) {
        this.leftImage = leftImage;
    }

    public void setLeftHide(boolean leftHide) {
        isLeftHide = leftHide;
    }

    public void setRightImage(int rightImage) {
        this.rightImage = rightImage;
    }

    public void setRightHide(boolean rightHide) {
        isRightHide = rightHide;
    }

    @Override
    public String toString() {
        return "ActionBarInfo{" +
                "title='" + title + '\'' +
                ", titleColor=" + titleColor +
                ", titleBackgroudColor=" + titleBackgroudColor +
                ", isTitleHide=" + isTitleHide +
                ", leftImage=" + leftImage +
                ", isLeftHide=" + isLeftHide +
                ", rightImage=" + rightImage +
                ", isRightHide=" + isRightHide +
                '}';
    }
}
