package core;
public abstract class Character {
    protected String name, currWeapon;
    protected int health;
    protected int damage;

    public Character() {
        this.name = "Junting Xie";
        this.health = 100;
        this.damage = 0;
    }

    public Character(String name) {
        this.name = name;
    }

    public Character(String name, int health, int damage) {
        this.name = name;
        this.health = health;
        this.damage = damage;
    }

    public Character(String name, int health, int damage, String weapon) {
        this.name = name;
        this.health = health;
        this.damage = damage;
        this.currWeapon = weapon;
    }

    public String getName() {
        return this.name;
    }

    public int getDamage() {
        return damage;
    }

    public int getHealth() {
        return health;
    }

    public String getWeapon() {
        return currWeapon;
    }

    public void takeDamage(int damageTaken) {
        health -= damageTaken;
    }

    public void healBy(int healing) {
        health += healing;
    }


}