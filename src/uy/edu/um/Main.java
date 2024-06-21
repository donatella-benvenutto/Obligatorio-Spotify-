package uy.edu.um;

import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;

import uy.edu.um.CsvReader.bufferReader;
import uy.edu.um.adt.binarytree.MySearchBinaryTree;
import uy.edu.um.adt.binarytree.MySearchBinaryTreeImpl;
import uy.edu.um.adt.linkedlist.MyLinkedListImpl;
import uy.edu.um.adt.linkedlist.MyList;
import uy.edu.um.entities.spotifyTrack;
import uy.edu.um.entities.Artists;

import static uy.edu.um.Consultas.topCountryDay.findTopSongs;
import static uy.edu.um.entities.spotifyTrack.datetoint;

public class Main {
    public static void main(String[] args) throws IOException {
        String csvFile = "CSV/universal_top_spotify_songs.csv";

        // Preprocess the CSV file
        String processedCSVFile = bufferReader.preprocessCSV(csvFile);
        //String processedCSVFile = "CSV/processed_universal_top_spotify_songs.csv";
        //String processedCSVFile = "CSV/testingcsv.csv";


        // Now use the processed CSV file
        //DONA
        try {
            MyList<spotifyTrack> beanslist = new MyLinkedListImpl<>();
            beanslist = beanslist.parseFromJavaList(new CsvToBeanBuilder(new FileReader(processedCSVFile))
                    .withType(spotifyTrack.class)
                    .build()
                    .parse());

            //Pasar string de snapshot_date a int ej: "2023-10-06" = 20231006 y hae una lista en el orden de beanslist
            MyList<Integer> beanslistkey = new MyLinkedListImpl<>();
            for (int i = 0; i < beanslist.size(); i++) {
                beanslistkey.add(datetoint(beanslist.get(i).getSnapshotDate()));
            }

            //Usar beanslistkey
            MySearchBinaryTree<Integer, spotifyTrack> beanstree = new MySearchBinaryTreeImpl<>();
            beanstree.parseLinkedListToTree(beanslistkey, beanslist);

            System.out.println(findTopSongs(beanstree, "2023-10-06", "NG"));

        } catch (IOException e) {
            e.printStackTrace();
        /*// Create a list to hold the SpotifyTrack objects
        MyList<spotifyTrack> beanslist = new MyLinkedListImpl<>();

        // Create a list to hold the integer keys derived from the SpotifyTrack objects
        MyList<Integer> beanslistkey = new MyLinkedListImpl<>();

        // Parse the CSV file and iterate over the records
        try (CSVReader reader = new CSVReader(new FileReader(processedCSVFile))) {
            CsvToBean<spotifyTrack> csvToBean = new CsvToBeanBuilder<spotifyTrack>(reader)
                    .withType(spotifyTrack.class)
                    .build();
            for (spotifyTrack track : csvToBean) {
                System.out.println(track);
                beanslist.add(track);
                beanslistkey.add(datetoint(track.getSnapshotDate()));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }*/


        }
    }
}