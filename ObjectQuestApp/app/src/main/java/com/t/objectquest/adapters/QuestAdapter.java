package com.t.objectquest.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.t.objectquest.R;
import com.t.objectquest.model.Quest;

import java.util.List;

public class QuestAdapter extends BaseAdapter {

    private List<Quest> quests;
    private Context context;

    public QuestAdapter(List<Quest> quests, Context context) {
        this.quests = quests;
        this.context = context;
    }

    @Override
    public int getCount(){ return quests.size();}

    @Override
    public Quest getItem(int position) {return quests.get(position);}

    @Override
    public long getItemId(int position){
        return quests.get(position).getQuestId();
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent){

        Quest quest = quests.get(position);
        LayoutInflater inflater = context.getSystemService(LayoutInflater.class);
        View view = convertView;
        if( view == null){
            view = inflater.inflate(R.layout.quest, parent, false);
        }

        TextView questName = view.findViewById(R.id.questName);
        questName.setText(quest.getQuestName());
        return view;
    }

}
