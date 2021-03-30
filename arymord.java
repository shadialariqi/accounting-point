package com.example.end;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;

import java.util.ArrayList;

class arymord extends BaseAdapter implements Filterable {
    Context context;
    ArrayList<mord_or_amal> arrayList;
    Castmarfilter filter;
    ArrayList<mord_or_amal> filterList;
    public arymord(Context context, ArrayList<mord_or_amal> arrayList){
        this.context=context;
        this.arrayList=arrayList;
        this.filterList=arrayList;
    }
    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public Object getItem(int position) {
        return arrayList.get(position);
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {


        if(convertView==null) {
            LayoutInflater inflater= (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.my_m_shakl, null);
        }

        TextView t2_id= convertView.findViewById(R.id.txt_namper_m);
        TextView t1_name= convertView.findViewById(R.id.txt_name_m);


        mord_or_amal studen= arrayList.get(position);
        t1_name.setText(studen.getName_amel());
        t2_id.setText(String.valueOf(studen.getId_amal()));


        return convertView;
    }
    @Override
    public int getCount() {
        return this.arrayList.size();
    }

    @Override
    public Filter getFilter() {
        if (filter == null){
            filter=new Castmarfilter();
        }
        return filter;
    }

    class Castmarfilter extends Filter {

        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
            FilterResults results = new FilterResults();
            if (constraint != null && constraint.length() > 0) {
                constraint = constraint.toString().toUpperCase();
                ArrayList<mord_or_amal> filters = new ArrayList<>();
                for (int i = 0; i < filterList.size(); i++) {
                    if (filterList.get(i).getName_amel().toUpperCase().contains(constraint)) {
                        mord_or_amal s = new mord_or_amal(filterList.get(i).getName_amel(), filterList.get(i).getId_amal());
                        filters.add(s);
                    }

                }
                results.count = filters.size();
                results.values = filters;

            } else {
                results.count = filterList.size();
                results.values = filterList;

            }
            return results;
        }

        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {
            arrayList = (ArrayList<mord_or_amal>) results.values;
            notifyDataSetChanged();

        }
    }



}

