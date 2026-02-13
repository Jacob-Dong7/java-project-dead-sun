package core;
import player.*;
import gameplay.*;
import control.*;


import Inventory.Inventory;

public class GameContext {
    public final Player player;
    public final Stats stats;
    public final Inventory inventory;
    public final Stealth stealth;
    public final Speech speech;
    public final Control control;
    public final Combat combat;
    public final Looting looting;

    public GameContext(Player p, Stats s, Inventory i, Stealth st, Speech sp, Control c, Combat ct, Looting lt) {
        this.player = p;
        this.stats = s;
        this.inventory = i;
        this.stealth = st;
        this.speech = sp;
        this.control = c;
        this.combat = ct;
        this.looting = lt;
    }
}