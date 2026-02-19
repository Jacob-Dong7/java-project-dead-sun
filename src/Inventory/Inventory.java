package Inventory;
import java.util.ArrayList;

import java.util.Scanner;
import items.*;
import player.Player;

public class Inventory {
    private ArrayList<HealingItem> medPouch;
    private ArrayList<Weapon> weaponSling;
    private Currency wallet;
    private Ammo ammoPouch;

    private static final Scanner scnr = new Scanner(System.in);

    public Inventory() {
        wallet = new Currency(20); //start user off with 20 bucks
        medPouch = new ArrayList<>();
        weaponSling = new ArrayList<>();  
        ammoPouch = new Ammo(2);

        medPouch.add(new HealingItem(Healing.BANDAGE, 2)); //start user off with 2 bandage
        weaponSling.add(Weapon.KNIFE); //starting weapon is knife
        weaponSling.add(Weapon.PISTOL);
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

    public void heal(Player player) {
        int input;
        System.out.println("==================================================");
        if (player.getHealth() == 100) {
            System.out.println("You check your wounds, but there's nothing to treat.");
            System.out.println("==================================================");
            return;
        }

        for (int i = 0; i < medPouch.size(); ++i) {
            System.out.println(i + 1 + " " + medPouch.get(i).getHeal().getName() + " Amount: " + medPouch.get(i).getAmount());
        }

        input = scnr.nextInt() - 1;

        if (input < 0 || input >= medPouch.size()) {
            System.out.println("You fumble through your pack but grab nothing useful.");
            return;
        }


        if (medPouch.get(input).getAmount() <= 0) {
            System.out.println("You have ran out of the healing item you want");
            return;
        }
        int healingFactor = medPouch.get(input).getHeal().getValue();
        player.healBy(healingFactor);
        player.healPrompt(medPouch.get(input).getHeal());
        medPouch.get(input).useItem();
        
        System.out.println("==================================================");
        
    }

    public int getAmmo() {
        return ammoPouch.getAmmo();
    }

    public void useAmmo() {
        ammoPouch.useAmmo();
    }
    public void useMoney(int amount) {
        if (wallet.canAfford(amount) == true) {
            wallet.decrease(amount);
        } else {
            System.out.println("You cannot afford to buy this");
        }
    }

    public int getMoney() {
        return wallet.getAmmount();
    }

    public void findAmmo(int amount) {
        ammoPouch.findAmmo(amount);
    }

    public void findMoney(int amount) {
        wallet.increase(amount);
    }

    public ArrayList<HealingItem> getMedPouch() {
        return medPouch;
    }

    public void viewMedPouch() {
            System.out.println("==================================================");
            System.out.println("1 (Heal) -1 (Return)");
            System.out.println("==================================================");
    }
}

