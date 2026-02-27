package friendly;

import items.Weapon;

public class Joe extends Trader{
    
    public Joe() {
        this.name = "Joe";
        this.type = "Weapon";
        this.traderWeapon.add(new TraderWeapon(Weapon.REINFORCED_KNIFE, 200, 5));
        this.traderWeapon.add(new TraderWeapon(Weapon.REINFORCED_CLEAVER, 300, 5));
        this.traderWeapon.add(new TraderWeapon(Weapon.RIFLE, 700, 1));
        this.traderWeapon.add(new TraderWeapon(Weapon.ADVANCERIFLE, 1500, 1));
    }
}
