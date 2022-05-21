package game.actors;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actions.DoNothingAction;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.positions.GameMap;
import game.actions.DeathMechanic;
import game.MonologueList;
import game.behaviours.Behaviour;
import game.statuses.Status;

import java.util.Collections;
import java.util.Map;
import java.util.TreeMap;

public abstract class NPC extends Actor {

    protected Map<Integer, Behaviour> behaviours = new TreeMap<>(); // priority, behaviour

    protected MonologueList monologueList = new MonologueList();
    /**
     * Constructor.
     *
     * @param name        the name of the Actor
     * @param displayChar the character that will represent the Actor in the display
     * @param hitPoints   the Actor's starting hit points
     */
    public NPC(String name, char displayChar, int hitPoints) {
        super(name, displayChar, hitPoints);
        createMonologues();
    }

    /**
     * Determines the action taken on a turn
     * @param actions    collection of possible Actions for this Actor
     * @param lastAction The Action this Actor took last turn. Can do interesting things in conjunction with Action.getNextAction()
     * @param map        the map containing the Actor
     * @param display    the I/O object to which messages may be written
     * @return The action to be taken
     */
    @Override
    public Action playTurn(ActionList actions, Action lastAction, GameMap map, Display display) {
        if (!this.isConscious()) {
            DeathMechanic.death(this, map);
        }
        if (this.hasCapability(Status.TALK)) {
            monologueList.getRandom().speak(this, display);
            this.removeCapability(Status.TALK);
        } else this.addCapability(Status.TALK);

        return new DoNothingAction();
    }


    public abstract void createMonologues();
}
