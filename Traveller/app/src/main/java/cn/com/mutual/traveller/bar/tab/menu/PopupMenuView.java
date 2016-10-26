package cn.com.mutual.traveller.bar.tab.menu;

import android.app.Activity;
import android.content.Context;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.TextView;


import java.util.List;

import cn.com.mutual.traveller.R;

/**
 * Created by Kern on 2016/8/29.
 */
public class PopupMenuView extends View {

    private Context context;
    private static PopupMenuView popupMenuView;
    public List<MenuItemInfo> items;
    public PopupWindow popup;
    public ListView mMenuList;

    public OnMenuClickListener onMenuClickListener;

    public PopupMenuView(Context context, List<MenuItemInfo> items) {
        super(context);
        this.context = context;
        this.items = items;
    }

    public static PopupMenuView getInstance(Context context, List<MenuItemInfo> items) {

        if (popupMenuView == null) {

            popupMenuView = new PopupMenuView(context, items);
        }
        return popupMenuView;
    }

    public PopupWindow createMenu(boolean touchable, int bgc, View view) {

        View v = LayoutInflater.from(context).inflate(R.layout.layout_popup_menu, null);
        popup = new PopupWindow(v, ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT, true);
        int width = ((Activity) context).getWindowManager().getDefaultDisplay().getWidth();
        popup.setWidth(width / 3);
        popup.setOutsideTouchable(touchable);
        popup.setBackgroundDrawable(context.getResources().getDrawable(bgc));
        mMenuList = (ListView) v.findViewById(R.id.menu_list);
        PopupMenuAdapter adapter = new PopupMenuAdapter(context, items);
        mMenuList.setAdapter(adapter);
        mMenuList.setOnItemClickListener(itemClickListener);

        if (popup != null) {
            if (!popup.isShowing()) {
                popup.showAsDropDown(view);
            } else {
                popup.dismiss();
            }
        }

        return popup;
    }

    AdapterView.OnItemClickListener itemClickListener = new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

            if (popup != null) {
                popup.dismiss();
            }
            if (onMenuClickListener != null) {
                onMenuClickListener.onMenuClick(adapterView, view, i, l, items.get(i));
            }
        }
    };

    public void setOnMenuClickListener(OnMenuClickListener onMenuClickListener) {

        this.onMenuClickListener = onMenuClickListener;
    }

    /*******************************************************************/
    class PopupMenuAdapter extends BaseAdapter {

        public Context context;
        public List<MenuItemInfo> items;

        public PopupMenuAdapter(Context context, List<MenuItemInfo> items) {
            this.context = context;
            this.items = items;
        }

        @Override
        public int getCount() {
            return items.size();
        }

        @Override
        public Object getItem(int i) {
            return items.get(i);
        }

        @Override
        public long getItemId(int i) {
            return i;
        }

        class Holder {

            ImageView image;
            TextView title;
        }

        @Override
        public View getView(int i, View convertView, ViewGroup viewGroup) {

            Holder holder = null;
            if (convertView == null) {
                holder = new Holder();
                convertView = LayoutInflater.from(context).inflate(R.layout.item_menu, null);
                holder.image = (ImageView) convertView.findViewById(R.id.menu_item_icon);
                holder.title = (TextView) convertView.findViewById(R.id.menu_item_title);
                convertView.setTag(holder);
            } else {
                holder = (Holder) convertView.getTag();
            }

            holder.image.setImageResource(items.get(i).getIcon());
            holder.title.setText(items.get(i).getTitle());

            return convertView;
        }
    }
}
