package game.actions;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import game.items.SuperMushroom;

public class DestroyShellAction extends Action {
    private Actor target;

    public DestroyShellAction(Actor target){
        this.target = target;
    }
    @Override
    public String execute(Actor actor, GameMap map) {
        map.locationOf(target).addItem(new SuperMushroom());
        map.removeActor(target);
        return actor + " smashes " + target + "'s shell";
    }

    @Override
    public String menuDescription(Actor actor) {

        return "Destroy " + target +"'s shell!";
    }
}