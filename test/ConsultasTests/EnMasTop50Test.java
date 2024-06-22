package ConsultasTests;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import uy.edu.um.Consultas.enMasTop50;
import uy.edu.um.adt.binarytree.MySearchBinaryTree;
import uy.edu.um.adt.binarytree.MySearchBinaryTreeImpl;
import uy.edu.um.adt.linkedlist.MyList;
import uy.edu.um.entities.spotifyTrack;

import static org.junit.Assert.*;
public class EnMasTop50Test {

    @Test
    public void testGetTop5Songs() {
        MySearchBinaryTree<Integer, spotifyTrack> tracks = new MySearchBinaryTreeImpl<>();
        tracks.add(20230425, new spotifyTrack("1", "Song1", "Artist1", 1, 0, 0, "US", "2023-04-25", 90, false, 200000, "Album1", "2023-01-01", 0.8, 0.7, 5, -5.0, 1, 0.1, 0.2, 0.0, 0.3, 0.5, 120.0, 4));
        tracks.add(20230425, new spotifyTrack("2", "Song2", "Artist2", 2, 0, 0, "US", "2023-04-25", 90, false, 200000, "Album1", "2023-01-01", 0.8, 0.7, 5, -5.0, 1, 0.1, 0.2, 0.0, 0.3, 0.5, 120.0, 4));
        tracks.add(20230425, new spotifyTrack("2", "Song2", "Artist2", 1, 0, 0, "UK", "2023-04-25", 90, false, 200000, "Album1", "2023-01-01", 0.8, 0.7, 5, -5.0, 1, 0.1, 0.2, 0.0, 0.3, 0.5, 120.0, 4));
        tracks.add(20230425, new spotifyTrack("2", "Song2", "Artist2", 7, 0, 0, "UY", "2023-04-25", 90, false, 200000, "Album1", "2023-01-01", 0.8, 0.7, 5, -5.0, 1, 0.1, 0.2, 0.0, 0.3, 0.5, 120.0, 4));
        tracks.add(20230425, new spotifyTrack("1", "Song1", "Artist1", 18, 0, 0, "UO", "2023-04-25", 90, false, 200000, "Album1", "2023-01-01", 0.8, 0.7, 5, -5.0, 1, 0.1, 0.2, 0.0, 0.3, 0.5, 120.0, 4));
        tracks.add(20230425, new spotifyTrack("3", "Song3", "Artist3", 3, 0, 0, "US", "2023-04-25", 90, false, 200000, "Album1", "2023-01-01", 0.8, 0.7, 5, -5.0, 1, 0.1, 0.2, 0.0, 0.3, 0.5, 120.0, 4));
        tracks.add(20230425, new spotifyTrack("3", "Song3", "Artist3", 21, 0, 0, "Uk", "2023-04-25", 90, false, 200000, "Album1", "2023-01-01", 0.8, 0.7, 5, -5.0, 1, 0.1, 0.2, 0.0, 0.3, 0.5, 120.0, 4));
        tracks.add(20230425, new spotifyTrack("4", "Song4", "Artist4", 43, 0, 0, "US", "2023-04-25", 90, false, 200000, "Album1", "2023-01-01", 0.8, 0.7, 5, -5.0, 1, 0.1, 0.2, 0.0, 0.3, 0.5, 120.0, 4));
        tracks.add(20230425, new spotifyTrack("5", "Song5", "Artist5", 40, 0, 0, "US", "2023-04-25", 90, false, 200000, "Album1", "2023-01-01", 0.8, 0.7, 5, -5.0, 1, 0.1, 0.2, 0.0, 0.3, 0.5, 120.0, 4));


        tracks.add(20230424, new spotifyTrack("1", "Song1", "Artist1", 1, 0, 0, "OP", "2023-04-24", 90, false, 200000, "Album1", "2023-01-01", 0.8, 0.7, 5, -5.0, 1, 0.1, 0.2, 0.0, 0.3, 0.5, 120.0, 4));
        tracks.add(20230426, new spotifyTrack("1", "Song1", "Artist1", 1, 0, 0, "OP", "2023-04-26", 90, false, 200000, "Album1", "2023-01-01", 0.8, 0.7, 5, -5.0, 1, 0.1, 0.2, 0.0, 0.3, 0.5, 120.0, 4));
        tracks.add(20230426, new spotifyTrack("1", "Song1", "Artist1", 9, 0, 0, "UM", "2023-04-26", 90, false, 200000, "Album1", "2023-01-01", 0.8, 0.7, 5, -5.0, 1, 0.1, 0.2, 0.0, 0.3, 0.5, 120.0, 4));
        tracks.add(20230426, new spotifyTrack("1", "Song1", "Artist1", 7, 0, 0, "LS", "2023-04-26", 90, false, 200000, "Album1", "2023-01-01", 0.8, 0.7, 5, -5.0, 1, 0.1, 0.2, 0.0, 0.3, 0.5, 120.0, 4));

        MyList<String> result = enMasTop50.getTop5Songs("2023-04-25", tracks);
        Assert.assertNotNull(result);
        Assert.assertEquals(5, result.size());
        assertTrue(result.get(4).contains("Song2"));    //Count: 3
        assertTrue(result.get(3).contains("Song1"));    //Count: 2
        assertTrue(result.get(2).contains("Song3"));    //Count: 2
        assertTrue(result.get(1).contains("Song4"));    //Count: 1
        assertTrue(result.get(0).contains("Song5"));    //Count: 1
        /*System.out.println(result.get(0));
        System.out.println(result.get(1));
        System.out.println(result.get(2));
        System.out.println(result.get(3));
        System.out.println(result.get(4));*/


    }
    @Test
    public void testGetTop5SongsNull() {
        MySearchBinaryTree<Integer, spotifyTrack> tracks = new MySearchBinaryTreeImpl<>();
        tracks.add(20230424, new spotifyTrack("1", "Song1", "Artist1", 1, 0, 0, "OP", "2023-04-24", 90, false, 200000, "Album1", "2023-01-01", 0.8, 0.7, 5, -5.0, 1, 0.1, 0.2, 0.0, 0.3, 0.5, 120.0, 4));
        tracks.add(20230426, new spotifyTrack("1", "Song1", "Artist1", 1, 0, 0, "OP", "2023-04-26", 90, false, 200000, "Album1", "2023-01-01", 0.8, 0.7, 5, -5.0, 1, 0.1, 0.2, 0.0, 0.3, 0.5, 120.0, 4));

        MyList<String> result = enMasTop50.getTop5Songs("2023-04-25", tracks);
        Assert.assertNull(result);
    }


}
