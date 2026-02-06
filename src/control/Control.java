package control;
import java.util.Scanner;

public class Control {
    private static final Scanner scnr = new Scanner(System.in);
    public int enemyPresent() {
        int input;
        while (true) {
            System.out.println("==================================================");
            System.out.println("1 (Sneak Pass) 2 (Attack) 3 (Talk) 4 (Inventory) 5 (Check Status)");
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
        int input;
        while (true) {
            System.out.println("==================================================");
            System.out.println("1 (Move forward) 2 (Loot) 3 (Check Status) 4 (Inventory)");
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
