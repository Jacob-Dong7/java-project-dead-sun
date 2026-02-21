package gameplay;

import java.util.*;

import core.GameContext;
import items.Healing;
import items.HealingItem;
public class Looting {
    protected int ammo, heal, money, enemyCount;
    private final Random random = new Random();

    public Looting() {
        this.ammo = 0;
        this.heal = 0;
        this.money = 0;
        this.enemyCount = 0;
    }

    public void generate(int enemyCount) {
        this.enemyCount = enemyCount;

        for (int i = 0; i < enemyCount; ++i) {
            this.ammo += random.nextInt(0, 3);
            this.heal += random.nextInt(0, 2);
            this.money += random.nextInt(0, 100);
        }
    }

    public boolean findLoot() {
        if (this.ammo == 0 && this.heal == 0 && this.money == 0) {
            return false;
        } 
        return true;
    }

    public void loot(ArrayList<HealingItem> getMedPouch, GameContext gc, int enemy) {
        generate(enemy);
        System.out.println(enemy);
        System.out.println("==================================================");
        if (findLoot() == true) {
                System.out.println("You search the area and the bodies, collecting anything of value.");
                if (this.ammo > 0) {
                    System.out.println("Ammunition recovered: " + ammo) ;
                    gc.inventory.findAmmo(ammo);
                }
                if (this.money > 0) {
                    System.out.println("Money recovered: $" + money);
                    gc.inventory.findMoney(money);
                }

                if (this.heal > 0) {
                    System.out.println("Medical supplies recovered: " + heal);
                    System.out.println("Contents:");
                    generateMeds(getMedPouch);
                }
        } else {
            System.out.println("You search the area but find nothing worth taking.");
        }
        System.out.println("==================================================");
    clear();
    return;
    }

    public void generateMeds(ArrayList<HealingItem> medPouch) {
        for (int i = 0; i < heal; ++i) {
            boolean found = false; 
            int chance = random.nextInt(1, 4); // 1-3
            switch (chance) {
                case 1:
                    for (HealingItem med : medPouch) {
                        if (med.getHeal() == Healing.BANDAGE) {
                            med.findItem();
                            System.out.println("You find a Bandage");
                            found = true;
                            break;
                        }
                    }

                    if (found == false) {
                        medPouch.add(new HealingItem(Healing.BANDAGE, 1));
                    }

                break;

                case 2:
                    for (HealingItem med : medPouch) {
                        if (med.getHeal() == Healing.MEDKIT) {
                            med.findItem();
                            System.out.println("You find a Medkit");
                            found = true;
                            break;
                        }
                    } 
                    if (found == false) {
                        System.out.println("You find a Medkit");
                        System.out.println("(New item added to Medical Pouch)");
                        medPouch.add(new HealingItem(Healing.MEDKIT, 1));
                    }

                    break;

                case 3:
                    for (HealingItem med : medPouch) {
                        if (med.getHeal() == Healing.SYRINGE) {
                            med.findItem();
                            System.out.println("You find a Syringe");
                            found = true;
                            break;
                        }
                    }    
                    if (found == false) {
                        System.out.println("You find a Syringe");
                        System.out.println("(New item added to Medical Pouch)");
                        medPouch.add(new HealingItem(Healing.SYRINGE, 1));
                    }
                    break;          
                }
    
            }
        }

    public void clear() {
        this.ammo = 0;
        this.heal = 0;
        this.money = 0;
        this.enemyCount = 0;
    }


    
}
