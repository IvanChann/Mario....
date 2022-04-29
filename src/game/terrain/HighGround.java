package game.terrain;


import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Exit;
import edu.monash.fit2099.engine.positions.Ground;
import edu.monash.fit2099.engine.positions.Location;
import game.actions.JumpAction;
import game.statuses.Status;

import java.util.List;

/**
 * Base class for all high ground's
 */
public abstract class HighGround extends Ground {
    HighGround highGround;


    /**
     * Constructor for High Ground's
     * @param displayChar
     * @param damage
     * @param successRate
     */
    public HighGround(char displayChar, int damage, double successRate){
        super(displayChar);
        this.addCapability(Status.JUMP);
    }


    /**
     * The amount of damage the ground will inflict on an unsuccessful jump
     *
     * @return the damage, in hitpoints
     */

    public abstract int damage(int damage);

    /**
     * The success rate for each jump for this ground
     *
     * @return the success rate, in %/100
     */
    public abstract double successRate(double successRate);

}
