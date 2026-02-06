package core;

import java.util.ArrayList;
import java.util.Random;

public abstract class Map {
    protected String name;
    protected int numRooms;
    protected boolean completed;
    private Random random = new Random();
    protected ArrayList<Dungeon> map;

    public String getName() {
        return name;
    }

    public int getNumRooms() {
        return numRooms;
    }

    public boolean isCompleted() {
        return completed;
    }

    public int generateEnemy() {
        return random.nextInt(1, 4); //generate 1-3 enemy
    }

    public int generateItem() {
        return random.nextInt(1,3); //generate 1-2 items
    }

    public ArrayList<Dungeon> getMap() {
        return map;
    }

    public void printDescription(int curr) {
        System.out.println("==================================================");
        for (int i = 0; i < map.get(curr).getDescription().length; ++i){ 
            System.out.println(map.get(curr).getDescription()[i]);
        }
        System.out.println("==================================================");
    }

}