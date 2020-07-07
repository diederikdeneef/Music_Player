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

    public SongAdapter(Activity context, ArrayList<SongDetails> songDetails) {
        super(context, 0, songDetails);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listItemView = convertView;
        if(listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.song_item, parent, false);
        }

        SongDetails currentSong = getItem(position);

        TextView songTitleTextView = (TextView) listItemView.findViewById(R.id.song_title_textView);
        songTitleTextView.setText(currentSong.getSongTitle());

        TextView artistNameTextView = (TextView) listItemView.findViewById(R.id.artist_name_textView);
        artistNameTextView.setText(currentSong.getArtistName());

        return listItemView;
    }
}
