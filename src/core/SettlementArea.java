package core;
import friendly.*;
public class SettlementArea {
    private boolean visited;
    private Trader trader;
    private String[] desc;
    private String areaName;

    public SettlementArea(String name, Trader trader, String[] desc) {
        this.areaName = name;
        this.visited = false; 
        this.trader = trader;
        this.desc = desc;
    }

    public Trader getTrader() {
        return trader;
    }
    
    public void visit() {
        this.visited = true;
    }

    public String getName() {
        return areaName;
    }

    public boolean visited() {
        return visited;
    }

    public void getDescription() {
        printDescription(desc);
    }

    public void printDescription(String[] prompt) {
        System.out.println("==================================================");
        System.out.println("LOCATION: " + getName());
        System.out.println("==================================================");
        for (int i = 0; i < prompt.length; ++i) {
            System.out.println(prompt[i]);
        }
        System.out.println("==================================================");
    }
}
