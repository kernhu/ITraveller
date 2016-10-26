package cn.com.mutual.traveller.frags;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.Toast;

import cn.com.mutual.traveller.R;
import cn.com.mutual.traveller.bar.tab.action.ActionBarFactory;
import cn.com.mutual.traveller.bar.tab.action.ActionBarView;
import cn.com.mutual.traveller.bar.tab.action.OnActionListener;

/**
 * Created by Kern on 2016/9/8.
 */
public class BaseFragment extends Fragment implements OnActionListener {

    private ActionBarView mActionBarView = null;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        mActionBarView = ActionBarView.getInstance(getActivity());
        mActionBarView.setOnActionListener(this);

        return super.onCreateView(inflater, container, savedInstanceState);
    }


    /**
     * @param position
     */
    public void setActionBar(int position) {

        ViewGroup parent = (ViewGroup) getActivity().findViewById(R.id.area_action_bar);

        ActionBarFactory factory = new ActionBarFactory(getActivity());
        factory.setActionBar(parent, position, null);
        factory.setActionListener(this);

    }

    public void showToast(String message) {

        Toast.makeText(getActivity(), message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onLeftClick(View view) {


    }

    @Override
    public void onRightClick(View view, CheckBox checkBox) {

    }


    @Override
    public void onTitleClick(View view) {

    }
}
