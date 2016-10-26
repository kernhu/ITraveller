package cn.com.mutual.traveller.bar.tab;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import cn.com.mutual.traveller.R;
import cn.com.mutual.traveller.tools.LogTool;

/**
 * Created by Kern on 2016/9/8.
 */
public class TabBarView extends View {

    private Context context;
    private static TabBarView mTabBarView;

    private RadioGroup mTabControl;
    public OnTabChangeListener onTabChangeListener;

    public TabBarView(Context context) {
        super(context);
        this.context = context;
    }


    public static TabBarView getInstance(Context context) {

        if (mTabBarView == null) {
            mTabBarView = new TabBarView(context);
        }
        return mTabBarView;
    }

    public void createTabBar(ViewGroup parent, TabBarInfo info) {

        View view = LayoutInflater.from(context).inflate(R.layout.layout_tab_bar, null);
        ViewGroup.LayoutParams params = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        parent.addView(view, params);

        mTabControl = (RadioGroup) view.findViewById(R.id.tab_control);
        if (info.getTabs() != null && info.getTabs().size() == mTabControl.getChildCount()) {
            for (int i = 0; i < mTabControl.getChildCount(); i++) {

                Drawable drawable = info.getTabs().get(i).getDrawableRes();
                drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
                ((RadioButton) mTabControl.getChildAt(i)).setCompoundDrawables(null, drawable, null, null);
                ((RadioButton) mTabControl.getChildAt(i)).setText(info.getTabs().get(i).getTitle());

            }
        } else {

            LogTool.logK(LogTool.LOG_E, LogTool.TAG_K, "TabInfo's count is not match RadioGroup's child count or TabInfo is null");

        }
        ((RadioButton) mTabControl.getChildAt(0)).setChecked(true);
        mTabControl.setOnCheckedChangeListener(changeListener);
    }


    public RadioGroup getParentGroup() {

        return mTabControl;
    }

    RadioGroup.OnCheckedChangeListener changeListener = new RadioGroup.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(RadioGroup radioGroup, int checkedId) {

            int position = 0;
            switch (checkedId) {
                case R.id.tab_home:
                    position = 0;
                    break;
                case R.id.tab_zone:
                    position = 1;
                    break;
                case R.id.tab_square:
                    position = 2;
                    break;
                case R.id.tab_mine:
                    position = 3;
                    break;
            }
            if (onTabChangeListener != null) {

                onTabChangeListener.onTabChange(radioGroup, position);
            }
        }
    };

    public void setOnTabChangeListener(OnTabChangeListener onTabChangeListener) {

        this.onTabChangeListener = onTabChangeListener;
    }
}
