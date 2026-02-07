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
        inventory.add(new Item("ammo", 3));

        weapons.add(new Weapon("pistol", 50));
        weapons.add(new Weapon("knife", 20));

    }

    public void switchWeapon() {

    }

    public void checkHeal(Player player) {
        for (Item item : inventory) {
            if (item.getName().equals("bandage")) {
                if (item.getAmount() > 0) {
                    heal(player);
                }
            } 
        }

        System.out.println("You are out of bandages")
    }

    public void heal(Player player) {

    }

    public int getAmmo() {

        for (Item item : inventory) {
            if (item.getName().equals("ammo")) {
                int amount = item.getAmount();
                return amount;
            }
        }

        return 0;
    }


    

    public void useItem() {
        while (true) {
            
        }
    }
}