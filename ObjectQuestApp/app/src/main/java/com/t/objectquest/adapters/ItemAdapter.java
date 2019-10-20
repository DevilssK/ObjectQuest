package com.t.objectquest.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.t.objectquest.R;
import com.t.objectquest.model.Item;

import java.util.List;

public class ItemAdapter extends BaseAdapter {

    private List<Item> items;
    private Context context;

    public ItemAdapter(List<Item> items, Context context) {
        this.items = items;
        this.context = context;
    }

    @Override
    public int getCount(){
        return items.size();
    }

    @Override
    public Object getItem(int position) {
        return items.get(position);
    }

    @Override
    public long getItemId(int position) {
        return items.get(position).getItemId();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        Item item = items.get(position);
        LayoutInflater inflater = context.getSystemService(LayoutInflater.class);
        View view = convertView;
        if(view == null){
            view = inflater.inflate(R.layout.item, parent, false);
        }
        //TextView
        return view;
    }
}
