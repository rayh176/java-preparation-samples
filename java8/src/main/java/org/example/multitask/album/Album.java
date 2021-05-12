package org.example.multitask.album;

import java.util.Date;

public class Album {
    public long id;
    public String name;
    public Date releaseDate;

    public Album(long id, String name, Date releaseDate) {
        this.id = id;
        this.name = name;
        this.releaseDate = releaseDate;
    }
}
