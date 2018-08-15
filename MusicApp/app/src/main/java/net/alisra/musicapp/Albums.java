package net.alisra.musicapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class Albums extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_albums);

        Button nowPlayingTopMenuButton = (Button) findViewById(R.id.settingsMenuNowIsPlaying);
        nowPlayingTopMenuButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent nowIsPlayingIntent = new Intent(Albums.this, NowPlaying.class);
                startActivity(nowIsPlayingIntent);
            }
        });

        Button artistTopMenuButton = (Button) findViewById(R.id.settingsMenuArtist);
        artistTopMenuButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ArtistIntent = new Intent(Albums.this, ArtistActivity.class);
                startActivity(ArtistIntent);
            }
        });

    }
}
