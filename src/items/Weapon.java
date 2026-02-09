package items;
public enum Weapon {
    KNIFE(10, "Rusted Shiv"),
    CLEAVER(15, "Chipped Cleaver"),
    PISTOL(20, "Rusted Type 92 Compact"),
    RIFLE(30, "Old Type 56 Rifle"),
    ADVANCERIFLE(50, "Type 95 Rifle");


    final int damage;
    final String name;

    Weapon(int value, String name) {
        this.damage = value;
        this.name = name;
    }

    public int getDamage() {
        return this.damage;
    }

    public String getName() {
        return this.name;
    }
}
