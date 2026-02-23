package world;
import java.util.ArrayList;
import core.*;

public class Maintenance extends Map {
    private int randEnemy;

    public Maintenance() {
        completed = false;
        numRooms = 2;
        name = "Maintenance Tunnels";
    }


    public void populate() {
        map = new ArrayList<>();

        //populate the dungeon
        map.add(new Dungeon("Valve Gallery", randEnemy = generateEnemy(), "raider", false, descOne(randEnemy)));
        map.add(new Dungeon("Pump Junction", 0, "raider", true, descTwo(), "raider boss"));
    }

    //description for each dungeon. Layout is exactly same for pretty much all rooms.
    public String[] descOne(int enemy) {
        if (enemy == 1) {
            String[] description = {
                "You descend into the tunnels.",
                "",
                "Valves line the wall like ribs. Pipes tick as they cool.",
                "The air still smells like smoke.",
                "",
                "One Black Torch raider squats by a toolbox, prying it open.",
                "",
                "He hasn't seen you yet.",
            };
            return description;
        } else {
            String enemyCount = String.valueOf(enemy);
            String[] description = {
                "You descend into the tunnels.",
                "",
                "Valves line the wall like ribs. Pipes tick as they cool.",
                "",
                enemyCount + " Black Torch raiders work the corridor, torches low.",
                "They control the only path forward.",
            };
            return description;
        }
    }

    public String[] descTwo() {
    String[] description = {
        "The tunnel opens into an old pump junction.",
        "Water drips steadily from overhead pipes.",
        "",
        "A man steps into view.",
        "",
        "He's heavily armored, scrap plates reinforced over thick, padded clothing.",
        "A dark, stained apron hangs stiffly over the front of his armor.",
        "",
        "Heavy gloves cover his hands.",
        "In one of them, he holds a cleaver. Clean. Maintained.",
        "",
        "Hooks, restraints, and metal tools hang from his belt.",
        "",
        "He isn't dressed like the others.",
        "",
        "He looks like a butcher.",
        "",
        "He studies you briefly.",
        "",
        "\"Stop.\"",
        "",
        "He waits.",
        "",
        "If you want to continue, you have to get past him..."
    };

    return description;
}


    public void play(GameContext gc) {
        for (int i = 0; i < map.size(); ++i) {
            System.out.println("==================================================");
            System.out.println("LOCATION: " + map.get(i).getName());
            printDescription(i);
            while (true) {
                //if boss is present
                if (map.get(i).enemyCount() > 0) {
                    gc.control.enemyPresent(gc, map.get(i));
                } else if (map.get(i).enemyCount() > 0 && map.get(i).bossPresent() == false){
                    //goes to no enemy present function in control.java
                    gc.control.noEnemy(gc, map.get(i));
                } else if (map.get(i).bossPresent()) {
                    gc.control.bossPresent(gc, map.get(i));
                }

                break;
            }
        }
        
        System.out.println("You emerge from the maintenance tunnel onto the surface.");
        System.out.println(">> LEVEL ADVANCED");
    }


}
