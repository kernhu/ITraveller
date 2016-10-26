package cn.com.mutual.traveller;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.LinearLayout;

import cn.com.mutual.traveller.bar.tab.action.ActionBarFactory;
import cn.com.mutual.traveller.tools.HideSoftInput;

/**
 * Created by Kern on 2016/9/14.
 */
public class RegisterActivity extends BaseActivity {


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setFlatStyleColoredBars(true, true, true);
        setContentView(R.layout.activity_register);

        new HideSoftInput(this).setBaseView(findViewById(R.id.base_layout_login));
        setActionBar((LinearLayout) findViewById(R.id.register_action), ActionBarFactory.ACTION_TYPE_NORMAL, getString(R.string.register_title));
    }


    @Override
    public void onLeftClick(View view) {
        super.onLeftClick(view);
        finish();
    }
}
