package cn.com.mutual.traveller.frags.home;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.CheckBox;
import android.widget.PopupWindow;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import cn.com.mutual.traveller.R;
import cn.com.mutual.traveller.bar.tab.menu.MenuItemInfo;
import cn.com.mutual.traveller.bar.tab.menu.OnMenuClickListener;
import cn.com.mutual.traveller.bar.tab.menu.PopupMenuView;
import cn.com.mutual.traveller.frags.BaseFragment;


/**
 * Created by Kern on 2016/8/26.
 */
public class HomeFragment extends BaseFragment implements OnMenuClickListener {


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_home, null, false);
        setActionBar(getArguments().getInt("position", 0));

        return view;
    }


    @Override
    public void onLeftClick(View view) {
        super.onLeftClick(view);


    }

    @Override
    public void onRightClick(View view, final CheckBox checkBox) {
        super.onRightClick(view, checkBox);

        List<MenuItemInfo> items = new ArrayList<>();
        items.add(new MenuItemInfo(R.drawable.ic_menu_write, getString(R.string.menu_write)));
        items.add(new MenuItemInfo(R.drawable.ic_menu_draft, getString(R.string.menu_draft)));
        items.add(new MenuItemInfo(R.drawable.ic_menu_mark, getString(R.string.menu_mark)));
        PopupMenuView menuView = PopupMenuView.getInstance(getActivity(), items);
        PopupWindow window = menuView.createMenu(true, R.drawable.bgc_popup_menu, view);
        window.setOnDismissListener(new PopupWindow.OnDismissListener() {
            @Override
            public void onDismiss() {

                checkBox.setPressed(false);
                checkBox.setSelected(false);
                checkBox.setChecked(false);
            }
        });

        menuView.setOnMenuClickListener(this);
    }

    @Override
    public void onMenuClick(AdapterView<?> adapterView, View view, int i, long l, MenuItemInfo info) {


        showToast("info:"+info.getTitle());
    }
}
