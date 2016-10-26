package cn.com.mutual.traveller.frags.mine;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import cn.com.mutual.traveller.LoginActivity;
import cn.com.mutual.traveller.R;
import cn.com.mutual.traveller.bar.tab.action.ActionBarFactory;
import cn.com.mutual.traveller.bar.tab.action.OnActionListener;
import cn.com.mutual.traveller.frags.BaseFragment;


/**
 * Created by Kern on 2016/8/26.
 */
public class MineFragment extends BaseFragment {

    private static final int REQUEST_CODE_LOGIN = 4001;
    private Intent intent;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_mine, null, false);
        setActionBar(getArguments().getInt("position", 0));

        skipLogin(false);

        return view;
    }

    public void skipLogin(boolean isLogin) {

        if (!isLogin) {
            intent = new Intent(getActivity(), LoginActivity.class);
            startActivityForResult(intent, REQUEST_CODE_LOGIN);
        }
    }

}
