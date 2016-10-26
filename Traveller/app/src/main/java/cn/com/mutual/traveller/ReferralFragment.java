package cn.com.mutual.traveller;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Kern on 2016/9/7.
 */
public class ReferralFragment extends Fragment {


    private ImageView mReferralFrames;
    private TextView mReferralSkip;

    private Intent intent = null;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_referral, null);
        mReferralFrames = (ImageView) view.findViewById(R.id.referral_frames);
        mReferralSkip = (TextView) view.findViewById(R.id.referral_skip);
        mReferralSkip.setOnClickListener(listener);

        int position = getArguments().getInt("position", 0);
        switchFrames(position);

        return view;
    }

    public void switchFrames(int position) {

        switch (position) {

            case 0:

                mReferralFrames.setBackgroundColor(Color.GREEN);
                break;
            case 1:

                mReferralFrames.setBackgroundColor(Color.WHITE);
                break;
            case 2:

                mReferralSkip.setVisibility(View.VISIBLE);
                mReferralFrames.setBackgroundColor(Color.YELLOW);
                break;
        }
    }


    View.OnClickListener listener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {

            intent = new Intent(getActivity(), HomeActivity.class);
            getActivity().startActivity(intent);
            getActivity().finish();

        }
    };

}
