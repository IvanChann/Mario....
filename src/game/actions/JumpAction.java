package game.actions;
import edu.monash.fit2099.engine.weapons.Weapon;
import game.statuses.Status;
import game.terrain.HighGround;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Ground;
import edu.monash.fit2099.engine.positions.Location;



public class JumpAction extends Action {
    private Ground ground;
    private Location location;

    public JumpAction(Ground ground){
        this.ground = ground;
    }
    @Override
    public String execute(Actor actor, GameMap map) {

        Weapon weapon = actor.getWeapon();
        Ground jumpLocation = location.getGround();
        return null;
    }

    @Override
    public String menuDescription(Actor actor) {

        return actor + " can jump " + ground;
    }
}
