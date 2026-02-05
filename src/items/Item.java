package items;
public class Item {
    private String name;
    private int amount;

    public Item(String name, int amount) {
        this.name = name;
        this.amount = amount;
    }

    public String getName() {
        return this.name;
    }

    public int getAmount() {
        return this.amount;
    }

}
