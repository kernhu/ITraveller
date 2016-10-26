package cn.com.mutual.traveller.frags.zone;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import cn.com.mutual.traveller.R;
import cn.com.mutual.traveller.bar.tab.action.ActionBarFactory;
import cn.com.mutual.traveller.bar.tab.action.OnActionListener;
import cn.com.mutual.traveller.frags.BaseFragment;

/**
 * Created by Kern on 2016/8/26.
 */
public class ZoneFragment extends BaseFragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_zone, null, false);
        setActionBar(getArguments().getInt("position",0));

        return view;
    }


}
