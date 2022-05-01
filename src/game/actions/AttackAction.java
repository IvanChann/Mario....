package game.actions;

import java.util.Random;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.weapons.Weapon;
import game.statuses.Status;

/**
 * Special Action for attacking other Actors.
 */
public class AttackAction extends Action {

	/**
	 * The Actor that is to be attacked
	 */
	protected Actor target;

	/**
	 * The direction of incoming attack.
	 */
	protected String direction;

	/**
	 * Random number generator
	 */
	protected Random rand = new Random();

	/**
	 * Constructor.
	 * 
	 * @param target the Actor to attack
	 * @param direction the direction of the target
	 */
	public AttackAction(Actor target, String direction) {
		this.target = target;
		this.direction = direction;
	}

	/**
	 * Method used by the engine to perform the attack. First calculates the damage,
	 * then applies the damage. Then checks if the target 'is conscious' or not, if unconscious,
	 * the target will drop all their items, and they will be removed from the game.
	 * @param actor The actor performing the action.
	 * @param map The map the actor is on.
	 * @return a string representing the action taken
	 */
	@Override
	public String execute(Actor actor, GameMap map) {

		Weapon weapon = actor.getWeapon();

		if (!(rand.nextInt(100) <= weapon.chanceToHit())) {
			return actor + " misses " + target + ".";
		}

		int damage = weapon.damage();

		if (actor.hasCapability(Status.GLOWING)){
			damage = Integer.MAX_VALUE;
		}

		if (target.hasCapability(Status.GLOWING)){
			damage = 0;
		}

		String result = actor + " " + weapon.verb() + " " + target + " for " + damage + " damage.";


		target.hurt(damage);
		if (!target.isConscious()) {
			ActionList dropActions = new ActionList();
			// drop all items
			for (Item item : target.getInventory())
				dropActions.add(item.getDropAction(actor));
			for (Action drop : dropActions)
				drop.execute(target, map);
			// remove actor
			map.removeActor(target);
			result += System.lineSeparator() + target + " is killed.";
		}

		return result;
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
