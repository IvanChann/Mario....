package game.actions;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import game.managers.BottleManager;
import game.terrain.Fountain;

/**
 * Class representing the action of refilling from fountain
 */
public class RefillAction extends Action {
    Fountain fountain;

    /**
     * Constructor.
     * @param fountain The fountain the bottle will be refilled from
     */
    public RefillAction(Fountain fountain){
        this.fountain = fountain;

    }

    /**
     * Refills the bottle using BottleManager, and reduces the current capacity of the fountain
     * @see Action#execute(Actor, GameMap)
     * @param actor The actor performing the action.
     * @param map The map the actor is on.
     * @return A string indicating that the bottle has been refilled
     */
    @Override
    public String execute(Actor actor, GameMap map) {
        fountain.reduceCapacity();
        BottleManager.getInstance().refill(actor.toString(), fountain);
        return actor + " filled bottle with " + fountain + " water!";
    }

    /**
     * @see Action#menuDescription(Actor)
     * @param actor The actor performing the action.
     * @return String representing the action in the menu
     */
    @Override
    public String menuDescription(Actor actor) {
        return actor + " fills bottle from " + fountain.getDescription();
    }
}
