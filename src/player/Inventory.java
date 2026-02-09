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

        weapons.add(Weapon.KNIFE);
    }

    public void switchWeapon() {
        System.out.println("==================================================");
        System.out.println("Weapons:");
        for (Weapon weapon : weapons) {
            System.out.println("Weapon: " + weapon.getName() + " - Damage: " + weapon.getDamage());
        }
        System.out.println("==================================================");
    }

    public void checkHeal(Player player) {
        boolean found = false;
        if (player.getHealth() == 100) {
            System.out.println("You check your wounds, but there’s nothing to treat.");
            return;
        }

        for (Item item : inventory) {
            if (item.getName().equals("bandage")) {
                if (item.getAmount() > 0) {
                    found = true;
                    heal(player);
                    item.consume();
                }
            } 
        }

        if (found == false) {
            System.out.println("You search your pack in panic, but find only blood-stained rags and nothing to use.");
            return;
        }
    }

    //30 healing 80 110 - 100
    public void heal(Player player) {
        int health = player.getHealth();
        if (health + 20 > 100) {

            player.healBy(30 - ((health + 20) - 100));
        } else {
            player.healBy(20);
        }
        System.out.println("You bind the wound tightly, the bleeding slowing as the pain fades to a dull ache.")
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

}

