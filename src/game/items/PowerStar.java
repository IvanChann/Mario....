package game.items;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Location;
import game.actions.ConsumeAction;
import game.statuses.Status;

import java.util.ArrayList;
import java.util.List;

/**
 * Class representing the Power Star item
 * @author Andy Ouyang
 */
public class PowerStar extends Item implements Consumable, Purchasable{
    /**
     * A timer representing how many turns power star will last
     */
    private int timer = 10;
    /**
     * Price of power star
     */
    private int price = 600;
    /**
     * Whether the Power Star has been consumed yet
     */
    private boolean consumed = false;
    /**
     * The amount of healing of power star
     */
    public static final int HEALING = 200;

    /***
     * Constructor.
     */
    public PowerStar() {

        super("Power Star", '*', true);

    }
    /**
     * Ticks down timer each turn, removes from inventory at 0
     * @param currentLocation The location of the actor carrying this Item.
     * @param actor The actor carrying this Item.
     */
    @Override
    public void tick(Location currentLocation, Actor actor) {
        this.timer -= 1;
        System.out.println(timer + " turns of power star remaining");
        if (this.timer == 0){
            actor.removeItemFromInventory(this);
        }
    }

    /**
     * Ticks down timer each turn, removes from location at 0
     * @param currentLocation The location of the ground on which we lie.
     */
    @Override
    public void tick(Location currentLocation){
        this.timer -= 1;
        System.out.println(timer + " turns of power star remaining");
        if (this.timer == 0){
            currentLocation.removeItem(this);
        }

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
            actor.addItemToInventory(this);
        }
        this.togglePortability();       // consumed item cannot be dropped
        this.consumed = true;
        actor.heal(PowerStar.HEALING);
        this.addCapability(Status.GLOWING);
        this.timer = 10;
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

    /**
     * Returns a list with a ConsumeAction inside it
     * @return a list of actions that can be done to this Power Star
     */
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





