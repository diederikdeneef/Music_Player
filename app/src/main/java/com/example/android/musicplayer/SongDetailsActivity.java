package com.example.android.musicplayer;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class SongDetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.song_details);

        String songTitle = getIntent().getExtras().getString("songTitle", "");
        String artistName = getIntent().getExtras().getString("artistName", "");
        String albumName = getIntent().getExtras().getString("albumName", "");

        TextView songTitleDetails = (TextView) findViewById(R.id.song_title_song_details);
        songTitleDetails.setText(songTitle);

        TextView artistNameDetails = (TextView) findViewById(R.id.artist_name_song_details);
        artistNameDetails.setText(artistName);

        TextView albumNameDetails = (TextView) findViewById(R.id.album_name_song_details);
        albumNameDetails.setText(albumName);
    }
}
