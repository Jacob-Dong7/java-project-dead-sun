package friendly;

import items.Weapon;
import java.util.Scanner;
import core.*;

public class Joe extends Trader{

    public Joe() {
        super("Joe", TraderType.WEAPON);
    }
    @Override
    public void populateVendor() {
        this.traderWeapon.add(new TraderWeapon(Weapon.REINFORCED_KNIFE, 200, 5));
        this.traderWeapon.add(new TraderWeapon(Weapon.REINFORCED_CLEAVER, 300, 5));
        this.traderWeapon.add(new TraderWeapon(Weapon.RIFLE, 700, 1));
        this.traderWeapon.add(new TraderWeapon(Weapon.ADVANCERIFLE, 1500, 1));
    }

    @Override 
    public String[] getDescription() {
        String[] desc = {
            "You push through the door marked SERVICE ACCESS.",
            "",
            "The noise of the Concourse fades behind you.",
            "",
            "Concrete walls. Exposed wiring.",
            "The air smells of oil and burnt metal.",
            "",
            "A reinforced door blocks the end of the corridor.",
            "",
            "A voice comes from inside.",
            "",
            "\"Hold.\"",
            "",
            "The door opens halfway.",
            "",
            "A man sits behind a heavy workbench.",
            "Rifles laid out in neat rows.",
            "Magazines stacked. Parts labeled.",
            "",
            "Nothing here is decorative.",
            "",
            "He studies you without standing.",
            "",
            "\"Joe.\"",
            "",
            "\"You looking for weapons or trouble?\""
        };
        return desc;
    }

    @Override
    public String[] getDescriptionVisited() {
        String[] desc = {
            "You head back into the Service Corridor.",
            "",
            "The generator hum continues overhead.",
            "",
            "Joe is at his bench, reassembling a rifle.",
            "",
            "He glances up briefly.",
            "",
            "\"What do you need?\""
        };
        return desc;
    }

    @Override
    public void trade(GameContext gc) {
        int input;
        Boolean hasWeapon = false;
        Scanner scnr = new Scanner(System.in);

        while (true) {
            hasWeapon = false;

            System.out.println("==================================================");
            System.out.println("TRADING - JOE'S WEAPONS & ARMS");
            System.out.println("==================================================");
            for (int i = 0; i < traderWeapon.size(); ++i) {
                System.out.print("[");
                System.out.print(i + 1);
                System.out.println("] " + traderWeapon.get(i).getWeapon().getName() + " DMG - " + traderWeapon.get(i).getWeapon().getDamage() + " Price - " + traderWeapon.get(i).getPrice() + " Amount - " + traderWeapon.get(i).getAmount());
            }
            System.out.println("--------------------------------------------------");
            System.out.println("[0] Return");
            System.out.println("==================================================");

            input = scnr.nextInt();
            if (input > traderWeapon.size() + 1 || input < 0) {
                System.out.println("--------------------------------------------------");
                System.out.println("Select from avaliable actions");
                System.out.println("--------------------------------------------------");
            }

            if (input == 0) return;

            for (Weapon weapon : gc.inventory.getWeaponSling()) {
                if (weapon == traderWeapon.get(input - 1).getWeapon()) {
                    hasWeapon = true;
                    break;
                }
            }

            if (hasWeapon == true) {
                alreadyOwn();
                continue;            
            }

            if (traderWeapon.get(input - 1).getAmount() <= 0) {
                noStock();
                continue;
            }

            if (gc.inventory.getMoney() < traderWeapon.get(input - 1).getPrice()) {
                noMoney();
                continue;
            } else {
                gc.inventory.useMoney(traderWeapon.get(input - 1).getPrice());
                gc.inventory.findWeapon(traderWeapon.get(input - 1).getWeapon());
                traderWeapon.get(input - 1).sell();
                System.out.println("--------------------------------------------------");
                System.out.println("+ " + traderWeapon.get(input - 1).getWeapon().getName());
                System.out.println("--------------------------------------------------");
            }
        }
    }

}
