package game.terrain;

import edu.monash.fit2099.engine.actors.Actor;
import game.actors.Drinker;

public class PowerFountain extends Fountain{
    private int increasedAttack =15;
    /**
     * Constructor.
     *
     */
    public PowerFountain() {
        super('P');
    }

    @Override
    public void giveEffects(Drinker drinker) {
        drinker.increaseBaseAttack(increasedAttack);

    }

    public String toString(){
        return "Power";
    }
}
