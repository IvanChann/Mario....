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
import game.actions.NormalAttack;
import game.behaviours.AttackBehaviour;
import game.behaviours.Behaviour;
import game.behaviours.FollowBehaviour;
import game.items.Key;
import game.reset.Resettable;
import game.statuses.Status;

public class Bowser extends Enemy implements Resettable {
    private boolean reset = false;
    private Location startLocation;
    /**
     * Constructor. Makes all enemies unable to enter floors by using a capability
     *
     */
    public Bowser(Location location) {

        super("Bowser", 'B', Utils.BOWSER_INITIAL_HITPOINTS);
        behaviours.put(Utils.ATTACK_PRIORITY, new AttackBehaviour());
        this.startLocation = location;
        this.addItemToInventory(new Key());
        this.addCapability(Status.FIERY);
        intrinsicDamage = 80;
        this.registerInstance();
    }

    @Override
    protected IntrinsicWeapon getIntrinsicWeapon() {
        return new IntrinsicWeapon(intrinsicDamage, "fire punches");
    }

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

    @Override
    public ActionList allowableActions(Actor otherActor, String direction, GameMap map) {
        ActionList actions = new ActionList();
        if (otherActor.hasCapability(Status.HOSTILE_TO_ENEMY)) {
            actions.add(new NormalAttack(this, direction));
            behaviours.put(Utils.FOLLOW_PRIORITY, new FollowBehaviour(otherActor));
        }

        return actions;
    }

    public void createMonologues() {
        monologueList.add(new Monologue("What was that sound? Oh, just a fire."));
        monologueList.add(new Monologue("Princess Peach! You are formally invited... to the creation of my new kingdom!"));
        monologueList.add(new Monologue("Never gonna let you down!"));
        monologueList.add(new Monologue("Wrrrrrrrrrrrrrrrryyyyyyyyyyyyyy!!!!"));
    }

    @Override
    public boolean resetInstance() {
        this.resetMaxHp(Utils.BOWSER_INITIAL_HITPOINTS);
        reset = true;
        return false;
    }
}
