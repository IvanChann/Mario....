package game.actors;


import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.actions.DoNothingAction;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.weapons.IntrinsicWeapon;
import game.behaviours.AttackBehaviour;
import game.behaviours.FollowBehaviour;
import game.reset.Resettable;
import game.statuses.Status;
import game.behaviours.WanderBehaviour;
import game.actions.AttackAction;
import game.behaviours.Behaviour;
/**
 * A little fungus guy.
 */
public class Goomba extends Enemy	 implements Resettable {
	public static final double SUICIDE_CHANCE = 0.1;
	private boolean remove = false;
	/**
	 * Constructor.
	 */
	public Goomba() {
		super("Goomba", 'g', 20);
		registerInstance();
		behaviours.put(WanderBehaviour.PRIORITY, new WanderBehaviour());
		behaviours.put(AttackBehaviour.PRIORITY, new AttackBehaviour());



	}

	/**
	 * At the moment, we only make it can be attacked by Player.
	 * You can do something else with this method.
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
			actions.add(new AttackAction(this, direction));
		}
		behaviours.put(FollowBehaviour.PRIORITY, new FollowBehaviour(otherActor));
		return actions;
	}

	@Override
	protected IntrinsicWeapon getIntrinsicWeapon() {
		return new IntrinsicWeapon(10, "obliterates");
	}

	/**
	 * Figure out what to do next.
	 * @see Actor#playTurn(ActionList, Action, GameMap, Display)
	 */
	@Override
	public Action playTurn(ActionList actions, Action lastAction, GameMap map, Display display) {
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
}
