package com.example.android.mydbab;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;

import com.example.android.mydbab.userfrags.fragA;
import com.example.android.mydbab.userfrags.fragB;
import com.example.android.mydbab.userfrags.fragc;

public class Homepage extends AppCompatActivity {


    BottomNavigationView navigationView;
    ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homepage);
        fragB defaultfrag=new fragB();
        getSupportFragmentManager().beginTransaction().replace(R.id.frame,defaultfrag).commit();


        navigationView = (BottomNavigationView) findViewById(R.id.bottomnav);
        navigationView.setSelectedItemId(R.id.one);

        navigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId())
                {
                    case R.id.Home:{

                        fragA fu=new fragA();
                        getSupportFragmentManager().beginTransaction().replace(R.id.frame,fu).commit();
                        break;
                    }
                    case R.id.one:{
                        fragB su=new fragB();
                        getSupportFragmentManager().beginTransaction().replace(R.id.frame,su).commit();
                        break;
                    }
                    case R.id.two:{
                        fragc tu=new fragc();
                        getSupportFragmentManager().beginTransaction().replace(R.id.frame,tu).commit();
                        break;
                    }
                }
                return true;
            }

        });


    }
}
