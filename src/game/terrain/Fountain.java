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

    public void reduceCapacity(){
        capacity -= Utils.FOUNTAIN_FILL_COST;
    }

    public String getDescription(){
        return this + " Fountain " + "(" + capacity + "/" + Utils.FOUNTAIN_MAX_CAPACITY + ")";
    }

    public abstract void giveEffects(Drinker actor);


}
