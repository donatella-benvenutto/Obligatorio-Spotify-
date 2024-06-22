package uy.edu.um.Consultas;

import uy.edu.um.adt.binarytree.MySearchBinaryTree;
import uy.edu.um.adt.binarytree.TreeNode;
import uy.edu.um.adt.linkedlist.MyList;
import uy.edu.um.entities.spotifyTrack;

public class CountSongsByTempoRangeAndDateRange {

    public int countSongsByTempo(double minTempo, double maxTempo, String startDateStr, String endDateStr, MySearchBinaryTree<Integer, spotifyTrack> tree) {
        int startDate = datetoint(startDateStr);
        int endDate = datetoint(endDateStr);
        int count = 0;

        MyList<TreeNode<Integer, spotifyTrack>> nodesInRange = tree.findNodesByDateRange(startDate, endDate);
        for (int i = 0 ; i < nodesInRange.size(); i++){
            spotifyTrack track = nodesInRange.get(i).getValue();
            double tempo = track.getTempo();
            if (tempo >= minTempo && tempo <= maxTempo) {
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
    /*public int countSongsByTempo(Date startDate, Date endDate, double minTempo, double maxTempo, MySearchBinaryTreeImpl<Date, MyLinkedListImpl<spotifyTrack>> tree) {
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
    }*/
}

