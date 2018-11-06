package com.example.a69477.myapplication;


import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

public class ViewPagerAdapter extends FragmentPagerAdapter {

        private List<Fragment> list;

        public void setList(List<Fragment> list) {
            this.list = list;
            notifyDataSetChanged();
        }

        public ViewPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return list.get(position);
        }

        @Override
        public int getCount() {
            return list != null ? list.size() : 0;
        }
    }

