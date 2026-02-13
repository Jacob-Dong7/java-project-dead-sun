package gameplay;

import java.util.*;

import core.GameContext;
import items.Healing;
import items.HealingItem;
public class Looting {
    protected int ammo, heal, money, scraps, enemyCount;
    private final Random random = new Random();

    public Looting() {
        this.ammo = 0;
        this.heal = 0;
        this.money = 0;
        this.scraps = 0;
        this.enemyCount = 0;
    }

    public void generate(int enemyCount) {
        this.enemyCount = enemyCount;

        for (int i = 0; i < enemyCount; ++i) {
            this.ammo += random.nextInt(0, 3);
            this.heal += random.nextInt(0, 2);
            this.money += random.nextInt(0, 100);
        }

        this.scraps = random.nextInt(0, 4);
    }

    public boolean findLoot() {
        if (this.ammo == 0 && this.heal == 0 && this.money == 0 && this.scraps == 0) {
            return false;
        } 
        return true;
    }

    public void loot(ArrayList<HealingItem> getMedPouch) {
        System.out.println("==================================================");
        if (findLoot() == true) {
            if (enemyCount > 1) {
                System.out.println("You search the area around you and through the bodies and found: ");
                if (this.ammo > 0) System.out.println("Ammunition: " + ammo);
                if (this.money > 0) System.out.println("Money: $" + money);
                if (this.scraps > 0) System.out.println("Scraps: " + scraps);

                if (this.heal > 0) {
                    System.out.println("Medicine: " + heal + ":");
                    generateMeds(getMedPouch);
                }
            }
        } else {
            System.out.println("You search but found nothing");
        }
        System.out.println("==================================================");
    
    }

    public void generateMeds(ArrayList<HealingItem> medPouch) {
        System.out.println("==================================================");
        for (int i = 0; i < heal; ++i) {
            int chance = random.nextInt(1, 4);
            switch (chance) {
                case 1:
                    for (HealingItem med : medPouch) {
                        if (med.getHeal() == Healing.BANDAGE) {
                            med.findItem();
                            System.out.println("You find a Bandage");
                        } else {
                            medPouch.add(new HealingItem(Healing.BANDAGE, 1));
                        }
                    }

                break;

                case 2:
                    for (HealingItem med : medPouch) {
                        if (med.getHeal() == Healing.MEDKIT) {
                            med.findItem();
                            System.out.println("You find a Medkit");
                        } else {
                            medPouch.add(new HealingItem(Healing.MEDKIT, 1));
                        }
                    } 
                    break;
                case 3:
                    for (HealingItem med : medPouch) {
                        if (med.getHeal() == Healing.SYRINGE) {
                            med.findItem();
                            System.out.println("You find a Syringe");
                        } else {
                            medPouch.add(new HealingItem(Healing.SYRINGE, 1));
                        }
                    }    
                        break;          
                }
    
            }
        System.out.println("==================================================");
        }

    public void add(GameContext gc) {
        gc.inventory.findMoney(money);
        gc.inventory.findAmmo(ammo);
        
    }

    public void clear() {
        this.ammo = 0;
        this.heal = 0;
        this.money = 0;
        this.scraps = 0;
        this.enemyCount = 0;
    }


    
}
