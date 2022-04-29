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





}
