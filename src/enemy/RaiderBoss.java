package enemy;

import core.Character;
import items.Weapon;
import java.util.Random;

public class RaiderBoss extends Character {
    Random random = new Random();
    public RaiderBoss() {
        this.name = "The Butcher";
        this.health = 150;
        this.damage = 30;
        currWeapon = Weapon.CLEAVER;
    }
    @Override
    public void takeDamage(int damageTaken, Weapon weapon) {
        health -= damageTaken;
        prompt(weapon, "damage");
        System.out.println("\nYou dealt " + damageTaken + " damage.");
        System.out.println("The Butcher's HP: " + String.valueOf(health) + " / 150");
        System.out.println("==================================================");
    }

    @Override
    public void killed(Weapon weapon) {
        System.out.println("==================================================");
        if (weapon == Weapon.CLEAVER || weapon == Weapon.KNIFE)  {
            System.out.println("Your blade finds the gap in his armor.");
            System.out.println("It sinks deep.");
            System.out.println("");
            System.out.println("The Butcher exhales slowly.");
            System.out.println("A sound like something finally ending.");
            System.out.println("");
            System.out.println("His body folds forward.");
            System.out.println("The Butcher is dead.");
        } else if (weapon == Weapon.PISTOL) {
            System.out.println("The muzzle flash burns bright.");
            System.out.println("The bullet punches clean through The Butcher's skull.");
            System.out.println("");
            System.out.println("The beast of a man slumps lifelessly onto the floor.");
            System.out.println("");
            System.out.println("Silence returns.");
            System.out.println("The Butcher is dead.");
        } else if (weapon == Weapon.RIFLE || weapon == Weapon.ADVANCERIFLE) {
            System.out.println("Your rifle bucks against your shoulder.");
            System.out.println("The impact shatters what remained of him.");
            System.out.println("");
            System.out.println("Armor, flesh, and bone fail together.");
            System.out.println("");
            System.out.println("Blood splatters as The Butcher falls violently onto the floor.");
            System.out.println("The Butcher is dead.");
        }
        System.out.println("==================================================");
    }

    public void prompt(Weapon weapon, String type) {
        int randomChance = random.nextInt(1, 4);
        System.out.println("==================================================");
        if (weapon == Weapon.CLEAVER || weapon == Weapon.KNIFE)  {
            switch (randomChance) {
                case 1:
                    System.out.println("You close the distance in a heartbeat.");
                    System.out.println("Your " + weapon.getName() + " bites into welded flesh.");
                    System.out.println("The Butcher barely reacts.");
                    break;
                case 2:
                    System.out.println("You slash across his torso.");
                    System.out.println("The " + weapon.getName() + " scrapes the metal armor.");
                    break;
                case 3:
                    System.out.println("You drive the " + weapon.getName() + " into his side.");
                    System.out.println("Blood runs down beneath rusted armor.");
                    System.out.println("The Butcher does not fall.");
                    break;
            }
        } else if (weapon == Weapon.PISTOL) {
            switch (randomChance) {
                case 1:
                    System.out.println("You fire the pistol");
                    System.out.println("The shot hits him in the armor, he staggers backward but does not fall");
                    break;
                case 2:
                    System.out.println("You aim and squeze the trigger.");
                    System.out.println("The pistol cracks loudly.");
                    System.out.println("The Butcher is hit but remains standing");
                    break;
                case 3:
                    System.out.println("You fire with precise control.");
                    System.out.println("The bullet strikes true.");
                    System.out.println("Staggering him...");
                    break;
            }
        } else if (weapon == Weapon.RIFLE || weapon == Weapon.ADVANCERIFLE) {
            switch (randomChance) {
                case 1:
                    System.out.println("You raise the " + weapon.getName() + " and fire.");
                    System.out.println("The round slams into The Butcher's armor.");
                    System.out.println("Yet, he remains standing...");
                    break;
                case 2:
                    System.out.println("A burst tears into him.");
                    System.out.println("The impact drives him backward");
                    break;
                case 3:
                    System.out.println("Your rifle roars");
                    System.out.println("The Butcher absorbs the hit");
                    break;
            }           
        }
    }

    @Override
    public boolean tryAttack() {
        int variety = random.nextInt(1, 4);
        int hit = random.nextInt(0, 101); // 0 - 100% 

        if (hit <= 60) {
            switch (variety) {
                case 1:
                    System.out.println("The Butcher steps forward and swings his knife");
                    System.out.println("The blade cuts throuugh your flesh");
                    break;
                case 2:
                    System.out.println("The Butcher lunges at you");
                    System.out.println("His knife drives into your flesh");
                    break;
                case 3:
                    System.out.println("The Butcher raises his blade high above his head.");
                    System.out.println("He brings it down in a crushing strike.");
                    break;
            }
            return true;
        } else {
            System.out.println("The Butcher swings at you, missing you by an inche.");
            return false;
        }
    }
}