package ConsultasTests;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import uy.edu.um.Consultas.topCountryDay;
import uy.edu.um.adt.binarytree.MySearchBinaryTree;
import uy.edu.um.adt.binarytree.MySearchBinaryTreeImpl;
import uy.edu.um.adt.linkedlist.MyLinkedListImpl;
import uy.edu.um.adt.linkedlist.MyList;
import uy.edu.um.entities.spotifyTrack;

import static org.junit.Assert.*;

public class topCountryDayTest {

    //private MySearchBinaryTree<Integer, spotifyTrack> tracks;

    //@Before
    /*@Test
    public void setUp() {
        tracks = new MySearchBinaryTreeImpl<>();

        tracks.add(20231015,new spotifyTrack("1", "Song111", "Artist1", 1, 0, 0, "USA", "2023-10-14", 90, false, 200000, "Album1", "2023-01-01", 0.8, 0.7, 5, -5.0, 1, 0.1, 0.2, 0.0, 0.3, 0.5, 120.0, 4));
        tracks.add(20231015,new spotifyTrack("1", "Song1111", "Artist1", 1, 0, 0, "USA", "2023-10-16", 90, false, 200000, "Album1", "2023-01-01", 0.8, 0.7, 5, -5.0, 1, 0.1, 0.2, 0.0, 0.3, 0.5, 120.0, 4));
        tracks.add(20231015,new spotifyTrack("1", "Song1", "Artist1", 1, 0, 0, "USA", "2023-10-15", 90, false, 200000, "Album1", "2023-01-01", 0.8, 0.7, 5, -5.0, 1, 0.1, 0.2, 0.0, 0.3, 0.5, 120.0, 4));
        tracks.add(20231015,new spotifyTrack("1", "Song1", "Artist1", 1, 0, 0, "USA", "2023-10-15", 90, false, 200000, "Album1", "2023-01-01", 0.8, 0.7, 5, -5.0, 1, 0.1, 0.2, 0.0, 0.3, 0.5, 120.0, 4));
        tracks.add(20231015,new spotifyTrack("2", "Song2", "Artist2", 2, 0, 0, "USA", "2023-10-15", 85, false, 210000, "Album2", "2023-02-01", 0.7, 0.8, 5, -5.0, 1, 0.1, 0.3, 0.0, 0.4, 0.6, 121.0, 4));
        tracks.add(20231015,new spotifyTrack("3", "Song3", "Artist3", 3, 0, 0, "USA", "2023-10-15", 80, false, 220000, "Album3", "2023-03-01", 0.6, 0.9, 5, -5.0, 1, 0.1, 0.4, 0.0, 0.5, 0.7, 122.0, 4));
        tracks.add(20231015,new spotifyTrack("4", "Song4", "Artist4", 4, 0, 0, "USA", "2023-10-15", 75, false, 230000, "Album4", "2023-04-01", 0.5, 1.0, 5, -5.0, 1, 0.1, 0.5, 0.0, 0.6, 0.8, 123.0, 4));
        tracks.add(20231015,new spotifyTrack("5", "Song5", "Artist5", 5, 0, 0, "USA", "2023-10-15", 70, false, 240000, "Album5", "2023-05-01", 0.4, 1.1, 5, -5.0, 1, 0.1, 0.6, 0.0, 0.7, 0.9, 124.0, 4));
        tracks.add(20231015,new spotifyTrack("6", "Song6", "Artist6", 6, 0, 0, "USA", "2023-10-15", 65, false, 250000, "Album6", "2023-06-01", 0.3, 1.2, 5, -5.0, 1, 0.1, 0.7, 0.0, 0.8, 1.0, 125.0, 4));
        tracks.add(20231015,new spotifyTrack("7", "Song7", "Artist7", 7, 0, 0, "USA", "2023-10-15", 60, false, 260000, "Album7", "2023-07-01", 0.2, 1.3, 5, -5.0, 1, 0.1, 0.8, 0.0, 0.9, 1.1, 126.0, 4));
        tracks.add(20231015,new spotifyTrack("8", "Song8", "Artist8", 8, 0, 0, "USA", "2023-10-15", 55, false, 270000, "Album8", "2023-08-01", 0.1, 1.4, 5, -5.0, 1, 0.1, 0.9, 0.0, 1.0, 1.2, 127.0, 4));
        tracks.add(20231015,new spotifyTrack("9", "Song9", "Artist9", 9, 0, 0, "USA", "2023-10-15", 50, false, 280000, "Album9", "2023-09-01", 0.05, 1.5, 5, -5.0, 1, 0.1, 1.0, 0.0, 1.1, 1.3, 128.0, 4));
        tracks.add(20231015,new spotifyTrack("10", "Song10", "Artist10", 10, 0, 0, "USA", "2023-10-15", 45, false, 290000, "Album10", "2023-10-01", 0.04, 1.6, 5, -5.0, 1, 0.1, 1.1, 0.0, 1.2, 1.4, 129.0, 4));
        tracks.add(20231015,new spotifyTrack("11", "Song11", "Artist11", 11, 0, 0, "USA", "2023-10-15", 40, false, 300000, "Album11", "2023-11-01", 0.03, 1.7, 5, -5.0, 1, 0.1, 1.2, 0.0, 1.3, 1.5, 130.0, 4));
        tracks.add(20231015,new spotifyTrack("12", "Song12", "Artist12", 12, 0, 0, "USA", "2023-10-15", 35, false, 310000, "Album12", "2023-12-01", 0.02, 1.8, 5, -5.0, 1, 0.1, 1.3, 0.0, 1.4, 1.6, 131.0, 4));
        tracks.add(20231015,new spotifyTrack("13", "Song13", "Artist13", 13, 0, 0, "USA", "2023-10-15", 30, false, 320000, "Album13", "2023-01-01", 0.01, 1.9, 5, -5.0, 1, 0.1, 1.4, 0.0, 1.5, 1.7, 132.0, 4));
        tracks.add(20231015,new spotifyTrack("14", "Song14", "Artist14", 14, 0, 0, "USA", "2023-10-15", 25, false, 330000, "Album14", "2023-02-01", 0.5, 1.0, 5, -5.0, 1, 0.1, 1.5, 0.0, 1.6, 1.8, 133.0, 4));
        tracks.add(20231015,new spotifyTrack("15", "Song15", "Artist15", 15, 0, 0, "USA", "2023-10-15", 20, false, 340000, "Album15", "2023-03-01", 0.5, 1.1, 5, -5.0, 1, 0.1, 1.6, 0.0, 1.7, 1.9, 134.0, 4));
        tracks.add(20231015,new spotifyTrack("16", "Song16", "Artist16", 16, 0, 0, "USA", "2023-10-15", 15, false, 350000, "Album16", "2023-04-01", 0.5, 1.2, 5, -5.0, 1, 0.1, 1.7, 0.0, 1.8, 2.0, 135.0, 4));
    }

    @Test
    public void testFindTopSongs() {
        MyList<String> topSongs = topCountryDay.findTopSongs(tracks, "2023-10-15", "USA");


        assertNotNull(topSongs);
        assertEquals(10, topSongs.size());

        assertEquals("Rank: 1, Song: Song1, Artist(s): ", topSongs.getlast().getValue());
        assertEquals("Rank: 2, Song: Song2, Artist(s): ", topSongs.get(8));
        assertEquals("Rank: 5, Song: Song5, Artist(s): ", topSongs.get(5));
        assertEquals("Rank: 10, Song: Song10, Artist(s): ", topSongs.get(0));
    }

    @Test
    public void testFindTopSongsWithNoMatches() {
        MyList<String> topSongs = topCountryDay.findTopSongs(tracks, "2023-10-16", "USA");

        assertNull(topSongs);
    }

    @Test
    public void testFindTopSongsWithDifferentCountry() {
        MyList<String> topSongs = topCountryDay.findTopSongs(tracks, "2023-10-15", "CAN");

        assertNull(topSongs);
    }*/

