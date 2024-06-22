package uy.edu.um.entities;

public class SongCount implements Comparable<SongCount>{
    private String spotifyId;
    private String songName;
    private int count;

    public SongCount(String spotifyId, String songName) {
        this.spotifyId = spotifyId;
        this.songName = songName;
        this.count = 0;
    }

    public String getSpotifyId() {
        return spotifyId;
    }

    public void setSpotifyId(String spotifyId) {
        this.spotifyId = spotifyId;
    }

    public String getSongName() {
        return songName;
    }

    public void setSongName(String songName) {
        this.songName = songName;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public void increment() {
        this.count++;
    }

    @Override
    public int compareTo(SongCount o) {
        // Queremos un Max-Heap, por lo que comparamos en orden descendente
        //the value 0 if x == y; a value less than 0 if x < y; and a value greater than 0 if x > y
        return Integer.compare(o.count, this.count);
    }
}
