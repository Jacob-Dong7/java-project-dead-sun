package friendly;
import items.*;

public class Clara extends Trader {
    public Clara() {
        this.name = "Clara";
        this.type = "General";
        this.traderInventory.add(new TraderItem(new Ammo(65), 100));
        this.traderInventory.add(new TraderItem(new HealingItem(Healing.BANDAGE, 3), 70));
        this.traderInventory.add(new TraderItem(new HealingItem(Healing.SYRINGE, 5), 300));
    }
}