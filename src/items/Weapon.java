package items;
public enum Weapon {
    KNIFE(25, "Shiv", false),
    REINFORCED_KNIFE(30, "Combat Shiv", false),
    CLEAVER(29, "Cleaver", false),
    REINFORCED_CLEAVER(35, "Reinforced Cleaver", false),
    SWORD(40, "Welded Greatblade", false),
    AXE(38, "Fire Axe", false),

    PISTOL(60, "Homemade Pistol", true),
    SMG(63, "Welded Burstgun", true),
    RIFLE(80, "Homemade Assualt Rifle", true),
    ADVANCERIFLE(100, "Old World Rifle", true);
    


    final int damage;
    final String name;
    final boolean ranged;

    Weapon(int value, String name, Boolean ranged) {
        this.damage = value;
        this.name = name;
        this.ranged = ranged;
    }

    public int getDamage() {
        return this.damage;
    }

    public String getName() {
        return this.name;
    }

    public boolean isRanged() {
        return this.ranged;
    }
}
