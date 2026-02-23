package items;

public enum Healing {
    BANDAGE(20, "Bandage", "A roll of worn gauze to wrap cuts and stop bleeding. Restores 20 HP."),
    MEDKIT(30, "Medkit", "A compact field kit with antiseptic and dressings for serious wounds. Restores 30 HP."),
    SYRINGE(40, "Medical Syringe","A pre-filled combat injector that forces your body to stabilize. Restores 40 HP.");

    final int value;
    final String name, description;
    

    Healing(int value, String name, String description) {
        this.value = value;
        this.name = name;
        this.description = description;
    }

    public int getHeal() {
        return this.value;
    }

    public String getName() {
        return this.name;
    }

    public int getValue() {
        return value;
    }

    public String getDescription() {
        return this.description;
    }

    
}
