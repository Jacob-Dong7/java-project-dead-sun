package items;

public class HealingItem {
    private int amount;
    private Healing item;

    public HealingItem(Healing item, int amount) {
        this.item = item;
        this.amount = amount;
    }

    public Healing getHeal() {
        return this.item;
    }

    public int getAmount() {
        return this.amount;
    }

    public void useItem() {
        --amount;
    }

    public void findItem() {
        ++amount;
    }

}