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
        map.add(new Dungeon("Valve Gallery", randEnemy = generateEnemy(), "raider", generateItem(), generateItem(), generateItem(), generateItem(), false, descOne(randEnemy)));
        map.add(new Dungeon("Pump Junction", 0, "raider", generateItem(), generateItem(), generateItem(), generateItem(), true, descTwo()));
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
                "One Black Torch raider squats by a toolbox, prying it open.",
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

    public String[] descTwo() {
        String[] description = {
            "The maintenance tunnel opens into a pump junction choked with rusted machinery.",
            "Thick pipes line the walls, some split and leaking dark water onto the floor.",
            "",
            "Floodlights glare down, harsh and deliberate.",
            "Someone is waiting.",
            "",
            "A single Black Torch  raider stands at the center of the room.",
            "Their armor is fused together from scrap, melted and bolted over flesh that never healed right.",
            "Scars twist across their exposed skin — burns, cuts, and old fractures layered on top of each other.",
            "",
            "If you want to continue, you have to get pass him...",
        };

        return description;
    }

    public void play(GameContext gc) {
        int userInput;
        for (int i = 0; i < map.size(); ++i) {
            printDescription(i);
            while (true) {
                //if boss is present
                if (map.get(i).bossPresent() == true) {

                } //if dungeon not cleared
                else if (map.get(i).enemyCount() > 0) {
                    //goes to enemy present function in control.java
                    userInput = gc.control.enemyPresent();
                    // gets user control that will determine what moves they do next.

                    //user selects 1 to sneak
                    if (userInput == 1) { 
                        if (gc.stealth.sneakAttempt(gc.stats) == true) { //calls the sneak attemp function in stealth.java. will return true or false for if stealth success
                            System.out.println("==================================================");
                            System.out.println("You successfully sneaked pass");
                            System.out.println("==================================================");
                            break;
                        } else {
                            System.out.println("==================================================");
                            System.out.println("You attempted to sneak pass, but was caught");
                            System.out.println("==================================================");
                            gc.combat.runEncounter(gc, map.get(i));
                        }
                    } else if (userInput == 2) { //user chooses to fight
                        gc.combat.runEncounter(gc, map.get(i));
                        break;
                    } else if (userInput == 3) { //user chooses to talk to enemy. will be presented with options that will return true if successful
                        if (gc.speech.attemptSpeech(gc.stats, 1, map.get(i).enemyCount()) == true) {
                            break;
                        } else {
                            gc.combat.runEncounter(gc, map.get(i));
                            break;                            
                        }
                    }
                } else {
                    //goes to no enemy present function in control.java
                    userInput = gc.control.noEnemy();
                    break;
                }
            }
        }
        completed = true;
    }
}
