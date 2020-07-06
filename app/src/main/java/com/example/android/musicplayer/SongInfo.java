package com.example.android.musicplayer;

public class SongInfo {

    // The song title
    private String mSongTitle;

    // The artist name
    private String mArtistName;

    // The album title
    private String mAlbumTitle;


    /**
     * Constructor --> create a new song info object
     *
     * @param songTitle  is the title of the song
     * @param artistName is the name of the artist
     * @param albumTitle is the title of the album the song occurs on
     */
    public SongInfo(String songTitle, String artistName, String albumTitle) {
        mSongTitle = songTitle;
        mArtistName = artistName;
        mAlbumTitle = albumTitle;
    }

    /**
     * gets the song title
     */
    public String getSongTitle() {
        return mSongTitle;
    }


    /**
     * gets the artist name
     */
    public String getArtistName() {
        return mArtistName;
    }

    /**
     * gets the album title
     */
    public String getAlbumTitle() {
        return mAlbumTitle;
    }

}
