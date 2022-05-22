package game.terrain;

import edu.monash.fit2099.engine.actions.Action;import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Location;
import game.actions.ConsumeAction;
import game.actions.RefillAction;
import game.actors.Drinker;
import game.items.Water;
import game.statuses.Status;

/**
 * Class representing the Health Fountain
 */
public class HealthFountain extends Fountain{
    private int healing = 50;
    /**
     * Constructor.
     *
     */
    public HealthFountain() {
        super('H');
    }


    /**
     * @see Fountain#giveEffects(Drinker)
     * @param actor Drinker who will receive the effects
     */
    @Override
    public void giveEffects(Drinker actor) {
        actor.increaseHitPoints(healing);   ;
    }

    public String toString(){
        return "Healing";
    }
}
