package game.terrain;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Ground;
import game.statuses.Status;


public class Wall extends HighGround {

	public Wall() {
		super('#', 20, 0.8);
	}


	@Override
	public boolean blocksThrownObjects() {
		return true;
	}

	/**
	 * Accessor for damage done by this ground.
	 *
	 * @return the damage
	 */
	@Override
	public int damage(int damage){
		return damage;
	};

	/**
	 * Accessor for success rate for each jump for this ground.
	 *
	 * @return the success rate.
	 */
	@Override
	public double successRate(double successRate) {
		return successRate;
	}
}
