package game.actions;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import game.items.Fire;
import game.statuses.Status;
/**
 * Class representing the Fire Attack
 */
public class FireAttack extends AttackAction {

    private int turns = 3;
    /**
     * Constructor.
     * @param target    the Actor to attack
     * @param direction the direction of the target
     */
    public FireAttack(Actor target, String direction){
        super(target, direction);
    }
    /**
     * Method used by the engine to perform the action of performing the fire attack and drops a "v" on the target ground
     * @param actor The actor performing the action.
     * @param map The map the actor is on.
     * @return String indicating that the target has been attacked with fire
     */
    @Override
    public String execute(Actor actor, GameMap map) {
        if (actor.hasCapability(Status.FIRE_ATTACK)){
            map.locationOf(target).addItem(new Fire(3));
        }
        return actor + " attacks " + target + " at " + direction + " with fire!";
    }
    /**
     * Displays the option of attacking with fire on the menu
     * @param actor The actor performing the action.
     * @return String indicating that player can attack with fire
     */
    @Override
    public String menuDescription(Actor actor) {
        return actor + " can attack " + target + " at " + direction + " with fire!";
    }

}
