package com.example.android.musicplayer;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class SongAdapter extends ArrayAdapter<SongDetails> {

    /**
     * Constructor
     * @param context: the current context to inflate the layout file
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
        if(listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.song_item, parent, false);
        }

        // get the songDetails object at this position in the list
        SongDetails currentSong = getItem(position);

        // Find the song title textView in song_item.xml layout and set the song title
        TextView songTitleTextView = (TextView) listItemView.findViewById(R.id.song_title_textView);
        songTitleTextView.setText(currentSong.getSongTitle());

        // Find the artist name textView in song_item.xml layout and set the artist name
        TextView artistNameTextView = (TextView) listItemView.findViewById(R.id.artist_name_textView);
        artistNameTextView.setText(currentSong.getArtistName());

        // return the listItem so it can be shown in the ListView
        return listItemView;
    }
}
