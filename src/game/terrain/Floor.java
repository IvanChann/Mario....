package game.terrain;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Ground;
import game.statuses.Status;

/**
 * A class that represents the floor inside a building.
 */
public class Floor extends Ground {

	/**
	  @see Ground#Ground(char)  Ground
	 */
	public Floor() {
		super('_');
	}

	/**
	 * Enemies cannot walk on Floor
	 * @see Ground#canActorEnter(Actor)
	 */
	@Override
	public boolean canActorEnter(Actor actor) {
		return !actor.hasCapability(Status.CANNOT_ENTER_FLOOR);
	}
}

