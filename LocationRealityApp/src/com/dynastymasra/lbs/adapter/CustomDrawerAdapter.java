package com.dynastymasra.lbs.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.dynastymasra.lbs.R;
import com.dynastymasra.lbs.domain.DrawerItem;

import java.util.List;

/**
 * Author   : Dynastymasra
 * Name     : Dimas Ragil T
 * Email    : dynastymasra@gmail.com
 * LinkedIn : http://www.linkedin.com/in/dynastymasra
 * Blogspot : dynastymasra.wordpress.com | dynastymasra.blogspot.com
 */
public class CustomDrawerAdapter extends BaseAdapter {

    private Context context;
    private List<DrawerItem> drawerItemList;

    public CustomDrawerAdapter(Context context, List<DrawerItem> listItems) {
        this.context = context;
        this.drawerItemList = listItems;
    }

    @Override
    public int getCount() {
        return drawerItemList.size();
    }

    @Override
    public Object getItem(int i) {
        return drawerItemList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // TODO Auto-generated method stub
        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.custom_drawer_item, parent, false);
        }

        TextView itemName = (TextView) convertView.findViewById(R.id.drawer_itemName);
        ImageView icon = (ImageView) convertView.findViewById(R.id.drawer_icon);
        TextView title = (TextView) convertView.findViewById(R.id.drawerTitle);
        LinearLayout headerLayout = (LinearLayout) convertView.findViewById(R.id.headerLayout);
        LinearLayout itemLayout = (LinearLayout) convertView.findViewById(R.id.itemLayout);

        DrawerItem dItem = (DrawerItem) this.drawerItemList.get(position);

        if (dItem.getTitle() != null) {
            headerLayout.setVisibility(LinearLayout.VISIBLE);
            itemLayout.setVisibility(LinearLayout.INVISIBLE);
            title.setText(dItem.getTitle());
        } else {
            headerLayout.setVisibility(LinearLayout.INVISIBLE);
            itemLayout.setVisibility(LinearLayout.VISIBLE);
            icon.setImageDrawable(convertView.getResources().getDrawable(dItem.getImgResID()));
            itemName.setText(dItem.getItemName());
        }

        return convertView;
    }
}