package com.t.objectquest.adapters;

import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

import com.t.objectquest.R;

import java.util.HashMap;
import java.util.List;

public class QuestExpandableListAdapter extends BaseExpandableListAdapter {

    private Context context;
    private List<String> questName;
    private HashMap<String, List<String>> objects;


    public QuestExpandableListAdapter(Context context, List<String> questName, HashMap<String, List<String>> objects) {
        this.context = context;
        this.questName = questName;
        this.objects = objects;
    }

    @Override
    public Object getChild(int listPosition, int expandedListPosition) {
        return this.objects.get(this.questName.get(listPosition));
    }

    @Override
    public long getChildId(int listPosition, int expandedListPosition) {
        return expandedListPosition;
    }

    @Override
    public View getChildView(int listPosition, final int expandedListPosition,
                             boolean isLastChild, View convertView, ViewGroup parent) {
        final String expandedListText = (String) getChild(listPosition, expandedListPosition);
        if (convertView == null) {
            LayoutInflater layoutInflater = (LayoutInflater) this.context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = layoutInflater.inflate(R.layout.quest_list, null);
        }
        TextView expandedListTextView = (TextView) convertView
                .findViewById(R.id.quest_name);
        expandedListTextView.setText(expandedListText);
        return convertView;
    }



    @Override
    public int getChildrenCount(int listPosition) {
        return this.objects.get(this.questName.get(listPosition))
                .size();
    }



    @Override
    public Object getGroup(int listPosition) {
        return this.questName.get(listPosition);
    }

    @Override
    public int getGroupCount() {
        return this.questName.size();
    }

    @Override
    public long getGroupId(int listPosition) {
        return listPosition;
    }

    @Override
    public View getGroupView(int listPosition, boolean isExpanded,
                             View convertView, ViewGroup parent) {
        String listTitle = (String) getGroup(listPosition);
        if (convertView == null) {
            LayoutInflater layoutInflater = (LayoutInflater) this.context.
                    getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = layoutInflater.inflate(R.layout.quest_list, null);
        }
        TextView listTitleTextView = (TextView) convertView
                .findViewById(R.id.listTitle);
        listTitleTextView.setTypeface(null, Typeface.BOLD);
        listTitleTextView.setText(listTitle);
        return convertView;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public boolean isChildSelectable(int listPosition, int expandedListPosition) {
        return true;
    }

}
