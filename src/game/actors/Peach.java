package game.actors;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actions.DoNothingAction;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.positions.GameMap;
import game.Monologue;
import game.actions.EndGameAction;
import game.statuses.Status;

public class Peach extends NPC {
    /**
     * Constructor.
     *
     */
    public Peach() {
        super("Peach", 'P', 100);
    }


    @Override
    public Action playTurn(ActionList actions, Action lastAction, GameMap map, Display display) {

        return new DoNothingAction();
    }

    /**
     * Generates an EndGameAction if the player has a key
     * @see Actor#allowableActions(Actor, String, GameMap)
     * @param otherActor the Actor that might be performing attack
     * @param direction  String representing the direction of the other Actor
     * @param map        current GameMap
     * @return Actions that can be performed
     */
    @Override
    public ActionList allowableActions(Actor otherActor, String direction, GameMap map) {
        ActionList actions = new ActionList();
        if (otherActor.hasCapability(Status.CAN_UNLOCK)){
            actions.add(new EndGameAction());
        }

        return actions;
    }

    public void createMonologues() {
        monologueList.add(new Monologue("Dear Mario, I'll be waiting for you..."));
        monologueList.add(new Monologue("Never gonna give you up!"));
        monologueList.add(new Monologue("Release me, or I will kick you!"));
    }
}
