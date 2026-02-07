package core;
import java.util.*;

public class Dungeon {
    protected String name;
    protected int enemyCount;
    protected String enemyType;
    protected int ammo, heal, money, scraps;
    protected String[] description;

    protected boolean boss;

    public Dungeon(String name, int enemyCount, String enemyType, int ammo, int heal, int money, int scraps, boolean boss, String[] description) {
        this.name = name;
        this.enemyCount = enemyCount;
        this.enemyType = enemyType;
        this.ammo = ammo;
        this.heal = heal;
        this.money = money;
        this.scraps = scraps;
        this.boss = boss;
        this.description = description;
    }

    public void removeEnemy(int num) {
        this.enemyCount -= num;
    }
    public String[] getDescription() {
        return description;
    }

    public boolean bossPresent() {
        return boss;
    }

    public String getName() {
        return name;
    }

    public String getEnemyType() {
        return enemyType;
    }



    public int ammo() {
        return ammo;
    }
    public int heal() {
        return heal;
    }
    public int scraps() {
        return scraps;
    }
    public int money() {
        return money;
    }
    public int enemyCount() {
        return enemyCount;
    }

}