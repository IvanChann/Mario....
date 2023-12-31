package game.actors;


import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.actions.DoNothingAction;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.weapons.IntrinsicWeapon;
import game.Utils;
import game.actions.FireAttack;
import game.actions.NormalAttack;
import game.Monologue;
import game.behaviours.AttackBehaviour;
import game.behaviours.FollowBehaviour;
import game.reset.Resettable;
import game.statuses.Status;
import game.behaviours.WanderBehaviour;
import game.behaviours.Behaviour;
/**
 * Class representing the Goomba enemy
 * @author Andy Ouyang
 */
public class Goomba extends Enemy implements Resettable {
	public static final double SUICIDE_CHANCE = 0.1;
	private boolean remove = false;
	/**
	 * Constructor. Allows the Goomba to wander around and attack a player on sight
	 */
	public Goomba() {
		super("Goomba", 'g', 20);
		behaviours.put(Utils.WANDER_PRIORITY, new WanderBehaviour());
		behaviours.put(Utils.ATTACK_PRIORITY, new AttackBehaviour());
		intrinsicDamage = 10;
		registerInstance();




	}

	/**
	 * Method that returns a list of actions that can be performed by another actor
	 * to this Goomba
	 *
	 * If a player is spotted, Goomba will begin following the player
	 *
	 * @param otherActor the Actor that might perform an action.
	 * @param direction  String representing the direction of the other Actor
	 * @param map        current GameMap
	 * @return list of actions
	 * @see Status#HOSTILE_TO_ENEMY
	 */
	@Override
	public ActionList allowableActions(Actor otherActor, String direction, GameMap map) {
		ActionList actions = new ActionList();
		if (otherActor.hasCapability(Status.HOSTILE_TO_ENEMY)) {
			actions.add(new NormalAttack(this, direction));
			behaviours.put(Utils.FOLLOW_PRIORITY, new FollowBehaviour(otherActor));
		}
		if (otherActor.hasCapability(Status.FIRE_ATTACK)){
			actions.add(new FireAttack(this, direction));
		}
		return actions;
	}


	@Override
	protected IntrinsicWeapon getIntrinsicWeapon() {
		return new IntrinsicWeapon(intrinsicDamage, "obliterates");
	}

	/**
	 * First checks if Goomba will commit suicide or not, if not then goes through
	 * the behaviours TreeMap to figure out what action to take
	 * @param actions    collection of possible Actions for this Actor
	 * @param lastAction The Action this Actor took last turn. Can do interesting things in conjunction with Action.getNextAction()
	 * @param map        the map containing the Actor
	 * @param display    the I/O object to which messages may be written
	 * @return
	 */
	@Override
	public Action playTurn(ActionList actions, Action lastAction, GameMap map, Display display) {
		super.playTurn(actions, lastAction, map, display);
		if (Math.random() <= Goomba.SUICIDE_CHANCE || this.remove) {
			map.removeActor(this);
			return new DoNothingAction();
		}
		for (Behaviour behaviour : behaviours.values()) {
			Action action = behaviour.getAction(this, map);
			if (action != null) {
				return action;
			}
		}
		return new DoNothingAction();
	}

	@Override
	public boolean resetInstance() {
		return remove = true;
	}

	@Override
	public void createMonologues() {
		monologueList.add(new Monologue("Mugga mugga!"));
		monologueList.add(new Monologue("Ugha ugha... (Never gonna run around and desert you...)"));
		monologueList.add(new Monologue("Ooga-Chaka Ooga-Ooga!"));
	}
}
