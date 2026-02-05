import player.Inventory;
import player.Player;
import player.Stats;
import world.Metro;
import core.Dungeon;
import java.util.*;

public class Game {
    public Game() {   
        ArrayList<Dungeon> currMap;    
        Player userPlayer = new Player();
        Stats playerStat = new Stats();
        Inventory userInventory = new Inventory();

        //start player creation and stats distribution
        userPlayer.create(playerStat);
        userPlayer.intro();

        //level one metro station
        Metro metroStation = new Metro();
        metroStation.populate();

        currMap = metroStation.getMap();



        

    }
}