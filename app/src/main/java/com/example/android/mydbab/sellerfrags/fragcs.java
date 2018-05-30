package com.example.android.mydbab.sellerfrags;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.android.mydbab.R;
import com.example.android.mydbab.active;
import com.example.android.mydbab.activeseller;
import com.example.android.mydbab.last;
import com.example.android.mydbab.lastseller;

public class fragcs extends Fragment {

    TabLayout mytab;
    ViewPager myviewpager;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.sellerorder,container,false);
    }



    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mytab=(TabLayout)view.findViewById(R.id.tabseller);
        myviewpager=(ViewPager)view.findViewById(R.id.pagerviwseller);
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
                    myfrag=new activeseller();
                    break;
                }
                case 1:{
                    myfrag=new lastseller();
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
