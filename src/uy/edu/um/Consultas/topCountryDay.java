package uy.edu.um.Consultas;

import uy.edu.um.adt.binarytree.MySearchBinaryTree;
import uy.edu.um.adt.binarytree.TreeNode;
import uy.edu.um.adt.linkedlist.MyLinkedListImpl;
import uy.edu.um.entities.spotifyTrack;
import uy.edu.um.adt.linkedlist.MyList;

import static uy.edu.um.entities.spotifyTrack.datetoint;

public class topCountryDay {
    public static MyList<String> findTopSongs(MySearchBinaryTree<Integer, spotifyTrack> tracks, String date, String country) {
        MyList<spotifyTrack> filteredTracks = new MyLinkedListImpl<>();
        System.out.println("Starting");
        int j = 0;
        int i = 0;
        MySearchBinaryTree<Integer, spotifyTrack> privatetracks = tracks;
        spotifyTrack track = privatetracks.find(datetoint(date));
        TreeNode<Integer, spotifyTrack> node = privatetracks.getleft(datetoint(date));
        while (privatetracks.getleft(datetoint(date)).getKey() == datetoint(date)) {
            if (track.getCountry().equalsIgnoreCase(country)) {
                filteredTracks.add(track);
                System.out.println("In for loop: " + j);
            }
            for (i=0; i < i; i++) {
                node=privatetracks.getleftofnode();
            }
            track = privatetracks.getleft(datetoint(date)).getValue();
            i++;
            System.out.println("Ran for loop: " + j);
            j++;

        }
        System.out.println("Bubblesort");

        MyList<spotifyTrack> sortedTracks = sortTracksByRank(filteredTracks);
        try {
            if (sortedTracks.size() < 10) {
                throw new IndexOutOfBoundsException();
            }
            MyList<String> topSongs = new MyLinkedListImpl<>();
            for (i = 0; i < 10; i++) {
                track = sortedTracks.get(9 - i);
                topSongs.add("Rank: " + track.getDailyRank() + ", Song: " + track.getName() + ", Artist(s): " + track.getArtistList().parseMylisttoString());
            }
            return topSongs;
        } catch (IndexOutOfBoundsException e) {
            return null;
        }
    }

    //bubblesort
    private static MyList<spotifyTrack> sortTracksByRank(MyList<spotifyTrack> tracks) {
        int n = tracks.size();
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (tracks.get(j).getDailyRank() > tracks.get(j + 1).getDailyRank()) {
                    spotifyTrack temp = tracks.get(j);
                    tracks.remove(temp);
                    tracks.addToPosition(temp, j + 1);
                }
            }
        }
        return tracks;
    }
}