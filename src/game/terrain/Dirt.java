package game.terrain;

import edu.monash.fit2099.engine.positions.Ground;
import game.statuses.Status;


/**
 * A class that represents bare dirt.
 */
public class Dirt extends Ground {

	public Dirt() {
		super('.');
		this.addCapability(Status.FERTILE);
	}
}

