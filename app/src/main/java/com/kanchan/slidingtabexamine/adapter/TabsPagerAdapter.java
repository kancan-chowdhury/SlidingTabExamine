package com.kanchan.slidingtabexamine.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.kanchan.slidingtabexamine.fragment.OneFragment;
import com.kanchan.slidingtabexamine.fragment.ThreeFragment;
import com.kanchan.slidingtabexamine.fragment.TwoFragment;

import java.util.ArrayList;

/**
 * Created by Kanchan on 12/23/2016.
 */

public class TabsPagerAdapter extends FragmentStatePagerAdapter {

    ArrayList<String> tabTitles;

    public TabsPagerAdapter(FragmentManager fm, ArrayList<String> tabTitles) {
        super(fm);
        this.tabTitles = tabTitles;
    }

    @Override
    public Fragment getItem(int position) {
     /*   Bundle args = new Bundle();
        args.putInt("tab_no", (position + 1));
        Fragment fragment = new OneFragment();
        fragment.setArguments(args); */
        Fragment fragment;
        if(position == 0) {
            fragment = new OneFragment();
        } else if(position == 1) {
            fragment = new TwoFragment();
        } else if(position == 2) {
            fragment = new ThreeFragment();
        } else {
            fragment = null;
        }
        return fragment;
    }

    @Override
    public int getCount() {
        return tabTitles.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return tabTitles.get(position);
     //   return null;
    }

}
