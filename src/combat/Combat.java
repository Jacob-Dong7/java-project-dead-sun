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
        defender.takeDamage(attacker.getDamage());
    }


    public void fighting(GameContext gc, Character enemy, Dungeon map) {
        int input;
            for (int i = 0; i < map.enemyCount(); ++i) {
                while (true) {


                    System.out.println("==================================================");
                    System.out.println("1 (Attack) 2 (Heal) 3 (Inventory) 4 (Switch Weapons) 5 (Check Status)");
                    System.out.println("==================================================");
                    input = scnr.nextInt();
                    if (verifyControl(input) == false ) {
                        System.out.println("Choose your next move");
                        continue;
                    }
                    
                    if (input == 1) {
                       if (gc.player.getWeapon() == "Pistol" || gc.player.getWeapon() == "Rifle") {
                        if (gc.inventory.getAmmo() <= 0) {
                            System.out.println("You are out of ammo");
                            continue;
                        } 
                       }

                       attack(gc.player, enemy, gc.player.getWeapon());
                    } else if (input == 2) {
                        gc.inventory.heal(gc.player);
                    }

                    if (enemy.getHealth() <= 0) {
                        map.removeEnemy(1);
                        if (enemy instanceof Raiders) {
                            ((Raiders) enemy).killed();
                        }

                        break;
                    }


                }
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