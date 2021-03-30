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
import android.widget.ListView;
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
import java.util.Locale;

//********************************************************************************
//*******************************************************************************
public class FARA_2_2 extends Fragment {
    private String[] X ;
    private String[] Y ;
    private static final String N="name";
    private static final String M="names";
    public FARA_2_2() {

    }
    public static FARA_2_2 obg(String[] A,String[]B){
        Bundle bundle=new Bundle();
        bundle.putStringArray(N,A);
        bundle.putStringArray(M,B);
        FARA_2_2 ff=new FARA_2_2();
        ff.setArguments(bundle);
        return ff;
    }

    ListView listView;
    TextView da_for;
    String SS1,SS2;

    Dialog dialog;
    SimpleDateFormat data;
    Calendar calendar;


    //******
    ArrayList<catgre> arrayList;
   /* Database db = new Database(getContext());*/
    mycat cat;





    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
      View v = inflater.inflate(R.layout.farg_2_2, container, false);


         listView=v.findViewById(R.id.list_farg);
        da_for=v.findViewById(R.id.da_for);
        listView.setAdapter(cat);

        /*TextView T_F_1 = v.findViewById(R.id.t_f_2);
        TextView  T_F_2 = v.findViewById(R.id.t_f_4);
        T_F_1.setText(X[0]);
        T_F_2.setText(X[1]);*/




        da_for.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //**داله عرض المنيو

                Context wrapper = new ContextThemeWrapper(getContext(), R.style.gonfar);



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
        return v;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle bundle=getArguments();

        X=bundle.getStringArray(N);
        Y=bundle.getStringArray(M);
        arrayList=new ArrayList<>();
        for (int i=0; i<X.length ;i++){
            arrayList.add(new catgre(X[i],Y[i]));
        }




           /* arrayList.add(new catgre(X[8],Y[0]));
            arrayList.add(new catgre(X[7],Y[1]));
            arrayList.add(new catgre(X[6],Y[2]));
           arrayList.add(new catgre(X[5],Y[3]));
            arrayList.add(new catgre(X[4],Y[4]));
           arrayList.add(new catgre(X[3],Y[5]));
           arrayList.add(new catgre(X[2],Y[6]));
          arrayList.add(new catgre(X[1],Y[7]));
          arrayList.add(new catgre(X[0],Y[8]));*/



           /* String[] nass={"اجمالي المشتريات","اجمالي المبالغ المدفوعه","اجمالي المبالغ المتبقيه للموردين"};
            arrayList.add(new catgre(nass[0],Y[0]));
            arrayList.add(new catgre(nass[1],Y[1]));
            arrayList.add(new catgre(nass[2],Y[2]));
*/



        cat = new mycat(getContext(), R.layout.shekl_farg2_2, arrayList);


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




 /*   public void lodedatalistview(boolean s) {

        if(s==true) {
           *//* String []nass={ " نسبة الارباح"," اجمالي الارباح بعد خصم المصروفات"," اجمالي المصروفات"," اجمالي الارباح"," اجمالي المبالغ المتبقية عند العملاء"," اجمالي الايرادات النقدية","اجمالي المبيعات بعد الخصم ","اجمالي الخصومات ","اجمالي المبيعات"};
             String []KS={"","","","","","","","",""};*//*
             arrayList=db.getAllData_far();





            //  arrayList = db.getAllData();
            cat = new mycat(getContext(), R.layout.shekl_farg2_2,arrayList);
             listView.setAdapter(cat);
        }
    }*/
}
