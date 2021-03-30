package com.example.end;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

import java.util.HashMap;
import java.util.List;

public class Mine_adapter extends BaseExpandableListAdapter {
    Context context;
    List<String> listGrope;
    HashMap<String,List<String>> listItem;
    public Mine_adapter (Context context, List<String> listGrope, HashMap<String, List<String>> listItem){
        this.context=context;
        this.listGrope=listGrope;
        this.listItem=listItem;
    }
    @Override
    public int getGroupCount() {
        return listGrope.size();
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return this.listItem.get(this.listGrope.get(groupPosition)).size();
    }

    @Override
    public Object getGroup(int groupPosition) {
        return this.listGrope.get(groupPosition);
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return this.listItem.get(this.listGrope.get(groupPosition)).get(childPosition);
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
        String group=(String) getGroup(groupPosition);
        if(convertView==null){
            LayoutInflater layoutInflater=(LayoutInflater) this.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView=layoutInflater.inflate(R.layout.listgrop,null);
        }
        TextView textView=convertView.findViewById(R.id.list_par);
        textView.setText(group);
        return convertView;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
       String cheld=(String) getChild(groupPosition,childPosition);
       if (convertView==null){
           LayoutInflater layoutInflater=(LayoutInflater) this.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
           convertView=layoutInflater.inflate(R.layout.listitem,null);
       }
       TextView textView=convertView.findViewById(R.id.list_child);
       textView.setText(cheld);
       return convertView;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }
}
