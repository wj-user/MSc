package com.example.a69477.myapplication;


import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.ViewGroup;
import android.support.v4.view.ViewPager;
import android.view.View;
import java.util.List;

public class ViewPagerAdapter extends FragmentPagerAdapter {

        private List<Fragment> list;
        private int mCurrentPosition = -1;
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

    @Override
    public void setPrimaryItem(ViewGroup container, int position, Object object) {
        super.setPrimaryItem(container, position, object);
        if (position != mCurrentPosition) {
            Fragment fragment = (Fragment) object;
            WrapContentHeightViewPager pager = (WrapContentHeightViewPager) container;
            if (fragment != null && fragment.getView() != null) {
                mCurrentPosition = position;
                pager.measureCurrentView(fragment.getView());
            }
        }
    }
    }

