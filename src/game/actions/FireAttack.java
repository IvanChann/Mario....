package game.actions;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import game.items.Fire;
import game.statuses.Status;

public class FireAttack extends AttackAction {

    private int turns = 3;

    public FireAttack(Actor target, String direction){
        super(target, direction);
    }

    @Override
    public String execute(Actor actor, GameMap map) {
        if (actor.hasCapability(Status.FIRE_ATTACK)){
            map.locationOf(target).addItem(new Fire(3));
        }
        return actor + " attacks " + target + " at " + direction + " with fire!";
    }

    @Override
    public String menuDescription(Actor actor) {
        return actor + " can attack " + target + " at " + direction + " with fire!";
    }

}
