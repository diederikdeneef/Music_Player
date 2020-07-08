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

        // set an item click listener on the adapter views
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                //Log.d("TAG", "onItemClick: song title " + songDetails.get(i));
                //Toast.makeText(MainActivity.this, "You clicked on: " + songDetails.get(i).getSongTitle(), Toast.LENGTH_LONG).show();

                // Get the song title and artist name to pass to new activity
                String songTitle = songDetails.get(i).getSongTitle();
                String artistName = songDetails.get(i).getArtistName();

                // Set intent to start Now Playing activity on a click event
                Intent nowPlayingIntent = new Intent(MainActivity.this, NowPlaying.class );

                // pass song title and artist name of the click event to the intent
                nowPlayingIntent.putExtra("songTitle", songTitle);
                nowPlayingIntent.putExtra("artistName", artistName);

                startActivity(nowPlayingIntent);
            }
        });
    }
}