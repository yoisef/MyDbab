package com.example.android.mydbab;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import java.lang.reflect.Array;

public class Reigstforseller extends AppCompatActivity {
    Spinner spinner;
    Button go;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reigstforseller);
        String paths[]={"كوفي شوب","ماركت","متجر","اخري","مطعم"};

        go=(Button)findViewById(R.id.submitsell);

        spinner = (Spinner)findViewById(R.id.spinerkindmarket);
        ArrayAdapter<String>adapter = new ArrayAdapter<String>(Reigstforseller.this,
                android.R.layout.simple_spinner_item,paths);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        go.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Reigstforseller.this,Homeseller.class));
            }
        });

    }
}
