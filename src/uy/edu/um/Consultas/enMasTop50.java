package uy.edu.um.Consultas;

import uy.edu.um.adt.binarytree.MySearchBinaryTree;
import uy.edu.um.adt.binarytree.MySearchBinaryTreeImpl;
import uy.edu.um.adt.binarytree.TreeNode;
import uy.edu.um.adt.hash.MyHash;
import uy.edu.um.adt.hash.MyHashImpl;
import uy.edu.um.adt.linkedlist.MyLinkedListImpl;
import uy.edu.um.adt.linkedlist.MyList;
import uy.edu.um.adt.queue.MyQueue;
import uy.edu.um.entities.SongCount;
import uy.edu.um.entities.spotifyTrack;
import java.util.*;

import static java.util.Map.Entry.comparingByValue;

public class enMasTop50 {
    public static MyList<String> getTop5Songs(String date, MySearchBinaryTree<Integer, spotifyTrack> tree) {

        int dateInt = datetoint(date);

        // Obtener todos los nodos con la misma fecha
        MyList<TreeNode<Integer, spotifyTrack>> nodesOnDate = tree.findNodesByDate(dateInt);

        // Utilizar un HashMap para contar las apariciones de cada canción
        MyHash<String, SongCount> songCountMap = new MyHashImpl<>();


        for (int i = 0 ; i < nodesOnDate.size(); i++) {
            TreeNode<Integer, spotifyTrack> node = nodesOnDate.get(i);
            spotifyTrack track = node.getValue();
            String spotifyId = track.getSpotifyId();
            if (!songCountMap.contains(spotifyId)) {
                songCountMap.put(spotifyId, new SongCount(spotifyId, track.getName()));
            }
            songCountMap.get(spotifyId).increment();
        }

        // Convertir todas las entradas del hash en una lista
        MyList<SongCount> allSongs = new MyLinkedListImpl<>();
        for (int i = 0; i < songCountMap.getCapacity(); i++) {
            if (songCountMap.getTable()[i] != null) {
                allSongs.add(songCountMap.getTable()[i].getValue());
            }
        }

        /*// Ordenar la lista según el count en orden descendente utilizando nuestra implementación personalizada
        sortSongsByCountDescending(allSongs);*/

        // Ordenar la lista según el count en orden descendente utilizando Quicksort
        quicksortDescending(allSongs, 0, allSongs.size() - 1);

        // Crear la MyList con las 5 canciones más populares
        MyList<String> top5Songs = new MyLinkedListImpl<>();
        if (allSongs.size() == 0) {
            return null;
        }
        for (int i = allSongs.size() - 1; i >= 0 && i < 5; i--) {
            SongCount songCount = allSongs.get(i);
            top5Songs.add("Rank: " + (i+1) + ", Song: " + songCount.getSongName());
        }

        return top5Songs;

    }


    private static void quicksortDescending(MyList<SongCount> songs, int left, int right) {
        if (left < right) {
            int pivotIndex = partitionDescending(songs, left, right);
            quicksortDescending(songs, left, pivotIndex - 1);
            quicksortDescending(songs, pivotIndex + 1, right);
        }
    }

    private static int partitionDescending(MyList<SongCount> songs, int left, int right) {
        SongCount pivot = songs.get(right);
        int i = left - 1;
        for (int j = left; j < right; j++) {
            if (songs.get(j).getCount() >= pivot.getCount()) {
                i++;
                SongCount temp = songs.get(i);
                songs.set(i, songs.get(j));
                songs.set(j, temp);
            }
        }
        SongCount temp = songs.get(i + 1);
        songs.set(i + 1, songs.get(right));
        songs.set(right, temp);
        return i + 1;
    }

    private static int datetoint(String value) {
        String[] parts = value.split("-");
        String year = parts[0];
        String month = parts[1];
        String day = parts[2];
        return Integer.parseInt(year.concat(month).concat(day));
    }

    /*MyList<spotifyTrack> tracks = tree.find(date);
            MyHash<spotifyTrack, Integer> frequencyMap = new MyHashImpl<>();

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
        }*/


   // getTop5Songs O(n log n)

}