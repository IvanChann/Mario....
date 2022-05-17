package game.actors;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.positions.GameMap;
import game.behaviours.AttackBehaviour;
import game.behaviours.Behaviour;
import game.behaviours.WanderBehaviour;
import game.statuses.Status;

import java.util.HashMap;
import java.util.Map;

/**
 * Class representing the enemies of the game
 */
public abstract class Enemy extends NPC {


    /**
     * Constructor. Makes all enemies unable to enter floors by using a capability
     *
     * @param name        the name of the Actor
     * @param displayChar the character that will represent the Actor in the display
     * @param hitPoints   the Actor's starting hit points
     */
    public Enemy(String name, char displayChar, int hitPoints) {
        super(name, displayChar, hitPoints);
        this.addCapability(Status.CANNOT_ENTER_FLOOR);

    }

    /**
     * Chooses an action to take in the current turn
     * @param actions    collection of possible Actions for this Actor
     * @param lastAction The Action this Actor took last turn. Can do interesting things in conjunction with Action.getNextAction()
     * @param map        the map containing the Actor
     * @param display    the I/O object to which messages may be written
     * @return Action to be taken in current turn
     */
    @Override
    public Action playTurn(ActionList actions, Action lastAction, GameMap map, Display display){
        return super.playTurn(actions, lastAction, map, display);
    }
    }

