package com.example.android.mydbab;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.android.mydbab.models.ActiveList;

import java.util.ArrayList;
import java.util.List;

public class last extends Fragment {
    Context context;
    TextView testtext, expert;
    RecyclerView prererecycle;
    List<ActiveList> activeLists = new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        // clone the inflater using the ContextThemeWrapper
      return inflater.inflate(R.layout.lastlayout,container,false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        context = view.getContext();
        prererecycle = (RecyclerView) view.findViewById(R.id.perviousorders);

        LinearLayoutManager manager = new LinearLayoutManager(context);
        prererecycle.setLayoutManager(manager);
        prererecycle.addItemDecoration(new DividerItemDecoration(getActivity(), DividerItemDecoration.VERTICAL));

        prererecycle.setAdapter(new perviousadapter(context,view));

    }
}