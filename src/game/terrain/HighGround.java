package game.terrain;


import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Exit;
import edu.monash.fit2099.engine.positions.Ground;
import edu.monash.fit2099.engine.positions.Location;
import game.items.Coin;
import game.statuses.Status;

import java.util.List;

/**
 * Base class for all high ground's
 */
public abstract class HighGround extends Ground {
    HighGround highGround;
    private int damage;
    private double successRate;


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
    public boolean canActorEnter(Actor actor) {
        if (actor.hasCapability(Status.GLOWING)){
            return true;
        }
        return false;
    }

    public double getSuccessRate(){
        return successRate;
    }
    public int damage(){
        return damage;
    };

    @Override
    public void tick(Location location) {
        if (location.containsAnActor() && location.getActor().hasCapability(Status.GLOWING)){
            location.setGround(new Dirt());
            location.addItem(new Coin(5));
        }
    }
}
