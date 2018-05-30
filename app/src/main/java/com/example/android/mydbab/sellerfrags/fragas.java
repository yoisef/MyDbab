package com.example.android.mydbab.sellerfrags;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.android.mydbab.R;

public class fragas extends Fragment {

    public int i=0;
    TextView textswitchm;
    ImageView switchimg;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.selleraccount,container,false);
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        final int ids[]={R.drawable.blueswitch,R.drawable.greenswitch};
        textswitchm=(TextView)view.findViewById(R.id.sichtext);
        switchimg=(ImageView)view.findViewById(R.id.siwtch);

        switchimg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (i)
                {
                    case 0:{
                        i=i+1;
                        switchimg.setImageResource(ids[i]);
                        textswitchm.setText("متاح");
                        textswitchm.setTextColor(getResources().getColor(R.color.avalable));
                        break;
                    }
                    case 1:{
                        i=i-1;
                        switchimg.setImageResource(ids[i]);
                        textswitchm.setText("غير متاح");
                        textswitchm.setTextColor(getResources().getColor(R.color.white));
                        break;
                    }
                }





               // switchimg.setImageDrawable(getResources().getDrawable(R.drawable.greenswitch));
            }
        });

    }



}
