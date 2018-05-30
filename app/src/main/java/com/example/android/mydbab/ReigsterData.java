package com.example.android.mydbab;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.style.ClickableSpan;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class ReigsterData extends AppCompatActivity {

    Button submitbutton;
    SpannableString styledString;
    TextView pharse;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reigster_data);


         pharse=(TextView)findViewById(R.id.pharsetext);

        submitbutton=(Button)findViewById(R.id.submit);
        submitbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ReigsterData.this,Homepage.class));
            }
        });

      styledString=new SpannableString("تسجيلك في تطبيق دباب يعني موافتك علي الاحكام والشروط");
        ClickableSpan clickableSpan = new ClickableSpan() {

            @Override
            public void onClick(View widget) {
                // We display a Toast. You could do anything you want here.
               // Toast.makeText(Spa.this, "Clicked", Toast.LENGTH_SHORT).show();

            }
        };

      styledString.setSpan(clickableSpan,36,52,0 );
      pharse.setText(styledString);

    }
}
