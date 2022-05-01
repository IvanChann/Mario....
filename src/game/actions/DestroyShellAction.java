package game.actions;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import game.items.SuperMushroom;

/**
 * The class representing the action of destroying a Koopa's shell
 * @author Andy Ouyang
 */
public class DestroyShellAction extends Action {
    /**
     * The target (a Koopa) whose shell will be destroyed
     */
    private Actor target;

    /**
     * Constructor, stores the target
     * @param target
     */
    public DestroyShellAction(Actor target){
        this.target = target;
    }

    /**
     * Method used by the engine to perform the action of destroying a Koopa's shell. Will add a super mushroom to the
     * target's location then remove the target from the map
     * @param actor The actor performing the action.
     * @param map The map the actor is on.
     * @return String indicating that the target's shell has been smashed by the actor
     */
    @Override
    public String execute(Actor actor, GameMap map) {
        map.locationOf(target).addItem(new SuperMushroom());
        map.removeActor(target);
        return actor + " smashes " + target + "'s shell";
    }

    /**
     * Displays the option of destroying a target's shell on the menu
     * @param actor The actor performing the action.
     * @return String indicating that target's shell can be destroyed
     */
    @Override
    public String menuDescription(Actor actor) {

        return "Destroy " + target +"'s shell!";
    }
}