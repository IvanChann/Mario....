package game.items;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.positions.GameMap;
import game.actions.ConsumeAction;
import game.statuses.Status;

import java.util.ArrayList;
import java.util.List;

/**
 * Class representing the Super Mushroom item
 * @author Andy Ouyang
 */
public class SuperMushroom extends Item implements Consumable, Purchasable{
    private int price = 400;
    public static final int HP_INCREASE = 50;

    /***
     * Constructor.
     */
    public SuperMushroom() {

        super("Super Mushroom", '^', true);
    }

    /** Adds the effects of consuming the item to the player
     * @see Consumable#consumedBy(Actor, GameMap)
     * @param actor The actor who consumes the item
     * @param map The map containing the actor
     */
    @Override
    public void consumedBy(Actor actor, GameMap map) {
        if (map.locationOf(actor).getItems().contains(this)) {
            map.locationOf(actor).removeItem(this);
        }
        actor.increaseMaxHp(SuperMushroom.HP_INCREASE);
        actor.addCapability(Status.TALL);
        actor.removeItemFromInventory(this);

    }

    /**
     * Returns a list with a ConsumeAction inside it
     * @return a list of actions that can be done to this Super Mushroom
     */
    public List<Action> getAllowableActions() {
        ArrayList<Action> actions = new ArrayList<>();
        actions.add(new ConsumeAction(this));
        return actions;
    }

    /**
     * Adds the purchased item to the actor's inventory.
     * purchased items cannot be dropped
     * @param actor The actor who purchased the item
     */
    @Override
    public void purchasedBy(Actor actor) {
        this.togglePortability();
        actor.addItemToInventory(this);
    }

    @Override
    public int getPrice() {
        return price;
    }
}
