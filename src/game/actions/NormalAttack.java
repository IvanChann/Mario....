package game.actions;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;

/**
 * Special Action for attacking other Actors.
 */
public class NormalAttack extends AttackAction {


	/**
	 * Constructor.
	 * 
	 * @param target the Actor to attack
	 * @param direction the direction of the target
	 */
	public NormalAttack(Actor target, String direction) {
		super(target, direction);
	}


	/**
	 * Method that displays the option of attacking a target in some specific direction on the menu
	 * @param actor The actor performing the action.
	 * @return String representing the attack action that can be taken
	 */
	@Override
	public String menuDescription(Actor actor) {
		return actor + " attacks " + target + " at " + direction;
	}
}
