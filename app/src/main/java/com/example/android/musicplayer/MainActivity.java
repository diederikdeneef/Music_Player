package com.example.android.musicplayer;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements SongAdapter.ItemClickListener {

    SongAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // data to populate the RecyclerView with
        ArrayList<String> songTitles = new ArrayList<>();
        songTitles.add("song a");
        songTitles.add("song b");
        songTitles.add("song c");
        songTitles.add("song d");
        songTitles.add("song e");
        songTitles.add("song f");
        songTitles.add("song g");
        songTitles.add("song h");
        songTitles.add("song i");
        songTitles.add("song j");
        songTitles.add("song k");
        songTitles.add("song l");
        songTitles.add("song m");
        songTitles.add("song n");
        songTitles.add("song o");
        songTitles.add("song p");
        songTitles.add("song q");
        songTitles.add("song r");
        songTitles.add("song s");
        songTitles.add("song t");
        songTitles.add("song u");
        songTitles.add("song v");
        songTitles.add("song w");
        songTitles.add("song x");
        songTitles.add("song y");
        songTitles.add("song z");

        // set up the RecyclerView
        RecyclerView recyclerView = findViewById(R.id.que_now_playing);
//        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        adapter = new SongAdapter(this, songTitles);
        adapter.setClickListener(this);
        recyclerView.setAdapter(adapter);

        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(recyclerView.getContext(), layoutManager.getOrientation());
        recyclerView.addItemDecoration(dividerItemDecoration);
    }

    @Override
    public void onItemClick(View view, int position) {
        Toast.makeText(this, "You clicked " + adapter.getItem(position) + " on row number " + position, Toast.LENGTH_SHORT).show();
    }


}