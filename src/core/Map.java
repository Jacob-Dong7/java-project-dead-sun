package core;
public abstract class Map {
    protected String name;
    protected int numRooms;
    protected boolean completed;

    public String getName() {
        return name;
    }

    public int getNumRooms() {
        return numRooms;
    }

    public boolean isCompleted() {
        return completed;
    }

}