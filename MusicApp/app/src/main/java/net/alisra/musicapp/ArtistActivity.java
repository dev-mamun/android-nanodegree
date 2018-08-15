package net.alisra.musicapp;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

public class ArtistActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_artist);

        ArrayList<Artist> artists = new ArrayList<Artist>();

        artists.add(new Artist("Warfaze", getString(R.string.about_warfaze)));
        artists.add(new Artist("Arbovirus", getString(R.string.about_artist)));
        artists.add(new Artist("LRB", getString(R.string.about_artist)));
        /*artists.add(new Artist("Warfaze", getString(R.string.about_warfaze)));
        artists.add(new Artist("Warfaze", getString(R.string.about_warfaze)));
        artists.add(new Artist("Warfaze", getString(R.string.about_warfaze)));*/

        ArtistAdapter adapter = new ArtistAdapter(this, artists);
        ListView listView = (ListView)findViewById(R.id.list);
        listView.setAdapter(adapter);


        Button nowPlayingTopMenuButton = (Button) findViewById(R.id.settingsMenuNowIsPlaying);
        nowPlayingTopMenuButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent nowIsPlayingIntent = new Intent(ArtistActivity.this, NowPlaying.class);
                startActivity(nowIsPlayingIntent);
            }
        });

        Button albumsTopMenuButton = (Button) findViewById(R.id.settingsMenuAlbums);
        // Listeners for info buttons
        // CLICKS ON TOP MENU BUTTONS
        albumsTopMenuButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent AlbumsIntent = new Intent(ArtistActivity.this, Albums.class);
                startActivity(AlbumsIntent);
            }
        });

    }
}
