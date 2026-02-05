package world;

import java.util.Random;
import java.util.ArrayList;
import core.Map;
import core.Dungeon;

public class Metro extends Map {
    private int randEnemy;
    private Random random = new Random();

    ArrayList<Dungeon> metroOne;
    public Metro() {
        completed = false;
        numRooms = 3;
        name = "Metro Line One";
    }

    public ArrayList<Dungeon> getMap() {
        return metroOne;
    }

    public void populate() {
        metroOne = new ArrayList<>();

        //populate the dungeon
        metroOne.add(new Dungeon("Platform C", randEnemy = generateEnemy(), "raider", generateItem(), generateItem(), generateItem(), generateItem(), false, descOne(randEnemy)));
        metroOne.add(new Dungeon("Concourse", randEnemy = generateEnemy(), "raider", generateItem(), generateItem(), generateItem(), generateItem(), false, descOne(randEnemy)));
        metroOne.add(new Dungeon("Service Access", randEnemy = generateEnemy(), "raider", generateItem(), generateItem(), generateItem(), generateItem(), false, descOne(randEnemy)));
    }

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
                "You step back onto Platform C.",
                "",
                "Blankets scattered. Blood dried black on the tiles.",
                "The air still smells like smoke.",
                "",
                "This was home.",
                "",
                "Near the bunks, one Black Torch raider digs through a pack.",
                "His back is turned."
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
                enemyCount,
                " Black Torch raiders move between the bunks, looting quietly.",
                "Torches glow in the dark.",
                "",
                "They block the way east."
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
                "He blocks the path forward."
            };

            return description;
        } else {
            String enemyCount = String.valueOf(enemy);
            String[] description = {
                "You enter the main concourse.",
                "",
                "Burn marks climb the pillars. Shell casings crunch underfoot.",
                "",
                enemyCount,
                " Black Torch raiders patrol the escalators with torches and rifles.",
                "There's no way around them."
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
                "Beyond him is the way out."
            };

            return description;
        } else {
            String enemyCount = String.valueOf(enemy);
            String[] description = {
                "You enter the maintenance tunnel.",
                "",
                "Cold air. Hanging cables. Fresh footprints in ash.",
                "",
                enemyCount,
                " Black Torch raiders sit around a barrel fire, weapons close.",
                "They're guarding the only exit east."
            };
            return description;
        }
    }


    
    
}
