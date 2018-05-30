package com.example.android.mydbab;

import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class Validateactivity extends AppCompatActivity {


    Button valditButtonv;
    ImageView personlay,sellerlay;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_validatectivity);

        AlertDialog.Builder builder=new AlertDialog.Builder(this);
       View chooseview= LayoutInflater.from(getApplicationContext()).inflate(R.layout.identitychoose,null);
       personlay=(ImageView) chooseview.findViewById(R.id.useridenity);
       sellerlay=(ImageView) chooseview.findViewById(R.id.seleridenity);
       personlay.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               startActivity(new Intent(Validateactivity.this,ReigsterData.class));

           }
       });
       sellerlay.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               startActivity(new Intent(Validateactivity.this,Reigstforseller.class));

           }
       });
       final AlertDialog choosediaog=builder.create();
       choosediaog.setView(chooseview);

        valditButtonv=(Button)findViewById(R.id.valdbu);
        valditButtonv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                choosediaog.show();

               //
            }
        });
    }
}
