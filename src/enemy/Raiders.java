package enemy;
import core.Character;
import java.util.Random;
import items.*;

public class Raiders extends Character{
    private Random random = new Random();
    
    public Raiders() {
        name = "Black Torch";
        health = 50;
        damage = 20;
        currWeapon = Weapon.KNIFE;
    }

    @Override
    public void takeDamage(int damageTaken, Weapon weapon) {
        health -= damageTaken;
        prompt(weapon, "damage");
        System.out.println("\nYou dealt " + damageTaken + " DMG.");
        System.out.println("Black Torch Raider HP: " + String.valueOf(health) + " / 50");
        System.out.println("==================================================");
    }

    @Override
    public void killed(Weapon weapon) {
        int randomChance = random.nextInt(1, 4);
        System.out.println("==================================================");
        System.out.println("YOUR TURN");
        System.out.println("==================================================");
        if (weapon == Weapon.CLEAVER || weapon == Weapon.KNIFE)  {
            switch (randomChance) {
                case 1:
                    System.out.println("You drive the " + weapon.getName() + " deep into the raider's chest.");
                    System.out.println("His breath catches - then fades.");
                    System.out.println("The Black Torch collapses at your feet.");
                    break;
                case 2:
                    System.out.println("You step in close and slash across The Black Torch's throat.");
                    System.out.println("Steel whispers. Blood follows.");
                    System.out.println("The raider crumples silently onto the concrete.");
                    break;
                case 3:
                    System.out.println("You plunge the " + weapon.getName() + " upward with brutal force.");
                    System.out.println("His grip loosens as the life drains from his eyes.");
                    System.out.println("The Black Torch falls - unmoving.");
                    break;
            }
        } else if (weapon == Weapon.PISTOL) {
            switch (randomChance) {
                case 1:
                    System.out.println("You fire your pistol. The shot echoes through the tunnel.");
                    System.out.println("The raider stiffens - then drops.");
                    break;
                case 2:
                    System.out.println("A clean trigger pull.");
                    System.out.println("The bullet finds his heart.");
                    System.out.println("He falls backward, motionless.");
                    break;
                case 3:
                    System.out.println("The muzzle flash from your pistol lights the dark.");
                    System.out.println("Smoke curls as the Black Torch collapses instantly.");
                    break;
            }
        } else if (weapon == Weapon.RIFLE || weapon == Weapon.ADVANCERIFLE) {
            switch (randomChance) {
                case 1:
                    System.out.println("You raise the " + weapon.getName() + " and fire.");
                    System.out.println("The Black Torch Raider is hit in the head.");
                    System.out.println("The ammunition smashes through his brain, and the raider collapses.");
                    break;
                case 2:
                    System.out.println("A controlled burst from your rifle tears through the raider.");
                    System.out.println("The raider falls to the floor in brief moment of agony, before dying.");
                    break;
                case 3:
                    System.out.println("You aim your rifle at the raider and pulls the trigger.");
                    System.out.println("The Black Torch drops instantly, lifeless.");
                    break;
            }           
        }

    }

    public void prompt(Weapon weapon, String type) {
        int randomChance = random.nextInt(1, 4);
        System.out.println("==================================================");
        System.out.println("YOUR TURN");
        System.out.println("==================================================");

        if (weapon == Weapon.CLEAVER || weapon == Weapon.KNIFE)  {
            switch (randomChance) {
                case 1:
                    System.out.println("You close the distance in a heartbeat.");
                    System.out.println("Steel flashes - the " + weapon.getName() + " bites deep into the raider's side.");
                    System.out.println("The Black Torch staggers back, clutching the wound as blood stains the concrete.");
                    break;
                case 2:
                    System.out.println("You lunge forward with savage force.");
                    System.out.println("The " + weapon.getName() + " tears across his guard, ripping through cloth and flesh.");
                    System.out.println("He snarls in pain, stumbling but still standing.");
                    break;
                case 3:
                    System.out.println("You step inside his reach.");
                    System.out.println("The " + weapon.getName() + " slams into him at close range - wet impact, sharp gasp.");
                    System.out.println("The raider reels, fury turning to fear.");
                    break;
            }
        } else if (weapon == Weapon.PISTOL) {
            switch (randomChance) {
                case 1:
                    System.out.println("You steady your grip and squeeze the trigger.");
                    System.out.println("The Rusted pistol cracks through the tunnel.");
                    System.out.println("The bullet punches into the raider's chest, sending him stumbling backward.");
                    break;
                case 2:
                    System.out.println("A sharp report echoes off the walls.");
                    System.out.println("Your pistol round finds its mark.");
                    System.out.println("The Black Torch clutches his shoulder, shock flashing in his eyes.");
                    break;
                case 3:
                    System.out.println("You fire once - precise and cold.");
                    System.out.println("The muzzle flash lights the dark for a split second.");
                    System.out.println("The raider drops to a knee, struggling to breathe.");
                    break;
            }
        } else if (weapon == Weapon.RIFLE || weapon == Weapon.ADVANCERIFLE) {
            switch (randomChance) {
                case 1:
                    System.out.println("You raise the " + weapon.getName() + " and fire.");
                    System.out.println("The rifle roars, deafening in the confined space.");
                    System.out.println("The Black Torch is thrown backward by the impact, armor splintering under the round.");
                    break;
                case 2:
                    System.out.println("A controlled burst tears through the darkness.");
                    System.out.println("Rounds slam into the raider before he can react.");
                    System.out.println("He collapses hard, weapon clattering across the floor.");
                    break;
                case 3:
                    System.out.println("You pull the trigger without hesitation.");
                    System.out.println("The rifle's recoil drives into your shoulder as the shot lands clean.");
                    System.out.println("The Black Torch drops instantly, smoke curling from the barrel.");
                    break;
            }           
        }
    }

    @Override
    public boolean tryAttack() {
        int variety = random.nextInt(1, 4);
        int hit = random.nextInt(0, 101); // 0 - 100% 

        if (hit <= 40) {
            switch (variety) {
                case 1:
                    System.out.print("The Black Torch swings his burning torch in a wide arc, embers scattering across the floor. ");
                    break;
                case 2:
                    System.out.print("Flames roar as the raider thrusts the torch forward, heat searing the air around you. ");
                    break;
                case 3:
                    System.out.print("The torch crashes down toward your head, sparks bursting on impact. ");
                    break;
            }
            return true;
        } else {
            System.out.println("The Black Torch swings wildly, missing you entirely.");
            return false;
        }
    }
}
