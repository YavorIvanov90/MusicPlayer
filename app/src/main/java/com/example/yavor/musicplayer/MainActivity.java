package com.example.yavor.musicplayer;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private static ArrayList<Song> songs = new ArrayList<Song>();
    public static Song currentPlayingSong;
    private SongAdapter itemsAdapter;
    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // The song list must be cleared, if not when minimizing the app it will duplicate the list
        songs.clear();
        // Adding some songs
        songs.add(new Song("Lose Yourself", "Eminem", "5:20", "8 mile"));
        songs.add(new Song("Love Me", "Eminem", "4:30", "8 mile"));
        songs.add(new Song("8 Mile", "Eminem", "5:57", "8 mile"));
        songs.add(new Song("Adrenaline Rush", "Eminem", "3:48", "8 mile"));
        songs.add(new Song("Walk on Water", "Eminem", "5:04", "Revival"));
        songs.add(new Song("Untouchable Water", "Eminem", "6:10", "Revival"));

        // Create the SongAdapter and adding it to the listView
        itemsAdapter = new SongAdapter(this, songs);
        listView = (ListView) findViewById(R.id.list);
        listView.setAdapter(itemsAdapter);
    }

    // Public static method is need to have access to the song ArrayList
    public static ArrayList<Song> getSongs() {
        return songs;
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
                break;
            }
            case R.id.item_1: {
                if (currentPlayingSong != null) {
                    intent = new Intent(MainActivity.this, NowPlayingActivity.class);
                    startActivity(intent);
                    break;
                } else {
                    Toast.makeText(this, "No currently playing song", Toast.LENGTH_LONG).show();
                }
            }
        }
        return super.onOptionsItemSelected(item);
    }

    // OnResume is need to update the status of songs after a song is played or stoped
    @Override
    protected void onResume() {
        super.onResume();
        itemsAdapter.notifyDataSetChanged();
    }
}
