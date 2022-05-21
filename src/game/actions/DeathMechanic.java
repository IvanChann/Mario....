package game.actions;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.positions.GameMap;

public class DeathMechanic {
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
