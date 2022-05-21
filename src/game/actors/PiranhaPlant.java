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

    @Override
    public ActionList allowableActions(Actor otherActor, String direction, GameMap map) {
        ActionList actions = new ActionList();
        if (otherActor.hasCapability(Status.HOSTILE_TO_ENEMY)) {
            actions.add(new NormalAttack(this, direction));
        }

        return actions;
    }

    @Override
    protected IntrinsicWeapon getIntrinsicWeapon() {
        return new IntrinsicWeapon(90, "chomps");
    }

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

    @Override
    public boolean resetInstance() {
        this.increaseMaxHp(Utils.PIRANHAPLANT_HEAL);
        return false;
    }
}
