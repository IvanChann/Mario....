package game.actions;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.positions.GameMap;

/**
 * Class that handles the dying/dropping items mechanic for actors in the game
 */
public class DeathMechanic {
    /**
     * Method that removes actor from the map and drops their items onto the ground
     * @param actor Actor to be removed, whose items are dropped
     * @param map Map that the actor is on
     */
    public static void death(Actor actor, GameMap map) {
        ActionList dropActions = new ActionList();
        // drop all items
        for (Item item : actor.getInventory())
            dropActions.add(item.getDropAction(actor));
        for (Action drop : dropActions)
            drop.execute(actor, map);
        // remove actor
        map.removeActor(actor);
    }
}
