package com.example.podcasts;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class PatternFragmentAdapter extends FragmentPagerAdapter {
    static final int COUNT_OF_PAGES=3;
    private String [] tabTitles = new String[]{"New episodes","In progress","Downloads"};
    private Context context;

    public PatternFragmentAdapter(FragmentManager fm, Context context) {
        super(fm);
        this.context=context;
    }

    @Override
    public int getCount() {
        return COUNT_OF_PAGES;
    }

    @Override
    public Fragment getItem(int index) {
        return  PageFragment.newInstance(index+1);
    }

    @Override
    public CharSequence getPageTitle(int index) {
       return tabTitles[index];
    }
}
