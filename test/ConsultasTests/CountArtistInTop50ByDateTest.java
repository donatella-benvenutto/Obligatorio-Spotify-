package ConsultasTests;
import org.junit.jupiter.api.BeforeEach;
import uy.edu.um.Consultas.CountArtistInTop50ByDate;
import uy.edu.um.adt.binarytree.MySearchBinaryTree;
import uy.edu.um.entities.spotifyTrack;
import org.junit.Assert;
import org.junit.Test;
import uy.edu.um.adt.binarytree.MySearchBinaryTreeImpl;
import uy.edu.um.adt.linkedlist.MyList;
import uy.edu.um.Consultas.top7ArtistsMostTop50;
import uy.edu.um.entities.spotifyTrack;

import static org.junit.Assert.*;
public class CountArtistInTop50ByDateTest {

    @Test
    public void testCountArtistInTop50(){
        CountArtistInTop50ByDate counter = new CountArtistInTop50ByDate();
        MySearchBinaryTree<Integer, spotifyTrack> tree = new MySearchBinaryTreeImpl<>();
        tree.add(20220101, new spotifyTrack("1", "Song1", "Artist1, Artist2", 1, 0, 0, "US", "2022-01-01", 90, false, 200000, "Album1", "2023-01-01", 0.8, 0.7, 5, -5.0, 1, 0.1, 0.2, 0.0, 0.3, 0.5, 120.0, 4));
        tree.add(20220102, new spotifyTrack("2", "Song2", "Artist2, Artist3", 2, 0, 0, "US", "2022-01-02", 90, false, 200000, "Album1", "2023-01-01", 0.8, 0.7, 5, -5.0, 1, 0.1, 0.2, 0.0, 0.3, 0.5, 120.0, 4));
        tree.add(20220103, new spotifyTrack("3", "Song3", "Artist1, Artist3", 2, 0, 0, "US", "2022-01-03", 90, false, 200000, "Album1", "2023-01-01", 0.8, 0.7, 5, -5.0, 1, 0.1, 0.2, 0.0, 0.3, 0.5, 120.0, 4));
        tree.add(20220103, new spotifyTrack("8", "Song8", "Artist1, Artist3", 2, 0, 0, "US", "2022-01-03", 90, false, 200000, "Album1", "2023-01-01", 0.8, 0.7, 5, -5.0, 1, 0.1, 0.2, 0.0, 0.3, 0.5, 120.0, 4));
        tree.add(20220104, new spotifyTrack("4", "Song4", "Artist1, Artist4", 2, 0, 0, "US", "2022-01-04", 90, false, 200000, "Album1", "2023-01-01", 0.8, 0.7, 5, -5.0, 1, 0.1, 0.2, 0.0, 0.3, 0.5, 120.0, 4));
        tree.add(20220105, new spotifyTrack("5", "Song5", "Artist2, Artist4", 2, 0, 0, "US", "2022-01-05", 90, false, 200000, "Album1", "2023-01-01", 0.8, 0.7, 5, -5.0, 1, 0.1, 0.2, 0.0, 0.3, 0.5, 120.0, 4));
        tree.add(20220106, new spotifyTrack("6", "Song6", "Artist3, Artist4", 2, 0, 0, "US", "2022-01-06", 90, false, 200000, "Album1", "2023-01-01", 0.8, 0.7, 5, -5.0, 1, 0.1, 0.2, 0.0, 0.3, 0.5, 120.0, 4));
        tree.add(20220107, new spotifyTrack("7", "Song7", "Artist1, Artist2, Artist3", 2, 0, 0, "US", "2022-01-07", 90, false, 200000, "Album1", "2023-01-01", 0.8, 0.7, 5, -5.0, 1, 0.1, 0.2, 0.0, 0.3, 0.5, 120.0, 4));

        int count1 = counter.countArtistInTop50("Artist1", "2022-01-01", tree);
        assertEquals(1, count1);
        int count2 = counter.countArtistInTop50("Artist3", "2022-01-03", tree);
        assertEquals(2, count2);
    }

}
