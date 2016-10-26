package cn.com.mutual.traveller.bar.tab.action;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.graphics.Rect;
import android.os.Build;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.RelativeLayout;
import android.widget.TextView;

import cn.com.mutual.traveller.R;
import cn.com.mutual.traveller.tools.LogTool;


/**
 * Created by Kern on 2016/8/30.
 */
public class ActionBarView extends View {

    private Context context;
    public CheckBox mActionLeft;
    public CheckBox mActionRight;
    public TextView mActionTitle;
    public OnActionListener onActionListener;

    public static ActionBarView mActionBarView;

    public ActionBarView(Context context) {
        super(context);
        this.context = context;
    }

    public static ActionBarView getInstance(Context context) {

        if (mActionBarView == null) {
            mActionBarView = new ActionBarView(context);
        }
        return mActionBarView;
    }

    /**
     * Coustom actionbar
     *
     * @param parent
     */
    public void createActionBar(ViewGroup parent, ActionBarInfo info) {

        if (info != null) {
            View view = LayoutInflater.from(context).inflate(R.layout.layout_action_bar, null);
            view.setBackgroundColor(getResources().getColor(info.getTitleBackgroudColor()));
            RelativeLayout.LayoutParams layoutParam = null;
            //状态栏一体化时要考虑到上边距//if hide status,should set the margins top
            if (isSupportLollipop()) {
                layoutParam = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
                layoutParam.setMargins(0, 0, 0, 0);
                parent.addView(view, layoutParam);
            } else {
                parent.addView(view);
            }

            mActionLeft = (CheckBox) view.findViewById(R.id.action_left);
            mActionRight = (CheckBox) view.findViewById(R.id.action_right);
            mActionTitle = (TextView) view.findViewById(R.id.action_title);

            if (!info.isTitleHide()) {
                mActionTitle.setText(info.getTitle());
                mActionTitle.setTextColor(info.getTitleColor());
            }

            if (!info.isLeftHide()) {
                mActionLeft.setVisibility(View.VISIBLE);
                mActionLeft.setBackgroundResource(info.getLeftImage());
            } else {
                mActionLeft.setVisibility(View.INVISIBLE);
            }

            if (!info.isRightHide()) {
                mActionRight.setVisibility(View.VISIBLE);
                mActionRight.setBackgroundResource(info.getRightImage());
            } else {
                mActionRight.setVisibility(View.INVISIBLE);
            }
            mActionLeft.setOnClickListener(mActionClick);
            mActionRight.setOnClickListener(mActionClick);
            mActionTitle.setOnClickListener(mActionClick);
        } else {
            LogTool.logK(LogTool.LOG_E, LogTool.TAG_K, "ActionBarInfo is null");
        }
    }

    /**
     * @return SDK higher than 5.0 or not
     */
    protected boolean isSupportLollipop() {

        return Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP;
    }

    /**
     * @return
     */
    protected int getTitleBarHight() {

        Rect rectangle = new Rect();
        ((Activity) context).getWindow().getDecorView().getWindowVisibleDisplayFrame(rectangle);

        return rectangle.top;
    }


    public void setTitle(String title) {

        if (mActionTitle != null) {
            mActionTitle.setText(title);
        }
    }

    View.OnClickListener mActionClick = new View.OnClickListener() {
        @Override
        public void onClick(View view) {

            switch (view.getId()) {

                case R.id.action_left:

                    if (onActionListener != null) {
                        onActionListener.onLeftClick(view);
                    }
                    break;
                case R.id.action_right:

                    if (onActionListener != null) {
                        onActionListener.onRightClick(view,mActionRight);
                    }else {
                        Log.e("sos","action_right");
                    }
                    break;
                case R.id.action_title:

                    if (onActionListener != null) {
                        onActionListener.onTitleClick(view);
                    }
                    break;
            }
        }
    };

    public void setOnActionListener(OnActionListener onActionListener) {

        this.onActionListener = onActionListener;
    }
}
