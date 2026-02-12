package core;
import items.*;
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
        System.out.println("==================================================");
        System.out.println("Equipped Weapon: " + currWeapon.getName());
        System.out.println("==================================================");
    }

    public void takeDamage(int damageTaken, Weapon weapon) {
        health -= damageTaken;
    }

    public void healBy(int factor) {
        if (health + factor >= 100) {
            health = 100;
        } else {
            health += factor;
        }
    }

    public void setHealth(int health) {
        this.health = health;
    }
    public void killed(Weapon weapon) {
        System.out.println("The target is dead");
    }

    public boolean tryAttack() {
        System.out.println("The character attacks");
        return true;
    }
}