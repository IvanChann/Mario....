package game.terrain;

import edu.monash.fit2099.engine.actions.Action;import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Location;
import game.actions.ConsumeAction;
import game.actions.RefillAction;
import game.actors.Drinker;
import game.items.Water;
import game.statuses.Status;

public class HealthFountain extends Fountain{
    private int healing = 50;
    /**
     * Constructor.
     *
     */
    public HealthFountain() {
        super('H');
    }



    @Override
    public void giveEffects(Drinker actor) {
        actor.increaseHitPoints(healing);   ;
    }

    public String toString(){
        return "Healing";
    }
}
