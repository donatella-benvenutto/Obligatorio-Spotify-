package uy.edu.um.Consultas;

import uy.edu.um.adt.binarytree.MySearchBinaryTree;
import uy.edu.um.adt.linkedlist.MyLinkedListImpl;
import uy.edu.um.entities.spotifyTrack;
import uy.edu.um.adt.linkedlist.MyList;

import static uy.edu.um.entities.spotifyTrack.datetoint;

public class topCountryDay {
    public static MyList<String> findTopSongs(MySearchBinaryTree<Integer,spotifyTrack> tracks, String date, String country) {
        MyList<spotifyTrack> filteredTracks = new MyLinkedListImpl<>();
        System.out.println("Starting");
        int j = 0;
        MySearchBinaryTree<Integer,spotifyTrack> privatetracks=tracks;
        while(tracks.contains(datetoint(date))) {
            spotifyTrack track = privatetracks.find(datetoint(date));
            if (track.getCountry().equalsIgnoreCase(country)) {
                filteredTracks.add(track);
                System.out.println("In for loop: "+j);
            }
            privatetracks.remove(datetoint(date));
            System.out.println("Ran for loop: "+j);
            j++;
        }
        System.out.println("Bubblesort");

        MyList<spotifyTrack> sortedTracks = sortTracksByRank(filteredTracks);
        try {
            if(sortedTracks.size() < 10) {
                throw new IndexOutOfBoundsException();
            }
            MyList<String> topSongs = new MyLinkedListImpl<>();
            for (int i = 0; i < 10; i++) {
                spotifyTrack track = sortedTracks.get(9 - i);
                topSongs.add("Rank: " + track.getDailyRank() + ", Song: " + track.getName() + ", Artist(s): " + track.getArtistList().parseMylisttoString());
            }
            return topSongs;
        }catch (IndexOutOfBoundsException e) {
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