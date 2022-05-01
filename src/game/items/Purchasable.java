package game.items;

import edu.monash.fit2099.engine.actors.Actor;

/**
 * Interface for items that are purchasable
 */
public interface Purchasable {
    /**
     * Adds the purchased item to the actor's inventory
     * @param actor
     */
    void purchasedBy(Actor actor);

    int getPrice();
}
