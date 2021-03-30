package com.example.end;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;

public class Fargmant_2 extends Fragment {
    View v;
    ViewPager viewPager2;

    TabLayout tabLayout2;



    public Fargmant_2(){

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        v=inflater.inflate(R.layout.fargmant_2,container,false);
        viewPager2=v.findViewById(R.id.viewpager_2);
        tabLayout2=v.findViewById(R.id.tab_a_2);
        return v;
    }
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        setUpViewPager(viewPager2);
        tabLayout2.setupWithViewPager(viewPager2);
        /*tabLayout2.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });*/
    }
    private void setUpViewPager(ViewPager vv){
        /*ViewPagerAdpter adapter=new ViewPagerAdpter(getChildFragmentManager());
        adapter.addFargment(new FARA_2_1(),"المبيعات");
        adapter.addFargment(new FARA_2_2(),"المشتريات");

        vv.setAdapter(adapter);*/
        Database db=new Database(getContext());
        ViewPagerAdpter adapter=new ViewPagerAdpter(getChildFragmentManager());
       /* String []SS=db.getAllamal(1);
        String []MM=db.getAllamal(1);*/
        //FARA_2_2 fara22=FARA_2_2.obg(SS);
/*
        String []nass={ " نسبة الارباح"," اجمالي الارباح بعد خصم المصروفات"," اجمالي المصروفات"," اجمالي الارباح"," اجمالي المبالغ المتبقية عند العملاء"," اجمالي الايرادات النقدية","اجمالي المبيعات بعد الخصم ","اجمالي الخصومات ","اجمالي المبيعات"};
*/

             String []das={"a1","a2","a3","a4","a5","a6","a7","a8","a9"};
        String[] SS={ " نسبة الارباح"," اجمالي الارباح بعد خصم المصروفات"," اجمالي المصروفات"," اجمالي الارباح"," اجمالي المبالغ المتبقية عند العملاء"," اجمالي الايرادات النقدية","اجمالي المبيعات بعد الخصم ","اجمالي الخصومات ","اجمالي المبيعات"};

        String[] MM={"اجمالي المشتريات","اجمالي المبالغ المدفوعه","اجمالي المبالغ المتبقيه للموردين"};

        adapter.addFargment(FARA_2_2.obg(SS,das),"المبيعات");
        adapter.addFargment(FARA_2_2.obg(MM,das),"المشتريات");

        vv.setAdapter(adapter);






    }
}
