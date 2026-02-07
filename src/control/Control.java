package control;
import java.util.Scanner;

public class Control {
    private static final Scanner scnr = new Scanner(System.in);
    int input;
    public int enemyPresent() {
        while (true) {
            System.out.println("==================================================");
            System.out.println("1 (Sneak Pass) 2 (Attack) 3 (Talk) 4 (Inventory) 5 (Switch Weapon) 6 (Check Status)");
            System.out.println("==================================================");
            input = scnr.nextInt();
            if (input != 1 && input != 2 && input != 3 && input != 4 && input != 5 && input != -1) {
                System.out.println("Please Select Your Next Move");
                continue;
            } else break;
        }

        return input;
        
    }

    public int noEnemy() {
        while (true) {
            System.out.println("==================================================");
            System.out.println("1 (Move forward) 2 (Loot) 3 (Inventory) 4 (Switch Weapon) 5 (Check Status)");
            System.out.println("==================================================");
            input = scnr.nextInt();
            if (input != 1 && input != 2 && input != 3 && input != 4 && input != -1) {
                System.out.println("Please Select Your Next Move");
                continue;
            } else break;
        }
        return input;
    }
}
