package game.items;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.weapons.WeaponItem;
import game.statuses.Status;

public class Wrench extends WeaponItem implements Purchasable{
    /***
     * Constructor.
     */
    public Wrench() {

        super("Wrench", 'w', 50, "smashes", 80);
        this.addCapability(Status.CAN_DESTROY_SHELL);
    }

    @Override
    public void purchasedBy(Actor actor) {
        actor.addItemToInventory(this);
    }

    @Override
    public int getPrice() {
        return 200;
    }
}
