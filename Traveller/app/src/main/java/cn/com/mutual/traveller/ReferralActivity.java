package cn.com.mutual.traveller;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Kern on 2016/9/7.
 * 介绍《引导界面》
 */
public class ReferralActivity extends BaseActivity {


    private ViewPager mReferralPager;
    private List<Fragment> fragments;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setFlatStyleColoredBars(true, true, true);
        setContentView(R.layout.activity_referral);

        fragments = new ArrayList<>();
        fragments.add(new ReferralFragment());
        fragments.add(new ReferralFragment());
        fragments.add(new ReferralFragment());

        initView();
    }

    private void initView() {

        mReferralPager = (ViewPager) findViewById(R.id.referral_pager);

        mReferralPager.setAdapter(new ReferralPagerAdapter(this.getSupportFragmentManager()));

    }


    class ReferralPagerAdapter extends FragmentPagerAdapter {


        public ReferralPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {

            Fragment fragment = fragments.get(position);
            Bundle bundle = new Bundle();
            bundle.putInt("position", position);
            fragment.setArguments(bundle);
            return fragment;
        }

        @Override
        public int getCount() {
            return fragments.size();
        }
    }
}
