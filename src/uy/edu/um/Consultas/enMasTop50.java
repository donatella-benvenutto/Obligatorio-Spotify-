package uy.edu.um.Consultas;

import uy.edu.um.adt.binarytree.MySearchBinaryTreeImpl;
import uy.edu.um.adt.hash.MyHash;
import uy.edu.um.adt.hash.MyHashImpl;
import uy.edu.um.adt.linkedlist.MyLinkedListImpl;
import uy.edu.um.adt.linkedlist.MyList;
import uy.edu.um.entities.spotifyTrack;
import java.util.*;

import static java.util.Map.Entry.comparingByValue;

public class enMasTop50 {
    public MyLinkedListImpl<spotifyTrack> getTop5Songs(Date date, MySearchBinaryTreeImpl<Date, MyLinkedListImpl<spotifyTrack>> tree) {

        MyLinkedListImpl<spotifyTrack> tracks = tree.find(date);
        MyHashImpl<spotifyTrack, Integer> frequencyMap = new MyHashImpl<>();

        for (int i = 0; i < tracks.size(); i++) {
            spotifyTrack track = tracks.get(i);
            Integer count = frequencyMap.get(track);
            if (count == null) {
                frequencyMap.put(track, 1);
            } else {
                frequencyMap.put(track, count + 1);
            }
        }

        MyLinkedListImpl<spotifyTrack> sortedTracks = new MyLinkedListImpl<>();
        for (int i = 0; i < tracks.size(); i++) {
            spotifyTrack track = tracks.get(i);

            sortedTracks.addInOrder(track, (t1, t2) -> frequencyMap.get(t2) - frequencyMap.get(t1));
        }

        MyLinkedListImpl<spotifyTrack> top5Tracks = new MyLinkedListImpl<>();
        for (int i = 0; i < 5 && i < sortedTracks.size(); i++) {
            top5Tracks.add(sortedTracks.get(i));
        }

        return top5Tracks;
    }
}