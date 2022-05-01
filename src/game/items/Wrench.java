package game.items;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.weapons.WeaponItem;
import game.statuses.Status;

/**
 * Class representing the Wrench item
 * @author Andy Ouyang
 */
public class Wrench extends WeaponItem implements Purchasable{
    /***
     * Constructor. Wrench has the ability to destroy Koopa shells
     */
    public Wrench() {

        super("Wrench", 'w', 50, "smashes", 80);
        this.addCapability(Status.CAN_DESTROY_SHELL);
    }

    /**
     * Adds the item to the player's inventory
     * @param actor Actor who bought the item
     */
    @Override
    public void purchasedBy(Actor actor) {
        actor.addItemToInventory(this);
    }

    @Override
    public int getPrice() {
        return 200;
    }
}
