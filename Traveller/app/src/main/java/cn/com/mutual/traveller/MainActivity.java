package cn.com.mutual.traveller;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import cn.com.mutual.traveller.tools.ShareprefHelper;

public class MainActivity extends BaseActivity {

    private static final String DEBUT_TIME = "debut_time";
    private static final int DELAY_TIME = 3000;
    private ShareprefHelper helper = null;
    private Intent intent = null;
    private int time;
    private boolean isDeBut = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setFlatStyleColoredBars(true, true, true);
        setContentView(R.layout.activity_main);

        helper = ShareprefHelper.getInstance(this);
        isDeBut = isDebut();

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                postpone(isDeBut);

            }
        }, DELAY_TIME);
    }


    /**
     * @param isDebut 是否是初次登陆
     */
    public void postpone(boolean isDebut) {

        helper.setIntExtra(DEBUT_TIME, time + 1);

        if (isDebut) {
            intent = new Intent(MainActivity.this, ReferralActivity.class);
        } else {
            intent = new Intent(MainActivity.this, HomeActivity.class);
        }
        startActivity(intent);
        finish();
    }


    /**
     * @return
     */
    public int getDebutTime() {

        return helper.getInt(DEBUT_TIME, 0);
    }

    /**
     * @return
     */
    public boolean isDebut() {

        time = getDebutTime();

        return time == 0 ? true : false;
    }
}
