package items;

public class Currency {
    private int total;


    public Currency(int amount) {
        this.total = amount;
    }

    public boolean canAfford(int cost) {
        if (this.total - cost <= 0) {
            return false;
        } else {
            return true;
        }
    }

    public int getAmmount() {
        return this.total;
    }

    public void increase(int amount) {
        this.total += amount;
    }

    public void decrease(int amount) {
        this.total -= amount;
    }
}

