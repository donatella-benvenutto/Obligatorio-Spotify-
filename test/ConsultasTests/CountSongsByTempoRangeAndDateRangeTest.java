package ConsultasTests;
import org.junit.jupiter.api.BeforeEach;
import uy.edu.um.adt.binarytree.MySearchBinaryTree;
import uy.edu.um.entities.spotifyTrack;
import org.junit.Assert;
import org.junit.Test;
import uy.edu.um.adt.binarytree.MySearchBinaryTreeImpl;
import uy.edu.um.adt.linkedlist.MyList;
import uy.edu.um.Consultas.CountSongsByTempoRangeAndDateRange;
import uy.edu.um.entities.spotifyTrack;

import static org.junit.Assert.*;

public class CountSongsByTempoRangeAndDateRangeTest {
    @Test
    public void testCountSongsByTempoRangeAndDateRange() {
        MySearchBinaryTree<Integer, spotifyTrack> tree = new MySearchBinaryTreeImpl<>();
        CountSongsByTempoRangeAndDateRange counter = new CountSongsByTempoRangeAndDateRange();
        tree.add(20220101, new spotifyTrack("1", "Song1", "Artist1 , Artist2", 1, 0, 0, "US", "2022-01-01", 90, false, 200000, "Album1", "2023-01-01", 0.8, 0.7, 5, -5.0, 1, 0.1, 0.2, 0.0, 0.3, 0.5, 120.0, 4));
        tree.add(20220102, new spotifyTrack("2", "Song2", "Artist2 , Artist3", 2, 0, 0, "US", "2022-01-02", 80, false, 200000, "Album1", "2023-01-01", 0.8, 0.7, 5, -5.0, 1, 0.1, 0.2, 0.0, 0.3, 0.5, 130.0, 4));
        tree.add(20220103, new spotifyTrack("3", "Song3", "Artist1 , Artist3", 3, 0, 0, "US", "2022-01-03", 70, false, 200000, "Album1", "2023-01-01", 0.8, 0.7, 5, -5.0, 1, 0.1, 0.2, 0.0, 0.3, 0.5, 140.0, 4));
        tree.add(20220104, new spotifyTrack("4", "Song4", "Artist4", 4, 0, 0, "US", "2022-01-04", 60, false, 200000, "Album1", "2023-01-01", 0.8, 0.7, 5, -5.0, 1, 0.1, 0.2, 0.0, 0.3, 0.5, 150.0, 4));

        int count = counter.countSongsByTempo(120.0, 140.0, "2022-01-01", "2022-01-31", tree);
        assertEquals(3, count);

        count = counter.countSongsByTempo(130.0, 150.0, "2022-01-01", "2022-01-31", tree);
        assertEquals(3, count);

        count = counter.countSongsByTempo(110.0, 120.0, "2022-01-01", "2022-01-31", tree);
        assertEquals(1, count);

        count = counter.countSongsByTempo(110.0, 120.0, "2022-02-01", "2022-02-31", tree);
        assertEquals(0, count);

        count = counter.countSongsByTempo(90.0, 100.0, "2022-01-01", "2022-01-31", tree);
        assertEquals(0, count);

        count = counter.countSongsByTempo(130.0, 140.0, "2022-01-01", "2022-01-03", tree);
        assertEquals(2, count);

    }

}
