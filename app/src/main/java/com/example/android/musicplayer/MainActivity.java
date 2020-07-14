package com.example.android.musicplayer;

import android.os.Bundle;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // set the content of the activity to use the activity_main.xml layout file
        setContentView(R.layout.activity_main);

        // Generate sample data to populate the ListView
        final ArrayList<SongDetails> songDetails = new ArrayList<SongDetails>();
        for (int i = 1; i <= 50; i++) {
            songDetails.add(new SongDetails("Song " + i, "Artist " + i, "Album " + i * i));
        }

        // set the adapter
        final SongAdapter adapter = new SongAdapter(this, songDetails);
        ListView listView = (ListView) findViewById(R.id.music_library);
        listView.setAdapter(adapter);

    }
}