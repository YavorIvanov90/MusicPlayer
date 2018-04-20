package com.example.yavor.musicplayer;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class SongActivity extends AppCompatActivity {

    private Song song;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_song);
        //The position of the song in the list
        int position;

        TextView songNameTextView = (TextView) findViewById(R.id.song_name_text_view);
        TextView artistNameTextView = (TextView) findViewById(R.id.artist_name_text_view);
        TextView durationTextView = (TextView) findViewById(R.id.duration_text_view);
        TextView albumNameTextView = (TextView) findViewById(R.id.album_name_text_view);
        final Button playButton = findViewById(R.id.play_button);

        position = getIntent().getExtras().getInt("position");
        song = MainActivity.getSongs().get(position);

        // Showing the song,artist and album names, also showing the duration time
        songNameTextView.setText(song.getmSongName());
        artistNameTextView.setText(song.getmArtistName());
        durationTextView.setText(song.getmDuration());
        albumNameTextView.setText(song.getmAlbumName());


        //Setting the Play/Stop Button text
        if (song.getPlay() == true) {
            playButton.setText("Stop");
        } else {
            playButton.setText("Play");
        }

        //Play/Stop Button onClickListener
        playButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (song.getPlay() == false) {
                    //if the there is playing song stop it
                    if (MainActivity.currentPlayingSong != null) {
                        MainActivity.currentPlayingSong.setPlay(false);
                    }
                    //set the current song to play and set as playing song in MainActivity
                    song.setPlay(true);
                    playButton.setText("Stop");
                    MainActivity.currentPlayingSong = song;
                } else {
                    //set the current song to stop and set the song in MainActivity to null
                    song.setPlay(false);
                    playButton.setText("Play");
                    MainActivity.currentPlayingSong = null;
                }
            }
        });
    }

    // Creating Menu
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    // Menu items
    public boolean onOptionsItemSelected(MenuItem item) {
        Intent intent;
        switch (item.getItemId()) {
            case R.id.item_0: {
                intent = new Intent(SongActivity.this, MainActivity.class);
                startActivity(intent);
                break;
            }
            case R.id.item_1: {
                if (MainActivity.currentPlayingSong != null) {
                    intent = new Intent(SongActivity.this, NowPlayingActivity.class);
                    startActivity(intent);
                    break;
                } else {
                    Toast.makeText(this, "No currently playing song", Toast.LENGTH_LONG).show();
                }
            }
        }
        return super.onOptionsItemSelected(item);
    }
}
