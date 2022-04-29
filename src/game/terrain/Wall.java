package game.terrain;

import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Ground;
import edu.monash.fit2099.engine.positions.Location;
import game.actions.JumpAction;
import game.statuses.Status;


public class Wall extends HighGround {
	HighGround highGround;

	public Wall() {
		super('#', 20, 0.8);
	}


	@Override
	public boolean blocksThrownObjects() {
		return true;
	}

	@Override
	public ActionList allowableActions(Actor actor, Location location, String direction) {
		return new ActionList(new JumpAction((HighGround) location.getGround(), location, direction));
	}

	@Override
	public boolean canActorEnter(Actor actor) {
		return false;
	}
}
