package world;

import java.util.ArrayList;

import player.*;

import combat.*;

import core.Map;
import core.Dungeon;
import core.GameContext;
import control.Control;

import enemy.Raiders;

public class Metro extends Map {
    private int randEnemy;
    Raiders raider = new Raiders();

    public Metro() {
        completed = false;
        numRooms = 3;
        name = "Metro Line One";
    }


    public void populate() {
        map = new ArrayList<>();

        //populate the dungeon
        map.add(new Dungeon("Platform C", randEnemy = generateEnemy(), "raider", generateItem(), generateItem(), generateItem(), generateItem(), false, descOne(randEnemy)));
        map.add(new Dungeon("Concourse", randEnemy = generateEnemy(), "raider", generateItem(), generateItem(), generateItem(), generateItem(), false, descTwo(randEnemy)));
        map.add(new Dungeon("Service Access", randEnemy = generateEnemy(), "raider", generateItem(), generateItem(), generateItem(), generateItem(), false, descThree(randEnemy)));
    }

    //description for each dungeon. Layout is exactly same for pretty much all rooms.
    public String[] descOne(int enemy) {
        if (enemy == 1) {
            String[] description = {
                "==================================================",
                "You step back onto Platform C.",
                "",
                "Blankets scattered. Blood dried black on the tiles.",
                "The air still smells like smoke.",
                "",
                "This was home.",
                "",
                "Near the bunks, one Black Torch raider digs through a pack.",
                "His back is turned.",
                "=================================================="
            };
            return description;
        } else {
            String enemyCount = String.valueOf(enemy);
            String[] description = {
                "==================================================",
                "You step back onto Platform C.",
                "",
                "Beds overturned. Barricades smashed inward.",
                "Bodies lie where they fell.",
                "",
                "This was home.",
                "",
                enemyCount + " Black Torch raiders move between the bunks, looting quietly.",
                "Torches glow in the dark.",
                "",
                "They block the way east.",
                "=================================================="
            };
            return description;
        }
    }

    public String[] descTwo(int enemy) {
        if (enemy == 1) {
            String[] description = {
                "==================================================",
                "You enter the main concourse.",
                "",
                "Ticket gates melted. Shops stripped bare.",
                "Ash drifts through the air.",
                "",
                "A lone Black Torch guard stands by the escalator, machete in hand.",
                "He blocks the path forward.",
                "=================================================="
            };

            return description;
        } else {
            String enemyCount = String.valueOf(enemy);
            String[] description = {
                "==================================================",
                "You enter the main concourse.",
                "",
                "Burn marks climb the pillars. Shell casings crunch underfoot.",
                "",
                enemyCount + " Black Torch raiders patrol the escalators with torches and rifles.",
                "There's no way around them.",
                "=================================================="
            };
            return description;
        }
    }

        public String[] descThree(int enemy) {
        if (enemy == 1) {
            String[] description = {
                "==================================================",
                "You slip through a rusted service door.",
                "",
                "Lights die behind you. Pipes drip overhead.",
                "The tunnel narrows east.",
                "",
                "One Black Torch scout waits near the bend, warming his hands over a small fire.",
                "Beyond him is the way out.",
                "=================================================="
            };

            return description;
        } else {
            String enemyCount = String.valueOf(enemy);
            String[] description = {
                "==================================================",
                "You enter the maintenance tunnel.",
                "",
                "Cold air. Hanging cables. Fresh footprints in ash.",
                "",
                enemyCount + " Black Torch raiders sit around a barrel fire, weapons close.",
                "They're guarding the only exit east.",
                "=================================================="
            };
            return description;
        }
    }

    public void play(GameContext gc) {
        int userInput;
        for (int i = 0; i < map.size(); ++i) {
            printDescription(i);
            while (true) {
                if (map.get(i).enemyCount() > 0) {
                    userInput = gc.control.enemyPresent();
                    if (userInput == 1) {
                        if (gc.stealth.sneakAttempt(gc.stats) == true) {
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
                        gc.combat.runEncounter(gc, map.get(i));
                    } else if (userInput == 3) {
                        if (gc.speech.attemptSpeech(gc.stats, 1, map.get(i).enemyCount()) == true) {
                            break;
                        } else {
                            gc.combat.fighting(gc, raider, map.get(i));
                            break;                            
                        }
                    }
                } else {
                    userInput = gc.control.noEnemy();
                    break;
                }
            }
        }
        System.out.println("You descend the stairwell.\nValves hiss somewhere below.");
    }
}


