package core;
import friendly.*;
public class SettlementArea {
    private boolean visited;
    private Trader trader;
    private String[] desc, descVisited;
    private String areaName;

    public SettlementArea(String name, Trader trader, String[] desc, String[] descVisited) {
        this.areaName = name;
        this.visited = false; 
        this.trader = trader;
        this.desc = desc;
        this.descVisited = descVisited;
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

    public void getDescriptionVisited() {
        printDescription(descVisited);
    }

    public void printDescription(String[] prompt) {
        System.out.println("==================================================");
        System.out.println("LOCATION: " + getName());
        System.out.println("==================================================");
        for (int i = 0; i < prompt.length; ++i) {
            System.out.println(prompt[i]);
        }
    }
}
