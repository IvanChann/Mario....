package game.terrain;


import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Ground;
import edu.monash.fit2099.engine.positions.Location;
import game.actions.JumpAction;
import game.items.Coin;
import game.statuses.Status;


/**
 * Base class for all high ground's
 */
public abstract class HighGround extends Ground {
    private final int damage;
    private final double successRate;


    /**
     * Constructor for High Ground's
     * @param displayChar
     * @param damage
     * @param successRate
     */
    public HighGround(char displayChar, int damage, double successRate){
        super(displayChar);
        this.damage = damage;
        this.successRate = successRate;
    }

    @Override
    public ActionList allowableActions(Actor actor, Location location, String direction) {
        ActionList actions = new ActionList();
        if (!location.containsAnActor() && !actor.hasCapability(Status.GLOWING)){
            actions.add(new JumpAction(this, location, direction));
        }
        return actions;
    }

    @Override
    public boolean canActorEnter(Actor actor) {
        return actor.hasCapability(Status.GLOWING);
    }

    public double getSuccessRate(){
        return successRate;
    }

    public int damage(){
        return damage;
    }

    @Override
    public void tick(Location location) {
        if (location.containsAnActor() && location.getActor().hasCapability(Status.GLOWING)){
            location.setGround(new Dirt());
            location.addItem(new Coin(5));
        }
    }
}
