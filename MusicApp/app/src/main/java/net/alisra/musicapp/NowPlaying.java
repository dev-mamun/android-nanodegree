package net.alisra.musicapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

public class NowPlaying extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_playing);

        Button albumsTopMenuButton = (Button) findViewById(R.id.settingsMenuAlbums);
        // Listeners for info buttons
        // CLICKS ON TOP MENU BUTTONS
        albumsTopMenuButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent AlbumsIntent = new Intent(NowPlaying.this, Albums.class);
                startActivity(AlbumsIntent);
            }
        });


        Button artistTopMenuButton = (Button) findViewById(R.id.settingsMenuArtist);
        artistTopMenuButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ArtistIntent = new Intent(NowPlaying.this, ArtistActivity.class);
                startActivity(ArtistIntent);
            }
        });

        ImageButton playButton = (ImageButton) findViewById(R.id.playSongButton);
        playButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Song is playing", Toast.LENGTH_SHORT).show();
            }
        });

        ImageButton previousSongButton = (ImageButton) findViewById(R.id.previousSongButton);
        previousSongButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Switched to previous song", Toast.LENGTH_SHORT).show();
            }
        });

        ImageButton nextSongButton = (ImageButton) findViewById(R.id.nextSongButton);
        nextSongButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Switched to next song", Toast.LENGTH_SHORT).show();
            }
        });

    }
}
