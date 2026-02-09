package items;

public class Currency {
    private int total;


    public Currency(int amount) {
        this.total = amount;
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