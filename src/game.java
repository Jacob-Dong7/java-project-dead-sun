import player.Inventory;
import player.Player;
import player.Stats;
import world.Metro;
import core.Dungeon;

import control.Control;

import combat.Stealth;
import combat.PlayerCombat;
import combat.Speech;

import java.util.*;

public class Game {
    ArrayList<Dungeon> currMap;
    Player userPlayer;
    Stats playerStat;
    Inventory userInventory;
    Stealth playerStealth;
    Speech playerSpeech;
    Control playerControl;
    
    private static final Scanner scnr = new Scanner(System.in);

    public Game() {   
        userPlayer = new Player();
        playerStat = new Stats();
        userInventory = new Inventory();
        playerStealth = new Stealth();
        playerSpeech = new Speech();
        playerControl = new Control();
        
    }

    public void start() {
        //start player creation and stats distribution
        userPlayer.create(playerStat);
        userPlayer.intro();

        //level one metro station
        Metro metroStation = new Metro();
        metroStation.populate();
        metroStation.play(playerControl, playerStat, playerStealth, playerSpeech);
    }

}