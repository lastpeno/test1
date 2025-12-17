public class Artist {
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void printInfo() {
        System.out.println("Artist: " + name + ", Age: " + age);
    }
}