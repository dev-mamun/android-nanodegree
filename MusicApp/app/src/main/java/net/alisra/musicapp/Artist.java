package net.alisra.musicapp;

import android.media.Image;

public class Artist {
    private String name;
    private Image image;
    private String desc;

    public Artist(String name, String desc){
        this.name=name;
        //this.image=image;
        this.desc=desc;
    }

    public String getName() {
        return name;
    }

    public Image getImage() {
        return image;
    }

    public String getDesc() {
        return desc;
    }
}
