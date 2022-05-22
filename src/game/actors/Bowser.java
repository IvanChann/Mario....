package game.actors;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actions.DoNothingAction;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Location;
import edu.monash.fit2099.engine.weapons.IntrinsicWeapon;
import game.Monologue;
import game.Utils;
import game.actions.FireAttack;
import game.actions.NormalAttack;
import game.behaviours.AttackBehaviour;
import game.behaviours.Behaviour;
import game.behaviours.FollowBehaviour;
import game.items.Key;
import game.reset.Resettable;
import game.statuses.Status;

/**
 * Class representing Bowser
 */
public class Bowser extends Enemy implements Resettable {
    /**
     * Boolean representing whether Bowser needs to be reset or not
     */
    private boolean reset = false;
    /**
     * Stored Location of where Bowser initially spawned
     */
    private Location startLocation;
    /**
     * Constructor.
     * @param location The location the bowser will return to when game is reset
     */
    public Bowser(Location location) {

        super("Bowser", 'B', Utils.BOWSER_INITIAL_HITPOINTS);
        behaviours.put(Utils.ATTACK_PRIORITY, new AttackBehaviour());
        this.startLocation = location;
        this.addItemToInventory(new Key());
        this.addCapability(Status.FIRE_ATTACK);
        intrinsicDamage = 80;
        this.registerInstance();
    }

    /**
     * @see Actor#getIntrinsicWeapon()
     */
    @Override
    protected IntrinsicWeapon getIntrinsicWeapon() {
        return new IntrinsicWeapon(intrinsicDamage, "fire punches");
    }

    /**
     * Handles the behaviours of Bowser, and his reset mechanic
     * @see Actor#playTurn(ActionList, Action, GameMap, Display)
     * @param actions    collection of possible Actions for this Actor
     * @param lastAction The Action this Actor took last turn. Can do interesting things in conjunction with Action.getNextAction()
     * @param map        the map containing the Actor
     * @param display    the I/O object to which messages may be written
     * @return Action that he will do this turn
     */
    @Override
    public Action playTurn(ActionList actions, Action lastAction, GameMap map, Display display) {
        if (!isConscious()) {
            return super.playTurn(actions, lastAction, map, display);
        }

        if (reset){
            if (startLocation.containsAnActor()){
                map.removeActor(startLocation.getActor());
            }
            map.moveActor(this, startLocation);
            reset = false;
            behaviours.remove(Utils.FOLLOW_PRIORITY);
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

    /**
     * @see Actor#allowableActions(Actor, String, GameMap)
     * @param otherActor the Actor that might be performing attack
     * @param direction  String representing the direction of the other Actor
     * @param map        current GameMap
     * @return
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

    public void createMonologues() {
        monologueList.add(new Monologue("What was that sound? Oh, just a fire."));
        monologueList.add(new Monologue("Princess Peach! You are formally invited... to the creation of my new kingdom!"));
        monologueList.add(new Monologue("Never gonna let you down!"));
        monologueList.add(new Monologue("Wrrrrrrrrrrrrrrrryyyyyyyyyyyyyy!!!!"));
    }

    /**
     * @see Resettable#resetInstance()
     */
    @Override
    public boolean resetInstance() {
        this.resetMaxHp(Utils.BOWSER_INITIAL_HITPOINTS);
        reset = true;
        return false;
    }
}
