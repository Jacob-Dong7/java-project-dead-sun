package core;
import friendly.*;
import java.util.*;

public abstract class Settlement {
    protected String name;
    protected int traderCount;
    protected ArrayList<Trader> traders;
    protected ArrayList<SettlementArea> settlementArea;

    public String getName() {
        return name;
    }

    public int getTraderCount() {
        return traderCount;
    }

    public void printDescription(String[] desc) {
        for (int i = 0; i < desc.length; ++i) {
            System.out.println(desc[i]);
        }
    }
}