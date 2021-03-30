package com.example.end;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;

public class alhsabat_a extends AppCompatActivity {
    TabLayout tabLayout;
    ViewPager viewPager;
    ViewPagerAdpter adpter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alhsabat_a);

        tabLayout=findViewById(R.id.tab_a);
        viewPager=findViewById(R.id.viewpager);
        adpter=new ViewPagerAdpter(getSupportFragmentManager());

        adpter.addFargment(new Fargmant_1(), "نظره عامة");
        adpter.addFargment(new Fargmant_2(),"بيانات مجمعه");
        adpter.addFargment(new Fargmant_3(),"التقارير");

        viewPager.setAdapter(adpter);
        tabLayout.setupWithViewPager(viewPager);
    }
}
