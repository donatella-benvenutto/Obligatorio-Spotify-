package uy.edu.um;
import com.opencsv.bean.CsvToBeanBuilder;
import uy.edu.um.adt.binarytree.MySearchBinaryTree;
import uy.edu.um.adt.binarytree.MySearchBinaryTreeImpl;
import uy.edu.um.adt.linkedlist.MyLinkedListImpl;
import uy.edu.um.adt.linkedlist.MyList;
import uy.edu.um.entities.*;
import uy.edu.um.Consultas.*;
import uy.edu.um.CsvReader.*;


import java.io.FileReader;
import java.io.IOException;

public class SpotifyDataManager {
    private MySearchBinaryTree<Integer, spotifyTrack> beanstree;

    public SpotifyDataManager() {
        this.beanstree = new MySearchBinaryTreeImpl<>();
    }
    public void loadDataFromCSV(String fileName) throws IOException {
        String processedCSVFile = bufferReader.preprocessCSV(fileName);
        String processedCSV = "CSV/processed_universal_top_spotify_songs.csv";

        try {
            MyList<spotifyTrack> beanslist = new MyLinkedListImpl<>();
            beanslist = beanslist.parseFromJavaList(new CsvToBeanBuilder(new FileReader(processedCSV))
                    .withType(spotifyTrack.class)
                    .build()
                    .parse());

            System.out.println("CSV loaded succesfully, now creating binary tree ... ");
            for (int i = 0; i < beanslist.size(); i++) {
                beanstree.add(datetoint(beanslist.get(i).getSnapshotDate()), beanslist.get(i));
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println();
    }
    private static int datetoint(String value) {
        if (value != null) {
            String[] parts = value.split("-");
            String year = parts[0];
            String month = parts[1];
            String day = parts[2];
            return Integer.parseInt(year.concat(month).concat(day));
        }
        return 0;
    }
    private void printResults(MyList<String> list){
        for (int i = 0 ; i < list.size(); i++){
            System.out.println(list.get(i));
        }
    }
    public void reportTop10SongsByCountryAndDate(String country, String date) {
        MyList<String> topSongs = topCountryDay.findTopSongs(beanstree, date, country);
        printResults(topSongs);
    }

    public void reportTop5SongsInMostCountries(String date) {
        MyList<String> topSongs = enMasTop50.getTop5Songs(date, beanstree);
        printResults(topSongs);
    }

    public void reportTop7ArtistsByDateRange(String startDate, String endDate) {
        MyList<String> topArtists = top7ArtistsMostTop50.getTop7Artists(startDate, endDate, beanstree);
        printResults(topArtists);
    }

    public void reportArtistAppearancesInTop50(String artist, String date) {
        int count = CountArtistInTop50ByDate.countArtistInTop50(artist, date, beanstree);
        System.out.println("La cantidad de veces que aparece " + artist + " en la fecha " + date + " proporcionada es: " + count);
    }

    public void reportSongsByTempoRangeAndDateRange(double tempoStart, double tempoEnd, String startDate, String endDate) {
        int count = CountSongsByTempoRangeAndDateRange.countSongsByTempo(tempoStart, tempoEnd, startDate, endDate, beanstree);
        System.out.println("La cantidad de canciones con tempo entre " + tempoStart + " y " + tempoEnd + " entre las fechas " + startDate + " y " + endDate + " es: " + count);

    }
}
