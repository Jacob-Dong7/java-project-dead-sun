package combat;
import core.*;
import core.Character;
import enemy.*;
import items.Weapon;

import java.util.*;
public class Combat {
    private static final Scanner scnr = new Scanner(System.in);

    //character one attacks character two
    public void attack(Character attacker, Character defender, Weapon weapon) {
        int weaponDamage = weapon.getDamage();
        if (attacker.tryAttack() == true) {
            if (defender.getHealth() <= 0) return;
            if (defender.getHealth() - weaponDamage <= 0) {
                defender.setHealth(0);
                return;
            }
            defender.takeDamage(weaponDamage, weapon);
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
            System.out.println("1 (Attack) 2 (Heal) 3 (Switch Weapons) 4 (Check Status)");
            System.out.println("==================================================");
            input = scnr.nextInt();
            if (verifyControl(input) == false ) {
                System.out.println("Choose your next move");
                continue;
            }
                    
            if (input == 1) { //player attack
                //checks if player uses guns
                if (gc.player.getWeapon().isRanged() == true) {
                     if (gc.inventory.getAmmo() <= 0) {
                        System.out.println("You are out of ammo");
                        continue;
                    } 
                }

            //attacks

            //checks if enemy is dead before attack first. false means current is dead
            if (enemyHealth(enemies, map, gc) == false) {
                continue;
            }
            attack(gc.player, enemies.get(0), gc.player.getWeapon());

            } else if (input == 2) { //user heal
                 gc.inventory.heal(gc.player);
                 continue;
            } else if (input == 3) {
                gc.inventory.switchWeapon(gc.player);
                continue;
            } else if (input == 4) {
                gc.player.getStatus(gc);
                continue;
            } else {
                System.out.println("Please select your next move");
                continue;
            }

            if (enemyHealth(enemies, map, gc) == false) {
                continue;
            }

            System.out.println("==================================================");
            System.out.println("Enemy Health: " + enemies.get(0).getHealth());
            System.out.println("Your Health: " + gc.player.getHealth());
            System.out.println("==================================================");
            
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

    //false means current is dead
    public boolean enemyHealth(ArrayList<Character> enemies, Dungeon map, GameContext gc) {
        if (enemies.isEmpty()) return false;
        if (enemies.get(0).getHealth() <= 0) {
            map.removeEnemy(1);
            if (enemies.get(0) instanceof Raiders) {
                ((Raiders) enemies.get(0)).killed(gc.player.getWeapon());
            }
            enemies.remove(0);
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