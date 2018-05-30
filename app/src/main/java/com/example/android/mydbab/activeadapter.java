package com.example.android.mydbab;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.android.mydbab.models.ActiveList;
import com.example.android.mydbab.models.Example;

import java.util.ArrayList;
import java.util.List;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class activeadapter extends RecyclerView.Adapter<activeadapter.viewholde> {

    active myactive=new active();
    Context context;
    List<ActiveList> adapterlist;
    AlertDialog.Builder builds;
    View cancelview;
    AlertDialog dia;


    public activeadapter(Context context)
    {
        this.context=context;
        adapterlist=new ArrayList<>();



        OkHttpClient.Builder builder = new OkHttpClient.Builder();

        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        builder.addInterceptor(loggingInterceptor);


        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://dbabapp.com/api-dbab/api/v1/")
                .addConverterFactory(GsonConverterFactory.create())
                .client(builder.build())
                .build();

        dbabapi service = retrofit.create(dbabapi.class);
        Call<Example> mycall = service.getactiveorders("12", "1", "1");
        final ProgressDialog progressDoalog;
        progressDoalog = new ProgressDialog(context);
        progressDoalog.setMax(100);
        progressDoalog.setMessage("جاري التحميل.....");

        progressDoalog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        // show it
        progressDoalog.show();


        mycall.enqueue(new Callback<Example>() {
            @Override
            public void onResponse(Call<Example> call, Response<Example> response) {

                progressDoalog.dismiss();

                adapterlist=  response.body().getActiveList();
                notifyDataSetChanged();





            }

            @Override
            public void onFailure(Call<Example> call, Throwable t) {

            }
        });

       builds =new AlertDialog.Builder(context);
        cancelview=LayoutInflater.from(context.getApplicationContext()).inflate(R.layout.canceldialog,null);
        dia=builds.create();
        dia.setView(cancelview);





    }
    @NonNull
    @Override
    public activeadapter.viewholde onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View rowactive = LayoutInflater.from(context.getApplicationContext()).inflate(R.layout.rowrecycle, parent,false);
        return new viewholde(rowactive);
    }

    @Override
    public void onBindViewHolder(@NonNull activeadapter.viewholde holder, int position) {

        holder.distant.setText(adapterlist.get(position).getShopDistance());
        holder.adressfmarket.setText(adapterlist.get(position).getOrderAddress());
        holder.cancelorder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                dia.show();

            }
        });
        switch (adapterlist.get(position).getOrderStatus())
        {
            case 0:{
                holder.orderstatue.setText("جاري التنفيذ");
                holder.orderstatue.setTextColor(Color.WHITE);

                break;
            }
            case 1:{
                holder.orderstatue.setText("الدردشة والخيارات");
                holder.orderstatue.setTextColor(Color.WHITE);
                holder.orderstatue.setBackgroundColor(context.getResources().getColor(R.color.buttong));
                holder.orderstatue.setCompoundDrawablesWithIntrinsicBounds(0,0,R.drawable.comin,0);

                holder.orderstatue.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        context.startActivity(new Intent(context.getApplicationContext(),messg.class));

                    }
                });
                break;
            }
        }


        holder.name.setText(adapterlist.get(position).getShopName());
        Glide.with(context)
                .load(adapterlist.get(position).getShopIcon())
                .into(holder.myimg);


    }

    @Override
    public int getItemCount() {
        return adapterlist.size();
    }


    class viewholde extends RecyclerView.ViewHolder{

        ImageView myimg;
        TextView name,distant,orderstatue,cancelorder,adressfmarket;

        public viewholde(View itemView) {
            super(itemView);
            myimg=(ImageView)itemView.findViewById(R.id.imgid);
            name=(TextView)itemView.findViewById(R.id.marketname);
            distant=(TextView)itemView.findViewById(R.id.distance);
            orderstatue=(TextView)itemView.findViewById(R.id.status);
            cancelorder=(TextView)itemView.findViewById(R.id.cancel);
            adressfmarket=(TextView)itemView.findViewById(R.id.adress);
        }
    }
}
