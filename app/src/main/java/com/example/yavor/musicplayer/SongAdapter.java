package com.example.yavor.musicplayer;

import android.app.Activity;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class SongAdapter extends ArrayAdapter<Song> {

    public SongAdapter(Activity context, ArrayList<Song> songs) {
        super(context, 0, songs);
    }

    @NonNull
    @Override
    public View getView(final int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }
        // Getting the song from the list
        Song currentSong = getItem(position);

        // Setting the play status
        TextView playStatus = (TextView) listItemView.findViewById(R.id.play_status);

        if (currentSong.getPlay() == true) {
            playStatus.setText("Now Playing");
        } else {
            playStatus.setText("");
        }
        // Showing the song,artist and album names, also showing the duration time
        TextView songNameTextView = (TextView) listItemView.findViewById(R.id.song_name_text_view);
        songNameTextView.setText(currentSong.getmSongName());

        TextView artistNameTextView = (TextView) listItemView.findViewById(R.id.artist_name_text_view);
        artistNameTextView.setText(currentSong.getmArtistName());

        TextView durationTextView = (TextView) listItemView.findViewById(R.id.duration_text_view);
        durationTextView.setText(currentSong.getmDuration());

        TextView albumNameTextView = (TextView) listItemView.findViewById(R.id.album_name_text_view);
        albumNameTextView.setText(currentSong.getmAlbumName());

        //Setting OnClickListener for each song
        listItemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent songIntent = new Intent(getContext(), SongActivity.class);
                songIntent.putExtra("position", position);
                getContext().startActivity(songIntent);
            }
        });
        return listItemView;
    }
}
