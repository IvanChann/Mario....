package game.items;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.positions.GameMap;
import game.actions.ConsumeAction;
import game.statuses.Status;

import java.util.ArrayList;
import java.util.List;

public class SuperMushroom extends Item implements Consumable, Purchasable{
    private int price = 400;

    /***
     * Constructor.
     * @param portable true if and only if the Item can be picked up
     */
    public SuperMushroom(boolean portable) {

        super("Super Mushroom", '^', portable);
    }


    @Override
    public void consumedBy(Actor actor, GameMap map) {
        if (map.locationOf(actor).getItems().size() != 0) {
            map.locationOf(actor).removeItem(this);
        }
        actor.increaseMaxHp(50);
        actor.addCapability(Status.TALL);
        // IMPLEMENT 100% JUMP HERE
        actor.removeItemFromInventory(this);

    }
    public List<Action> getAllowableActions() {
        ArrayList<Action> actions = new ArrayList<>();
        actions.add(new ConsumeAction(this));
        return actions;
    }

    @Override
    public void purchasedBy(Actor actor) {
        actor.addItemToInventory(this);
    }

    @Override
    public int getPrice() {
        return price;
    }
}
