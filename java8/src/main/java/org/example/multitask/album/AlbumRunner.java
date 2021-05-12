package org.example.multitask.album;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class AlbumRunner {

    public static final Map<String, List<Album>> getAllAlbumsByBandName(List<Band> bands){
        // BandName
        return bands.stream().collect(Collectors.toMap(Band::getName, Band::getAlbums));
    }

    public static List<String> getAllAlbumsByName(List<Band> bands) {
        return bands.stream().map(Band::getAlbums).flatMap(album -> album.stream().map(a -> a.name)).collect(Collectors.toList());
    }
}
