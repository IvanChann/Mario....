package game.actions;

import game.statuses.Status;
import game.terrain.HighGround;
import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Location;



public class JumpAction extends Action {
    private HighGround highGround;
    private String direction;
    private Location jumpLocation;

    public JumpAction(HighGround highGround, Location jumpLocation, String direction){
        this.highGround = highGround;
        this.jumpLocation = jumpLocation;
        this.direction = direction;
    }
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

    @Override
    public String menuDescription(Actor actor) {
        return actor + " can jump " + highGround.getClass().getSimpleName() + " at " + direction;
    }
}
