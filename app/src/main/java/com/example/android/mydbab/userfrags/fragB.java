package com.example.android.mydbab.userfrags;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.SearchView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.android.mydbab.Homepage;
import com.example.android.mydbab.MapsActivity;
import com.example.android.mydbab.R;
import com.example.android.mydbab.dbabapi;
import com.example.android.mydbab.marketdeatail;
import com.example.android.mydbab.models.Example;
import com.example.android.mydbab.models.ShopList;
import com.example.android.mydbab.models.ShopListExample;

import java.util.ArrayList;
import java.util.List;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class fragB extends Fragment {

    Context context;
    RecyclerView marketresrecycle;
    ImageView mapimg;
    public Homepage activity;






    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

       return inflater.inflate(R.layout.fragb,container,false);

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        context=view.getContext();

        marketresrecycle=(RecyclerView)view.findViewById(R.id.myrecyclemarket);
        LinearLayoutManager manager=new LinearLayoutManager(context);
        mapimg=(ImageView)view.findViewById(R.id.gomap);

        mapimg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(getActivity(), MapsActivity.class));
            }
        });
        marketresrecycle.setLayoutManager(manager);

        marketadapter marketadapter=new marketadapter(context);
        fragB.marketadapter adapter=new fragB.marketadapter(context);
        marketresrecycle.setAdapter(adapter);
        marketresrecycle.addItemDecoration(new DividerItemDecoration(getActivity(), DividerItemDecoration.VERTICAL));


    }

    class marketadapter extends RecyclerView.Adapter<fragB.viewholde>{


        List<ShopList> adapterlist;

        Context context;


        public marketadapter(Context context)
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
            Call<ShopListExample> mycall = service.getshoplist("31.2219914", "29.9345114","1");

            final ProgressDialog progressDoalog;
            progressDoalog = new ProgressDialog(context);
            progressDoalog.setMax(100);
            progressDoalog.setMessage("جاري التحميل.....");
            progressDoalog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
            // show it
            progressDoalog.show();

           mycall.enqueue(new Callback<ShopListExample>() {
               @Override
               public void onResponse(Call<ShopListExample> call, Response<ShopListExample> response) {
                   progressDoalog.dismiss();

                 adapterlist=  response.body().getShopList();
                 notifyDataSetChanged();
               }

               @Override
               public void onFailure(Call<ShopListExample> call, Throwable t) {

               }
           });



        }

        @NonNull
        @Override
        public fragB.viewholde onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
        {
            View  myview=LayoutInflater.from(context.getApplicationContext()).inflate(R.layout.rowrecycle,parent,false);


            return new viewholde(myview);
        }

        @Override
        public void onBindViewHolder(@NonNull fragB.viewholde holder, int position) {

            final int z= ((int) holder.getAdapterPosition());

            holder.name.setText(adapterlist.get(position).getShopName());
            holder.orderstatue.setText(null);
            holder.cancelorder.setText(adapterlist.get(position).getShopDistance());
            Glide.with(context)
                    .load(adapterlist.get(position).getShopIcon())
                    .into(holder.myimg);
            holder.adressfmarket.setText(null);
            holder.data.setText(null);

            View marketview= LayoutInflater.from(context.getApplicationContext()).inflate(R.layout.activity_marketdeatail,null);
            TextView nmd=(TextView)marketview.findViewById(R.id.namemarketdeatail);
            nmd.setText(adapterlist.get(position).getShopName());

            holder.clicllayout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    startActivity(new Intent(getActivity(),marketdeatail.class));


                }
            });


        }

        @Override
        public int getItemCount() {
            return adapterlist.size();
        }
    }

    class viewholde extends RecyclerView.ViewHolder{

        ImageView myimg;
        TextView name,data,orderstatue,cancelorder,adressfmarket;
        LinearLayout clicllayout;

        public viewholde(View itemView) {
            super(itemView);
            myimg=(ImageView)itemView.findViewById(R.id.imgid);
            name=(TextView)itemView.findViewById(R.id.marketname);
            data=(TextView)itemView.findViewById(R.id.distance);
            orderstatue=(TextView)itemView.findViewById(R.id.status);
            cancelorder=(TextView)itemView.findViewById(R.id.cancel);
            adressfmarket=(TextView)itemView.findViewById(R.id.adress);
            clicllayout=(LinearLayout)itemView.findViewById(R.id.recycletoclick);
        }
    }
}
