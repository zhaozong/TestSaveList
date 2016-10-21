package com.slightech.testsavelist;

import android.content.Context;
import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Rokey on 2016/10/21.
 */

public class MyAdapter extends BaseAdapter {
    private Context context;
    private List<String> list;

    public MyAdapter(Context context, List list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        Holder holder;
        if (convertView == null){
            holder = new Holder();
            convertView = View.inflate(context,R.layout.item_list,null);
            holder.tv = (TextView) convertView.findViewById(R.id.textview);
            convertView.setTag(holder);
        }else {
            holder = (Holder) convertView.getTag();
        }

        holder.tv.setText(list.get(position));
        return convertView;
    }
    class Holder {
        TextView tv ;
    }
}
