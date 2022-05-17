package game.actors;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actions.DoNothingAction;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.positions.GameMap;
import game.Monologue;
import game.actions.AttackAction;

// JUST FOR TESTING
public class PiranhaPlant extends Enemy{
    /**
     * Constructor. Makes all enemies unable to enter floors by using a capability
     *
     */
    public PiranhaPlant() {
        super("Piranha Plant", 'Y', 1);
    }

    @Override
    public Action playTurn(ActionList actions, Action lastAction, GameMap map, Display display) {
        super.playTurn(actions, lastAction, map, display);
        return new DoNothingAction();
    }

    public ActionList allowableActions(Actor otherActor, String direction, GameMap map) {
        ActionList actions = new ActionList();
        actions.add(new AttackAction(this, direction));
        return actions;

    }

    @Override
    public void createMonologues() {
        monologueList.add(new Monologue("Slsstssthshs~! (Never gonna say goodbye~)"));
        monologueList.add(new Monologue("Ohmnom nom nom nom."));
    }
}
