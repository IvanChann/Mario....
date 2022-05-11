package game.terrain;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Ground;
import edu.monash.fit2099.engine.positions.Location;
import game.statuses.Status;

public class Lava extends Ground {
    /**
     * Constructor.
     */
    public Lava() {
        super('L');
    }

    @Override
    public void tick(Location location) {
        if (location.containsAnActor()){
            Actor actor = location.getActor();
            actor.hurt(15);
            if (!actor.isConscious()){
                location.map().removeActor(actor);
            }
        }
    }

    @Override
    public boolean canActorEnter(Actor actor) {
        return !actor.hasCapability(Status.CANNOT_ENTER_FLOOR);
    }
}
