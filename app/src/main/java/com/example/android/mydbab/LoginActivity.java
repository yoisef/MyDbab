package com.example.android.mydbab;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseException;

import com.hbb20.CountryCodePicker;

import java.util.List;
import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class LoginActivity extends AppCompatActivity {

    CountryCodePicker ccp;


    Button entervaldite;
    EditText usernumber;



    TextView codetext;


    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        ccp = (CountryCodePicker) findViewById(R.id.ccp_loadFullNumber);
        usernumber = (EditText) findViewById(R.id.editText_loadCarrierNumber);
        entervaldite = (Button) findViewById(R.id.enter);
        codetext=(TextView) findViewById(R.id.textcode);

        final String phonenumber=ccp.getFormattedFullNumber();
        String code=ccp.getDefaultCountryCodeWithPlus();
        codetext.setText(code);
        ccp.setOnCountryChangeListener(new CountryCodePicker.OnCountryChangeListener() {
            @Override
            public void onCountrySelected() {
                codetext.setText(ccp.getSelectedCountryCodeWithPlus());
            }
        });





        entervaldite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(LoginActivity.this,Validateactivity.class));



            }
        });

    }











    }







