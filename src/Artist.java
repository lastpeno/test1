public class Artist extends Entity {
    private String name;
    private int age;

    public Artist() {
        this.name = "Unknown";
        this.age = 0;
    }

    public Artist(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public int getAge() { return age; }
    public void setAge(int age) { this.age = age; }

    @Override
    public String toString() {
        return "Artist: " + name + ", Age: " + age;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Artist artist = (Artist) obj;
        return age == artist.age && name.equals(artist.name);
    }

    @Override
    public int hashCode() {
        return name.hashCode() + age;
    }

    @Override
    public int compareTo(Entity other) {
        if (other instanceof Artist) {
            return Integer.compare(this.age, ((Artist) other).age);
        }
        return 0;
    }
}