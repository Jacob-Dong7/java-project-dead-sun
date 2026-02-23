package world;

import java.util.*;

import core.Map;
import core.Dungeon;
import core.GameContext;

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
        map.add(new Dungeon("Platform C", randEnemy = generateEnemy(), "raider", false, descOne(randEnemy)));
        map.add(new Dungeon("Concourse", randEnemy = generateEnemy(), "raider", false, descTwo(randEnemy)));
        map.add(new Dungeon("Service Access", randEnemy = generateEnemy(), "raider", false, descThree(randEnemy)));
    }

    //description for each dungeon. Layout is exactly same for pretty much all rooms.
    public String[] descOne(int enemy) {
        if (enemy == 1) {
            String[] description = {
                "You step back onto Platform C.",
                "",
                "Blankets scattered. Blood dried black on the tiles.",
                "The air still smells like smoke.",
                "",
                "This was home.",
                "",
                "Near the bunks, one Black Torch raider digs through a pack.",
                "His back is turned.",
            };
            return description;
        } else {
            String enemyCount = String.valueOf(enemy);
            String[] description = {
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
            };
            return description;
        }
    }

    public String[] descTwo(int enemy) {
        if (enemy == 1) {
            String[] description = {
                "You enter the main concourse.",
                "",
                "Ticket gates melted. Shops stripped bare.",
                "Ash drifts through the air.",
                "",
                "A lone Black Torch guard stands by the escalator, machete in hand.",
                "He blocks the path forward.",
            };

            return description;
        } else {
            String enemyCount = String.valueOf(enemy);
            String[] description = {
                "You enter the main concourse.",
                "",
                "Burn marks climb the pillars. Shell casings crunch underfoot.",
                "",
                enemyCount + " Black Torch raiders patrol the escalators with torches and rifles.",
                "There's no way around them.",
            };
            return description;
        }
    }

        public String[] descThree(int enemy) {
        if (enemy == 1) {
            String[] description = {
                "You slip through a rusted service door.",
                "",
                "Lights die behind you. Pipes drip overhead.",
                "The tunnel narrows east.",
                "",
                "One Black Torch scout waits near the bend, warming his hands over a small fire.",
                "Beyond him is the way out.",
            };

            return description;
        } else {
            String enemyCount = String.valueOf(enemy);
            String[] description = {
                "You enter the maintenance tunnel.",
                "",
                "Cold air. Hanging cables. Fresh footprints in ash.",
                "",
                enemyCount + " Black Torch raiders sit around a barrel fire, weapons close.",
                "They're guarding the only exit east.",
            };
            return description;
        }
    }

    public void play(GameContext gc) {
        for (int i = 0; i < map.size(); ++i) {
            System.out.println("==================================================");
            System.out.println("LOCATION: " + map.get(i).getName());
            printDescription(i);
            while (true) {
                //if there is enemies present
                if (map.get(i).enemyCount() > 0) {
                    gc.control.enemyPresent(gc, map.get(i));
                    continue;
                } 
                //if there are no enemies present
                else {
                    gc.control.noEnemy(gc, map.get(i));
                    break;
                }
            }
        }
        System.out.println("==================================================");
        System.out.println("LOCATION: Maintenance Tunnels");
        System.out.println("==================================================");
        System.out.println("You descend the stairwell.\nValves hiss somewhere below.");
        System.out.println(">> LEVEL ADVANCED");
    }
}


