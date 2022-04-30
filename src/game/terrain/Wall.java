package game.terrain;

import edu.monash.fit2099.engine.actors.Actor;

public class Wall extends HighGround {

	public Wall() {
		super('#', 20, 0.8);
	}


	@Override
	public boolean blocksThrownObjects() {
		return true;
	}

	@Override
	public boolean canActorEnter(Actor actor) {
		return false;
	}
}
