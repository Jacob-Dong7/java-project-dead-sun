package friendly;

import java.util.Scanner;

import core.GameContext;
import items.*;

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
            "You step into Central Concourse.",
            "",
            "The ceiling arches high overhead, skylights patched with metal sheets.",
            "Light filters down in dull grey beams.",
            "",
            "Balconies above are reinforced with scrap barricades.",
            "You can feel people watching.",
            "",
            "The old information kiosk sits in the center of the floor.",
            "Crates are stacked around it - canned food, ammunitions, medicines, cloth bundles.",
            "",
            "A stove burns quietly behind the counter.",
            "",
            "A woman stands there sorting inventory.",
            "Calm. Methodical.",
            "",
            "She looks up at you.",
            "",
            "\"Welcome to New Concourse, we don't get that many newcomers nowadays\" she says.",
            "",
            "Her eyes flick briefly to your hands, your gear, your posture.",
            "",
            "\"Names Clara.\"",
            "\"You buying?\"",
            "Your stomach answers before you do.",
            "",
            "She slides a dented tin of navy beans and a bottle of purified water across the counter..",
            "\"Food and water for 10.\"",
            "",
            "You hand over what you can spare.",
            "You sit on the edge of the kiosk and eat.",
            "The food is plain. Warm enough.",
            "The water is clean.",
            "",
            "The ache in your gut dulls.",
            "",
            "This is the settlement's main trading floor.",
            "",
            "Beyond the far wall, a sign reads: SERVICE ACCESS.",
            "A heavier section of the mall lies deeper inside.",
            "Clara is already back to sorting inventory.",
            "",
            "\"You need anything else?\""
    };
    return desc;

    }

    @Override
    public String[] getDescriptionVisited() {
        String[] desc = {
            "You step back into Central Concourse.",
            "",
            "The stove is burning.",
            "Traders move between stacked crates.",
            "",
            "Clara stands behind the kiosk, counting inventory.",
            "",
            "She looks up briefly.",
            "",
            "\"Back again.\"",
            "",
            "\"What do you need?\""
        };
        return desc;    
    }

    @Override
    public void trade(GameContext gc) {
        int input;
        Scanner scnr = new Scanner(System.in);

        while (true) {

            System.out.println("==================================================");
            System.out.println("TRADING - CONCOURSE PROVISIONS");
            System.out.println("==================================================");
            for (int i = 0; i < traderInventory.size(); ++i) {
                System.out.print("[");
                System.out.print(i + 1);
                System.out.println("] " + traderInventory.get(i).getItem().getName() + " DMG - " + traderWeapon.get(i).getWeapon().getDamage() + " Price - " + traderWeapon.get(i).getPrice() + " Amount - " + traderWeapon.get(i).getAmount());
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