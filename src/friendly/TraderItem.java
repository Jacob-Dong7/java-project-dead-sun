package friendly;
import items.*;

public class TraderItem {
    protected Items item;
    protected int price;

    public TraderItem(Items item, int price) {
        this.item = item;
        this.price = price;
    }
    
    public Items getItem() {
        return item;
    }


    public int getPrice() {
        return price;
    }

    public void sell(int amount) {
        this.item.removeAmount(amount);
    }
}
