package player;
import java.util.Scanner;

public class Stats {

    private static final Scanner scnr = new Scanner(System.in);
    int strength, charisma, stealth, points, input;

    public Stats() {
        strength = 0;
        stealth = 0;
        charisma = 0;
        points = 5;
    }

    public void statAssign() {
        System.out.println("==================================================");
        System.out.println("Assign You Stats:");
        
        //while loop created for stat creation
        while (points > 0) {
        
        //tells user how many points remain
        if (points > 1) {
            System.out.println(
                points +
                " skill points remaining"
            );
        } else if (points == 1) {
            System.out.println("1 skill point remaining");
        }

        System.out.println(
            "===============================\n" +
            "Current Stats:\n" +
            "Strength: " + strength + "\n" +
            "Charisma: " + charisma + "\n" + 
            "Stealth: " + stealth +
            "\n==============================="
        );

        System.out.println("==================================================");
        System.out.println("1 (Strength) 2 (Charisma) 3 (Stealth) 4 (Reset)");
        System.out.println("==================================================");

        input = scnr.nextInt();

        //user skill selection input
        if (input == 1) {
            ++strength;
            --points;
        } else if (input == 2) {
            ++charisma;
            --points;
        } else if (input == 3) {
            ++stealth;
            --points;
        } else if (input == 4) {
            System.out.println("Your Stats Have Been Reset");
            strength = 0;
            stealth = 0; 
            charisma = 0;
            points = 5;

        } else if (input == -1) {
            System.out.println("Quitting...");
            System.exit(0);
        } else {
            System.out.println("Please Select From The Options Displayed");
            continue;
        }

        }
    }
}