package game.actors;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.positions.GameMap;
import game.behaviours.Behaviour;

import java.util.Collections;
import java.util.Map;
import java.util.TreeMap;

public abstract class NPC extends Actor {

    private Map<Integer, Behaviour> behaviours = new TreeMap<>(); // priority, behaviour

    public Map<Integer, Behaviour> getBehaviours() {
        return Collections.unmodifiableMap(behaviours);
    }

    public void addBehaviour(Integer priority, Behaviour behaviour){
        behaviours.put(priority, behaviour);    // FOLLOWS DEFENSIVE COPYING SAME AS ABOVE
    }
    /**
     * Constructor.
     *
     * @param name        the name of the Actor
     * @param displayChar the character that will represent the Actor in the display
     * @param hitPoints   the Actor's starting hit points
     */
    public NPC(String name, char displayChar, int hitPoints) {
        super(name, displayChar, hitPoints);
    }

    @Override
    public Action playTurn(ActionList actions, Action lastAction, GameMap map, Display display) {
        return null;
    }
}
