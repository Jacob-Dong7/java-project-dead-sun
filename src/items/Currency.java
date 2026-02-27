package items;

public class Currency extends Items{

    public Currency(int amount) {
        this.amount = amount;
    }

    public boolean canAfford(int cost) {
        if (this.amount - cost <= 0) {
            return false;
        } else {
            return true;
        }
    }
    public void increase(int amount) {
        this.amount += amount;
    }

    public void decrease(int amount) {
        this.amount -= amount;
    }
}

