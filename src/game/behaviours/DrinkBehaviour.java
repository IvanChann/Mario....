package game.behaviours;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;

import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Ground;
import game.statuses.Status;

public class DrinkBehaviour implements Behaviour{

    @Override
    public Action getAction(Actor actor, GameMap map) {
        Ground potentialFountain = map.locationOf(actor).getGround();
        if (map.locationOf(actor).getGround().hasCapability(Status.CAN_DRINK_FROM) && potentialFountain.allowableActions(actor, map.locationOf(actor), "").size() != 0){
            return potentialFountain.allowableActions(actor, map.locationOf(actor), "").get(0);
        }
        return null;
    }
}
