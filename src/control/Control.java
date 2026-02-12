package control;
import java.util.Scanner;
import core.*;
public class Control {
    private static final Scanner scnr = new Scanner(System.in);
    int userInput;
    public void enemyPresent(GameContext gc, Dungeon map) {
        while (true) {
            System.out.println("==================================================");
            System.out.println("1 (Sneak Pass) 2 (Attack) 3 (Talk) 4 (Inventory) 5 (Switch Weapon) 6 (Check Status)");
            System.out.println("==================================================");
            userInput = scnr.nextInt();
            if (userInput == 1) {
                if (gc.stealth.sneakAttempt(gc.stats) == true) {
                    System.out.println("==================================================");
                    System.out.println("You successfully sneaked pass");
                    System.out.println("==================================================");
                    break;
                } else {
                    System.out.println("==================================================");
                    System.out.println("You attempted to sneak pass, but was caught");
                    System.out.println("==================================================");
                    gc.combat.runEncounter(gc, map);
            }
        } else if (userInput == 2) {
            gc.combat.runEncounter(gc, map);
        } else if (userInput == 3) {
            if (gc.speech.attemptSpeech(gc.stats, 1, map.enemyCount()) == true) {
                break;
            } else {
                gc.combat.runEncounter(gc, map);                       
            }
            //view inventory
        } else if (userInput == 4) { 
            int open;
            System.out.println("==================================================");
            System.out.println("1 (Medicine Pouch) 2 (Wallet) 3 (Ammo Pouch) -1 (Return)");
            System.out.println("==================================================");
            open = scnr.nextInt();
            if (open == 1) {
                gc.inventory.viewMedPouch();
                open = scnr.nextInt();
            if (open == -1) continue;
                gc.inventory.heal(gc.player);
            } else if (open == 2) {
                System.out.println("==================================================");
                System.out.println("$" + String.valueOf(gc.inventory.getMoney()));
                System.out.println("==================================================");
            } else if (open == 3) {
                System.out.println("==================================================");
                System.out.println("Amount: " + String.valueOf(gc.inventory.getAmmo()));
                System.out.println("==================================================");
            } else {
                continue;
            }
        } else if (userInput == 5) { //switch weapon
            gc.inventory.switchWeapon(gc.player);
        } else if (userInput == 6) { //get status
            gc.player.getStatus(gc);
        } else if (userInput == -1) { //exit
            System.exit(0);
        } else {
            System.out.println("Please select your next move");
            continue;
        }
        
    }
    }

    public void noEnemy(GameContext gc, Dungeon map) {
        while (true) {
            System.out.println("==================================================");
            System.out.println("1 (Move forward) 2 (Loot) 3 (Inventory) 4 (Switch Weapon) 5 (Check Status)");
            System.out.println("==================================================");
            userInput = scnr.nextInt();

            if (userInput == 1) {
                break;
            } else if (userInput == 2) {
                System.out.println("Loot");
                continue;
            } else if (userInput == 3) {
                int open;
                System.out.println("==================================================");
                System.out.println("1 (Medicine Pouch) 2 (Wallet) 3 (Ammo Pouch) -1 (Return)");
                System.out.println("==================================================");
                open = scnr.nextInt();
                if (open == 1) {
                    gc.inventory.viewMedPouch();
                    open = scnr.nextInt();
                    if (open == -1) continue;
                    gc.inventory.heal(gc.player);
                } else if (open == 2) {
                    System.out.println("==================================================");
                    System.out.println("$" + String.valueOf(gc.inventory.getMoney()));
                    System.out.println("==================================================");
                } else if (open == 3) {
                    System.out.println("==================================================");
                    System.out.println("Amount: " + String.valueOf(gc.inventory.getAmmo()));
                    System.out.println("==================================================");
                } else {
                    continue;
                }      
            } else if (userInput == 4) {
                gc.inventory.switchWeapon(gc.player);
            } else if (userInput == 5) {
                gc.player.getStatus(gc);
            } else if (userInput == -1) {
                System.exit(0);
            } else {
                continue;
            }
        }

    }
    
}
