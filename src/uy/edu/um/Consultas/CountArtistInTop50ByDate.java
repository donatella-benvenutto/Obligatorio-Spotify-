package uy.edu.um.Consultas;

import uy.edu.um.adt.binarytree.MySearchBinaryTree;
import uy.edu.um.adt.binarytree.TreeNode;
import uy.edu.um.adt.linkedlist.MyList;
import uy.edu.um.entities.spotifyTrack;

public class CountArtistInTop50ByDate {

    public int countArtistInTop50(String artistName, String snapshotDate, MySearchBinaryTree<Integer, spotifyTrack> tree) {
        int count = 0;

        MyList<TreeNode<Integer, spotifyTrack>> nodesOnDate = tree.findNodesByDate(datetoint(snapshotDate));
        for (int i = 0 ; i < nodesOnDate.size(); i++){
            spotifyTrack track = nodesOnDate.get(i).getValue();
            if (track.getArtists().contains(artistName)) {
                count++;
            }
        }

        return count;
    }

    private static int datetoint(String value) {
        String[] parts = value.split("-");
        String year = parts[0];
        String month = parts[1];
        String day = parts[2];
        return Integer.parseInt(year.concat(month).concat(day));
    }
   /* public int countArtistAppearances(Date date, Artists artist, MySearchBinaryTreeImpl<Date, MyLinkedListImpl<spotifyTrack>> tree) {
        MyLinkedListImpl<spotifyTrack> tracks = tree.find(date);
        int count = 0;

        for (int i = 0; i < tracks.size(); i++) {
            spotifyTrack track = tracks.get(i);
            if (track.getArtists().contains(artist.toString())) {
                count++;
            }
        }

        return count;
    }*/
}
