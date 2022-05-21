package game.items;

import edu.monash.fit2099.engine.items.Item;
import game.statuses.Status;

public class Key extends Item {
    /***
     * Constructor.
     */
    public Key() {
        super("Key", 'k', true);
        this.addCapability(Status.CAN_UNLOCK);
    }
}