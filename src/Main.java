import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ArrayList<Artist> artists = new ArrayList<>();
        ArrayList<Song> songs = new ArrayList<>();
        ArrayList<Playlist> playlists = new ArrayList<>();

        artists.add(new Artist("Liker1337", 25));
        artists.add(new Artist("g4v3r", 30));
        songs.add(new Song("Track 1", "Liker1337", 180));
        songs.add(new Song("Track 2", "g4v3r", 220));
        playlists.add(new Playlist("My Favorites", 5));
        playlists.add(new Playlist("Chill", 3));

        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("\n=== MUSIC LIBRARY MENU ===");
            System.out.println("1. Add Artist");
            System.out.println("2. Add Song");
            System.out.println("3. Add Playlist");
            System.out.println("4. List All");
            System.out.println("5. Search by Name");
            System.out.println("6. Sort Artists by Age");
            System.out.println("7. Sort Songs by Duration");
            System.out.println("8. Sort Playlists by Song Count");
            System.out.println("9. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:  // Add Artist
                    System.out.print("Enter artist name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter age: ");
                    int age = scanner.nextInt();
                    artists.add(new Artist(name, age));
                    break;
                case 2:  // Add Song
                    System.out.print("Enter song title: ");
                    String title = scanner.nextLine();
                    System.out.print("Enter artist name: ");
                    String artist = scanner.nextLine();
                    System.out.print("Enter duration (sec): ");
                    int duration = scanner.nextInt();
                    songs.add(new Song(title, artist, duration));
                    break;
                case 3:  // Add Playlist
                    System.out.print("Enter playlist name: ");
                    String pName = scanner.nextLine();
                    System.out.print("Enter song count: ");
                    int count = scanner.nextInt();
                    playlists.add(new Playlist(pName, count));
                    break;
                case 4:  // List All
                    System.out.println("Artists:");
                    for (Artist a : artists) System.out.println(a.toString());
                    System.out.println("Songs:");
                    for (Song s : songs) System.out.println(s.toString());
                    System.out.println("Playlists:");
                    for (Playlist p : playlists) System.out.println(p.toString());
                    break;
                case 5:  // Search by Name
                    System.out.print("Enter name to search: ");
                    String search = scanner.nextLine();
                    System.out.println("Artists matching:");
                    for (Artist a : artists) if (a.getName().contains(search)) System.out.println(a.toString());
                    System.out.println("Songs matching:");
                    for (Song s : songs) if (s.getTitle().contains(search)) System.out.println(s.toString());
                    System.out.println("Playlists matching:");
                    for (Playlist p : playlists) if (p.getName().contains(search)) System.out.println(p.toString());
                    break;
                case 6:  // Sort Artists
                    bubbleSort(artists);
                    System.out.println("Artists sorted by age:");
                    for (Artist a : artists) System.out.println(a.toString());
                    break;
                case 7:  // Sort Songs
                    bubbleSort(songs);
                    System.out.println("Songs sorted by duration:");
                    for (Song s : songs) System.out.println(s.toString());
                    break;
                case 8:  // Sort Playlists
                    bubbleSort(playlists);
                    System.out.println("Playlists sorted by song count:");
                    for (Playlist p : playlists) System.out.println(p.toString());
                    break;
                case 9:  // Exit
                    running = false;
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        }
        scanner.close();
    }

    private static <T extends Entity> void bubbleSort(ArrayList<T> list) {
        for (int i = 0; i < list.size() - 1; i++) {
            for (int j = 0; j < list.size() - i - 1; j++) {
                if (list.get(j).compareTo(list.get(j + 1)) > 0) {
                    T temp = list.get(j);
                    list.set(j, list.get(j + 1));
                    list.set(j + 1, temp);
                }
            }
        }
    }
}