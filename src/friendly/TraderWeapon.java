package friendly;
import items.Weapon;

public class TraderWeapon {
    private Weapon weapon;
    private int price, amount;

    public TraderWeapon(Weapon weapon, int price, int amount) {
        this.weapon = weapon;
        this.price = price;
        this.amount = amount;

    }
    public Weapon getWeapon() {
        return weapon;
    }

    public int getPrice() {
        return price;
    }

    public int getAmount() {
        return amount;
    }
}
