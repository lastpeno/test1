public abstract class Entity implements Comparable<Entity> {
    public abstract String toString();
    public abstract boolean equals(Object obj);
    public abstract int hashCode();

    public abstract int compareTo(Entity other);
}