    @Test
    public void testFindTopSongsWithNoMatches() {
        MySearchBinaryTree<Integer, spotifyTrack> tracks = new MySearchBinaryTreeImpl<>();
        tracks.add(20230620, new spotifyTrack("1", "Song1", "Artist1", 1, 0, 0, "US", "2023-06-20", 90, false, 200000, "Album1", "2023-01-01", 0.8, 0.7, 5, -5.0, 1, 0.1, 0.2, 0.0, 0.3, 0.5, 120.0, 4));
        tracks.add(20230621, new spotifyTrack("2", "Song2", "Artist2", 2, 0, 0, "US", "2023-06-21", 90, false, 200000, "Album1", "2023-01-01", 0.8, 0.7, 5, -5.0, 1, 0.1, 0.2, 0.0, 0.3, 0.5, 120.0, 4));

        MyList<String> result = topCountryDay.findTopSongs(tracks, "2023-06-19", "US");

        Assert.assertNull(result);
    }

    @Test
    public void testFindTopSongsWithMatches() {
        MySearchBinaryTree<Integer, spotifyTrack> tracks = new MySearchBinaryTreeImpl<>();
        tracks.add(20230620, new spotifyTrack("1", "Song1", "Artist1", 1, 0, 0, "US", "2023-06-20", 90, false, 200000, "Album1", "2023-01-01", 0.8, 0.7, 5, -5.0, 1, 0.1, 0.2, 0.0, 0.3, 0.5, 120.0, 4));
        tracks.add(20230620, new spotifyTrack("2", "Song2", "Artist2", 2, 0, 0, "US", "2023-06-20", 90, false, 200000, "Album1", "2023-01-01", 0.8, 0.7, 5, -5.0, 1, 0.1, 0.2, 0.0, 0.3, 0.5, 120.0, 4));
        tracks.add(20230621, new spotifyTrack("3", "Song3", "Artist3", 3, 0, 0, "US", "2023-06-21", 90, false, 200000, "Album1", "2023-01-01", 0.8, 0.7, 5, -5.0, 1, 0.1, 0.2, 0.0, 0.3, 0.5, 120.0, 4));

        MyList<String> result = topCountryDay.findTopSongs(tracks, "2023-06-20", "US");

        Assert.assertNotNull(result);
        Assert.assertEquals(2, result.size());
        Assert.assertTrue(result.get(0).contains("Song2"));
        Assert.assertTrue(result.get(1).contains("Artist1"));
    }

