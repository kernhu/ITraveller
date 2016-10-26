package cn.com.mutual.traveller.oauth;

import android.view.View;
import android.widget.AdapterView;

/**
 * Created by Kern on 2016/9/10.
 */
public interface OnOuathItemClickListenr {

    void onOuathItenClick(AdapterView<?> adapterView, View view, int i, long l,OauthInfo info);
}
