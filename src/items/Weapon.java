package items;
public enum Weapon {
    KNIFE(20, "Rusted Shiv", false),
    CLEAVER(25, "Chipped Cleaver", false),
    PISTOL(30, "Rusted Type 92 Compact", true),
    RIFLE(35, "Old Type 56 Rifle", true),
    ADVANCERIFLE(50, "Type 95 Rifle", true);


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
