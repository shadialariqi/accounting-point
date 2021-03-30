package com.example.end;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.ContextThemeWrapper;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ExpandableListView;
import android.widget.PopupMenu;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;

public class Fargmant_3 extends Fragment {
 //   TextView textView1,textView2,textView3,textView4,textView5;
/*
    public static final String N="ss";
    public static catgre catgr;
    private String SL;
    catgre catg;
*/


        //=new catgre("rr","rr","rr","rr","rr","rr");
    public Fargmant_3(){}
/*
    public static Fargmant_3 newInstance(String S,catgre c) {
        

        ;
        Fargmant_3 fragment = new Fargmant_3();
            Bundle args = new Bundle();
        args.putString("ss",N)  ;
        args.putSerializable("ss", catgr.getName());

        fragment.setArguments(args);
        return fragment;
    }









    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(getArguments()!= null){
            SL=getArguments().getString("ss");

        }

    }
*/



      ExpandableListView expandableListView;
    List<String> listg;
    HashMap<String,List<String>> listi;
    Mine_adapter adapter;


    TextView da_for;
    String SS1,SS2;

    Dialog dialog;
    SimpleDateFormat data;
    Calendar calendar;



    @Nullable
    @Override
    public View onCreateView(@NonNull final LayoutInflater inflater, @Nullable ViewGroup container, @Nullable final Bundle savedInstanceState) {
        View v =inflater.inflate(R.layout.fargmant_3,container,false);
         expandableListView = v.findViewById(R.id.expand_for);
        da_for=v.findViewById(R.id.da_for);






        da_for.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //**داله عرض المنيو

                Context wrapper = new ContextThemeWrapper (getContext(), R.style.gonfar);



                PopupMenu popupMenu=new PopupMenu(wrapper, view, Gravity.LEFT);





                MenuInflater menuInflater=popupMenu.getMenuInflater();
                menuInflater.inflate(R.menu.farg_menu,popupMenu.getMenu());




                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        long z=0;
                        z=24*60*60*1000;
                        int id=item.getItemId();
                        Date date=new Date();
                        SimpleDateFormat simple=new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
                        if(id==R.id.Date1){
                            //اليوم
                            z*=30;
                            String s=simple.format(date);
                            da_for.setText(s);

                        }


                        if(id==R.id.Date2){
                            //امس
                            z*=1;
                            String s=simple.format(date.getTime()-z);
                            da_for.setText(s);

                        }
                        if(id==R.id.Date3){
                            //اخر سبعه ايام
                            z*=7;
                            String s=simple.format(date)+"   :   "+simple.format(date.getTime()-z);
                            da_for.setText(s);

                        }
                        if(id==R.id.Date4){
                            //هذا الشهر
                            Calendar cc = Calendar.getInstance();
                            int year = cc.get(Calendar.YEAR);
                            int month = cc.get(Calendar.MONTH);


                            //GregorianCalendar يسمح لك بالتعديل في التاريخ
                            GregorianCalendar calend=new GregorianCalendar(year,month,1);
                            Date date1=calend.getTime();
                            String s=simple.format(date1) +"  :  "+simple.format(date);
                            da_for.setText(s);


                        }
                        if(id==R.id.Date5){
                            //اخر 30 يوم

                            z*=30;



                            String s=simple.format(date.getTime())+"   :   "+simple.format(date.getTime()-z);



                            da_for.setText(s);
                        }
                        if(id==R.id.Date6){
                            Calendar cc = Calendar.getInstance();
                            int year = cc.get(Calendar.YEAR);
                            int month = cc.get(Calendar.MONTH);

                            month-=1;
                            GregorianCalendar calend=new GregorianCalendar(year,month,1);
                            GregorianCalendar calend1=new GregorianCalendar(year,month,30);
                            Date date1=calend.getTime();
                            Date date2=calend1.getTime();
                            String s=simple.format(date1) +"  :  "+simple.format(date2);
                            da_for.setText(s);

                        }
                        if(id==R.id.Date7){
                            // سيتم تحديده في قاعدة البيانات جميع ما في الجدول
                            da_for.setText("مدى العمل");
                        }
                        if(id==R.id.Date8){

                            datepicker(" يبداء من تاريخ",true);
                        }

                        return true;
                    }
                });

                popupMenu.show();


            }
        });
         /*spinner=v.findViewById(R.id.spiner);
        ArrayAdapter<String> sp1 = new ArrayAdapter<>(getContext()
            ,android.R.layout.simple_list_item_1,ss);
        spinner.setAdapter(sp1);*/
        listg=new ArrayList<>();
       listi=new HashMap<>();
       adapter=new Mine_adapter(getContext(),listg,listi);
       expandableListView.setAdapter(adapter);

        initlistdata();

        return v;
    }

    private void initlistdata() {
        listg.add(getString(R.string.g1));
        listg.add(getString(R.string.g2));
        listg.add(getString(R.string.g3));
        listg.add(getString(R.string.g4));
        listg.add(getString(R.string.g5));
        listg.add(getString(R.string.g6));
        listg.add(getString(R.string.g7));
        String[]arry;
        List<String> list1=new ArrayList<>();
        arry=getResources().getStringArray(R.array.g1);
        for(String item:arry){
            list1.add(item);
        }
        List<String> list2=new ArrayList<>();
        arry=getResources().getStringArray(R.array.g2);
        for(String item:arry){
            list2.add(item);
        }
        List<String> list3=new ArrayList<>();
        arry=getResources().getStringArray(R.array.g3);
        for(String item:arry){
            list3.add(item);
        }
        List<String> list4=new ArrayList<>();
        arry=getResources().getStringArray(R.array.g4);
        for(String item:arry){
            list4.add(item);
        }
        List<String> list5=new ArrayList<>();
        arry=getResources().getStringArray(R.array.g5);
        for(String item:arry){
            list5.add(item);
        }
        List<String> list6=new ArrayList<>();
        arry=getResources().getStringArray(R.array.g6);
        for(String item:arry){
            list6.add(item);
        }
        List<String> list7=new ArrayList<>();
        arry=getResources().getStringArray(R.array.g7);
        for(String item:arry){
            list7.add(item);
        }
        listi.put(listg.get(0),list1);
        listi.put(listg.get(1),list2);
        listi.put(listg.get(2),list3);
        listi.put(listg.get(3),list4);
        listi.put(listg.get(4),list5);
        listi.put(listg.get(5),list6);
        listi.put(listg.get(6),list7);
        adapter.notifyDataSetChanged();


    }
    //********تاريخ معين من الى
    public void datepicker(String S,final boolean t){
        calendar=Calendar.getInstance();
        data=new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
        dialog=new Dialog(getContext());
        dialog.setContentView(R.layout.dialog_data_picker);
        final DatePicker datePicker= dialog.findViewById(R.id.data_picker);
        Button button_ok =dialog.findViewById(R.id.ok_date);
        Button button_no =dialog.findViewById(R.id.No_date);
        TextView txtdata=dialog.findViewById(R.id.txt_date);
        txtdata.setText(S);
       /* Calendar calendar1=Calendar.getInstance();
        calendar1.add(Calendar.WEEK_OF_YEAR,4);*/

       long z=0;
       z=24*60*60*1000;
       z*=361;
        datePicker.setMinDate(calendar.getTimeInMillis()-z);


        datePicker.setMaxDate(calendar.getTimeInMillis());



        button_ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(t==true){


                    final Calendar calendar2=Calendar.getInstance();
                    calendar2.set(datePicker.getYear(),datePicker.getMonth(),datePicker.getDayOfMonth());
                    SS1 =data.format(calendar2.getTime() );
                    dialog.cancel();
                    datepicker( " ينتهي من تاريخ ",false);









                    //dialog

                }else {
                    final Calendar calendar2=Calendar.getInstance();
                    calendar2.set(datePicker.getYear(),datePicker.getMonth(),datePicker.getDayOfMonth());
                    SS2 =data.format(calendar2.getTime());
                    da_for.setText(SS1+"  :  "+SS2);



                    dialog.dismiss();

                }

            }
        });
        button_no.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();

            }
        });
        dialog.show();



    }
    //*************هذا الاسبوع










    }
