package combat;
import player.Stats;
import java.util.Random;

public class Stealth {
    private Random random = new Random();

    public boolean sneakAttempt(Stats playerStat) {
        int chance;
        int base = 10;
        int boost = 8 * playerStat.getStealth();
        chance = random.nextInt(1, 100);

        if (chance <= base) {
            return true;
        } else {
            return false;
        }

    }
}
