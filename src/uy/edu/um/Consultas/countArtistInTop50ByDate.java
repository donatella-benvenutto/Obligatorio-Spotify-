package uy.edu.um.Consultas;

import uy.edu.um.adt.binarytree.MySearchBinaryTreeImpl;
import uy.edu.um.adt.linkedlist.MyLinkedListImpl;
import uy.edu.um.entities.Artists;
import uy.edu.um.entities.spotifyTrack;

import java.util.Date;

public class countArtistInTop50ByDate {

    public int countArtistAppearances(Date date, Artists artist, MySearchBinaryTreeImpl<Date, MyLinkedListImpl<spotifyTrack>> tree) {
        MyLinkedListImpl<spotifyTrack> tracks = tree.find(date);
        int count = 0;

        for (int i = 0; i < tracks.size(); i++) {
            spotifyTrack track = tracks.get(i);
            if (track.getArtists().contains(artist.toString())) {
                count++;
            }
        }

        return count;
    }
}
