package items;

public class HealingItem extends Items{
    private Healing item;

    public HealingItem(Healing item, int amount) {
        this.item = item;
        this.amount = amount;
    }

    public Healing getHeal() {
        return this.item;
    }

    public void useItem() {
        --amount;
    }

    public void findItem() {
        ++amount;
    }

}