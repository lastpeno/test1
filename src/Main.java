public class Main {
    public static void main(String[] args) {
        Artist artist1 = new Artist("Liker1337", 25);
        Artist artist2 = new Artist("g4v3r", 30);

        Song song1 = new Song("Track 1", "Liker1337", 180);
        Song song2 = new Song("Track 2", "g4v3r", 220);

        Playlist playlist1 = new Playlist("My Favorites", 5);
        Playlist playlist2 = new Playlist("Chill", 3);
/*
        System.out.println("=== MUSIC LIBRARY ===");
        artist1.printInfo();
        artist2.printInfo();
        System.out.println();

        song1.printInfo();
        song2.printInfo();
        System.out.println();

        playlist1.printInfo();
        playlist2.printInfo();
        System.out.println();
*/
        System.out.println("Comparing playlists:");
        if (playlist1.getSongCount() > playlist2.getSongCount()) {
            System.out.println(playlist1.getName() + " has more songs");
        } else {
            System.out.println(playlist2.getName() + " has fewer songs");
        }

        System.out.println("Comparing artists age:");
        if (artist1.getAge() < artist2.getAge()) {
            System.out.println(artist1.getName() + " is younger than " + artist2.getName());
        }
    }
}