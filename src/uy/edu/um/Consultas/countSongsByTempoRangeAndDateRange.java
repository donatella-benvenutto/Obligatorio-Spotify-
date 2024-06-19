package uy.edu.um.Consultas;

import uy.edu.um.adt.binarytree.MySearchBinaryTreeImpl;
import uy.edu.um.adt.linkedlist.MyLinkedListImpl;
import uy.edu.um.entities.spotifyTrack;

import java.util.Calendar;
import java.util.Date;

public class countSongsByTempoRangeAndDateRange {

    public int countSongsByTempo(Date startDate, Date endDate, double minTempo, double maxTempo, MySearchBinaryTreeImpl<Date, MyLinkedListImpl<spotifyTrack>> tree) {
        int count = 0;

        for (Date date = startDate; !date.after(endDate); date = incrementDateByOne(date)) {
            MyLinkedListImpl<spotifyTrack> tracks = tree.find(date);
            for (int i = 0; i < tracks.size(); i++) {
                spotifyTrack track = tracks.get(i);
                if (track.getTempo() >= minTempo && track.getTempo() <= maxTempo) {
                    count++;
                }
            }
        }

        return count;
    }

    private Date incrementDateByOne(Date date) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.add(Calendar.DATE, 1);
        return c.getTime();
    }
}

