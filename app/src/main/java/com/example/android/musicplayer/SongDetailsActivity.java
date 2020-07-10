package com.example.android.musicplayer;

import android.content.Intent;
import android.graphics.drawable.Icon;
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

        final String songTitle = getIntent().getExtras().getString("songTitle", "");
        final String artistName = getIntent().getExtras().getString("artistName", "");
        String albumName = getIntent().getExtras().getString("albumName", "");

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
                //Toast.makeText(SongDetailsActivity.this, "You clicked the home icon", Toast.LENGTH_SHORT).show();
                Intent homeIntent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(homeIntent);
            }
        });

        // set onClickListener for the add to basket icon
        ImageView basketIcon = (ImageView) findViewById(R.id.add_to_basket);
        basketIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(SongDetailsActivity.this, "You clicked the add to basket icon", Toast.LENGTH_SHORT).show();
            }
        });

        // set onClickListener for the add to que icon
        ImageView queIcon = (ImageView) findViewById(R.id.add_to_que);
        queIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(SongDetailsActivity.this, "You clicked the add to que icon", Toast.LENGTH_SHORT).show();
            }
        });

        // set onClickListener for the play now icon
        ImageView playIcon = (ImageView) findViewById(R.id.play_button);
        playIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(SongDetailsActivity.this, "You clicked the play now icon", Toast.LENGTH_SHORT).show();
                Intent nowPlayingIntent = new Intent(getApplicationContext(), NowPlaying.class);
                nowPlayingIntent.putExtra("songTitle", songTitle);
                nowPlayingIntent.putExtra("artistName", artistName);
                startActivity(nowPlayingIntent);
            }
        });
    }
}
