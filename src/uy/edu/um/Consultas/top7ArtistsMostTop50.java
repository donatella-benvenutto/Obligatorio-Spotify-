package uy.edu.um.Consultas;

import uy.edu.um.adt.binarytree.MySearchBinaryTree;
import uy.edu.um.adt.binarytree.MySearchBinaryTreeImpl;
import uy.edu.um.adt.binarytree.TreeNode;
import uy.edu.um.adt.hash.MyHash;
import uy.edu.um.adt.hash.MyHashImpl;
import uy.edu.um.adt.linkedlist.MyLinkedListImpl;
import uy.edu.um.adt.linkedlist.MyList;
import uy.edu.um.entities.Artists;
import uy.edu.um.entities.ArtistCount;
import uy.edu.um.entities.spotifyTrack;

import java.util.Calendar;
import java.util.Date;

public class top7ArtistsMostTop50{
    public static MyList<String> getTop7Artists(String startDate, String endDate, MySearchBinaryTree<Integer, spotifyTrack> tree) {
        int startDateInt = datetoint(startDate);
        int endDateInt = datetoint(endDate);

        // Obtener todos los nodos entre las fechas de inicio y fin
        MyList<TreeNode<Integer, spotifyTrack>> nodesInRange = tree.findNodesByDateRange(startDateInt, endDateInt);

        // Utilizar un hash map para contar las apariciones de cada artista
        MyHash<String, ArtistCount> artistCountMap = new MyHashImpl<>();

        for (int i = 0; i < nodesInRange.size(); i++) {
            TreeNode<Integer, spotifyTrack> node = nodesInRange.get(i);
            spotifyTrack track = node.getValue();
            MyList<Artists> artists = track.getArtistList();
            for (int j = 0 ; j < artists.size(); j++) {
                String artist = artists.get(j).getName();
                if (!artistCountMap.contains(artist)) {
                    artistCountMap.put(artist,new ArtistCount(artist));
                }
                artistCountMap.get(artist).increment();
            }
        }

        // Convertir todas las entradas del hash en una lista
        MyList<ArtistCount> allArtists = new MyLinkedListImpl<>();
        for (int i = 0; i < artistCountMap.getCapacity(); i++) {
            if (artistCountMap.getTable()[i] != null) {
                allArtists.add(artistCountMap.getTable()[i].getValue());
            }
        }

        // Ordenar la lista según el count en orden descendente utilizando Quicksort
        quicksortDescending(allArtists, 0, allArtists.size() - 1);

        // Crear la MyList con los 7 artistas más populares
        MyList<String> top7Artists = new MyLinkedListImpl<>();
        if (allArtists.size() == 0) {
            return null;
        }
        for (int i = 0; i < 7 && i < allArtists.size(); i++) {
            ArtistCount artistCount = allArtists.get(i);
            top7Artists.add("Rank: " + (i+1) + ", Artist: " + artistCount.getArtistName());
        }

        return top7Artists;
    }

    private static void quicksortDescending(MyList<ArtistCount> artists, int left, int right) {
        if (left < right) {
            int pivotIndex = partitionDescending(artists, left, right);
            quicksortDescending(artists, left, pivotIndex - 1);
            quicksortDescending(artists, pivotIndex + 1, right);
        }
    }

    private static int partitionDescending(MyList<ArtistCount> artists, int left, int right) {
        ArtistCount pivot = artists.get(right);
        int i = left - 1;
        for (int j = left; j < right; j++) {
            if (artists.get(j).getCount() >= pivot.getCount()) {
                i++;
                ArtistCount temp = artists.get(i);
                artists.set(i, artists.get(j));
                artists.set(j, temp);
            }
        }
        ArtistCount temp = artists.get(i + 1);
        artists.set(i + 1, artists.get(right));
        artists.set(right, temp);
        return i + 1;
    }

    private static int datetoint(String value) {
        String[] parts = value.split("-");
        String year = parts[0];
        String month = parts[1];
        String day = parts[2];
        return Integer.parseInt(year.concat(month).concat(day));
    }

        /*public MyLinkedListImpl<Artists> getTop7Artists(Date startDate, Date endDate, MySearchBinaryTreeImpl<Date, MyLinkedListImpl<spotifyTrack>> tree) {
            MyHashImpl<Artists, Integer> frequencyMap = new MyHashImpl<>();

            for (Date date = startDate; !date.after(endDate); date = incrementDateByOne(date)) {
                MyLinkedListImpl<spotifyTrack> tracks = tree.find(date);
                for (int i = 0; i < tracks.size(); i++) {
                    spotifyTrack track = tracks.get(i);
                    for (Artists artist : track.getArtists()) {
                        Integer count = frequencyMap.get(artist);
                        if (count == null) {
                            frequencyMap.put(artist, 1);
                        } else {
                            frequencyMap.put(artist, count + 1);
                        }
                    }
                }
            }

            MyLinkedListImpl<Integer> counts = frequencyMap.values();
            counts.sort((a, b) -> b - a);

            MyLinkedListImpl<Artists> top7Artists = new MyLinkedListImpl<>();
            for (int i = 0; i < 7 && i < counts.size(); i++) {
                for (int j = 0; j < frequencyMap.size(); j++) {
                    if (frequencyMap.get(tracks.get(j).getArtists().get(0)).equals(counts.get(i))) {
                        top7Artists.add(tracks.get(j).getArtists().get(0));
                        break;
                    }
                }
            }

            return top7Artists;
        }

        private Date incrementDateByOne(Date date) {
            Calendar c = Calendar.getInstance();
            c.setTime(date);
            c.add(Calendar.DATE, 1);
            return c.getTime();
        }*/
}