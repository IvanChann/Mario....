package game.actors;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actions.DoNothingAction;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.weapons.IntrinsicWeapon;
import game.Utils;
import game.actions.NormalAttack;
import game.behaviours.FollowBehaviour;
import game.reset.Resettable;
import game.Monologue;
import game.actions.AttackAction;
import game.statuses.Status;

public class PiranhaPlant extends Enemy implements Resettable {
    /**
     * Constructor. Makes all enemies unable to enter floors by using a capability
     *
     */
    public PiranhaPlant() {

        super("Piranha Plant", 'Y', 150);
        registerInstance();
    }

    /**
     * @see Actor#allowableActions(Actor, String, GameMap)
     * @param otherActor the Actor that might be performing attack
     * @param direction  String representing the direction of the other Actor
     * @param map        current GameMap
     * @return actions that can be performed on this
     */
    @Override
    public ActionList allowableActions(Actor otherActor, String direction, GameMap map) {
        ActionList actions = new ActionList();
        if (otherActor.hasCapability(Status.HOSTILE_TO_ENEMY)) {
            actions.add(new NormalAttack(this, direction));
        }

        return actions;
    }

    /**
     * @see Actor#getIntrinsicWeapon()
     * @return
     */
    @Override
    protected IntrinsicWeapon getIntrinsicWeapon() {
        return new IntrinsicWeapon(90, "chomps");
    }

    /**
     * @see Actor#playTurn(ActionList, Action, GameMap, Display)
     * @param actions    collection of possible Actions for this Actor
     * @param lastAction The Action this Actor took last turn. Can do interesting things in conjunction with Action.getNextAction()
     * @param map        the map containing the Actor
     * @param display    the I/O object to which messages may be written
     * @return
     */
    @Override
    public Action playTurn(ActionList actions, Action lastAction, GameMap map, Display display) {
        super.playTurn(actions, lastAction, map, display);
        return new DoNothingAction();
    }

    @Override
    public void createMonologues() {
        monologueList.add(new Monologue("Slsstssthshs~! (Never gonna say goodbye~)"));
        monologueList.add(new Monologue("Ohmnom nom nom nom."));
    }

    /**
     * @see Resettable#resetInstance()
     * @return
     */
    @Override
    public boolean resetInstance() {
        this.increaseMaxHp(Utils.PIRANHAPLANT_HEAL);
        return false;
    }
}
