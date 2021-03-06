package com.example.android.musicplayer;

import android.app.Activity;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class SongAdapter extends ArrayAdapter<SongDetails> {

    /**
     * Constructor
     *
     * @param context:     the current context to inflate the layout file
     * @param songDetails: an ArrayList with song details
     */
    public SongAdapter(Activity context, ArrayList<SongDetails> songDetails) {
        super(context, 0, songDetails);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        // check if the existing view is being reused, if not inflate the view
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.song_item, parent, false);
        }

        // get the songDetails object at this position in the list
        SongDetails currentSong = getItem(position);

        // Find the song title textView in song_item.xml layout and set the song title
        TextView songTitleTextView = (TextView) listItemView.findViewById(R.id.song_title_textView);
        assert currentSong != null;
        songTitleTextView.setText(currentSong.getSongTitle());

        // Find the artist name textView in song_item.xml layout and set the artist name
        TextView artistNameTextView = (TextView) listItemView.findViewById(R.id.artist_name_textView);
        artistNameTextView.setText(currentSong.getArtistName());

        // Create intent for Song Details Activity
        final Intent songDetailsIntent = new Intent(getContext(), SongDetailsActivity.class);
        songDetailsIntent.putExtra("songTitle", currentSong.getSongTitle());
        songDetailsIntent.putExtra("artistName", currentSong.getArtistName());
        songDetailsIntent.putExtra("albumName", currentSong.getAlbumName());

        // Create intent for Now Playing activity
        final Intent nowPlayingIntent = new Intent(getContext(), NowPlaying.class);
        nowPlayingIntent.putExtra("songTitle", currentSong.getSongTitle());
        nowPlayingIntent.putExtra("artistName", currentSong.getArtistName());
        nowPlayingIntent.putExtra("albumName", currentSong.getAlbumName());

        // set an onClickListener on the song_title_textView
        songTitleTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                view.getContext().startActivity(songDetailsIntent);
            }
        });

        // set an onClickListener on the artist_name_textView
        artistNameTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                view.getContext().startActivity(songDetailsIntent);
            }
        });

        // Find album art imageView in song_item.xml and set an onClickListener
        ImageView albumArtImageView = (ImageView) listItemView.findViewById(R.id.album_art_song_item);
        albumArtImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                view.getContext().startActivity(songDetailsIntent);
            }
        });

        // Find play icon imageView in song_item.xml and set an onClickListener
        ImageView playIconImageView = (ImageView) listItemView.findViewById(R.id.play_button);
        playIconImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                view.getContext().startActivity(nowPlayingIntent);
            }
        });

        // return the listItem so it can be shown in the ListView
        return listItemView;
    }
}
