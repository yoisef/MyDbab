package com.example.android.mydbab;

import android.provider.ContactsContract;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

public class marketdeatail extends AppCompatActivity {

    ImageView hearte,back;
    RelativeLayout ordernow;

    int i=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_marketdeatail);

        AlertDialog.Builder builder=new AlertDialog.Builder(this, R.style.BlueTheme);
        View orderv= LayoutInflater.from(getApplicationContext()).inflate(R.layout.orderlayouts,null);
        final AlertDialog orderdialog=builder.create();
        orderdialog.setView(orderv);

        hearte=(ImageView)findViewById(R.id.heartswitch);
        back=(ImageView)findViewById(R.id.arrowimg);
        ordernow=(RelativeLayout) findViewById(R.id.ordernowl);

        hearte.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                switch (i)
                {
                    case 0:{
                        i=i+1;
                        hearte.setImageResource(R.drawable.hm);
                        break;
                    }
                    case 1:{
                        i=i-1;
                        hearte.setImageResource(R.drawable.hf);
                    }
                }

            }
        });

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                finish();
            }
        });
        ordernow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                orderdialog.show();
            }
        });
    }
}
