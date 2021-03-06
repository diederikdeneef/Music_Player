package com.example.android.musicplayer;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class SongDetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.song_details);

        final String songTitle = getIntent().getExtras().getString("songTitle", "No song title available");
        final String artistName = getIntent().getExtras().getString("artistName", "No artist name available");
        final String albumName = getIntent().getExtras().getString("albumName", "No album name available");

        TextView songTitleDetails = (TextView) findViewById(R.id.song_title_song_details);
        songTitleDetails.setText(songTitle);

        TextView artistNameDetails = (TextView) findViewById(R.id.artist_name_song_details);
        artistNameDetails.setText(artistName);

        TextView albumNameDetails = (TextView) findViewById(R.id.album_name_song_details);
        albumNameDetails.setText(albumName);

        // set onClickListener and intent for the home icon
        ImageView homeIcon = (ImageView) findViewById(R.id.home_button);
        homeIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent homeIntent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(homeIntent);
            }
        });

        // set onClickListener for the add to basket icon
        ImageView basketIcon = (ImageView) findViewById(R.id.add_to_basket);
        basketIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(SongDetailsActivity.this, "Shopping basket functionality not available at this time", Toast.LENGTH_SHORT).show();
            }
        });

        // set onClickListener for the add to que icon
        ImageView queIcon = (ImageView) findViewById(R.id.add_to_que);
        queIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(SongDetailsActivity.this, "Add to que functionality not available at this time", Toast.LENGTH_SHORT).show();
            }
        });

        // set onClickListener for the play now icon
        ImageView playIcon = (ImageView) findViewById(R.id.play_button);
        playIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent nowPlayingIntent = new Intent(getApplicationContext(), NowPlaying.class);
                nowPlayingIntent.putExtra("songTitle", songTitle);
                nowPlayingIntent.putExtra("artistName", artistName);
                nowPlayingIntent.putExtra("albumName", albumName);
                startActivity(nowPlayingIntent);
            }
        });
    }
}
