package game.actions;

import java.util.Random;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.weapons.Weapon;
import game.statuses.Status;

/**
 * Special Action for attacking other Actors.
 */
public abstract class AttackAction extends Action {

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

		effectsOfAttack(target, map);

		if (!(rand.nextInt(100) <= weapon.chanceToHit())) {
			return actor + " misses " + target + ".";
		}

		int damage = getDamage(actor, weapon);

		String result = actor + " " + weapon.verb() + " " + target + " for " + damage + " damage.";


		target.hurt(damage);
		if (!target.isConscious()) {
			DeathMechanic.death(target, map);
			result += System.lineSeparator() + target + " is killed.";
		}

		return result;
	}


	/**
	 * Method for calculating the damage in the attack
	 * @param actor Actor doing the attack
	 * @param weapon Weapon that the actor potentially holds
	 * @return Integer representing damage to be dealt
	 */
	protected int getDamage(Actor actor, Weapon weapon) {
		int damage = weapon.damage();

		if (actor.hasCapability(Status.GLOWING)){
			damage = Integer.MAX_VALUE;
		}

		if (target.hasCapability(Status.GLOWING)){
			damage = 0;
		}
		return damage;
	}

	/**
	 * Applies the different effects of different types of attacks
	 * @param target Actor receiving the attack
	 * @param map Map that actor is on
	 */
	protected abstract void effectsOfAttack(Actor target, GameMap map);


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
