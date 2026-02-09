package items;

public enum Healing {
    BANDAGE(10, "Bandage"),
    MEDKIT(20, "Medkit"),
    SYRINGE(30, "Medical Syringe");

    final int value;
    final String name;
    

    Healing(int value, String name) {
        this.value = value;
        this.name = name;
    }

    public int getHeal() {
        return this.value;
    }

    public String getName() {
        return this.name;
    }

    
}
