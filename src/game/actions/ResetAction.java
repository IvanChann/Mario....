package game.actions;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import game.reset.ResetManager;
import game.statuses.Status;

/**
 * Action to reset the game
 */
public class ResetAction extends Action {

    /**
     * @see Action#execute(Actor, GameMap) 
     */
    @Override
    public String execute(Actor actor, GameMap map) {
        ResetManager.getInstance().run();
        actor.removeCapability(Status.CAN_RESET);
        return "Game was reset";
    }

    /**
     * @see Action#menuDescription(Actor) 
     */
    @Override
    public String menuDescription(Actor actor) {
        return "Reset the game";
    }

    /**
     * @see Action#hotkey() 
     */
    @Override
    public String hotkey(){
        return "r";
    }
}
