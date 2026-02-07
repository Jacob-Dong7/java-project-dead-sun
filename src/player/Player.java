package player;
import java.util.*;

import core.Character;

public class Player extends Character {
    private final Scanner scnr = new Scanner(System.in);
    private int input;

    public void killed() {
        System.out.println(
            "==================================================\n" +
            "You collapse, strength leaving your body.\n" +
            "\n" +
            "Breath slows.\n" + 
            "Thoughts scatter.\n" +
            "\n" +
            "The world grows distant and quiet.\n" +
            "\n" + 
            name + " is gone.\n" +
            "The ash endures.\n" +
            "GAME OVER\n" +
             "==================================================" 
        );
        System.exit(0);
    }

    public void create(Stats playerStat) {
        System.out.println("==================================================");
        System.out.println("Character Creation");
        System.out.println("Please enter your name: ");

        //default health weapon and its damage 
        health = 100;
        currWeapon = "Knife";
        damage = 20;


        //name creation and validation
        while (true) {
            name = scnr.nextLine().trim();

            if (name.isBlank()) {
                System.out.println("Warning: No names detected. Please try again:");
                continue;
            } else if (name.length() > 20) {
                System.out.println("Warning: Your name is too long. Please ensure your name is less than 20 characters long");
                System.out.println("Please try again:");
                continue;
            } else if (name == "-1") {
                System.out.println("Exiting...");
                System.exit(0);
            } else {
                break;
            }

        }

    

        //character stats creation 
        playerStat.statAssign();
        displayStat(playerStat);

        
    }

    public void displayStat(Stats playerStat) {
        System.out.println("==================================================");
        System.out.println(
            "Your Name: " + name + "\n" +
            "Your Stats: \n" +
            "Strength: " + playerStat.strength + "\n" +
            "Charisma: " + playerStat.charisma + "\n" +
            "Stealth: " + playerStat.stealth
        );
        System.out.println("==================================================");
    }
  
    public void intro() {
        String[] introText = {

            "==================================================",
            "                     DEAD SUN",
            "==================================================",
            "",
            "Year 2176.",
            "",
            "One hundred years ago, pressure built beneath the crust.",
            "Tectonic plates locked.",
            "Magma chambers swelled.",
            "",
            "When they ruptured, they ruptured everywhere.",
            "",
            "Supervolcanoes erupted across the planet.",
            "Ash entered the stratosphere.",
            "Sulfur clouds reflected sunlight back into space.",
            "",
            "Global temperature dropped six degrees in months.",
            "",
            "The sun disappeared.",
            "",
            "Scientists called it a volcanic winter.",
            "",
            "It lasted thirty years.",
            "",
            "Crops failed first.",
            "Then power.",
            "Then law.",
            "",
            "People did not die from lava.",
            "They died from hunger.",
            "",
            "And hunger makes animals of everyone.",
            "",
            "Neighbors killed neighbors for rice.",
            "Parents stole from children.",
            "Bodies lay in the streets for days.",
            "",
            "Some burned furniture for heat.",
            "Some burned houses...",
            "Some burned people...",
            "",
            "By the time the sky cleared,",
            "ninety-eight percent of humanity was gone.",
            "",
            "The sun came back wrong.",
            "",
            "A weak red blur behind smoke.",
            "",
            "A dead sun.",
            "",
            name + ", you were born long after the fall.",
            "",
            "You have never seen blue sky.",
            "You have never tasted fresh food.",
            "",
            "Only ash.",
            "Only cold.",
            "",
            "Only ruins filled with bones that used to be cities.",
            "",
            "Your home wasn't a house.",
            "It was a metro station.",
            "Line 12. Platform C.",
            "",
            "Thirty people. Scrap beds. Melted snow for water.",
            "They called it Haven.",
            "",
            "It wasn't living.",
            "But it was safe.",
            "",
            "Last night, gunshots echoed through the tunnels.",
            "",
            "Doors blown open.",
            "Flashlights in the dark.",
            "Screaming.",
            "",
            "The Black Torch raiders.",
            "",
            "They took food.",
            "They took people.",
            "They killed the rest.",
            "",
            "Your parents shoved you into a maintenance hatch.",
            "",
            "\"Run east,\" your father said.",
            "\"Geothermal station... greenhouse... food...\"",
            "",
            "You heard the shots before the door slammed shut.",
            "",
            "By morning, Haven was silent.",
            "",
            "Smoke.",
            "Blood.",
            "No survivors.",
            "",
            "You take what you can carry.",
            "Three bullets. An homemade pistol. A knife. And some bandages.",
            "",
            "The tunnel ahead is cold and black.",
            "",
            "Walk east.",
            "Find the greenhouse.",
            "",
            "Or die like the others.",
            "",
            "Press 1 to step into the ash...",
            "=================================================="
        };
        for (int i = 0; i < introText.length; ++i) {
            System.out.println(introText[i]);
        }

        while (true) {
            input = scnr.nextInt();
            if (input == -1) {
                System.out.println("Exiting...");
                System.exit(0);
            } else if (input == 1) {
                return;
            } else {
                System.out.println("Press 1 to step into the ash...");
                scnr.nextLine();
                continue;
            }
        }
    };

};
    



//javac src/main.java src/character.java src/player.java
//java src/main.java


