package com.example.android.musicplayer;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ArrayList<SongDetails> songDetails = new ArrayList<SongDetails>();
        for (int i = 1; i <= 30; i++) {
            songDetails.add(new SongDetails("Song " + i, "Artist " + i));
        }
        SongAdapter adapter = new SongAdapter(this, songDetails);
        ListView listView = (ListView) findViewById(R.id.music_library);
        listView.setAdapter(adapter);
    }
}