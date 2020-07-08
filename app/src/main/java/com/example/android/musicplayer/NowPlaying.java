package com.example.android.musicplayer;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class NowPlaying extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.now_playing);

        String songTitle = getIntent().getExtras().getString("songTitle", "");
        String artistName = getIntent().getExtras().getString("artistName", "");

        TextView songTitleNowPlaying = (TextView) findViewById(R.id.song_title_now_playing);
        songTitleNowPlaying.setText(songTitle);

        TextView artistNameNowPlaying = (TextView) findViewById(R.id.artist_name_now_playing);
        artistNameNowPlaying.setText(artistName);
    }
}
