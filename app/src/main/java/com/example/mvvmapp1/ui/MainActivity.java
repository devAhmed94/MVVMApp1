package com.example.mvvmapp1.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;

import com.example.mvvmapp1.MainActivityViewModel;
import com.example.mvvmapp1.R;
import com.example.mvvmapp1.adapter.PlaceAdapter;
import com.example.mvvmapp1.model.Places;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView ;
    FloatingActionButton f_btn;
    ProgressBar progressBar;
    PlaceAdapter placeAdapter;
    ArrayList<Places> places;
    MainActivityViewModel mainActivityViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        places = new ArrayList<>();
        initView();
        mainActivityViewModel = ViewModelProviders.of(this).get(MainActivityViewModel.class);
        mainActivityViewModel.init();
        mainActivityViewModel.getPlaces().observe(this, new Observer<List<Places>>() {
            @Override
            public void onChanged(List<Places> places) {
                placeAdapter.notifyDataSetChanged();
            }
        });
        mainActivityViewModel.getUpdate().observe(this, new Observer<Boolean>() {
            @Override
            public void onChanged(Boolean aBoolean) {
                if (aBoolean){
                    showProgressBar();
                }else {
                    hiddenProgressBar();
                }
            }
        });

        f_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mainActivityViewModel.addNewValue(
                        new Places(
                                "https://i.imgur.com/ZcLLrkY.jpg",
                                "Washington"
                        )
                );
            }
        });


        init_recycle();



    }


    private void init_recycle() {

        placeAdapter = new PlaceAdapter(this, mainActivityViewModel.getPlaces().getValue());
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(placeAdapter);
    }

    private void initView(){
        recyclerView = findViewById(R.id.recycle_view);
        f_btn = findViewById(R.id.f_btn);
        progressBar = findViewById(R.id.progress_bar);
    }
    private void showProgressBar(){
        progressBar.setVisibility(View.VISIBLE);
    }
    private void hiddenProgressBar(){
        progressBar.setVisibility(View.GONE);
    }


}