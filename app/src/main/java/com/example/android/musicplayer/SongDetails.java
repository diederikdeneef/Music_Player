package com.example.android.musicplayer;

public class SongDetails {

    // Title of the song
    private String mSongTitle;

    // Name of the Artist
    private String mArtistName;

    /**
     * Constructor --> create new song details object
     *
     * @param songTitle: title of the song
     * @param artistName: name of the artist
     */
    public SongDetails (String songTitle, String artistName) {
        mSongTitle = songTitle;
        mArtistName = artistName;
    }

    /**
     * Get the song title
     */
    public String getSongTitle() {
        return mSongTitle;
    }

    /**
     * Get the artist name
     */
    public String getArtistName() {
        return mArtistName;
    }
}
