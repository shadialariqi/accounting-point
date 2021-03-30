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

public class Fargmant_1 extends Fragment {

    View v;
    ViewPager viewPager1;

    TabLayout tabLayout1;
    public Fargmant_1(){

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
       v=inflater.inflate(R.layout.fargmant_1,container,false);
       viewPager1=v.findViewById(R.id.viewpager_1);
       tabLayout1=v.findViewById(R.id.tab_a_1);

        return v;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        setUpViewPager(viewPager1);
        tabLayout1.setupWithViewPager(viewPager1);

    }
    private void setUpViewPager(ViewPager vv){
        ViewPagerAdpter adapter=new ViewPagerAdpter(getChildFragmentManager());
        Database db=new Database(getContext());
        String []AA=db.getAllamal(1);
        String []BB=db.getAllamal(1);
        String []CC=db.getAllamal(1);
        String []DD=db.getAllamal(1);
        adapter.addFargment(FARA_1_1.obg(AA),"المبيعات");
        adapter.addFargment(FARA_1_1.obg(BB),"الارباح");
        adapter.addFargment(FARA_1_1.obg(CC),"المنتجات الاكثر مبيعا");
        adapter.addFargment(FARA_1_1.obg(DD),"المنتجات الاكثر ربحا");
        vv.setAdapter(adapter);



    }
}
