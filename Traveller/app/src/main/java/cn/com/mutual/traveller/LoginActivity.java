package cn.com.mutual.traveller;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.SlidingDrawer;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import cn.com.mutual.traveller.bar.tab.action.ActionBarFactory;
import cn.com.mutual.traveller.oauth.OauthInfo;
import cn.com.mutual.traveller.oauth.OauthLoginManager;
import cn.com.mutual.traveller.oauth.OauthView;
import cn.com.mutual.traveller.oauth.OnOuathItemClickListenr;
import cn.com.mutual.traveller.tools.HideSoftInput;
import cn.com.mutual.traveller.view.BardianImageView;

/**
 * Created by Kern on 2016/9/9.
 */
public class LoginActivity extends BaseActivity implements SlidingDrawer.OnDrawerCloseListener, SlidingDrawer.OnDrawerOpenListener, OnOuathItemClickListenr, View.OnTouchListener, View.OnClickListener {


    private static final int REQUSET_LOGIN = 50;
    private LinearLayout loginAction;
    private BardianImageView logoIcon;
    private OauthLoginManager manager = null;
    private SlidingDrawer slidingDrawer;
    private ImageView drawerClosed;
    private EditText editAccount, editPassword;
    private CheckBox markPassword;
    private TextView loginBtn;
    private TextView register, retrieve;

    private Intent intent;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setFlatStyleColoredBars(true, true, true);
        setContentView(R.layout.activity_login);

        new HideSoftInput(this).setBaseView(findViewById(R.id.base_layout_login));
        loginAction = (LinearLayout) findViewById(R.id.login_action);
        setActionBar(loginAction, ActionBarFactory.ACTION_TYPE_NORMAL, getString(R.string.app_name));

        slidingDrawer = (SlidingDrawer) findViewById(R.id.login_sliding);
        drawerClosed = (ImageView) findViewById(R.id.login_drawer_close);
        slidingDrawer.setOnDrawerCloseListener(this);
        slidingDrawer.setOnDrawerOpenListener(this);

        editAccount = (EditText) findViewById(R.id.login_account_box);
        editPassword = (EditText) findViewById(R.id.login_password_box);
        markPassword = (CheckBox) findViewById(R.id.login_mark_password);
        loginBtn = (TextView) findViewById(R.id.login_btn);

        editAccount.setOnTouchListener(this);
        editPassword.setOnTouchListener(this);

        register = (TextView) findViewById(R.id.login_register);
        retrieve = (TextView) findViewById(R.id.login_retrieve);
        register.setOnClickListener(this);
        retrieve.setOnClickListener(this);
    }

    /**
     * 回退按钮
     *
     * @param view
     */
    @Override
    public void onLeftClick(View view) {
        super.onLeftClick(view);
        finish();
    }

    @Override
    public boolean onTouch(View view, MotionEvent motionEvent) {
        //关闭SlidingDrawable
        slidingDrawer.close();
        return false;
    }

    /**
     * 初始化数据
     *
     * @return
     */
    public List<OauthInfo> getOauths() {

        List<OauthInfo> infos = new ArrayList<>();
        OauthInfo qq = new OauthInfo(getString(R.string.oauth_qq), R.drawable.ic_qq_normal, OauthInfo.OAUTH_QQ, true);
        OauthInfo wx = new OauthInfo(getString(R.string.oauth_wx), R.drawable.ic_wx_normal, OauthInfo.OAUTH_WX, true);
        OauthInfo zfb = new OauthInfo(getString(R.string.oauth_zfb), R.drawable.ic_zfb_normal, OauthInfo.OAUTH_ZFB, true);
        OauthInfo wb = new OauthInfo(getString(R.string.oauth_wb), R.drawable.ic_wb_normal, OauthInfo.OAUTH_WB, true);
        infos.add(qq);
        infos.add(wx);
        infos.add(zfb);
        infos.add(wb);

        return infos;
    }

    /**
     * 设置第三方登录控件
     */
    public void setOauthView() {

        OauthView oauthView = OauthView.getInstance(this, getOauths());
        oauthView.createOauthView((ViewGroup) findViewById(R.id.login_content));
        oauthView.setOnOuathItemClickListenr(this);
    }

    @Override
    public void onDrawerClosed() {
        drawerClosed.setVisibility(View.GONE);
    }

    @Override
    public void onDrawerOpened() {
        drawerClosed.setVisibility(View.VISIBLE);
        setOauthView();
    }


    /**
     * 第三方登陆事件监听
     *
     * @param adapterView
     * @param view
     * @param i
     * @param l
     * @param info
     */
    @Override
    public void onOuathItenClick(AdapterView<?> adapterView, View view, int i, long l, OauthInfo info) {

        manager = OauthLoginManager.getInstance(this);
        manager.oauthLogin(info.getCode());
    }

    /**
     * 点击事件监听
     *
     * @param view
     */
    @Override
    public void onClick(View view) {

        switch (view.getId()) {

            case R.id.login_register:

                intent = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivityForResult(intent, REQUSET_LOGIN);

                break;
            case R.id.login_retrieve:


                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        manager.onActivityResult(requestCode, resultCode, data);
    }


}
