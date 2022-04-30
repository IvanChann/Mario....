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

public class Koopa extends Enemy implements Resettable {
    private boolean dormant = false;
    private boolean remove = false;

    /**
     * Constructor.
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

    @Override
    public boolean isConscious() {
        if (!super.isConscious()){
            this.dormant = true;
            this.setDisplayChar('D');
        }
        return true;
    }

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

