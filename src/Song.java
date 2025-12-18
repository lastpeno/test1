public class Song {
    private String title;
    private String artistName;
    private int duration;

    public Song() {
        this.title = "Unknown";
        this.artistName = "Unknown";
        this.duration = 0;
    }

    public Song(String title, String artistName, int duration) {
        this.title = title;
        this.artistName = artistName;
        this.duration = duration;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getArtistName() {
        return artistName;
    }

    public void setArtistName(String artistName) {
        this.artistName = artistName;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public void printInfo() {
        System.out.println("Song: " + title + " by " + artistName +
                ", Duration: " + duration + " sec");
    }
}