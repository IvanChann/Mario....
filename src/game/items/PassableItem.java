package game.items;

import edu.monash.fit2099.engine.actors.Actor;

/**
 * Interface that all items that can be passed will implement
 */
public interface PassableItem {
    /**
     * Handles adding an item to the receiving actor's inventory and removing it from
     * the passing actor's inventory. Or can have custom implementations for special items
     * like Bottle
     * @param receivingActor
     * @param passingActor
     */
    void passItem(Actor receivingActor, Actor passingActor);
}
