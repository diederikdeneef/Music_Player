package com.example.android.musicplayer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // set the content of the activity to use the activity_main.xml layout file
        setContentView(R.layout.activity_main);

        // Generate sample data to populate the ListView
        final ArrayList<SongDetails> songDetails = new ArrayList<SongDetails>();
        for (int i = 1; i <= 50; i++) {
            songDetails.add(new SongDetails("Song " + i, "Artist " + i));
        }

        // set the adapter
        SongAdapter adapter = new SongAdapter(this, songDetails);
        ListView listView = (ListView) findViewById(R.id.music_library);
        listView.setAdapter(adapter);

        // set an item click listener
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                //Log.d("TAG", "onItemClick: song title " + songDetails.get(i));
                //Toast.makeText(MainActivity.this, "You clicked on: " + songDetails.get(i), Toast.LENGTH_SHORT).show();
                Intent nowPlayingIntent = new Intent(MainActivity.this, NowPlaying.class );
                startActivity(nowPlayingIntent);
            }
        });
    }
}