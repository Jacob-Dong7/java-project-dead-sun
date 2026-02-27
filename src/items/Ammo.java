package items;

public class Ammo extends Items{

    public Ammo(int amount) {
        this.amount = amount;
    }

    public void findAmmo(int amount) {
        this.amount += amount;
    }

    public void checkAmmo() {
        if (this.amount > 1) {
            System.out.println("You have " + this.amount + " bullets left");
        } else if (this.amount == 1) {
            System.out.println("You have one bullet left");
        } else {
            System.out.println("You are out of ammunition");
        }
    }

    public void useAmmo() {
        --amount;
    }

    
}
