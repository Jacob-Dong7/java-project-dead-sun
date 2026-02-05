package player;
import java.util.ArrayList;

import items.Item;
import items.Weapon;
public class Inventory {
    private ArrayList<Item> inventory;
    private ArrayList<Weapon> weapons;

    public Inventory() {
        inventory = new ArrayList<>();
        weapons = new ArrayList<>();
        
        inventory.add(new Item("bandage", 3));
        inventory.add(new Item("9mm", 3));

        weapons.add(new Weapon("Homemade Pistol", 50));
        weapons.add(new Weapon("Knife", 20));

    }
}