    @Test
    public void testFindTopSongsWithDifferentCountry() {
        MySearchBinaryTree<Integer, spotifyTrack> tracks = new MySearchBinaryTreeImpl<>();

        tracks.add(20230620, new spotifyTrack("1", "Song1", "Artist1", 1, 0, 0, "US", "2023-06-20", 90, false, 200000, "Album1", "2023-01-01", 0.8, 0.7, 5, -5.0, 1, 0.1, 0.2, 0.0, 0.3, 0.5, 120.0, 4));
        tracks.add(20230620, new spotifyTrack("2", "Song2", "Artist2", 2, 0, 0, "UK", "2023-06-20", 90, false, 200000, "Album1", "2023-01-01", 0.8, 0.7, 5, -5.0, 1, 0.1, 0.2, 0.0, 0.3, 0.5, 120.0, 4));
        tracks.add(20230621, new spotifyTrack("3", "Song3", "Artist3", 3, 0, 0, "US", "2023-06-21", 90, false, 200000, "Album1", "2023-01-01", 0.8, 0.7, 5, -5.0, 1, 0.1, 0.2, 0.0, 0.3, 0.5, 120.0, 4));
        tracks.add(20230620, new spotifyTrack("3", "Song3", "Artist3", 1, 0, 0, "UK", "2023-06-20", 90, false, 200000, "Album1", "2023-01-01", 0.8, 0.7, 5, -5.0, 1, 0.1, 0.2, 0.0, 0.3, 0.5, 120.0, 4));


        MyList<String> result = topCountryDay.findTopSongs(tracks, "2023-06-20", "UK");

        Assert.assertNotNull(result);
        Assert.assertEquals(2, result.size());
        Assert.assertTrue(result.get(0).contains("Song2"));
    }
}