package com.example.android.mydbab;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;

import com.example.android.mydbab.sellerfrags.fragas;
import com.example.android.mydbab.sellerfrags.fragbs;
import com.example.android.mydbab.sellerfrags.fragcs;
import com.example.android.mydbab.userfrags.fragA;
import com.example.android.mydbab.userfrags.fragB;
import com.example.android.mydbab.userfrags.fragc;

public class Homeseller extends AppCompatActivity {
    BottomNavigationView navigationView;
    ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homeseller);

        navigationView = (BottomNavigationView) findViewById(R.id.bottomnavseller);
        navigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId())
                {
                    case R.id.accounticon:{

                        com.example.android.mydbab.sellerfrags.fragas fu=new fragas();
                        getSupportFragmentManager().beginTransaction().replace(R.id.frameseller,fu).commit();
                        break;
                    }
                    case R.id.notiicon:{
                        fragbs su=new fragbs();
                        getSupportFragmentManager().beginTransaction().replace(R.id.frameseller,su).commit();
                        break;
                    }
                    case R.id.marketicon:{
                        fragcs tu=new fragcs();
                        getSupportFragmentManager().beginTransaction().replace(R.id.frameseller,tu).commit();
                        break;
                    }
                }
                return true;
            }

        });


    }
    }

