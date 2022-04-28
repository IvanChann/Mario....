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
import game.statuses.Status;

public class Koopa extends Enemy {
    private boolean dormant = false;

    /**
     * Constructor.
     *
     */
    public Koopa() {

        super("Koopa", 'K', 100);
        this.addBehaviour(WanderBehaviour.PRIORITY, new WanderBehaviour());
        this.addBehaviour(AttackBehaviour.PRIORITY, new AttackBehaviour());
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
                this.addBehaviour(FollowBehaviour.PRIORITY, new FollowBehaviour(otherActor));
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
        if (dormant){
            return new DoNothingAction();
        }
        for (Behaviour behaviour : this.getBehaviours().values()) {
            Action action = behaviour.getAction(this, map);
            if (action != null) {
                return action;
            }
        }
        return new DoNothingAction();
    }
}

