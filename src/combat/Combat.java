package combat;
import core.*;
import core.Character;
import control.Control;
import enemy.*;

import java.util.*;
public class Combat {
    private static final Scanner scnr = new Scanner(System.in);

    //character one attacks character two
    public void attack(Character attacker, Character defender, String weapon) {
        int buffs;
        buffs = weaponModifier(weapon) + skillsModifer();
        defender.takeDamage(attacker.getDamage());
    }

    public int weaponModifier(String weapon) {
        if (weapon.equals("knife")) {
            
        }

    }


    //runs the encounter
    //packs the enemies into an arraylist

    public void runEncounter(GameContext gc, Dungeon map) {
        ArrayList<Character> enemies = new ArrayList<>();
        for (int i = 0; i < map.enemyCount(); ++i) {
            if (map.getEnemyType().equals("raider")) {
                Raiders raider = new Raiders();
                enemies.add(raider);
            }
        }

        fightEnemy(gc, enemies, map);

    }

    public void fightEnemy(GameContext gc, ArrayList<Character> enemies, Dungeon map) {
        int input;
        while (!enemies.isEmpty()) {
            System.out.println("==================================================");
            System.out.println("1 (Attack) 2 (Heal) 3 (Inventory) 4 (Switch Weapons) 5 (Check Status)");
            System.out.println("==================================================");
            input = scnr.nextInt();
            if (verifyControl(input) == false ) {
                System.out.println("Choose your next move");
                continue;
            }
                    
            if (input == 1) { //player attack
                //checks if player uses guns
                if (gc.player.getWeapon() == "pistol" || gc.player.getWeapon() == "rifle") {
                     if (gc.inventory.getAmmo() <= 0) {
                        System.out.println("You are out of ammo");
                        continue;
                    } 
                }

            //attacks
            attack(gc.player, enemies.get(0), gc.player.getWeapon());

            } else if (input == 2) { //user heal
                 gc.inventory.heal(gc.player);
            }


            if (enemies.get(0).getHealth() <= 0) {
                map.removeEnemy(1);
                enemies.remove(0);
    
                if (enemies.get(0) instanceof Raiders) {
                    ((Raiders) enemies.get(0)).killed();
                }
            }
            
            //enemy attack backs depending on how many there are
            if (enemies.isEmpty()) break;

            for (Character enemy : enemies) {
                attack(enemy, gc.player, enemy.getWeapon());
            }
        }
}
    
    public boolean playerStatus(GameContext gc) {
        if (gc.player.getHealth() <= 0) {
            return false;
        } else {
            return true;
        }
    }



    public boolean verifyControl(int userInput) {
        if (userInput != 1 && userInput != 2 && userInput != 3 && userInput != 4 && userInput != 5 && userInput != -1) {
            return false;
        } else {
            return true;
        }
    }

    
}