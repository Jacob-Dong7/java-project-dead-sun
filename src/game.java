public class Game {
    public Game() {       
        Player userPlayer = new Player();
        Inventory userInventory = new Inventory();
        userPlayer.create();
        userPlayer.intro();

    }
}