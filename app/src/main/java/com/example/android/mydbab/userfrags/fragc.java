package com.example.android.mydbab.userfrags;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.android.mydbab.R;
import com.example.android.mydbab.active;
import com.example.android.mydbab.last;

public class fragc extends Fragment {

    TabLayout mytab;
    ViewPager myviewpager;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final Context contextThemeWrapper = new ContextThemeWrapper(getActivity(), R.style.WhiteTheme);

        // clone the inflater using the ContextThemeWrapper
        LayoutInflater localInflater = inflater.cloneInContext(contextThemeWrapper);

        return localInflater.inflate(R.layout.fragc,container,false);
    }



    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mytab=(TabLayout)view.findViewById(R.id.tab);
        myviewpager=(ViewPager)view.findViewById(R.id.pagerviw);
        myviewpager.setAdapter(new viewpageradapter(getChildFragmentManager()) );
        mytab.setupWithViewPager(myviewpager);

     mytab.setTabTextColors(Color.WHITE,Color.WHITE);

    }

    class viewpageradapter extends FragmentPagerAdapter{

        public viewpageradapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            Fragment myfrag=new Fragment();
            switch (position)
            {
                case 0:{
                    myfrag=new active();
                    break;
                }
                case 1:{
                    myfrag=new last();
                    break;
                }
            }
            return myfrag;
        }

        @Override
        public int getCount() {
            return 2;
        }

        @Nullable
        @Override
        public CharSequence getPageTitle(int position) {
            switch (position)
            {
                case 0:{
                    return " النشطة";

                }
                case 1:{
                    return "السابقة";

                }
            }
            return null;
        }
    }

}
