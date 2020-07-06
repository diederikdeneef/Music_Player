package com.example.android.musicplayer;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class SongAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Context context;
    private ArrayList<SongInfo> songInfo;

    public SongAdapter(Context context, ArrayList<SongInfo> songInfo) {
        this.context = context;
        this.songInfo = songInfo;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view;
        //view = LayoutInflater.from(context).inflate(R.layout.song_item_minimal, viewGroup, false);
        view = LayoutInflater.from(context).inflate(R.layout.song_item, viewGroup, false);
        return new SongViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int position) {
        ((SongViewHolder) viewHolder).setSongDetails(songInfo.get(position));
    }

    @Override
    public int getItemCount() {
        return songInfo.size();
    }

    class SongViewHolder extends RecyclerView.ViewHolder {

        private TextView txtSongTitle;
        private TextView txtArtistName;

        SongViewHolder(@NonNull View itemView) {
            super(itemView);
            txtSongTitle = itemView.findViewById(R.id.song_title);
            txtArtistName = itemView.findViewById(R.id.artist_name);
        }

        void setSongDetails(SongInfo songInfo) {
            txtSongTitle.setText(songInfo.getSongTitle());
            txtArtistName.setText(songInfo.getArtistName());
        }
    }

}