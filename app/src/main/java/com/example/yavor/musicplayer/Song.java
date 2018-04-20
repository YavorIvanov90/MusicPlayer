package com.example.yavor.musicplayer;

public class Song {


    private String mSongName;
    private String mArtistName;
    private String mDuration;
    private String mAlbumName;
    boolean playBoolean;

    public Song(String songName, String artistName, String duration, String albumName) {

        mSongName = songName;
        mArtistName = artistName;
        mDuration = duration;
        mAlbumName = albumName;

    }

    public String getmSongName() {
        return mSongName;
    }

    public String getmArtistName() {
        return mArtistName;
    }

    public String getmDuration() {
        return mDuration;
    }

    public String getmAlbumName() {
        return mAlbumName;
    }

    public void setPlay(boolean play) {
        playBoolean = play;
    }

    public boolean getPlay() {
        return playBoolean;
    }
}
