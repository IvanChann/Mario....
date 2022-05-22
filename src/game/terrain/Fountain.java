package game.terrain;

import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Ground;
import edu.monash.fit2099.engine.positions.Location;
import game.Utils;
import game.actions.ConsumeAction;
import game.actions.RefillAction;
import game.actors.Drinker;
import game.items.Water;
import game.managers.BottleManager;
import game.statuses.Status;

/**
 * Abstract class representing a Fountain
 */
public abstract class Fountain extends Ground {
    private int capacity = Utils.FOUNTAIN_MAX_CAPACITY;
    private int refillTimer = Utils.FOUNTAIN_COOLDOWN_TIMER;
    /**
     * Constructor.
     *
     * @param displayChar character to display for this type of terrain
     */
    public Fountain(char displayChar) {
        super(displayChar);
        this.addCapability(Status.CAN_DRINK_FROM);
    }

    /**
     * Lets an actor refill from this fountain or drink from this fountain depending on
     * the capacity of the fountain
     * @see Ground#allowableActions(Actor, Location, String)
     * @param actor the Actor acting
     * @param location the current Location
     * @param direction the direction of the Ground from the Actor
     * @return Actions that can be performed on this fountain
     */
    @Override
    public ActionList allowableActions(Actor actor, Location location, String direction) {
        ActionList actions = new ActionList();
        if (capacity == 0){
            return actions;
        }
        if (location.containsAnActor() && location.getActor().equals(actor)){
            if (BottleManager.getInstance().checkActorHasBottle(actor.toString()) && !BottleManager.getInstance().checkIfMaxCapacity(actor.toString())){
                actions.add(new RefillAction(this));
            }
        }
        if (location.containsAnActor() && !location.getActor().hasCapability(Status.HOSTILE_TO_ENEMY)) {
            actions.add(new ConsumeAction(new Water(this)));
        }
        return actions;
    }

    /**
     * Checks if Fountain is empty, if it is start the refresh timer
     * @see Ground#tick(Location)
     * @param location The location of the Ground
     */
    @Override
    public void tick(Location location) {
        if (refillTimer == 0){
            capacity = Utils.FOUNTAIN_MAX_CAPACITY;
            refillTimer = Utils.FOUNTAIN_COOLDOWN_TIMER;
        }
        if (capacity == 0){
            refillTimer -= 1;

        }
    }

    /**
     * Reduces capacity of the fountain by a fixed amount
     */
    public void reduceCapacity(){
        capacity -= Utils.FOUNTAIN_FILL_COST;
    }

    public String getDescription(){
        return this + " Fountain " + "(" + capacity + "/" + Utils.FOUNTAIN_MAX_CAPACITY + ")";
    }

    /**
     * Gives a specific effect to the actor from drinking from this fountain. Effects vary
     * with each fountain
     * @param actor Drinker who will receive the effects
     */
    public abstract void giveEffects(Drinker actor);


}
