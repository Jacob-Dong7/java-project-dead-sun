package friendly;

import core.GameContext;
import items.*;
import java.util.Scanner;

public class Clara extends Trader {

    public Clara() {
        super("Clara", TraderType.GENERAL);
        populateVendor();
    }

    @Override
    public void populateVendor() {
        this.traderInventory.add(new TraderItem(new Ammo(65), 100));
        this.traderInventory.add(new TraderItem(new HealingItem(Healing.BANDAGE, 3), 70));
        this.traderInventory.add(new TraderItem(new HealingItem(Healing.SYRINGE, 5), 300));
    }

    @Override
    public String[] getDescription() {
        String[] desc = {
            "You move toward the kiosk.",
            "The woman behind the kiosk looks up.",
            "",
            "Up close, the stall is more organized than it first appeared.",
            "Food tins stacked by label.",
            "Rounds bundled in cloth.",
            "Antibiotics sealed tight in metal tins.",
            "",
            "A kettle simmers on the stove beside her.",
            "Her eyes assess you quickly - hands, weapon, posture.",
            "",
            "\"Welcome to New Concourse. We don't see many new faces.\"",
            "",
            "She wipes her hands on a rag.",
            "",
            "\"Name's Clara\"",
            "",
            "She leans slightly against the counter.",
            "",
            "\"You buying?\"",
            "",
            "Your stomach answers before you do.",
            "",
            "She slides a dented tin of navy beans and a bottle of purified water across the counter..",
            "",
            "\"Food and water for 10.\"",
            "",
            "You hand over what you can spare.",
            "You sit on the edge of the kiosk and eat.",
            "The food is plain. Warm enough.",
            "The water is clean.",
            "",
            "The ache in your gut dulls.",
            "",
            "You looks around as you eat",
            "You see that beyond the far wall, a sign reads: SERVICE ACCESS.",
            "A heavier section of the mall lies deeper inside.",
            "",
            "You finish the canned food quickly.",
            "\"You need anything else?\" says Clara"
    };
    return desc;

    }

    @Override
    public String[] getDescriptionVisited() {
        String[] desc = {
            "Clara stands behind the kiosk, counting inventory.",
            "",
            "\"Back again?\" She says as you approach",
            "",
            "\"What do you need?\""
        };
        return desc;    
    }

   @Override
    public void trade(GameContext gc) {


        while (true) {
            Scanner scnr = new Scanner(System.in);
            int input, amount = 0, price = 0, choice; 

            System.out.println("==================================================");
            System.out.println("TRADING - " + getName().toUpperCase() + "'S GENERAL GOODS");
            System.out.println("Credits: " + gc.inventory.getMoney());
            System.out.println("==================================================");
            for (int i = 0; i < traderInventory.size(); ++i) {
                System.out.print("[");
                System.out.print(i + 1);
                System.out.print("] ");
                if (traderInventory.get(i).getItem() instanceof HealingItem) {
                    HealingItem healingItem = (HealingItem) traderInventory.get(i).getItem();
                    System.out.print( healingItem.getHeal().getName() + " | PRICE  $" + traderInventory.get(i).getPrice() + " | STOCK " + traderInventory.get(i).getItem().getAmount());
                    System.out.println(" | HEALING " + traderInventory.get(i).getItem().getAmount() + " HP");
                } else if (traderInventory.get(i).getItem() instanceof Ammo) {
                    System.out.println(traderInventory.get(i).getItem().getName() + " | PRICE  $" + traderInventory.get(i).getPrice() + " | STOCK " + traderInventory.get(i).getItem().getAmount());
                }
            }
            System.out.println("--------------------------------------------------");
            System.out.println("[0] Return");
            System.out.println("==================================================");

            input = scnr.nextInt();
            if (input > traderInventory.size() || input < 0) {
                System.out.println("--------------------------------------------------");
                System.out.println("Select from avaliable actions");
                System.out.println("--------------------------------------------------");
            }

            if (input == 0) return;

            choice = input;

            if (traderInventory.get(choice - 1).getItem().getAmount() <= 0) {
                noStock();
                continue;
            }

            if (traderInventory.get(choice - 1).getItem() instanceof Ammo) {
                System.out.println("--------------------------------------------------");
                System.out.println("Enter Quantity (Stock Left " + traderInventory.get(choice - 1).getItem().getAmount() + "): ");
                System.out.println("--------------------------------------------------");
                input = scnr.nextInt();
                if (input < 0 || input > traderInventory.get(choice - 1).getItem().getAmount()) {
                    System.out.println("--------------------------------------------------");
                    System.out.println("Out of stock");
                    System.out.println("--------------------------------------------------");
                    continue;
                }

                amount = input;
                price = traderInventory.get(choice - 1).getPrice() * amount;
                 System.out.println("-23");
                if (gc.inventory.getMoney() < price) {
                    noMoney();
                    continue;
                }  else {
                    gc.inventory.useMoney(price);
                    gc.inventory.findAmmo(amount);
                    System.out.println("--------------------------------------------------");
                    System.out.println("+ " + amount + " ammo");
                    System.out.println("--------------------------------------------------");

                }
            } else if (traderInventory.get(choice - 1).getItem() instanceof HealingItem) {
                System.out.println("--------------------------------------------------");
                System.out.println("Enter Quantity (Stock Left " + traderInventory.get(choice - 1).getItem().getAmount() + "): ");
                System.out.println("--------------------------------------------------");
                HealingItem heal = (HealingItem) traderInventory.get(choice - 1).getItem();
                Healing newHeal = (Healing) heal.getHeal();

                input = scnr.nextInt();
                if (input < 0 || input > traderInventory.get(choice - 1).getItem().getAmount()) {
                    System.out.println("--------------------------------------------------");
                    System.out.println("Out of stock");
                    System.out.println("--------------------------------------------------");
                    continue;
                }


                amount = input;
                price = amount * traderInventory.get(choice - 1).getPrice();

                if (gc.inventory.getMoney() < price) {
                    noMoney();
                    continue;
                } else {
                    Boolean hasHeal = false;
                    for (HealingItem med : gc.inventory.getMedPouch()) {
                        if (med.getHeal() ==  heal.getHeal()) {
                            System.out.println("+ " + heal.getName()  + " x" + amount);
                            med.buyItem(amount);
                            hasHeal = true;
                            break;
                        }
                    }           
                    
                    if (hasHeal == false) {
                        System.out.println("+ " + newHeal.getName() + " x" + amount + " (New item added to Medical Pouch)");
                        gc.inventory.getMedPouch().add(new HealingItem(newHeal, amount));
                    }

                }

                }

                traderInventory.get(choice - 1).sell(amount);
                
            }
        } 
}
