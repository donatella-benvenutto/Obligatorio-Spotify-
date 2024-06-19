package uy.edu.um.Consultas;

import uy.edu.um.adt.binarytree.MySearchBinaryTreeImpl;
import uy.edu.um.adt.hash.MyHashImpl;
import uy.edu.um.adt.linkedlist.MyLinkedListImpl;
import uy.edu.um.entities.Artists;
import uy.edu.um.entities.spotifyTrack;

import java.util.Calendar;
import java.util.Date;

public class top7ArtistsMostTop50

        public MyLinkedListImpl<Artists> getTop7Artists(Date startDate, Date endDate, MySearchBinaryTreeImpl<Date, MyLinkedListImpl<spotifyTrack>> tree) {
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
        }
}