public class Playlist {
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSongCount() {
        return songCount;
    }

    public void setSongCount(int songCount) {
        this.songCount = songCount;
    }

    public void printInfo() {
        System.out.println("Playlist: " + name + ", Songs: " + songCount);
    }
}