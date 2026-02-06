package combat;
import core.*;
import core.Character;
import control.Control;
public class Combat {

    //character one attacks character two
    public void attack(Character attacker, Character defender) {
        defender.takeDamage(attacker.getDamage());
    }

    public void fighting(Character attacker, Character defender, Dungeon map) {
        while (true) {
            for (int i = 0; i < map.enemyCount(); ++i) {
                
            }
        }
    }

    
}