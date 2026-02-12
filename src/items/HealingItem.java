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

    public void usePrompt(Healing usedItem) {
        System.out.println("==================================================");
        if (usedItem == Healing.BANDAGE) {
            System.out.println("You tear open a worn bandage packet with shaking fingers.");
            System.out.println("Cloth wraps tight around the wound, soaking slowly as you pull it firm.");
            System.out.println("The bleeding eases. It's not pretty, but it will hold.");
        } else if (usedItem == Healing.MEDKIT) {
            System.out.println("You drop to one knee and snap open the medkit.");
            System.out.println("Disinfectant burns as you clean the wound, stitching and sealing with steady hands.");
            System.out.println("Your breathing steadies. Strength creeps back into your limbs.");
        } else if(usedItem == Healing.SYRINGE) {
            System.out.println("You press the syringe against your arm and inject without hesitation.");
            System.out.println("A cold rush floods your veins, numbing pain and sharpening your focus.");
            System.out.println("Your vision clears. The weakness fades — for now.");
        }
        System.out.println("+ " + usedItem.getHeal() + " Health");
        System.out.println("==================================================");
    }
}