package game.actors;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actions.DoNothingAction;
import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.weapons.IntrinsicWeapon;
import game.Utils;
import game.reset.Resettable;

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
    protected IntrinsicWeapon getIntrinsicWeapon() {
        return new IntrinsicWeapon(90, "chomps");
    }

    @Override
    public Action playTurn(ActionList actions, Action lastAction, GameMap map, Display display) {
        super.playTurn(actions, lastAction, map, display);
        return new DoNothingAction();
    }

    @Override
    public boolean resetInstance() {
        this.increaseMaxHp(Utils.PIRANHAPLANT_HEAL);
        return false;
    }
}
