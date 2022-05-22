package game.actions;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Location;
import game.terrain.WarpPipe;

/**
 * Class representing the Warping from a WarpPipe
 */
public class WarpAction extends Action {
    /**
     * WarpPipe being warped from
     */
    private WarpPipe currentPipe;

    /**
     * WarpPipe being warped to
     */
    private WarpPipe connectingPipe;

    /**
     * Constructor
     * @param currentPipe WarpPipe being warped from
     * @param connectingPipe WarpPipe being warped to
     */
    public WarpAction(WarpPipe currentPipe, WarpPipe connectingPipe){
        this.currentPipe = currentPipe;
        this.connectingPipe = connectingPipe;
    }

    /**
     * @see Action#execute(Actor, GameMap)
     * @param actor The actor performing the action.
     * @param map The map the actor is on.
     * @return line to print
     */
    @Override
    public String execute(Actor actor, GameMap map) {
        connectingPipe.setConnectingPipe(currentPipe);
        Location warpLocation = connectingPipe.getCurrentLocation();
        if (warpLocation.containsAnActor()){
            warpLocation.map().removeActor(warpLocation.getActor());
        }
        map.moveActor(actor, connectingPipe.getCurrentLocation());
        return actor + " warped!";
    }

    /**
     * @see Action#menuDescription(Actor)
     * @param actor The actor performing the action.
     * @return line to print
     */
    @Override
    public String menuDescription(Actor actor) {
        return actor + " warps";
    }
}
