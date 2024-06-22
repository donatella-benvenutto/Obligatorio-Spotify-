package uy.edu.um.entities;

public class ArtistCount {
    private String artistName;
    private int count;

    public ArtistCount(String artistName) {
        this.artistName = artistName;
        this.count = 0;
    }

    public void increment() {
        this.count++;
    }

    public String getArtistName() {
        return this.artistName;
    }

    public int getCount() {
        return this.count;
    }
}
