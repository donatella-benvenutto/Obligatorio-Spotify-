package uy.edu.um.Consultas;

import org.w3c.dom.ranges.Range;
import uy.edu.um.adt.binarytree.MySearchBinaryTree;
import uy.edu.um.adt.binarytree.TreeNode;
import uy.edu.um.adt.linkedlist.MyLinkedListImpl;
import uy.edu.um.entities.spotifyTrack;
import uy.edu.um.adt.linkedlist.MyList;

import static uy.edu.um.entities.spotifyTrack.datetoint;

public class topCountryDay {
    public static int datetoint(String value) {
        String[] parts = value.split("-");
        String year = parts[0];
        String month = parts[1];
        String day = parts[2];
        return Integer.parseInt(year.concat(month).concat(day));
    }
    public static MyList<String> findTopSongs(MySearchBinaryTree<Integer, spotifyTrack> tracks, String date, String country) {

        //MyList<spotifyTrack> filteredTracks = new MyLinkedListImpl<>();
        spotifyTrack [] arrayTop = new spotifyTrack[10];


        System.out.println("Starting");

        //int j = 0;
        //int i = 0;
        int valuesInArray = 0;
        int dateInt = datetoint(date);


        MyList<TreeNode<Integer, spotifyTrack>> nodes = tracks.findNodesByDate(dateInt);

        for (int i = 0; i < nodes.size() ; i++) {
            if (valuesInArray >= 10){
                break;
            }
            TreeNode<Integer, spotifyTrack> node = nodes.get(i);
            spotifyTrack track = node.getValue();
            if (track.getCountry().equalsIgnoreCase(country)) {
                int rank = track.getDailyRank();
                if (rank > 0 && rank <= 10) {
                    arrayTop[10 - rank] = track;
                    valuesInArray++;
                    System.out.println("valuesInArray: " + valuesInArray);
                }
            }

        }

        System.out.println("Finished traversing the tree");

        if (valuesInArray == 0) {
            return null;
        }
        MyList<String> topSongs = new MyLinkedListImpl<>();
        for (int i = 0; i < 10; i++) {
            spotifyTrack track = arrayTop[i];
            if (track != null) {
                topSongs.add("Rank: " + track.getDailyRank() + ", Song: " + track.getName() + ", Artist(s): " + track.getArtists().toString());
            }
        }
        return topSongs;
        //spotifyTrack track = privatetracks.find(dateInt);
        //MySearchBinaryTree<Integer, spotifyTrack> privatetracks = tracks;
        //TreeNode<Integer, spotifyTrack> node = privatetracks.findNode(dateInt);

        /*while ((node != null) && (node.getKey() == dateInt) && (valuesInArray < 10)) {
            spotifyTrack track = node.getValue();
            if (track.getCountry().equalsIgnoreCase(country)) {
                int rank = track.getDailyRank();
                if (rank > 0 && rank <= 10){
                    arrayTop[10 - rank] = track;
                    //filteredTracks.add(track);
                    valuesInArray++;
                    //System.out.println("valuesInArray: " + valuesInArray);
                }
                //System.out.println("In for loop: " + j);
            }

            node = node.getLeft();
            *//*i++;
            System.out.println("Ran for loop: " + j);
            j++;*//*

        }*/
        //System.out.println("Bubblesort");

        // MyList<spotifyTrack> sortedTracks = sortTracksByRank(filteredTracks);


        /*try {
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
        }*/
    }

    //bubblesort
    /*private static MyList<spotifyTrack> sortTracksByRank(MyList<spotifyTrack> tracks) {
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
    }*/
}