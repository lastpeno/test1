public class Playlist extends Entity {
    private String name;
    private int songCount;

    public Playlist() {
        this.name = "Default Playlist";
        this.songCount = 0;
    }

    public Playlist(String name, int songCount) {
        this.name = name;
        this.songCount = songCount;
    }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public int getSongCount() { return songCount; }
    public void setSongCount(int songCount) { this.songCount = songCount; }

    @Override
    public String toString() {
        return "Playlist: " + name + ", Songs: " + songCount;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Playlist playlist = (Playlist) obj;
        return songCount == playlist.songCount && name.equals(playlist.name);
    }

    @Override
    public int hashCode() {
        return name.hashCode() + songCount;
    }

    @Override
    public int compareTo(Entity other) {
        if (other instanceof Playlist) {
            return Integer.compare(this.songCount, ((Playlist) other).songCount);
        }
        return 0;
    }
}