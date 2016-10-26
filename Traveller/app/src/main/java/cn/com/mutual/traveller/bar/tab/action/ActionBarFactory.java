package cn.com.mutual.traveller.bar.tab.action;

import android.content.Context;
import android.graphics.Color;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;

import cn.com.mutual.traveller.R;

/**
 * Created by Kern on 2016/9/9.
 */
public class ActionBarFactory {

    public static final int ACTION_TYPE_NORMAL = 4;
    private Context context;
    private ActionBarView mActionBarView = null;
    private OnActionListener mOnActionListener = null;

    public ActionBarFactory(Context context) {

        this.context = context;
    }


    /**
     * @param parent 设置ActionBar
     */
    public void setActionBar(ViewGroup parent, int position,String title) {
        parent.removeAllViews();
        ActionBarInfo actionBarInfo = null;
        switch (position) {

            case 0:
                actionBarInfo = new ActionBarInfo(context);
                actionBarInfo.setTitle(context.getString(R.string.tab_home));
                actionBarInfo.setTitleColor(Color.WHITE);
                actionBarInfo.setTitleBackgroudColor(R.color.bgc_action_bar);
                actionBarInfo.setTitleHide(false);
                actionBarInfo.setLeftHide(false);
                actionBarInfo.setLeftImage(R.drawable.action_near);
                actionBarInfo.setRightHide(false);
                actionBarInfo.setRightImage(R.drawable.selector_action_menu);
                break;

            case 1:
                actionBarInfo = new ActionBarInfo(context);
                actionBarInfo.setTitle(context.getString(R.string.tab_zone));
                actionBarInfo.setTitleColor(Color.WHITE);
                actionBarInfo.setTitleBackgroudColor(R.color.bgc_action_bar);
                actionBarInfo.setTitleHide(false);
                actionBarInfo.setLeftHide(true);
                actionBarInfo.setLeftImage(R.drawable.action_near);
                actionBarInfo.setRightHide(true);
                actionBarInfo.setRightImage(R.drawable.selector_action_menu);
                break;

            case 2:
                actionBarInfo = new ActionBarInfo(context);
                actionBarInfo.setTitle(context.getString(R.string.tab_square));
                actionBarInfo.setTitleColor(Color.WHITE);
                actionBarInfo.setTitleBackgroudColor(R.color.bgc_action_bar);
                actionBarInfo.setTitleHide(false);
                actionBarInfo.setLeftHide(true);
                actionBarInfo.setLeftImage(R.drawable.action_near);
                actionBarInfo.setRightHide(false);
                actionBarInfo.setRightImage(R.drawable.ic_serach);
                break;

            case 3:
                actionBarInfo = new ActionBarInfo(context);
                actionBarInfo.setTitle(context.getString(R.string.tab_mine));
                actionBarInfo.setTitleColor(Color.WHITE);
                actionBarInfo.setTitleBackgroudColor(R.color.bgc_action_bar);
                actionBarInfo.setTitleHide(false);
                actionBarInfo.setLeftHide(true);
                actionBarInfo.setLeftImage(R.drawable.action_near);
                actionBarInfo.setRightHide(false);
                actionBarInfo.setRightImage(R.drawable.ic_setting);
                break;

            case 4:
                actionBarInfo = new ActionBarInfo(context);
                actionBarInfo.setTitle(title);
                actionBarInfo.setTitleColor(Color.WHITE);
                actionBarInfo.setTitleBackgroudColor(R.color.bgc_action_bar);
                actionBarInfo.setTitleHide(false);
                actionBarInfo.setLeftHide(false);
                actionBarInfo.setLeftImage(R.drawable.ic_back);
                actionBarInfo.setRightHide(true);
                actionBarInfo.setRightImage(R.drawable.ic_setting);
                break;

        }

        mActionBarView = ActionBarView.getInstance(context);
        mActionBarView.createActionBar(parent, actionBarInfo);
        mActionBarView.setOnActionListener(onActionListener);
    }

    OnActionListener onActionListener = new OnActionListener() {
        @Override
        public void onLeftClick(View view) {
            if (mOnActionListener != null) {
                mOnActionListener.onLeftClick(view);
            }

        }

        @Override
        public void onRightClick(View view, CheckBox checkBox) {
            if (mOnActionListener != null) {
                mOnActionListener.onRightClick(view,checkBox);
            }
        }


        @Override
        public void onTitleClick(View view) {

            if (mOnActionListener != null) {
                mOnActionListener.onTitleClick(view);
            }

        }
    };

    public void setActionListener(OnActionListener mOnActionListener) {

        this.mOnActionListener = mOnActionListener;
    }
    /**
     * 自定义ActionBar的事件监听
     */


}
