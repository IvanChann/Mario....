package game.actions;

import game.statuses.Status;
import game.terrain.HighGround;
import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Location;


/**
 * Class representing the action of jumping to HighGround
 */
public class JumpAction extends Action {
    /**
     * The HighGround being jumped to
     */
    private final HighGround highGround;

    /**
     * The direction of the HighGround
     */
    private final String direction;

    /**
     * The location of the HighGround
     */
    private final Location jumpLocation;

    /**
     * Constructor for JumpAction
     * @param highGround HighGround being jumped to
     * @param jumpLocation The location being jumped to
     * @param direction The direction of the jump
     */
    public JumpAction(HighGround highGround, Location jumpLocation, String direction){
        this.highGround = highGround;
        this.jumpLocation = jumpLocation;
        this.direction = direction;
    }

    /**
     * @see Action#execute(Actor, GameMap) 
     */
    @Override
    public String execute(Actor actor, GameMap map) {
        if (Math.random() < highGround.getSuccessRate() || actor.hasCapability(Status.TALL)){
            map.moveActor(actor, jumpLocation);
            return "Woohoo! " + actor + " jumps successfully.";
        }else {
            actor.hurt(highGround.damage());
            return "Oh no!" + actor + " failed to make the jump.";
        }
    }

    /**
     * @see Action#menuDescription(Actor) 
     */
    @Override
    public String menuDescription(Actor actor) {
        return actor + " can jump " + highGround.getClass().getSimpleName() + " at " + direction;
    }
}
