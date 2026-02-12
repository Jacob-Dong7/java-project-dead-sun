import player.*;
import world.*;
import core.*;
import control.*;
import combat.*;
import java.util.*;

import Inventory.Inventory;

public class Game {
    GameContext gc;

    ArrayList<Dungeon> currMap;
    Maintenance maintenanceTunnel;
    Metro metroStation;


    
    private static final Scanner scnr = new Scanner(System.in);

    public Game() {   
        Player p = new Player();
        Stats s = new Stats();
        Inventory i = new Inventory();
        Control c = new Control();
        Stealth st = new Stealth();
        Speech sp = new Speech();
        Combat ct = new Combat();
        
        gc = new GameContext(p, s, i, st, sp, c, ct);

        //maps
        maintenanceTunnel = new Maintenance();
        metroStation = new Metro();
        
    }

    public void start() {
        //start player creation and stats distribution
        gc.player.create(gc.stats);
        gc.player.intro();

        //level one metro station
        metroStation.populate();
        metroStation.play(gc);

        //level two maintenance tunnel
        maintenanceTunnel.populate();
        maintenanceTunnel.play(gc);
    }

}