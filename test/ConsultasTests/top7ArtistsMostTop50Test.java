package ConsultasTests;

import org.junit.jupiter.api.BeforeEach;
import uy.edu.um.adt.binarytree.MySearchBinaryTree;
import uy.edu.um.entities.spotifyTrack;
import org.junit.Assert;
import org.junit.Test;
import uy.edu.um.adt.binarytree.MySearchBinaryTreeImpl;
import uy.edu.um.adt.linkedlist.MyList;
import uy.edu.um.Consultas.top7ArtistsMostTop50;
import uy.edu.um.entities.spotifyTrack;

import static org.junit.Assert.*;

public class top7ArtistsMostTop50Test {
    /*private MySearchBinaryTree<Integer, spotifyTrack> tree;

    @BeforeEach
    void setUp() {
        tree = new MySearchBinaryTreeImpl<>();
        tree.add(20220101, new spotifyTrack("1", "Song1", "Artist1& Artist2", 1, 0, 0, "US", "2022-01-01", 90, false, 200000, "Album1", "2023-01-01", 0.8, 0.7, 5, -5.0, 1, 0.1, 0.2, 0.0, 0.3, 0.5, 120.0, 4));
        tree.add(20220102, new spotifyTrack("2", "Song2", "Artist2& Artist3", 2, 0, 0, "US", "2022-01-02", 90, false, 200000, "Album1", "2023-01-01", 0.8, 0.7, 5, -5.0, 1, 0.1, 0.2, 0.0, 0.3, 0.5, 120.0, 4));
        tree.add(20220103, new spotifyTrack("3", "Song3", "Artist1& Artist3", 2, 0, 0, "US", "2022-01-03", 90, false, 200000, "Album1", "2023-01-01", 0.8, 0.7, 5, -5.0, 1, 0.1, 0.2, 0.0, 0.3, 0.5, 120.0, 4));
        tree.add(20220104, new spotifyTrack("4", "Song4", "Artist1& Artist4", 2, 0, 0, "US", "2022-01-04", 90, false, 200000, "Album1", "2023-01-01", 0.8, 0.7, 5, -5.0, 1, 0.1, 0.2, 0.0, 0.3, 0.5, 120.0, 4));
        tree.add(20220105, new spotifyTrack("5", "Song5", "Artist2& Artist4", 2, 0, 0, "US", "2022-01-05", 90, false, 200000, "Album1", "2023-01-01", 0.8, 0.7, 5, -5.0, 1, 0.1, 0.2, 0.0, 0.3, 0.5, 120.0, 4));
        tree.add(20220106, new spotifyTrack("6", "Song6", "Artist3& Artist4", 2, 0, 0, "US", "2022-01-06", 90, false, 200000, "Album1", "2023-01-01", 0.8, 0.7, 5, -5.0, 1, 0.1, 0.2, 0.0, 0.3, 0.5, 120.0, 4));
        tree.add(20220107, new spotifyTrack("7", "Song7", "Artist1& Artist2& Artist3", 2, 0, 0, "US", "2022-01-07", 90, false, 200000, "Album1", "2023-01-01", 0.8, 0.7, 5, -5.0, 1, 0.1, 0.2, 0.0, 0.3, 0.5, 120.0, 4));

    }*/

