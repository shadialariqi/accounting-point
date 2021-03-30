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

public class MyAdapter extends BaseAdapter implements Filterable {
    Context context;
    ArrayList<student> arrayList;
    Castmarfilter filter;
    ArrayList<student> filterList;
    public MyAdapter(Context context, ArrayList<student> arrayList){
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

            LayoutInflater inflater= (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            if(convertView==null) {
                convertView = inflater.inflate(R.layout.mycastmlastview, null);
            }
            TextView t1_id= convertView.findViewById(R.id.txt_id);
            TextView t2_name= convertView.findViewById(R.id.txt_name);
            TextView t3_age= convertView.findViewById(R.id.txt_age);

            
            student studen= arrayList.get(position);
               t1_id.setText(studen.getName_product());
               t2_name.setText(String.valueOf(studen.getQuantity()));
               t3_age.setText(String.valueOf(studen.getPrice_sale()));


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


class Castmarfilter extends Filter{

    @Override
    protected FilterResults performFiltering(CharSequence constraint) {
        FilterResults results=new FilterResults();
        if(constraint !=null && constraint.length()>0){
            constraint=constraint.toString().toUpperCase();
            ArrayList<student> filters=new ArrayList<student>();
            for (int i=0;i<filterList.size();i++){
                if (filterList.get(i).getName_product().toUpperCase().contains(constraint)){
                    student s=new student(filterList.get(i).getName_product(),filterList.get(i).getQuantity(),filterList.get(i).getPrice_sale());
                    filters.add(s);
                }

            }
            results.count=filters.size();
            results.values=filters;

        }else {
            results.count=filterList.size();
            results.values=filterList;

        }
        return results;
    }

    @Override
    protected void publishResults(CharSequence constraint, FilterResults results) {
        arrayList=(ArrayList<student>) results.values;
        notifyDataSetChanged();

    }
}}
