package com.example.end;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class sale_list extends ArrayAdapter<student> {

    Context context;
    int resource;





    public sale_list(Context context, int resource, ArrayList<student> objects) {
        super(context, resource, objects);
        this.context = context;
        this.resource=resource;

    }
    //int i=1;
    @Override
    public View getView(int p, View view, ViewGroup vg) {

       // student ss=new student(getItem(p).getName_product(),getItem(p).getQuantity(),getItem(p).getPrice_sale());
        LayoutInflater layoutInflater=LayoutInflater.from(context);

        view =layoutInflater.inflate(resource,vg ,false);
        TextView t1_id= view.findViewById(R.id.txt_id);
        TextView t2_name= view.findViewById(R.id.txt_name);
        TextView t3_age= view.findViewById(R.id.txt_age);


        t1_id.setText(getItem(p).getName_product());
        t2_name.setText(String.valueOf(getItem(p).getQuantity()));
        t3_age.setText(String.valueOf(getItem(p).getPrice_sale()));

        return view;
    }
}
