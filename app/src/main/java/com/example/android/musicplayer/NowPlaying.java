package com.example.android.musicplayer;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class NowPlaying extends AppCompatActivity {
    ImageView playButton;
    ImageView pauseButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.now_playing);

        // pass song details from previous activity into now playing activity
        final String songTitle = getIntent().getExtras().getString("songTitle", "No Title Available");
        final String artistName = getIntent().getExtras().getString("artistName", "No Artist Name Available");
        final String albumName = getIntent().getExtras().getString("albumName", "No Album Name Available");

        // Set song title to the song title TextView
        TextView songTitleNowPlaying = (TextView) findViewById(R.id.song_title_now_playing);
        songTitleNowPlaying.setText(songTitle);

        // Set the artist name to the artist name TextView
        TextView artistNameNowPlaying = (TextView) findViewById(R.id.artist_name_now_playing);
        artistNameNowPlaying.setText(artistName);

        // Set onClickListener and intent on the song title
        songTitleNowPlaying.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Toast.makeText(getApplicationContext(), "You clicked the song title", Toast.LENGTH_SHORT).show();
                Intent songDetailsIntent = new Intent(getApplicationContext(), SongDetailsActivity.class);
                songDetailsIntent.putExtra("songTitle", songTitle);
                songDetailsIntent.putExtra("artistName", artistName);
                songDetailsIntent.putExtra("albumName", albumName);
                startActivity(songDetailsIntent);
            }
        });

        // Set onClickListener and intent on the artist name
        artistNameNowPlaying.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Toast.makeText(getApplicationContext(), "You clicked the artist name", Toast.LENGTH_SHORT).show();
                Intent songDetailsIntent = new Intent(getApplicationContext(), SongDetailsActivity.class);
                songDetailsIntent.putExtra("songTitle", songTitle);
                songDetailsIntent.putExtra("artistName", artistName);
                songDetailsIntent.putExtra("albumName", albumName);
                startActivity(songDetailsIntent);
            }
        });

        // Set onClickListener and intent on the album art
        ImageView albumArtNowPlaying = (ImageView) findViewById(R.id.album_art_now_playing);
        albumArtNowPlaying.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Toast.makeText(getApplicationContext(), "You clicked the album art", Toast.LENGTH_SHORT).show();
                Intent songDetailsIntent = new Intent(getApplicationContext(), SongDetailsActivity.class);
                songDetailsIntent.putExtra("songTitle", songTitle);
                songDetailsIntent.putExtra("artistName", artistName);
                songDetailsIntent.putExtra("albumName", albumName);
                startActivity(songDetailsIntent);
            }
        });

        // Set onClickListener and intent on home icon
        ImageView homeNowPlaying = (ImageView) findViewById(R.id.home_button_now_playing);
        homeNowPlaying.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent homeIntent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(homeIntent);
            }
        });

        // Set play and pause buttons programmatically
        playButton = findViewById(R.id.play_button_now_playing);
        playButton.setImageResource(R.drawable.ic_action_play_outline);
        playButton.setTag("playing");
        String tag = (String) playButton.getTag();
//        Log.d("TAG", "ID of the play button is: " + tag);

        playButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(playButton.getTag().toString() == "playing"){
                    playButton.setImageResource(R.drawable.ic_action_pause_outline);
                    playButton.setTag("paused");
                } else if (playButton.getTag().toString() == "paused"){
                    playButton.setImageResource(R.drawable.ic_action_play_outline);
                    playButton.setTag("playing");
                }
            }
        });
    }
}
