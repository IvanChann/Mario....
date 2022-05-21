package game.actions;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import game.managers.BottleManager;
import game.terrain.Fountain;

public class RefillAction extends Action {
    Fountain fountain;


    public RefillAction(Fountain fountain){
        this.fountain = fountain;

    }
    @Override
    public String execute(Actor actor, GameMap map) {
        fountain.reduceCapacity();
        BottleManager.getInstance().refill(actor.toString(), fountain);
        return actor + " filled bottle with " + fountain + " water!";
    }

    @Override
    public String menuDescription(Actor actor) {
        return actor + " fills bottle from " + fountain.getDescription();
    }
}
