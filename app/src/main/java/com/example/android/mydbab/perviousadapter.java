package com.example.android.mydbab;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.android.mydbab.models.CompletedList;
import com.example.android.mydbab.models.Examplecompleted;

import java.util.ArrayList;
import java.util.List;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class perviousadapter extends RecyclerView.Adapter<perviousadapter.viewholde> {

    active myactive=new active();
    Context context;
    List<CompletedList> adapterlist;
    TextView fir,sec,three,four,five,sex;
    View muview;
    android.support.v4.app.FragmentManager manager;


    public perviousadapter(Context context,View itemview)
    {

        this.context=context;
        adapterlist=new ArrayList<>();
        this.muview=itemview;


       manager=((FragmentActivity)context).getSupportFragmentManager();




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
        Call<Examplecompleted> mycall = service.getfinishedorders("12","1","1");
        final ProgressDialog progressDoalog;
        progressDoalog = new ProgressDialog(context);
        progressDoalog.setMax(100);
        progressDoalog.setMessage("جاري التحميل.....");
        progressDoalog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        // show it
        progressDoalog.show();


        mycall.enqueue(new Callback<Examplecompleted>() {
          @Override
          public void onResponse(Call<Examplecompleted> call, Response<Examplecompleted> response) {

              progressDoalog.dismiss();

             adapterlist= response.body().getCompletedList();
             notifyDataSetChanged();
          }

          @Override
          public void onFailure(Call<Examplecompleted> call, Throwable t) {

          }
      });


    }




    @NonNull
    @Override
    public perviousadapter.viewholde onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View rowactive = LayoutInflater.from(context.getApplicationContext()).inflate(R.layout.rowrecycle, parent,false);
        return new perviousadapter.viewholde(rowactive);
    }

    @Override
    public void onBindViewHolder(@NonNull perviousadapter.viewholde holder, int position) {

        final int myposition=(int)holder.getAdapterPosition();


        holder.data.setText(adapterlist.get(position).getOrderDate());
        holder.adressfmarket.setText(adapterlist.get(position).getOrderAddress());
        switch (adapterlist.get(position).getOrderStatus())
        {
            case 5:{
                holder.orderstatue.setText("التفاصيل");
                holder.orderstatue.setTextColor(Color.WHITE);

                holder.orderstatue.setBackgroundColor(context.getResources().getColor(R.color.buttong));
                holder.orderstatue.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        AlertDialog.Builder mbuilder=new AlertDialog.Builder(context);
                        View detailvie=LayoutInflater.from(context.getApplicationContext()).inflate(R.layout.dialogorderdetails,null);
                        fir=(TextView)detailvie.findViewById(R.id.dimisss);
                        sec=(TextView)detailvie.findViewById(R.id.datetime);
                        three=(TextView)detailvie.findViewById(R.id.nameshop) ;
                        four=(TextView)detailvie.findViewById(R.id.adressshop);
                        five=(TextView)detailvie.findViewById(R.id.addresorder);
                        sex=(TextView)detailvie.findViewById(R.id.orderdetailss) ;
                        mbuilder.setView(detailvie);
                        final AlertDialog dialog=mbuilder.create();
                        dialog.show();


                        three.setText(adapterlist.get(myposition).getShopName());
                        four.setText(adapterlist.get(myposition).getShopAddress());
                        sec.setText(adapterlist.get(myposition).getOrderDate());
                        five.setText(adapterlist.get(myposition).getOrderAddress());
                        sex.setText(adapterlist.get(myposition).getOrderDetails());
                        fir.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                dialog.dismiss();

                            }
                        });

                    }
                });

                break;
            }

            case 2: {
                holder.orderstatue.setText("الطلب ملغي ");


                break;
            }
            default:{
                holder.orderstatue.setText("الطلب ملغي ");
                break;

            }
        }

        holder.cancelorder.setText(null);

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
        TextView name,data,orderstatue,cancelorder,adressfmarket;

        public viewholde(View itemView) {
            super(itemView);
            myimg=(ImageView)itemView.findViewById(R.id.imgid);
            name=(TextView)itemView.findViewById(R.id.marketname);
            data=(TextView)itemView.findViewById(R.id.distance);
            orderstatue=(TextView)itemView.findViewById(R.id.status);
            cancelorder=(TextView)itemView.findViewById(R.id.cancel);
            adressfmarket=(TextView)itemView.findViewById(R.id.adress);
        }
    }
}
