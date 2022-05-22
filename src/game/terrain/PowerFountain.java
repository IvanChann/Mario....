package game.terrain;

import game.actors.Drinker;

/**
 * Class representing the Power Fountain
 */
public class PowerFountain extends Fountain{
    private int increasedAttack =15;
    /**
     * Constructor.
     *
     */
    public PowerFountain() {
        super('P');
    }

    /**
     * @see Fountain#giveEffects(Drinker)
     * @param drinker
     */
    @Override
    public void giveEffects(Drinker drinker) {
        drinker.increaseBaseAttack(increasedAttack);

    }

    public String toString(){
        return "Power";
    }
}
