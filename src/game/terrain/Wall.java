package game.terrain;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Ground;

public class Wall extends HighGround {

	public Wall() {
		super('#');
	}

	
	@Override
	public boolean blocksThrownObjects() {
		return true;
	}
}
