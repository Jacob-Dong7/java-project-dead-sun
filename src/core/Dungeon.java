package core;

public class Dungeon {
    protected String name;
    protected int enemyCount;
    protected String enemyType, bossType;
    protected String[] description;
    protected boolean looted; //used to insure one dungeon can be looted once

    protected boolean boss;

    public Dungeon(String name, int enemyCount, String enemyType, boolean boss, String[] description) {
        this(name, enemyCount, enemyType, boss, description, null);
    }

    public Dungeon(String name, int enemyCount, String enemyType, boolean boss, String[] description, String bossType) {
        this.name = name;
        this.enemyCount = enemyCount;
        this.enemyType = enemyType;
        this.boss = boss;
        this.description = description;
        this.looted = false;
        this.bossType = bossType;
    }

    public boolean isLooted() {
        return looted;
    }

    public void loot() {
        looted = true;
    }

    public void removeEnemy(int num) {
        this.enemyCount -= num;
    }
    public String[] getDescription() {
        return description;
    }

    public void removeBoss() {
        this.boss = false;
        this.bossType = null;
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

    public int enemyCount() {
        return enemyCount;
    }

    public String getBossType() {
        return bossType;
    }

}