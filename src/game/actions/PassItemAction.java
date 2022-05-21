package game.actions;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.positions.GameMap;
import game.items.PassableItem;

public class PassItemAction extends Action {
    private Actor passingActor;
    private PassableItem passedItem;

    public PassItemAction(Actor passingActor, PassableItem item){
        this.passingActor = passingActor;
        this.passedItem = item;
    }
    @Override
    public String execute(Actor actor, GameMap map) {
        passedItem.passItem(actor, passingActor);

        return passingActor + " passed " + passedItem + " to " + actor;
    }

    @Override
    public String menuDescription(Actor actor) {

        return passingActor + " passes " + passedItem + " to " + actor;
    }
}
