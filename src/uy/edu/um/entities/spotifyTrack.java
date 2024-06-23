package uy.edu.um.entities;

import com.opencsv.bean.CsvBindByName;
import com.opencsv.bean.CsvBindByPosition;
import com.opencsv.bean.CsvCustomBindByName;
import uy.edu.um.CsvReader.QuotedBooleanConverter;
import uy.edu.um.CsvReader.QuotedDoubleConverter;
import uy.edu.um.CsvReader.QuotedIntegerConverter;
import uy.edu.um.CsvReader.QuotedStringConverter;
import uy.edu.um.adt.linkedlist.MyLinkedListImpl;
import uy.edu.um.adt.linkedlist.MyList;
import uy.edu.um.entities.Artists;

public class spotifyTrack implements Comparable<spotifyTrack> {
    @CsvBindByName(column = "spotify_id")
    private String spotifyId;

    @CsvBindByName(column = "name")
    private String name;

    @CsvBindByName(column = "artists")
    private String artists;

    @CsvBindByName(column = "daily_rank")
    private Integer dailyRank;

    @CsvBindByName(column = "daily_movement")
    private Integer dailyMovement;

    @CsvBindByName(column = "weekly_movement")
    private Integer weeklyMovement;

    @CsvBindByName(column = "country")
    private String country;

    @CsvBindByName(column = "snapshot_date")
    private String snapshotDate;

    @CsvBindByName(column = "popularity")
    private Integer popularity;

    @CsvBindByName(column = "is_explicit")
    private Boolean isExplicit;

    @CsvBindByName(column = "duration_ms")
    private Integer durationMs;

    @CsvBindByName(column = "album_name")
    private String albumName;

    @CsvBindByName(column = "album_release_date")
    private String albumReleaseDate;

    @CsvBindByName(column = "danceability")
    private Double danceability;

    @CsvBindByName(column = "energy")
    private Double energy;

    @CsvBindByName(column = "key")
    private Integer key;

    @CsvBindByName(column = "loudness")
    private Double loudness;

    @CsvBindByName(column = "mode")
    private Integer mode;

    @CsvBindByName(column = "speechiness")
    private Double speechiness;

    @CsvBindByName(column = "acousticness")
    private Double acousticness;

    @CsvBindByName(column = "instrumentalness")
    private Double instrumentalness;

    @CsvBindByName(column = "liveness")
    private Double liveness;

    @CsvBindByName(column = "valence")
    private Double valence;

    @CsvBindByName(column = "tempo")
    private Double tempo;

    @CsvBindByName(column = "time_signature")
    private Integer timeSignature;

    // Additional field to store the split artists
    private MyList<Artists> artistList;

    public spotifyTrack(String spotifyId, String name, String artists, int dailyRank, int dailyMovement, int weeklyMovement, String country, String snapshotDate, int popularity, boolean isExplicit, int durationMs, String albumName, String albumReleaseDate, double danceability, double energy, int key, double loudness, int mode, double speechiness, double acousticness, double instrumentalness, double liveness, double valence, double tempo, int timeSignature) {
        this.spotifyId = spotifyId;
        this.name = name;
        this.artists = artists;
        this.dailyRank = dailyRank;
        this.dailyMovement = dailyMovement;
        this.weeklyMovement = weeklyMovement;
        this.country = country;
        this.snapshotDate = snapshotDate;
        this.popularity = popularity;
        this.isExplicit = isExplicit;
        this.durationMs = durationMs;
        this.albumName = albumName;
        this.albumReleaseDate = albumReleaseDate;
        this.danceability = danceability;
        this.energy = energy;
        this.key = key;
        this.loudness = loudness;
        this.mode = mode;
        this.speechiness = speechiness;
        this.acousticness = acousticness;
        this.instrumentalness = instrumentalness;
        this.liveness = liveness;
        this.valence = valence;
        this.tempo = tempo;
        this.timeSignature = timeSignature;
        this.artistList = new MyLinkedListImpl<>();
        splitArtists(artists);
    }

    public MyList<Artists> getArtistList() {
        return artistList;
    }

    public void setArtistList(MyList<Artists> artistList) {
        this.artistList = artistList;
    }

    // No-argument constructor
    public spotifyTrack() {
    }
    public String getSpotifyId() {
        return spotifyId;
    }

