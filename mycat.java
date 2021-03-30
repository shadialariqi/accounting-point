package com.example.end;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class mycat extends ArrayAdapter<catgre> {
    Context context;
    int resource;





    public mycat(Context context, int resource, ArrayList<catgre> objects) {
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
        TextView t1_nas= view.findViewById(R.id.txt_nas);
        TextView t2_kamah= view.findViewById(R.id.txt_kamh);



        t1_nas.setText(getItem(p).getNas());
        t2_kamah.setText(String.valueOf(getItem(p).getKamh()));


        return view;
    }
}
