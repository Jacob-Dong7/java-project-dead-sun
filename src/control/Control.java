package control;
import java.util.Scanner;
import core.*;
public class Control {
    private static final Scanner scnr = new Scanner(System.in);
    int userInput;
    int maxEnemyCount;

    public void bossPresent(GameContext gc, Dungeon map) {
        this.maxEnemyCount = 1;
        while (true) {
            System.out.println("Action:");
            System.out.println("1. Attack");;
            System.out.println("\nManagement:");
            System.out.println("2. Inventory");
            System.out.println("3. Switch Weapon") ;
            System.out.println("4. Check Status");
            System.out.println("==================================================");
            userInput = scnr.nextInt();
            if (userInput == 1) {
                gc.combat.runEncounter(gc, map);
                break;
            } else if (userInput == 2) { 
                int open;
                System.out.println("==================================================");
                System.out.println("Inventory:");
                System.out.println("1. Medicine Pouch");
                System.out.println("2. Wallet");
                System.out.println("3. Ammo Pouch");
                System.out.println("");
                System.out.println("-1. Return");
                System.out.println("==================================================");
                open = scnr.nextInt();
                if (open == 1) {
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
            } else if (userInput == 3) { //switch weapon
                gc.inventory.switchWeapon(gc.player);
            } else if (userInput == 4) { //get status
                gc.player.getStatus(gc);
            } else if (userInput == -1) { //exit
                System.exit(0);
            } else {
                System.out.println("Choose your next action");
                continue;
            }
        
    }
    }
    
    public void enemyPresent(GameContext gc, Dungeon map) {
        this.maxEnemyCount = map.enemyCount();
        while (true) {
            System.out.println("Actions:");
            System.out.println("1. Attack");
            System.out.println("2. Sneak Pass");
            System.out.println("3. Talk");
            System.out.println("\nManagement:");
            System.out.println("4. Inventory");
            System.out.println("5. Switch Weapon") ;
            System.out.println("6. Check Status");
            System.out.println("==================================================");
            userInput = scnr.nextInt();
            if (userInput == 2) {
                if (gc.stealth.sneakAttempt(gc.stats) == true) {
                    System.out.println("==================================================");
                    System.out.println("You slip past undetected.");
                    System.out.println("==================================================");
                    break;
                } else {
                    System.out.println("==================================================");
                    System.out.println("You attempted to sneak past, but were caught.");
                    System.out.println("==================================================");
                    gc.combat.runEncounter(gc, map);
                    break;
            }
        } else if (userInput == 1) {
            gc.combat.runEncounter(gc, map);
            break;
        } else if (userInput == 3) {
            if (gc.speech.attemptSpeech(gc.stats, map.getEnemyType(), map.enemyCount()) == false) {
                gc.combat.runEncounter(gc, map);  
                break;
            } else {
                map.removeEnemy(map.enemyCount());
               this. maxEnemyCount = -1;
                break;
            }
            //view inventory
        } else if (userInput == 4) { 
            int open;
            System.out.println("==================================================");
            System.out.println("Inventory:");
            System.out.println("1. Medicine Pouch");
            System.out.println("2. Wallet");
            System.out.println("3. Ammo Pouch");
            System.out.println("");
            System.out.println("-1. Return");
            System.out.println("==================================================");
            open = scnr.nextInt();
            if (open == 1) {
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
            System.out.println("Choose your next action");
            continue;
        }
        
    }
    }

    public void noEnemy(GameContext gc, Dungeon map) {
        while (true) {
            System.out.println("Actions:");
            System.out.println("1. Move forward");
            System.out.println("2. Loot");
            System.out.println("\nManagement:");
            System.out.println("3. Inventory");
            System.out.println("4. Switch Weapon") ;
            System.out.println("5. Check Status");
            System.out.println("==================================================");
            userInput = scnr.nextInt();

            if (userInput == 1) {
                break;
            } else if (userInput == 2) {
                if (maxEnemyCount == -1) {
                    System.out.println("I should get going...");
                } else if (map.isLooted() == false) {
                    gc.looting.loot(gc.inventory.getMedPouch(), gc, maxEnemyCount);
                    map.loot();
                } else {
                    System.out.println("You have already looted everything you can");
                }
                continue;
            } else if (userInput == 3) {
                int open;
                System.out.println("==================================================");
                System.out.println("Inventory:");
                System.out.println("1. Medicine Pouch");
                System.out.println("2. Wallet");
                System.out.println("3. Ammo Pouch");
                System.out.println("");
                System.out.println("-1. Return");
                System.out.println("==================================================");
                open = scnr.nextInt();
                if (open == 1) {
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