    @Test
    public void testGetTop7ArtistsWithValidRange() {
        MySearchBinaryTree<Integer, spotifyTrack> tree = new MySearchBinaryTreeImpl<>();
        tree.add(20220101, new spotifyTrack("1", "Song1", "Artist1, Artist2", 1, 0, 0, "US", "2022-01-01", 90, false, 200000, "Album1", "2023-01-01", 0.8, 0.7, 5, -5.0, 1, 0.1, 0.2, 0.0, 0.3, 0.5, 120.0, 4));
        tree.add(20220102, new spotifyTrack("2", "Song2", "Artist2, Artist3", 2, 0, 0, "US", "2022-01-02", 90, false, 200000, "Album1", "2023-01-01", 0.8, 0.7, 5, -5.0, 1, 0.1, 0.2, 0.0, 0.3, 0.5, 120.0, 4));
        tree.add(20220103, new spotifyTrack("3", "Song3", "Artist1, Artist3", 2, 0, 0, "US", "2022-01-03", 90, false, 200000, "Album1", "2023-01-01", 0.8, 0.7, 5, -5.0, 1, 0.1, 0.2, 0.0, 0.3, 0.5, 120.0, 4));
        tree.add(20220104, new spotifyTrack("4", "Song4", "Artist1, Artist4", 2, 0, 0, "US", "2022-01-04", 90, false, 200000, "Album1", "2023-01-01", 0.8, 0.7, 5, -5.0, 1, 0.1, 0.2, 0.0, 0.3, 0.5, 120.0, 4));
        tree.add(20220105, new spotifyTrack("5", "Song5", "Artist2, Artist4", 2, 0, 0, "US", "2022-01-05", 90, false, 200000, "Album1", "2023-01-01", 0.8, 0.7, 5, -5.0, 1, 0.1, 0.2, 0.0, 0.3, 0.5, 120.0, 4));
        tree.add(20220106, new spotifyTrack("6", "Song6", "Artist3, Artist4", 2, 0, 0, "US", "2022-01-06", 90, false, 200000, "Album1", "2023-01-01", 0.8, 0.7, 5, -5.0, 1, 0.1, 0.2, 0.0, 0.3, 0.5, 120.0, 4));
        tree.add(20220107, new spotifyTrack("7", "Song7", "Artist1, Artist2, Artist3", 2, 0, 0, "US", "2022-01-07", 90, false, 200000, "Album1", "2023-01-01", 0.8, 0.7, 5, -5.0, 1, 0.1, 0.2, 0.0, 0.3, 0.5, 120.0, 4));

        MyList<String> top7Artists = top7ArtistsMostTop50.getTop7Artists("2022-01-01", "2022-01-05", tree);
        assertNotNull(top7Artists);
        assertEquals(4, top7Artists.size());
        assertTrue(top7Artists.get(0).contains("Artist1"));     //Count: 3
        assertTrue(top7Artists.get(1).contains("Artist2"));     //Count: 3
        assertTrue(top7Artists.get(2).contains("Artist3"));     //Count: 2
        assertTrue(top7Artists.get(3).contains("Artist4"));     //Count: 2

       /* System.out.println(top7Artists.get(0));
        System.out.println(top7Artists.get(1));
        System.out.println(top7Artists.get(2));
        System.out.println(top7Artists.get(3));*/
    }

    @Test
    public void testGetTop7ArtistsWithEmptyRange() {
        MySearchBinaryTree<Integer, spotifyTrack> tree = new MySearchBinaryTreeImpl<>();
        tree.add(20220101, new spotifyTrack("1", "Song1", "Artist1, Artist2", 1, 0, 0, "US", "2022-01-01", 90, false, 200000, "Album1", "2023-01-01", 0.8, 0.7, 5, -5.0, 1, 0.1, 0.2, 0.0, 0.3, 0.5, 120.0, 4));
        tree.add(20220102, new spotifyTrack("2", "Song2", "Artist2, Artist3", 2, 0, 0, "US", "2022-01-02", 90, false, 200000, "Album1", "2023-01-01", 0.8, 0.7, 5, -5.0, 1, 0.1, 0.2, 0.0, 0.3, 0.5, 120.0, 4));
        tree.add(20220103, new spotifyTrack("3", "Song3", "Artist1, Artist3", 2, 0, 0, "US", "2022-01-03", 90, false, 200000, "Album1", "2023-01-01", 0.8, 0.7, 5, -5.0, 1, 0.1, 0.2, 0.0, 0.3, 0.5, 120.0, 4));
        tree.add(20220104, new spotifyTrack("4", "Song4", "Artist1, Artist4", 2, 0, 0, "US", "2022-01-04", 90, false, 200000, "Album1", "2023-01-01", 0.8, 0.7, 5, -5.0, 1, 0.1, 0.2, 0.0, 0.3, 0.5, 120.0, 4));
        tree.add(20220105, new spotifyTrack("5", "Song5", "Artist2, Artist4", 2, 0, 0, "US", "2022-01-05", 90, false, 200000, "Album1", "2023-01-01", 0.8, 0.7, 5, -5.0, 1, 0.1, 0.2, 0.0, 0.3, 0.5, 120.0, 4));
        tree.add(20220106, new spotifyTrack("6", "Song6", "Artist3, Artist4", 2, 0, 0, "US", "2022-01-06", 90, false, 200000, "Album1", "2023-01-01", 0.8, 0.7, 5, -5.0, 1, 0.1, 0.2, 0.0, 0.3, 0.5, 120.0, 4));
        tree.add(20220107, new spotifyTrack("7", "Song7", "Artist1, Artist2, Artist3", 2, 0, 0, "US", "2022-01-07", 90, false, 200000, "Album1", "2023-01-01", 0.8, 0.7, 5, -5.0, 1, 0.1, 0.2, 0.0, 0.3, 0.5, 120.0, 4));

        MyList<String> top7Artists = top7ArtistsMostTop50.getTop7Artists("2022-01-08", "2022-01-09", tree);
        assertNull(top7Artists);
    }
}
