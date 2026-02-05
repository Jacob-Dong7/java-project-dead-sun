package core;
public abstract class Character {
    protected String name;
    protected int health;
    protected int damage;

    public Character() {
        this.name = "No name";
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

    public String getName() {
        return this.name;
    }

}