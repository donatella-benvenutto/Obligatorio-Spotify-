package uy.edu.um;

import com.opencsv.bean.CsvToBeanBuilder;

import java.io.FileReader;
import java.io.IOException;

import uy.edu.um.adt.binarytree.MySearchBinaryTree;
import uy.edu.um.adt.binarytree.MySearchBinaryTreeImpl;
import uy.edu.um.adt.linkedlist.MyLinkedListImpl;
import uy.edu.um.adt.linkedlist.MyList;
import uy.edu.um.entities.spotifyTrack;

import static uy.edu.um.Consultas.topCountryDay.findTopSongs;

public class Main {
    public static void main(String[] args) throws IOException {
        //String csvFile = "CSV/universal_top_spotify_songs.csv";

        // Preprocess the CSV file
        //String processedCSVFile = bufferReader.preprocessCSV(csvFile);
        String processedCSVFile = "CSV/processed_universal_top_spotify_songs.csv";
        // Now use the processed CSV file
        //DONA
        try {
            MyList<spotifyTrack> beanslist = new MyLinkedListImpl<>();
            beanslist = beanslist.parseFromJavaList(new CsvToBeanBuilder(new FileReader(processedCSVFile))
                    .withType(spotifyTrack.class)
                    .build()
                    .parse());
            MyList<String> beanslistkey = new MyLinkedListImpl<>();
            for(int i=0; i<beanslist.size(); i++){
                beanslistkey.add(beanslist.get(i).getSpotifyId());
            }
            MySearchBinaryTree<String, spotifyTrack> beanstree = new MySearchBinaryTreeImpl<>();
            beanstree.parseLinkedListToTree(beanslistkey, beanslist);
            System.out.println(findTopSongs(beanslist,"2024-05-13","AR"));
        } catch (IOException e) {
        System.err.println("Error reading CSV file: " + e.getMessage());
        e.printStackTrace();
        }


        //FRAN
        /*try (Reader reader = new FileReader(processedCSVFile)) {
            CSVReader csvReader = new CSVReaderBuilder(reader)
                    .withSkipLines(1)
                    .withCSVParser(new CSVParserBuilder()
                            .withSeparator(';')
                            .withQuoteChar(',')
                            .withIgnoreQuotations(false)
                            .build())
                    .build();

            QuotedMappingStrategy<spotifyTrack> strategy = new QuotedMappingStrategy<>();
            strategy.setType(spotifyTrack.class);

            CsvToBean<spotifyTrack> csvToBean = new CsvToBeanBuilder<spotifyTrack>(csvReader)
                    .withMappingStrategy(strategy)
                    .withIgnoreLeadingWhiteSpace(true)
                    .build();

            List<spotifyTrack> tracks = new ArrayList<>();
            int parsedCount = 0;
            try {
                Iterator<spotifyTrack> iterator = csvToBean.iterator();
                while (iterator.hasNext()) {
                    spotifyTrack track = iterator.next();
                    tracks.add(track);
                    parsedCount++;
                    System.out.println("Parsed track: " + track.getName());
                }
            } catch (RuntimeException e) {
                System.err.println("Error parsing CSV file: " + e.getMessage());
                e.printStackTrace();
            }

            System.out.println("Number of tracks parsed: " + parsedCount);
        } catch (IOException e) {
            System.err.println("Error reading CSV file: " + e.getMessage());
            e.printStackTrace();
        }*/
/*
            for (spotifyTrack track : tracks) {
                String name = track.getName();
                if (name != null) {
                    track.setName(name.replace("\"<DOUBLE_QUOTE>", "\"\""));
                    track.setName(name.replace("<SEMICOLON>", ";"));
                }
                String albumName = track.getAlbumName();
                if (albumName != null) {
                    track.setAlbumName(albumName.replace("\"<DOUBLE_QUOTE>", "\"\""));
                    track.setAlbumName(albumName.replace("<SEMICOLON>", ";"));
                }
            }
            System.out.print(tracks);
            // Process each track to split the "artists" field
            for (spotifyTrack track : tracks) {
                String artists = track.getArtists();
                if (artists != null && !artists.isEmpty()) {
                    List<String> firstartistList = Arrays.asList(artists.split(",\\s*"));
                    MyList<String> artistList = new MyLinkedListImpl<>();
                    artistList = artistList.parseFromJavaList(firstartistList);
                    track.setArtistList(artistList);
                }
            }

            MyList<spotifyTrack> Tracks = new MyLinkedListImpl<>();
            Tracks = Tracks.parseFromJavaList(tracks);
        */
    }
}
