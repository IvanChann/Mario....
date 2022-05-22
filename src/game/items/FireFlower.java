package game.items;

import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Location;
import game.actions.ConsumeAction;
import game.statuses.Status;

import java.util.ArrayList;
import java.util.List;

public class FireFlower extends Item implements Consumable{

    private int timer = 20;

    private boolean consumed = false;
    /***
     * Constructor.
     */
    public FireFlower() {
        super("Fire Flower", 'f', true);
    }

    @Override
    public void consumedBy(Actor actor, GameMap map) {
        if (map.locationOf(actor).getItems().contains(this)) {
            map.locationOf(actor).removeItem(this);
            actor.addItemToInventory(this);
        }
        this.togglePortability();       // consumed item cannot be dropped
        this.consumed = true;
        this.addCapability(Status.FIRE_ATTACK);
    }
    /**
     * Ticks down timer each turn, removes from inventory at 0,
     * then remove it from the inventory upon reset
     * @param currentLocation The location of the actor carrying this Item.
     * @param actor The actor carrying this Item.
     */
    @Override
    public void tick(Location currentLocation, Actor actor) {
        if (actor.hasCapability(Status.FIRE_ATTACK) && this.consumed){

            this.timer -= 1;
            System.out.println(timer + " turns of fire attack remaining");
        }
        if (this.timer == 0){
            actor.removeCapability(Status.FIRE_ATTACK);
            actor.removeItemFromInventory(this);
        }
    }

    @Override
    public List<Action> getAllowableActions() {
        if (!consumed) {
            ArrayList<Action> actions = new ArrayList<>();
            actions.add(new ConsumeAction(this));
            return actions;
        }
        return super.getAllowableActions();
    }
}
