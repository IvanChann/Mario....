package game.actions;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.positions.GameMap;
import game.items.PassableItem;

/**
 * Class representing the action of passing items
 */
public class PassItemAction extends Action {
    private Actor passingActor;
    private PassableItem passedItem;

    /**
     * Constructor.
     * @param passingActor Actor who is passing
     * @param item Item to be passed
     */
    public PassItemAction(Actor passingActor, PassableItem item){
        this.passingActor = passingActor;
        this.passedItem = item;
    }

    /**
     * @see Action#execute(Actor, GameMap)
     * @param actor The actor performing the action.
     * @param map The map the actor is on.
     * @return String indicating that action has been taken
     */
    @Override
    public String execute(Actor actor, GameMap map) {
        passedItem.passItem(actor, passingActor);

        return passingActor + " passed " + passedItem + " to " + actor;
    }

    /**
     * @see Action#execute(Actor, GameMap)
     * @param actor The actor performing the action.
     * @return String representing the action in the menu
     */
    @Override
    public String menuDescription(Actor actor) {

        return passingActor + " passes " + passedItem + " to " + actor;
    }
}
