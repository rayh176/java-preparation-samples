package org.example.multitask;

import org.example.multitask.album.Album;
import org.example.multitask.album.AlbumRunner;
import org.example.multitask.album.Band;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class AlbumRunnerTest {


    @ParameterizedTest
    @MethodSource("albumList")
    public void testAlbumRunner(List<Band> bands, int expectedSize){
        List<String> receivedAlbums = AlbumRunner.getAllAlbumsByName(bands);
        assertThat(receivedAlbums.size(), is(expectedSize));
    }


    @ParameterizedTest
    @MethodSource("albumBandList")
    public void testAllAlbumsByBandName(List<Band> bands, int expectedSize){
        Map<String, List<Album>> receivedAlbums = AlbumRunner.getAllAlbumsByBandName(bands);
        assertThat(receivedAlbums.size(), is(expectedSize));
    }


    private Stream<Arguments> albumList(){
        List<Album> albums = new ArrayList<>();
        albums.add(new Album(1,"coolband1", Calendar.getInstance().getTime()));
        albums.add(new Album(2,"coolband2", Calendar.getInstance().getTime()));
        albums.add(new Album(3,"coolband3", Calendar.getInstance().getTime()));
        albums.add(new Album(4,"coolband4", Calendar.getInstance().getTime()));
        albums.add(new Album(5,"coolband5", Calendar.getInstance().getTime()));
        albums.add(new Album(6,"coolband6", Calendar.getInstance().getTime()));
        albums.add(new Album(7,"coolband7", Calendar.getInstance().getTime()));
        albums.add(new Album(8,"coolband8", Calendar.getInstance().getTime()));
        albums.add(new Album(9,"coolband9", Calendar.getInstance().getTime()));

        List<Album> albums1 = new ArrayList<>();
        albums1.add(new Album(1,"coolband11", Calendar.getInstance().getTime()));
        albums1.add(new Album(2,"coolband21", Calendar.getInstance().getTime()));
        albums1.add(new Album(3,"coolband31", Calendar.getInstance().getTime()));
        albums1.add(new Album(4,"coolband41", Calendar.getInstance().getTime()));
        albums1.add(new Album(5,"coolband51", Calendar.getInstance().getTime()));
        albums1.add(new Album(6,"coolband61", Calendar.getInstance().getTime()));
        albums1.add(new Album(7,"coolband71", Calendar.getInstance().getTime()));
        albums1.add(new Album(8,"coolband81", Calendar.getInstance().getTime()));
        albums1.add(new Album(9,"coolband91", Calendar.getInstance().getTime()));

        List<Album> albums2 = new ArrayList<>();
        albums2.add(new Album(1,"coolband12", Calendar.getInstance().getTime()));
        albums2.add(new Album(2,"coolband22", Calendar.getInstance().getTime()));
        albums2.add(new Album(3,"coolband32", Calendar.getInstance().getTime()));
        albums2.add(new Album(4,"coolband42", Calendar.getInstance().getTime()));
        albums2.add(new Album(5,"coolband52", Calendar.getInstance().getTime()));
        albums2.add(new Album(6,"coolband62", Calendar.getInstance().getTime()));
        albums2.add(new Album(7,"coolband72", Calendar.getInstance().getTime()));
        albums2.add(new Album(8,"coolband82", Calendar.getInstance().getTime()));
        albums2.add(new Album(9,"coolband92", Calendar.getInstance().getTime()));

        List<Album> albums3 = new ArrayList<>();
        albums3.add(new Album(1,"coolband13", Calendar.getInstance().getTime()));
        albums3.add(new Album(2,"coolband23", Calendar.getInstance().getTime()));
        albums3.add(new Album(3,"coolband33", Calendar.getInstance().getTime()));
        albums3.add(new Album(4,"coolband43", Calendar.getInstance().getTime()));
        albums3.add(new Album(5,"coolband53", Calendar.getInstance().getTime()));
        albums3.add(new Album(6,"coolband63", Calendar.getInstance().getTime()));
        albums3.add(new Album(7,"coolband73", Calendar.getInstance().getTime()));
        albums3.add(new Album(8,"coolband83", Calendar.getInstance().getTime()));
        albums3.add(new Album(9,"coolband93", Calendar.getInstance().getTime()));

        List<Album> albums4 = new ArrayList<>();
        albums4.add(new Album(1,"coolband14", Calendar.getInstance().getTime()));
        albums4.add(new Album(2,"coolband24", Calendar.getInstance().getTime()));
        albums4.add(new Album(3,"coolband34", Calendar.getInstance().getTime()));
        albums4.add(new Album(4,"coolband44", Calendar.getInstance().getTime()));
        albums4.add(new Album(5,"coolband54", Calendar.getInstance().getTime()));
        albums4.add(new Album(6,"coolband64", Calendar.getInstance().getTime()));
        albums4.add(new Album(7,"coolband74", Calendar.getInstance().getTime()));
        albums4.add(new Album(8,"coolband84", Calendar.getInstance().getTime()));
        albums4.add(new Album(9,"coolband94", Calendar.getInstance().getTime()));

        List<Band> bands = new ArrayList<>();
        bands.add( new Band(1,"Job1", albums));
        bands.add( new Band(2,"Job2", albums1));
        bands.add( new Band(3,"Job3", albums2));
        bands.add( new Band(4,"Job4", albums3));
        bands.add( new Band(5,"Job5", albums4));
        return Stream.of(Arguments.of(bands, 45));
    }

    private Stream<Arguments> albumBandList(){
        List<Album> albums = new ArrayList<>();
        albums.add(new Album(1,"coolband1", Calendar.getInstance().getTime()));
        albums.add(new Album(2,"coolband2", Calendar.getInstance().getTime()));
        albums.add(new Album(3,"coolband3", Calendar.getInstance().getTime()));
        albums.add(new Album(4,"coolband4", Calendar.getInstance().getTime()));
        albums.add(new Album(5,"coolband5", Calendar.getInstance().getTime()));
        albums.add(new Album(6,"coolband6", Calendar.getInstance().getTime()));
        albums.add(new Album(7,"coolband7", Calendar.getInstance().getTime()));
        albums.add(new Album(8,"coolband8", Calendar.getInstance().getTime()));
        albums.add(new Album(9,"coolband9", Calendar.getInstance().getTime()));

        List<Album> albums1 = new ArrayList<>();
        albums1.add(new Album(1,"coolband11", Calendar.getInstance().getTime()));
        albums1.add(new Album(2,"coolband21", Calendar.getInstance().getTime()));
        albums1.add(new Album(3,"coolband31", Calendar.getInstance().getTime()));
        albums1.add(new Album(4,"coolband41", Calendar.getInstance().getTime()));
        albums1.add(new Album(5,"coolband51", Calendar.getInstance().getTime()));
        albums1.add(new Album(6,"coolband61", Calendar.getInstance().getTime()));
        albums1.add(new Album(7,"coolband71", Calendar.getInstance().getTime()));
        albums1.add(new Album(8,"coolband81", Calendar.getInstance().getTime()));
        albums1.add(new Album(9,"coolband91", Calendar.getInstance().getTime()));

        List<Album> albums2 = new ArrayList<>();
        albums2.add(new Album(1,"coolband12", Calendar.getInstance().getTime()));
        albums2.add(new Album(2,"coolband22", Calendar.getInstance().getTime()));
        albums2.add(new Album(3,"coolband32", Calendar.getInstance().getTime()));
        albums2.add(new Album(4,"coolband42", Calendar.getInstance().getTime()));
        albums2.add(new Album(5,"coolband52", Calendar.getInstance().getTime()));
        albums2.add(new Album(6,"coolband62", Calendar.getInstance().getTime()));
        albums2.add(new Album(7,"coolband72", Calendar.getInstance().getTime()));
        albums2.add(new Album(8,"coolband82", Calendar.getInstance().getTime()));
        albums2.add(new Album(9,"coolband92", Calendar.getInstance().getTime()));

        List<Album> albums3 = new ArrayList<>();
        albums3.add(new Album(1,"coolband13", Calendar.getInstance().getTime()));
        albums3.add(new Album(2,"coolband23", Calendar.getInstance().getTime()));
        albums3.add(new Album(3,"coolband33", Calendar.getInstance().getTime()));
        albums3.add(new Album(4,"coolband43", Calendar.getInstance().getTime()));
        albums3.add(new Album(5,"coolband53", Calendar.getInstance().getTime()));
        albums3.add(new Album(6,"coolband63", Calendar.getInstance().getTime()));
        albums3.add(new Album(7,"coolband73", Calendar.getInstance().getTime()));
        albums3.add(new Album(8,"coolband83", Calendar.getInstance().getTime()));
        albums3.add(new Album(9,"coolband93", Calendar.getInstance().getTime()));

        List<Album> albums4 = new ArrayList<>();
        albums4.add(new Album(1,"coolband14", Calendar.getInstance().getTime()));
        albums4.add(new Album(2,"coolband24", Calendar.getInstance().getTime()));
        albums4.add(new Album(3,"coolband34", Calendar.getInstance().getTime()));
        albums4.add(new Album(4,"coolband44", Calendar.getInstance().getTime()));
        albums4.add(new Album(5,"coolband54", Calendar.getInstance().getTime()));
        albums4.add(new Album(6,"coolband64", Calendar.getInstance().getTime()));
        albums4.add(new Album(7,"coolband74", Calendar.getInstance().getTime()));
        albums4.add(new Album(8,"coolband84", Calendar.getInstance().getTime()));
        albums4.add(new Album(9,"coolband94", Calendar.getInstance().getTime()));

        List<Band> bands = new ArrayList<>();
        bands.add( new Band(1,"Job1", albums));
        bands.add( new Band(2,"Job2", albums1));
        bands.add( new Band(3,"Job3", albums2));
        bands.add( new Band(4,"Job4", albums3));
        bands.add( new Band(5,"Job5", albums4));
        return Stream.of(Arguments.of(bands, 5));
    }

}
