package com.example.android.mydbab.sellerfrags;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.android.mydbab.R;

public class fragbs extends Fragment {

    Context context;
    RecyclerView marketresrecycle;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        setHasOptionsMenu(true);
        return inflater.inflate(R.layout.sellernoti, container, false);


    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


        /*
        marketresrecycle=(RecyclerView)view.findViewById(R.id.myrecycle);
        LinearLayoutManager manager=new LinearLayoutManager(context);
        marketresrecycle.setLayoutManager(manager);

        marketadapter marketadapter=new marketadapter();
        marketresrecycle.setAdapter(marketadapter);

    }

    class marketadapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{

        @NonNull
        @Override
        public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            return null;
        }

        @Override
        public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

        }

        @Override
        public int getItemCount() {
            return 0;
        }
    }

    class viewholde extends RecyclerView.ViewHolder{

        public viewholde(View itemView) {
            super(itemView);
        }
    }
    */
    }
}