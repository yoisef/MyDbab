package com.example.android.mydbab;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Splashdbab extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash);




        Handler myhandler=new Handler();
        myhandler.postDelayed(new Runnable() {
            @Override
            public void run() {

                startActivity(new Intent(Splashdbab.this,LoginActivity.class));
                finish();

            }
        },4000);
    }
}
