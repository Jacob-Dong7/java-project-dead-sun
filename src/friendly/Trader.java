package friendly;

import java.util.*;

public abstract class Trader {
    protected String name;
    protected String type;
    protected ArrayList<TraderItem> traderInventory;
    protected ArrayList<TraderWeapon> traderWeapon;

    //initalize 
    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }
}
