package com.example.end;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

public class ViewPagerAdpter extends FragmentPagerAdapter {

    List<Fragment> fragmentList=new ArrayList<>();
    List<String> titelList=new ArrayList<>();
    public ViewPagerAdpter(FragmentManager fm){
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        return fragmentList.get(position);
    }

    @Override
    public int getCount() {
        return fragmentList.size();
    }

    @NonNull
    @Override
    public CharSequence getPageTitle(int position){

        return titelList.get(position);
    }
    public void addFargment(Fragment fragment,String title){
        fragmentList.add(fragment);
        titelList.add(title);

    }
}
