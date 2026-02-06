package world;

import java.util.Random;
import java.util.ArrayList;

import player.*;

import combat.*;

import core.Map;
import core.Dungeon;
import control.Control;

public class Maintenance extends Map {
    private int randEnemy;
    private Random random = new Random();

    ArrayList<Dungeon> maintenanceTunnel;
    public Maintenance() {
        completed = false;
        numRooms = 2;
        name = "Maintenance Tunnels";
    }

    public ArrayList<Dungeon> getMap() {
        return maintenanceTunnel;
    }

    public void populate() {
        maintenanceTunnel = new ArrayList<>();

        //populate the dungeon
        maintenanceTunnel.add(new Dungeon("Valve Gallery", randEnemy = generateEnemy(), "raider", generateItem(), generateItem(), generateItem(), generateItem(), false, descOne(randEnemy)));
        maintenanceTunnel.add(new Dungeon("Pump Junction", randEnemy = generateEnemy(), "raider", generateItem(), generateItem(), generateItem(), generateItem(), true, descTwo(randEnemy)));

    public int generateEnemy() {
        return random.nextInt(1, 4); //generate 1-3 enemy
    }

    public int generateItem() {
        return random.nextInt(1,3); //generate 1-2 items
    }

    //description for each dungeon. Layout is exactly same for pretty much all rooms.
    public String[] descOne(int enemy) {
        if (enemy == 1) {
            String[] description = {
                "==================================================",
                "You descend into the tunnels.",
                "",
                "Valves line the wall like ribs. Pipes tick as they cool.",
                "The air still smells like smoke.",
                "",
                "One Black Torch raider squats by a toolbox, prying it ope.",
                "",
                "He hasn't seen you yet.",
                "=================================================="
            };
            return description;
        } else {
            String enemyCount = String.valueOf(enemy);
            String[] description = {
                "==================================================",
                "You descend into the tunnels.",
                "",
                "Valves line the wall like ribs. Pipes tick as they cool.",
                "",
                enemyCount + " Black Torch raiders work the corridor, torches low.",
                "They control the only path forward.",
                "=================================================="
            };
            return description;
        }
    }

    public String[] descTwo(int enemy) {
        if (enemy == 1) {
            String[] description = {
                "==================================================",
                "You step into the pump junction.",
                "",
                "Old machinery looms in the dark,",
                "its casing warped by heat and age.",
                "",
                "A lone raider stands near a barrel fire, warming his hands.",
                "Behind him, a ladder climbs out of the tunnels.",
                "=================================================="
            };

            return description;
        } else {
            String enemyCount = String.valueOf(enemy);
            String[] description = {
                "==================================================",
                "You enter the pump junction.",
                "Massive pumps dominate the chamber,",
                "their housings cracked and blackened.",
                "",
                enemyCount + " raiders gather around a barrel fire,",
                "weapons within reach.",
                "They’re guarding the ladder out.",
                "=================================================="
            };
            return description;
        }
    }

    public void printDescription(int curr) {
        System.out.println("==================================================");
        for (int i = 0; i < maintenanceTunnel.get(curr).getDescription().length; ++i){ 
            System.out.println(maintenanceTunnel.get(curr).getDescription()[i]);
        }
        System.out.println("==================================================");
    }

    public void play(Control playerControl, Stats playerStat, Stealth playerStealth, Speech playerSpeech) {
        int userInput;
        for (int i = 0; i < maintenanceTunnel.size(); ++i) {
            printDescription(i);
            while (true) {
                if (maintenanceTunnel.get(i).enemyCount() > 0) {
                    userInput = playerControl.enemyPresent();
                    if (userInput == 1) {
                        if (playerStealth.sneakAttempt(playerStat) == true) {
                            System.out.println("==================================================");
                            System.out.println("You successfully sneaked pass");
                            System.out.println("==================================================");
                            break;
                        } else {
                            System.out.println("==================================================");
                            System.out.println("You attempted to sneak pass, but was caught");
                            System.out.println("==================================================");
                            break;
                        }
                    } else if (userInput == 2) {
                        System.out.println("u kill");
                        break;
                    } else if (userInput == 3) {
                        if (playerSpeech.attemptSpeech(playerStat, 1, maintenanceTunnel.get(i).enemyCount()) == true) {
                            break;
                        } else {
                            System.out.println("u kill");
                            break;                            
                        }
                    }
                } else {
                    userInput = playerControl.noEnemy();
                    break;
                }
            }
        }
        completed = true;
    }
}
}
