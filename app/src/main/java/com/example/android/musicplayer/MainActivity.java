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
            songDetails.add(new SongDetails("Song " + i, "Artist " + i, "Album " + i*i));
        }

        // set the adapter
        final SongAdapter adapter = new SongAdapter(this, songDetails);
        ListView listView = (ListView) findViewById(R.id.music_library);
        listView.setAdapter(adapter);

        // set an item click listener on the adapter views
//        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
//                //Log.d("TAG", "onItemClick: song title " + songDetails.get(i));
//                Log.d("TAG", "The row Id of the item that was clicked: " + id);
//                Log.d("TAG", "Position of the view in the adapter: " + position);
//                Log.d("TAG", "View within the adapterView that was clicked: " + view.getId());
//                //Toast.makeText(MainActivity.this, "You clicked on: " + songDetails.get(i).getSongTitle(), Toast.LENGTH_LONG).show();
//                //Toast.makeText(MainActivity.this, "You clicked on: " + songDetails.get(i), Toast.LENGTH_LONG).show();
//
//                // Get the position of the view that was clicked
//                int pos = adapterView.getPositionForView(view);
//                Log.d("TAG", "Position of view within the adapterView: " + pos);
//                int adapterViewId = adapterView.getId();
//                Log.d("TAG", "ID of the adapterView: " + adapterViewId);
//                int viewId = view.getId();
//                Log.d("TAG", "ID of the adapterView: " + viewId);


//                // Get the song title and artist name to pass to new activity
//                String songTitle = songDetails.get(position).getSongTitle();
//                String artistName = songDetails.get(position).getArtistName();
//
//                // Set intent to start Now Playing activity on a click event
//                Intent nowPlayingIntent = new Intent(MainActivity.this, NowPlaying.class );
//
//                // pass song title and artist name of the click event to the intent
//                nowPlayingIntent.putExtra("songTitle", songTitle);
//                nowPlayingIntent.putExtra("artistName", artistName);
//
//                startActivity(nowPlayingIntent);
//            }
//        });
    }
}