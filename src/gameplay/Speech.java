package gameplay;

import player.Stats;
import java.util.*;

public class Speech {
    private int choice;
    private static final Scanner scnr = new Scanner(System.in);
    Random random = new Random();

    public boolean attemptSpeech(Stats playerStat, String enemyType, int enemyCount) {
        //speech for first section, metro station
        while (true) {

            //map dependent
            if (enemyType == "raider") {
                if (enemyCount == 1) {
                    System.out.println("==================================================");
                    System.out.println(
                        "A single torch burns ahead.\n" + "A Black Torch raider turns.\n" + "Smoke curls around his mask."
                    );
                } else {
                    System.out.println("==================================================");
                    System.out.println(
                        "Several torches flicker ahead.\n" + "Shadows move through the smoke.\n" + "Black Torch raiders fan out."
                    );
                }
                    System.out.println("You step forward");
                    System.out.println("==================================================");
                    System.out.println("Speech Options:");
                    System.out.println("1. Intimidate");
                    System.out.println("2. Persuade");
                    System.out.println("3. Fight");
                    System.out.println("==================================================");
                    choice = scnr.nextInt();
            } else {

            }


            //user choices
            if (choice == 1) {
                System.out.println("==================================================");
                System.out.println("INTIMIDATION");
                System.out.println("==================================================");
                System.out.println("You push forward, unflinching.");
                if (intimidate(playerStat) == true) {
                    if (enemyCount == 1) {
                        System.out.println(
                            "The raider freezes." + "\n" +
                            "He looks you over" + "\n" +
                            "Then slowly lowers the torch." + "\n" +
                            "\"...Not worth it.\"" + "\n" +
                            "He backs away into the dark."
                        );
                    } else {
                        System.out.println(
                            "The raiders pause." + "\n" +
                            "Eyes flick between you." + "\n" +
                            "Torches dip." + "\n" +
                            "\"...Leave it.\"" + "\n" +
                            "They melt back into the smoke."
                        );
                    }
                    System.out.println("==================================================");
                    return true;
                } else {
                    if (enemyCount == 1) {
                        System.out.println(
                            "The raider grins." + "\n" +
                            "\"I am going to skin you alive boy\"" + "\n" +
                            "He steps closer."
                        );
                    } else {
                        System.out.println(
                            "Laughter breaks out." + "\n" +
                            "\"Your gonna get burned alive boy...\" One of the raider said" + "\n" +
                            "Torches rise."
                        );
                    }
                    System.out.println("==================================================");
                    return false;
                }
            } else if (choice == 2) { //user persuade
                System.out.println("==================================================");
                System.out.println("PERSUATION");
                System.out.println("==================================================");
                System.out.println("You try to talk your way through.");
                if (persuade(playerStat) == true) {
                    if (enemyCount == 1) {
                        System.out.println(
                            "The raider listens." + "\n" +
                            "He exhales through the mask." + "\n" +
                            "Looks past you." + "\n" +
                            "\"...Too small.\"" + "\n" +
                            "He turns away."
                        );
                    } else {
                        System.out.println(
                            "The raiders exchange looks." + "\n" +
                            "One shakes his head." + "\n" +
                            "Another gestures down the tunnel." + "\n" +
                            "\"...Waste of time.\"" + "\n" +
                            "They move on."
                        );
                    }
                    System.out.println("==================================================");
                    return true;
                } else {
                    if (enemyCount == 1) {
                        System.out.println(
                            "The raider tilts his head." + "\n" +
                            "\"Nice try boy, but you're still dead...\"" + "\n" +
                            "He tightens his grip on the torch."
                        );
                    } else {
                        System.out.println(
                            "A few chuckles." + "\n" +
                            "\"Doesn't change a thing..\" One of the raider says" + "\n" +
                            "They close in."
                        );
                    }
                    System.out.println("==================================================");
                    return false;
                }                
            } else if (choice == 3) {
                System.out.println("==================================================");
                System.out.println("COMBAT");
                System.out.println("==================================================");
                System.out.println("You ready your weapon.");
                if (enemyCount == 1) {
                        System.out.println(
                            "You shift your weight." + "\n" +
                            "The raider notices." + "\n" +
                            "The torch lifts." + "\n" +
                            "\"So be it.\"" + "\n" +
                            "He closes in."
                        );
                } else {
                        System.out.println(
                            "You tense." + "\n" +
                            "They see it." + "\n" +
                            "Weapons come up." + "\n" +
                            "\"Look who we have here\""
                        );
                }
                System.out.println("==================================================");
                return false;
            }
        }
    }

    public boolean intimidate(Stats playStats) {
        int base = 10, buff, chance;
        chance = random.nextInt(1, 100);
        buff = 5 * playStats.getStrength();

        if (chance < base + buff) {
            return true;
        } else {
            return false;
        }
    }

    public boolean persuade(Stats playStats) {
        int base = 10, buff, chance;
        chance = random.nextInt(1, 100);
        buff = 5 * playStats.getCharisma();

        if (chance < base + buff) {
            return true;
        } else {
            return false;
        }
    }

    }

