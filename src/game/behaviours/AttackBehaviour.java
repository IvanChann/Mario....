package game.behaviours;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Exit;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Location;
import game.actions.FireAttack;
import game.actions.NormalAttack;
import game.statuses.Status;

public class AttackBehaviour implements Behaviour {

    public static final Integer PRIORITY = 10;

    /**
     * Scans if there is a hostile actor nearby, if there is, then prepares to attack
     * @param actor the Actor acting
     * @param map the GameMap containing the Actor
     * @return an action to attack the other actor
     */
    @Override
    public Action getAction(Actor actor, GameMap map) {

        for (Exit exit : map.locationOf(actor).getExits()) {
            Location destination = exit.getDestination();
            if (destination.containsAnActor() && destination.getActor().hasCapability(Status.HOSTILE_TO_ENEMY)){
                if (actor.hasCapability(Status.FIRE_ATTACK)){
                    return new FireAttack(destination.getActor(), exit.getName());
                }
                else{
                    return new NormalAttack(destination.getActor(), exit.getName());
                }
            }
        }
        return null;
    }
}
