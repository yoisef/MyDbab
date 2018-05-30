package com.example.android.mydbab;

import android.app.DialogFragment;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class Dialogdetail extends DialogFragment {


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.dialogorderdetails,container,false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        TextView back=(TextView)view.findViewById(R.id.dimisss);
       TextView time=(TextView)view.findViewById(R.id.datetime);
        TextView shopname=(TextView)view.findViewById(R.id.nameshop) ;
        TextView costm=(TextView) view.findViewById(R.id.cost);

        Typeface typeface=Typeface.createFromAsset(getResources().getAssets(),"fonts/bold.ttf");
        costm.setTypeface(typeface);

        TextView shopaddresss=(TextView)view.findViewById(R.id.adressshop);
        TextView orderaddre=(TextView)view.findViewById(R.id.addresorder);

        shopname.setText("jhjhjhjhj");

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dismiss();
            }
        });
    }
}
