import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DatabaseDemo {

    private static final String URL = "jdbc:postgresql://localhost:5432/oop";
    private static final String USER = "postgres";
    private static final String PASSWORD = "quahRi3i!";

    public static void main(String[] args) {
        // 1. create: Insert data
        System.out.println("--- Inserting Artists ---");
        addArtist(new Artist("Liker1337", 25));
        addArtist(new Artist("g4v3r", 30));

        // 2. read: Fetch data
        System.out.println("\n--- Reading Artists ---");
        List<Artist> currentArtists = getAllArtists();
        for (Artist a : currentArtists) {
            System.out.println(a);
        }

        // 3. update: Change data
        System.out.println("\n--- Updating Liker1337's Age ---");
        updateArtistAge("Liker1337", 26);

        // 4. delete: Remove data
        System.out.println("\n--- Deleting g4v3r ---");
        deleteArtist("g4v3r");

        // Final check
        System.out.println("\n--- Final List ---");
        getAllArtists().forEach(System.out::println);
    }


    private static Connection connect() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    // craete (Insert)
    public static void addArtist(Artist artist) {
        String sql = "INSERT INTO artists (name, age) VALUES (?, ?)";

        try (Connection conn = connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, artist.getName());
            pstmt.setInt(2, artist.getAge());
            pstmt.executeUpdate();
            System.out.println("Inserted: " + artist.getName());

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    // read (Select)
    public static List<Artist> getAllArtists() {
        List<Artist> list = new ArrayList<>();
        String sql = "SELECT name, age FROM artists";

        try (Connection conn = connect();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Artist artist = new Artist(
                        rs.getString("name"),
                        rs.getInt("age")
                );
                list.add(artist);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return list;
    }

    // update
    public static void updateArtistAge(String name, int newAge) {
        String sql = "UPDATE artists SET age = ? WHERE name = ?";

        try (Connection conn = connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, newAge);
            pstmt.setString(2, name);
            int rows = pstmt.executeUpdate();
            if (rows > 0) System.out.println("Updated age for " + name);

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    // delete
    public static void deleteArtist(String name) {
        String sql = "DELETE FROM artists WHERE name = ?";

        try (Connection conn = connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, name);
            int rows = pstmt.executeUpdate();
            if (rows > 0) System.out.println("Deleted artist: " + name);

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}