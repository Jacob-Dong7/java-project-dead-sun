package enemy;
import core.Character;
import java.util.Random;

public class Raiders extends Character{
    private Random random = new Random();
    
    public Raiders() {
        name = "Black Torch";
        health = 50;
        damage = 20;
        currWeapon = "knife";
    }

    public void killed() {

    }

    public void attack() {
        int variety = random.nextInt(1, 3);
        int hit = random.nextInt(1, 100);

        if (hit <= 40) {
            switch (variety) {
                case 1:
                    System.out.println("The Black Torch swings his burning torch in a wide arc, embers scattering across the floor.\n");
                case 2:
                    System.out.println("Flames roar as the raider thrusts the torch forward, heat searing the air around you.\n");
                case 3:
                    System.out.println("The torch crashes down toward your head, sparks bursting on impact.\n");
                default:
                    System.out.println("");
            }
        } else {
            System.out.println("The Black Torch overextends, the torch whistling past you and missing entirely.");
        }
    }
}
