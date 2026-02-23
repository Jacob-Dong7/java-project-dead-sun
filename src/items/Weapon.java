package items;
public enum Weapon {
    KNIFE(25, "Shiv", false),
    CLEAVER(30, "Cleaver", false),
    PISTOL(35, "Homemade Pistol", true),
    RIFLE(45, "Homemade Assualt Rifle", true),
    ADVANCERIFLE(60, "Old World Rifle", true);


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
