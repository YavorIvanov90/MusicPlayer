package com.example.yavor.musicplayer;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class NowPlayingActivity extends AppCompatActivity {

    private Song currentSong;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_now_playing);


        TextView songNameTextView = (TextView) findViewById(R.id.song_name_text_view);
        TextView artistNameTextView = (TextView) findViewById(R.id.artist_name_text_view);
        TextView durationTextView = (TextView) findViewById(R.id.duration_text_view);
        TextView albumNameTextView = (TextView) findViewById(R.id.album_name_text_view);
        final ImageButton buttonImage = (ImageButton) findViewById(R.id.play_button);

        //Take the currentSong from the MainActivity
        currentSong = MainActivity.currentPlayingSong;

        songNameTextView.setText(currentSong.getmSongName());
        artistNameTextView.setText(currentSong.getmArtistName());
        durationTextView.setText(currentSong.getmDuration());
        albumNameTextView.setText(currentSong.getmAlbumName());

        //Set the stop image for the button whe the activity is started
        buttonImage.setImageDrawable(getDrawable(R.drawable.stop_button));

        //Set the play/stop image for the button
        buttonImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (currentSong.getPlay() == true) {
                    buttonImage.setImageDrawable(getDrawable(R.drawable.play_button));
                    currentSong.setPlay(false);
                } else {
                    buttonImage.setImageDrawable(getDrawable(R.drawable.stop_button));
                    currentSong.setPlay(true);
                }
            }
        });
    }

    //Create the Menu
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    //Menu Items
    public boolean onOptionsItemSelected(MenuItem item) {
        Intent intent;
        switch (item.getItemId()) {
            case R.id.item_0: {
                intent = new Intent(NowPlayingActivity.this, MainActivity.class);
                startActivity(intent);
                break;
            }
            case R.id.item_1: {
                break;
            }
        }
        return super.onOptionsItemSelected(item);
    }
}
