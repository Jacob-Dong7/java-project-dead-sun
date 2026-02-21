package gameplay;
import core.*;
import core.Character;
import enemy.*;
import items.Weapon;
import player.Player;

import java.util.*;
public class Combat {
    private static final Scanner scnr = new Scanner(System.in);

    //character one attacks character two
    public void attack(Character attacker, Character defender, Weapon weapon, GameContext gc) {
        int weaponDamage = weapon.getDamage();
        if (attacker instanceof Player) {
            weaponDamage += gc.stats.getStrength();
        }
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
        if (map.bossPresent()) {
            if (map.getBossType().equals("raider boss")) {
                RaiderBoss boss = new RaiderBoss();
                fightBoss(gc, boss, map);
            }
            return;
        }

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
        int enemyCount = 1;
        while (!enemies.isEmpty()) {
            enemies.removeIf(e -> e.getHealth() <= 0);
            System.out.println("==================================================");
            System.out.println("COMBAT STATUS");
            System.out.println("==================================================");
            System.out.println("Hostile Count: " + map.enemyCount() + "\n");
            System.out.println("Target HP: " + enemies.get(0).getHealth());
            System.out.println("\nYour Health: " + gc.player.getHealth());

            System.out.println("--------------------------------------------------");
            System.out.println("ACTIONS");
            System.out.println("--------------------------------------------------");
            System.out.println("Combat:");
            System.out.println("1. Attack");
            System.out.println("\nManagement:");
            System.out.println("2. Heal");
            System.out.println("3. Switch Weapon");
            System.out.println("4. Check Status");
            System.out.println("==================================================");
            input = scnr.nextInt();

            if (verifyControl(input) == false ) {
                System.out.println("Choose your next action");
                continue;
            }
                    
            if (input == 1) { //player attack
                if (enemies.get(0).getHealth() <= 0) continue;
                //checks if player uses guns
                if (gc.player.getWeapon().isRanged() == true) {
                     if (gc.inventory.getAmmo() <= 0) {
                        System.out.println("You are out of ammo");
                        continue;
                    } 
                    gc.inventory.useAmmo();
                }

            //checks if enemy is dead before attack first. false means current is dead
            if (enemyHealth(enemies, map, gc) == false) {
                continue;
            }

            attack(gc.player, enemies.get(0), gc.player.getWeapon(), gc);
            
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
                System.out.println("Choose your next action");
                continue;
            }

            if (enemyHealth(enemies, map, gc) == false) {
                continue;
            }
            
            //enemy attack backs depending on how many there are
            if (enemies.isEmpty()) break;

            System.out.println("==================================================");
            System.out.println("ENEMY TURN");
            System.out.println("==================================================");
            for (Character enemy : enemies) {
                System.out.print("[" + enemyCount + "] ");
                attack(enemy, gc.player, enemy.getWeapon(), gc);
                ++enemyCount;
            }
            System.out.println("Your HP: " + gc.player.getHealth() + " / 100");
            enemyCount = 0;
        }
        if (gc.player.getHealth() <= 0) {
            gc.player.killed();
        }
    }

    public void fightBoss(GameContext gc, Character boss, Dungeon map) {
        int input;
        while (true) {

            System.out.println("==================================================");
            System.out.println(boss.getName() + "'s' HP: " + boss.getHealth());
            System.out.println("Your Health: " + gc.player.getHealth());
            System.out.println("Combat:");
            System.out.println("1. Attack");;
            System.out.println("\nManagement:");
            System.out.println("2. Heal");
            System.out.println("3. Switch Weapon");
            System.out.println("4. Check Status");
            System.out.println("==================================================");
            input = scnr.nextInt();
            if (verifyControl(input) == false ) {
                System.out.println("Choose your next move");
                continue;
            }
                    
            if (input == 1) { //player attack
                if (boss.getHealth() <= 0) {
                    boss.killed(gc.player.getWeapon());
                    map.removeBoss();
                    return;
                }
                //checks if player uses guns
                if (gc.player.getWeapon().isRanged() == true) {
                     if (gc.inventory.getAmmo() <= 0) {
                        System.out.println("You are out of ammo");
                        continue;
                    } 
                    gc.inventory.useAmmo();
                }

            //checks if enemy is dead before attack first. false means current is dead
            if (boss.getHealth() <= 0) {
                boss.killed(gc.player.getWeapon());
                map.removeBoss();
                 return;
            }

            attack(gc.player, boss, gc.player.getWeapon(), gc);
            
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
                System.out.println("Choose your next move");
                continue;
            }

            if (boss.getHealth() <= 0) {
                boss.killed(gc.player.getWeapon());
                map.removeBoss();
                return;
            }

            attack(boss, gc.player, boss.getWeapon(), gc);

            if (gc.player.getHealth() <= 0) {
                gc.player.killed();
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
            System.out.println("(Enemy Killed)");
            System.out.println("==================================================");
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