    public void setSpotifyId(String spotifyId) {
        this.spotifyId = spotifyId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getArtists() {
        return artists;
    }

    public void setArtists(String artists) {
        this.artists = artists;
        splitArtists(artists); // Llamar al método helper cada vez que se actualice artists
    }

    public int getDailyRank() {
        return dailyRank;
    }

    public void setDailyRank(int dailyRank) {
        this.dailyRank = dailyRank;
    }

    public int getDailyMovement() {
        return dailyMovement;
    }

    public void setDailyMovement(int dailyMovement) {
        this.dailyMovement = dailyMovement;
    }

    public int getWeeklyMovement() {
        return weeklyMovement;
    }

    public void setWeeklyMovement(int weeklyMovement) {
        this.weeklyMovement = weeklyMovement;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getSnapshotDate() {
        return snapshotDate;
    }

    public void setSnapshotDate(String snapshotDate) {
        this.snapshotDate = snapshotDate;
    }

    public int getPopularity() {
        return popularity;
    }

    public void setPopularity(int popularity) {
        this.popularity = popularity;
    }

    public boolean isExplicit() {
        return isExplicit;
    }

    public void setExplicit(boolean explicit) {
        isExplicit = explicit;
    }

    public int getDurationMs() {
        return durationMs;
    }

    public void setDurationMs(int durationMs) {
        this.durationMs = durationMs;
    }

    public String getAlbumName() {
        return albumName;
    }

    public void setAlbumName(String albumName) {
        this.albumName = albumName;
    }

    public String getAlbumReleaseDate() {
        return albumReleaseDate;
    }

    public void setAlbumReleaseDate(String albumReleaseDate) {
        this.albumReleaseDate = albumReleaseDate;
    }

    public double getDanceability() {
        return danceability;
    }

    public void setDanceability(double danceability) {
        this.danceability = danceability;
    }

    public double getEnergy() {
        return energy;
    }

    public void setEnergy(double energy) {
        this.energy = energy;
    }

    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }

    public double getLoudness() {
        return loudness;
    }

    public void setLoudness(double loudness) {
        this.loudness = loudness;
    }

    public int getMode() {
        return mode;
    }

    public void setMode(int mode) {
        this.mode = mode;
    }

    public double getSpeechiness() {
        return speechiness;
    }

    public void setSpeechiness(double speechiness) {
        this.speechiness = speechiness;
    }

    public double getAcousticness() {
        return acousticness;
    }

    public void setAcousticness(double acousticness) {
        this.acousticness = acousticness;
    }

    public double getInstrumentalness() {
        return instrumentalness;
    }

    public void setInstrumentalness(double instrumentalness) {
        this.instrumentalness = instrumentalness;
    }

    public double getLiveness() {
        return liveness;
    }

    public void setLiveness(double liveness) {
        this.liveness = liveness;
    }

    public double getValence() {
        return valence;
    }

    public void setValence(double valence) {
        this.valence = valence;
    }

    public double getTempo() {
        return tempo;
    }

    public void setTempo(double tempo) {
        this.tempo = tempo;
    }

    public int getTimeSignature() {
        return timeSignature;
    }

    public void setTimeSignature(int timeSignature) {
        this.timeSignature = timeSignature;
    }

    private void splitArtists(String artists) {
        if (artists != null && !artists.isEmpty()) {
            //artistList.clear(); // Limpiar la lista antes de volver a llenarla?????
            artistList = new MyLinkedListImpl<>();
            if (artists.contains(",")){
                String[] artistArray = artists.split(",");
                for (String artistName : artistArray) {
                    artistList.add(new Artists(artistName.trim()));
                    //System.out.println(artistName.trim().toString());
                }
            } else{
                artistList.add(new Artists(artists));
                //System.out.println(artists.toString());
            }
            setArtistList(artistList);

        }
    }
    public static int datetoint(String value) {
        if (value != null) {
            String[] parts = value.split("-");
            String year = parts[0];
            String month = parts[1];
            String day = parts[2];
            return Integer.parseInt(year.concat(month).concat(day));
        }
        return 0;
    }


    @Override
    public String toString() {
        return "SpotifyTrack{" +
                "spotifyId='" + spotifyId + '\'' +
                ", name='" + name + '\'' +
                ", artists='" + artists + '\'' +
                ", artistList=" + artistList +
                ", dailyRank=" + dailyRank +
                ", dailyMovement=" + dailyMovement +
                ", weeklyMovement=" + weeklyMovement +
                ", country='" + country + '\'' +
                ", snapshotDate='" + snapshotDate + '\'' +
                ", popularity=" + popularity +
                ", isExplicit=" + isExplicit +
                ", durationMs=" + durationMs +
                ", albumName='" + albumName + '\'' +
                ", albumReleaseDate='" + albumReleaseDate + '\'' +
                ", danceability=" + danceability +
                ", energy=" + energy +
                ", key=" + key +
                ", loudness=" + loudness +
                ", mode=" + mode +
                ", speechiness=" + speechiness +
                ", acousticness=" + acousticness +
                ", instrumentalness=" + instrumentalness +
                ", liveness=" + liveness +
                ", valence=" + valence +
                ", tempo=" + tempo +
                ", timeSignature=" + timeSignature +
                '}';
    }

    @Override
    public int compareTo(spotifyTrack o) {

        return 0;
    }
}