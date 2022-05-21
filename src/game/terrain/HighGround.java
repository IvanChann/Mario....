package game.terrain;


import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Ground;
import edu.monash.fit2099.engine.positions.Location;
import game.actions.JumpAction;
import game.items.Coin;
import game.statuses.Status;


/**
 * Base class for all high grounds
 */
public abstract class HighGround extends Ground {
    /**
     * Damage taken when failing jump
     */
    private final int damage;

    /**
     * Success Rate of jump
     */
    private final double successRate;


    /**
     * Constructor for High Ground's
     * @param displayChar Display character
     * @param damage Damage taken when failed jump
     * @param successRate Rate of success of jump
     * @see Ground#Ground(char)
     */
    public HighGround(char displayChar, int damage, double successRate){
        super(displayChar);
        this.damage = damage;
        this.successRate = successRate;
    }

    /**
     * Adds the jump action for adjacent actors
     * @param actor the Actor acting
     * @param location the current Location
     * @param direction the direction of the Ground from the Actor
     * @return an ActionList
     * @see Ground#allowableActions(Actor, Location, String)
     */
    @Override
    public ActionList allowableActions(Actor actor, Location location, String direction) {
        ActionList actions = new ActionList();
        if (!actor.hasCapability(Status.GLOWING) && !location.containsAnActor()){
            actions.add(new JumpAction(this, location, direction));
        }
        return actions;
    }

    /**
     * If the actor has PowerStar Active they can walk on HighGround
     * @param actor the Actor to check
     * @return if the actor can enter or not
     */
    @Override
    public boolean canActorEnter(Actor actor) {
        return actor.hasCapability(Status.GLOWING) || actor.hasCapability(Status.CAN_FLY);
    }

    /**
     *
     * @return successRate
     */
    public double getSuccessRate(){
        return successRate;
    }

    /**
     *
     * @return damage
     */
    public int damage(){
        return damage;
    }

    /**
     * Converts current ground to Dirt and adds a coin to the current location if a player is under the
     * effects of Power Star
     * @param location The location of the Ground
     */
    @Override
    public void tick(Location location) {
        if (location.containsAnActor() && location.getActor().hasCapability(Status.GLOWING)){
            location.setGround(new Dirt());
            location.addItem(new Coin(5));
        }
    }
}
