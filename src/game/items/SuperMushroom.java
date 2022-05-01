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
    public static final int HP_INCREASE = 50;

    /***
     * Constructor.
     */
    public SuperMushroom() {

        super("Super Mushroom", '^', true);
    }


    @Override
    public void consumedBy(Actor actor, GameMap map) {
        if (map.locationOf(actor).getItems().contains(this)) {
            map.locationOf(actor).removeItem(this);
        }
        actor.increaseMaxHp(SuperMushroom.HP_INCREASE);
        actor.addCapability(Status.TALL);
        actor.removeItemFromInventory(this);

    }
    public List<Action> getAllowableActions() {
        ArrayList<Action> actions = new ArrayList<>();
        actions.add(new ConsumeAction(this));
        return actions;
    }

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
