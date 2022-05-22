package game.actions;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;

/**
 * Class representing the action to end the game
 */
public class EndGameAction extends Action {
    /**
     * Removes actor from the game and prints winning message
     * @see Action#execute(Actor, GameMap)
     * @param actor The actor performing the action.
     * @param map The map the actor is on.
     * @return Winning message
     */
    @Override
    public String execute(Actor actor, GameMap map) {
        map.removeActor(actor);
        return "Congratulations, you win!";
    }

    /**
     * Shows option to win the game in the menu
     * @see Action#menuDescription(Actor)
     * @param actor The actor performing the action.
     * @return
     */
    @Override
    public String menuDescription(Actor actor) {
        return "Unlock Princess Peach's cage";
    }
}
