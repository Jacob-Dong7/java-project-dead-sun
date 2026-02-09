package Inventory;
import java.util.ArrayList;

import java.util.Scanner;
import items.*;
import player.Player;

public class Inventory {
    private ArrayList<HealingItem> medPouch;
    private ArrayList<Weapon> weaponSling;
    private Currency wallet;

    private static final Scanner scnr = new Scanner(System.in);
    public Inventory() {
        wallet = new Currency(20); //start user off with 20 bucks
        medPouch = new ArrayList<>();
        weaponSling = new ArrayList<>();  

        medPouch.add(new HealingItem(Healing.BANDAGE, 2)); //start user off with 2 bandage
        weaponSling.add(Weapon.KNIFE); //starting weapon is knife
    }

    public void switchWeapon(Player player) {
        int input;
        System.out.println("==================================================");
        System.out.println("Weapons:");
        for (int i = 0; i < weaponSling.size(); ++i) {
            System.out.print(i + 1);
            System.out.println(" (" + weaponSling.get(i).getName() + " Damage: " + weaponSling.get(i).getDamage() + ")");
        }

        System.out.println("==================================================");

        //changing weapon
        input = scnr.nextInt() - 1;

        player.switchWeapon(weaponSling.get(input));

        
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

