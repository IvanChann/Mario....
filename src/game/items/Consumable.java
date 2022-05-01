package game.items;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;

/**
 * Interface for consumable items
 */
public interface Consumable {
    /**
     * Implements the effects of some item
     * @param actor actor who consumes the item
     * @param map map containing the actor
     */
    void consumedBy(Actor actor, GameMap map);
}
