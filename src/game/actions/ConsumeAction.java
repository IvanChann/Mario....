package game.actions;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import game.items.Consumable;

/**
 * The class representing the action of consuming a consumable item
 * @author Andy Ouyang
 */
public class ConsumeAction extends Action {
    /**
     * The item to be consumed
     */
    private Consumable consumable;

    /**
     * Constructor. Stores the consumable item
     * @param consumable
     */
    public ConsumeAction(Consumable consumable){
        this.consumable = consumable;

    }

    /**
     * Method used by the engine to perform the consume action of an item. Calls the consumedBy method
     * of the Consumable item which have varying effects depending on the item.
     *
     * @param actor The actor performing the action.
     * @param map The map the actor is on.
     * @return String indicating that the item has been consumed
     */
    @Override
    public String execute(Actor actor, GameMap map) {
        consumable.consumedBy(actor, map);
        return actor + " consumed " + consumable;
    }

    /**
     * Displays the option of consuming an item on the menu
     * @param actor The actor performing the action.
     * @return String representing that the item can be consumed
     */
    @Override
    public String menuDescription(Actor actor) {

        return actor + " consumes " + consumable;
    }

}
