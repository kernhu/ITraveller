package cn.com.mutual.traveller.oauth;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import cn.com.mutual.traveller.R;

/**
 * Created by Kern on 2016/9/10.
 */
public class OauthView implements AdapterView.OnItemClickListener {


    private Context context;
    private List<OauthInfo> oauths;
    private static OauthView oauthView;
    private GridView gridView = null;
    private OauthAdapter adapter = null;
    private OnOuathItemClickListenr onOuathItemClickListenr;

    public OauthView(Context context, List<OauthInfo> oauths) {
        this.context = context;
        this.oauths = oauths;
    }

    public static OauthView getInstance(Context context, List<OauthInfo> oauths) {

        if (oauthView == null) {

            oauthView = new OauthView(context, oauths);
        }
        return oauthView;
    }

    public void createOauthView(ViewGroup parent) {


        View view = LayoutInflater.from(context).inflate(R.layout.layout_oauth, null);
        parent.addView(view);

        gridView = (GridView) view.findViewById(R.id.login_ouath_list);
        adapter = new OauthAdapter(context, oauths);
        gridView.setAdapter(adapter);

        gridView.setOnItemClickListener(this);

    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

        if (onOuathItemClickListenr != null) {
            onOuathItemClickListenr.onOuathItenClick(adapterView, view, i, l, (OauthInfo) adapter.getItem(i));
        }
    }

    public void setOnOuathItemClickListenr(OnOuathItemClickListenr onOuathItemClickListenr) {

        this.onOuathItemClickListenr = onOuathItemClickListenr;
    }

    /*****************************************************/
    class OauthAdapter extends BaseAdapter {

        private Context context;
        private List<OauthInfo> oauths;

        public OauthAdapter(Context context, List<OauthInfo> oauths) {
            this.context = context;
            this.oauths = oauths;
        }

        @Override
        public int getCount() {
            return oauths.size();
        }

        @Override
        public Object getItem(int i) {
            return oauths.get(i);
        }

        @Override
        public long getItemId(int i) {
            return i;
        }


        class Holder {

            ImageView image;
            TextView name;
        }


        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {

            Holder holder = null;
            if (view == null) {

                holder = new Holder();
                view = LayoutInflater.from(context).inflate(R.layout.item_oauth_list, null);
                holder.image = (ImageView) view.findViewById(R.id.oauth_image);
                holder.name = (TextView) view.findViewById(R.id.oauth_name);
                view.setTag(holder);
            } else {
                holder = (Holder) view.getTag();
            }
            holder.image.setImageResource(oauths.get(i).getIamge());
            holder.name.setText(oauths.get(i).getName());
            return view;
        }
    }
}
