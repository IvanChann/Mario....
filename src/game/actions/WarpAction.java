package game.actions;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Location;
import game.terrain.WarpPipe;

public class WarpAction extends Action {
    private WarpPipe currentPipe;
    private WarpPipe connectingPipe;

    public WarpAction(WarpPipe currentPipe, WarpPipe connectingPipe){
        this.currentPipe = currentPipe;
        this.connectingPipe = connectingPipe;
    }

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

    @Override
    public String menuDescription(Actor actor) {
        return actor + " warps";
    }
}
