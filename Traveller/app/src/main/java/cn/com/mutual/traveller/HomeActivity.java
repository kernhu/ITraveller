package cn.com.mutual.traveller;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RadioGroup;

import java.util.ArrayList;
import java.util.List;

import cn.com.mutual.traveller.bar.tab.OnTabChangeListener;
import cn.com.mutual.traveller.bar.tab.TabBarInfo;
import cn.com.mutual.traveller.bar.tab.TabBarView;
import cn.com.mutual.traveller.bar.tab.TabInfo;
import cn.com.mutual.traveller.frags.home.HomeFragment;
import cn.com.mutual.traveller.frags.mine.MineFragment;
import cn.com.mutual.traveller.frags.square.SquareFragment;
import cn.com.mutual.traveller.frags.zone.ZoneFragment;

/**
 * Created by Kern on 2016/9/7.
 * 介绍《引导界面》
 */
public class HomeActivity extends BaseActivity {

    private long backTime = 0;
    private LinearLayout mAreaTabBar;
    private FrameLayout mAreaFrame;
    private TabBarView mTabBarView = null;
    private RadioGroup mControl;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setFlatStyleColoredBars(true, true, true);
        setContentView(R.layout.activity_home);


        initView();

    }

    /**
     * @return 实例化Fragment 存入集合
     */
    private List<Fragment> getFragment() {

        List<Fragment> fragments = new ArrayList<>();
        fragments.add(new HomeFragment());
        fragments.add(new ZoneFragment());
        fragments.add(new SquareFragment());
        fragments.add(new MineFragment());

        return fragments;
    }

    /**
     * 实例化视图
     */
    private void initView() {

        mAreaTabBar = (LinearLayout) findViewById(R.id.area_tab_bar);
        mAreaFrame = (FrameLayout) findViewById(R.id.area_frame);
        setTabBar(mAreaTabBar);
        initFragment(0);
    }

    public void initFragment(int position) {

        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        Fragment fragment = getFragment().get(position);
        Bundle bundle = new Bundle();
        bundle.putInt("position", position);
        fragment.setArguments(bundle);
        transaction.replace(R.id.area_frame, fragment);
        transaction.commit();

    }

    /**
     * TabBar设置
     *
     * @param parent
     */
    public void setTabBar(ViewGroup parent) {

        TabBarInfo tabBarInfo = new TabBarInfo(this);
        tabBarInfo.setTabBackgroudColor(R.color.bgc_tab_bar);
        tabBarInfo.setTabTextColor(R.color.cl_tab_text);
        List<TabInfo> tabInfos = new ArrayList<>();
        tabInfos.add(new TabInfo(getResources().getDrawable(R.drawable.selector_home), getString(R.string.tab_home)));
        tabInfos.add(new TabInfo(getResources().getDrawable(R.drawable.selector_zone), getString(R.string.tab_zone)));
        tabInfos.add(new TabInfo(getResources().getDrawable(R.drawable.selector_square), getString(R.string.tab_square)));
        tabInfos.add(new TabInfo(getResources().getDrawable(R.drawable.selector_mine), getString(R.string.tab_mine)));
        tabBarInfo.setTabs(tabInfos);

        mTabBarView = TabBarView.getInstance(this);
        mTabBarView.createTabBar(parent, tabBarInfo);
        mControl = mTabBarView.getParentGroup();
        mTabBarView.setOnTabChangeListener(onTabChangeListener);
    }

    /**
     * 自定义TabBar的事件监听
     */
    OnTabChangeListener onTabChangeListener = new OnTabChangeListener() {
        @Override
        public void onTabChange(RadioGroup radioGroup, int position) {

            initFragment(position);
        }
    };

    /****************
     * 回退
     ***************/
    /**
     * second times to press back to finish app
     */
    @Override
    public void onBackPressed() {

        if (System.currentTimeMillis() - backTime < 3000) {
            System.exit(0);
        } else {
            backTime = System.currentTimeMillis();
            showToast(getString(R.string.msg_back_app));
        }
    }
}
