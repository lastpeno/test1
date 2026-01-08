public class Song extends Entity {
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

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }
    public String getArtistName() { return artistName; }
    public void setArtistName(String artistName) { this.artistName = artistName; }
    public int getDuration() { return duration; }
    public void setDuration(int duration) { this.duration = duration; }

    @Override
    public String toString() {
        return "Song: " + title + " by " + artistName + ", Duration: " + duration + " sec";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Song song = (Song) obj;
        return duration == song.duration && title.equals(song.title) && artistName.equals(song.artistName);
    }

    @Override
    public int hashCode() {
        return title.hashCode() + artistName.hashCode() + duration;
    }

    @Override
    public int compareTo(Entity other) {
        if (other instanceof Song) {
            return Integer.compare(this.duration, ((Song) other).duration);
        }
        return 0;
    }
}