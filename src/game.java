import player.Inventory;
import player.Player;
import player.Stats;
import world.Maintenance;
import world.Metro;
import core.Dungeon;

import enemy.Raiders;

import control.Control;

import combat.*;

import java.util.*;

public class Game {
    ArrayList<Dungeon> currMap;
    Player userPlayer;
    Stats playerStat;
    Inventory userInventory;
    Stealth playerStealth;
    Speech playerSpeech;
    Control playerControl;
    Maintenance maintenanceTunnel;
    Metro metroStation;
    Combat combat;
    
    private static final Scanner scnr = new Scanner(System.in);

    public Game() {   
        userPlayer = new Player();
        playerStat = new Stats();
        userInventory = new Inventory();
        playerStealth = new Stealth();
        playerSpeech = new Speech();
        playerControl = new Control();
        combat = new Combat();

        //maps
        maintenanceTunnel = new Maintenance();
        metroStation = new Metro();
        
    }

    public void start() {
        //start player creation and stats distribution
        userPlayer.create(playerStat);
        userPlayer.intro();

        //level one metro station
        metroStation.populate();
        metroStation.play(userPlayer, playerControl, playerStat, playerStealth, playerSpeech, combat);

        //level two maintenance tunnel
        maintenanceTunnel.populate();
        maintenanceTunnel.play(playerControl, playerStat, playerStealth, playerSpeech);
    }

}