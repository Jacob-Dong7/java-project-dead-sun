package core;

import items.Weapon;
public abstract class Character {
    protected String name;
    protected int health;
    protected int damage;
    protected Weapon currWeapon;

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

    public Character(String name, int health, int damage, Weapon weapon) {
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

    public Weapon getWeapon() {
        return currWeapon;
    }

    public void switchWeapon(Weapon newWeapon) {
        this.currWeapon = newWeapon;
    }

    public void takeDamage(int damageTaken) {
        health -= damageTaken;
    }

    public void healBy(int healing) {
        health += healing;
    }


}