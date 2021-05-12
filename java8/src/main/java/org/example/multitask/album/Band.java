package org.example.multitask.album;

import java.util.List;

public class Band {
    public long id;
    public String name;
    public String genre;
    public List<Album> albums;

    public Band(long id, String name, List<Album> albums) {
        this.id = id;
        this.name = name;
        this.albums = albums;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getGenre() {
        return genre;
    }

    public List<Album> getAlbums() {
        return albums;
    }
}
