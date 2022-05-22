package game.behaviours;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;

import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Ground;
import game.statuses.Status;

/**
 * Class representing the Drink Behaviour for enemies
 */
public class DrinkBehaviour implements Behaviour{

    /**
     * Generates a ConsumeAction for the water in a fountain if the actor is standing on top of it
     * @see Behaviour#getAction(Actor, GameMap)
     * @param actor the Actor acting
     * @param map the GameMap containing the Actor
     * @return A ConsumeAction for the water
     */
    @Override
    public Action getAction(Actor actor, GameMap map) {
        Ground potentialFountain = map.locationOf(actor).getGround();
        if (map.locationOf(actor).getGround().hasCapability(Status.CAN_DRINK_FROM) && potentialFountain.allowableActions(actor, map.locationOf(actor), "").size() != 0){
            return potentialFountain.allowableActions(actor, map.locationOf(actor), "").get(0);
        }
        return null;
    }
}
