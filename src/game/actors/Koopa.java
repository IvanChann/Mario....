package game.actors;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actions.DoNothingAction;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.weapons.IntrinsicWeapon;
import game.actions.AttackAction;
import game.actions.DestroyShellAction;
import game.behaviours.AttackBehaviour;
import game.behaviours.Behaviour;
import game.behaviours.FollowBehaviour;
import game.behaviours.WanderBehaviour;
import game.reset.Resettable;
import game.statuses.Status;

/**
 * Class representing the Koopa enemy
 */
public class Koopa extends Enemy implements Resettable {
    /**
     * The state of Koopa, either dormant or not dormant
     */
    private boolean dormant = false;
    private boolean remove = false;

    /**
     * Constructor. Lets Koopa wander around and attack players on sight
     *
     */
    public Koopa() {

        super("Koopa", 'K', 100);
        behaviours.put(WanderBehaviour.PRIORITY, new WanderBehaviour());
        behaviours.put(AttackBehaviour.PRIORITY, new AttackBehaviour());
        this.registerInstance();
    }

    @Override
    protected IntrinsicWeapon getIntrinsicWeapon() {
        return new IntrinsicWeapon(30, "decimates");
    }

    /**
     * Method that returns a list of actions that can be performed by another actor to this Koopa,
     * the actions returned will depend on whether the Koopa is dormant or not. For example the Koopa can be attacked
     * if not dormant, and the Koopa's shell can be destroyed if dormant
     *
     * If a player is spotted and Koopa is not dormant, a follow behaviour will be added to follow the player
     *
     * @param otherActor the Actor that might be performing attack
     * @param direction  String representing the direction of the other Actor
     * @param map        current GameMap
     * @return
     */
    public ActionList allowableActions(Actor otherActor, String direction, GameMap map) {
        ActionList actions = new ActionList();
        if (!dormant) {
            if (otherActor.hasCapability(Status.HOSTILE_TO_ENEMY)) {
                actions.add(new AttackAction(this, direction));
                behaviours.put(FollowBehaviour.PRIORITY, new FollowBehaviour(otherActor));
            }
        } else{
            if (otherActor.hasCapability(Status.CAN_DESTROY_SHELL)){
                actions.add(new DestroyShellAction(this));
            }
        }

        return actions;
    }

    /**
     * Method that changes the Koopa's state to dormant if its hitpoints drop to 0 or below
     * @return true since Koopa is still conscious even when its inside its shell
     */
    @Override
    public boolean isConscious() {
        if (!super.isConscious()){
            this.dormant = true;
            this.setDisplayChar('D');
        }
        return true;
    }

    /**
     * Determines how the Koopa will behave on each turn, actions differ depending on if Koopa is dormant or not
     *
     * @param actions    collection of possible Actions for this Actor
     * @param lastAction The Action this Actor took last turn. Can do interesting things in conjunction with Action.getNextAction()
     * @param map        the map containing the Actor
     * @param display    the I/O object to which messages may be written
     * @return action to be taken on a turn
     */
    @Override
    public Action playTurn(ActionList actions, Action lastAction, GameMap map, Display display) {
        if (remove) {
            map.removeActor(this);
            return new DoNothingAction();
        }
        if (dormant){
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

