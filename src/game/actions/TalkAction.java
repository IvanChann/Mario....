package game.actions;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;

import java.util.ArrayList;
import java.util.Random;

/**
 * Action for talking between Actors.
 */
public class TalkAction extends Action {
    /**
     * Actor that is to be talked to
     */
    private Actor target;

    /**
     * This list of lines that can be said
     */
    private String sentence;

    /**
     * Random number generator
     */
    private Random rand = new Random();

    public TalkAction(Actor target, String sentence){
        this.target = target;
        this.sentence = sentence;
    }

    /**
     * @see Action#execute(Actor, GameMap)
     */
    @Override
    public String execute(Actor actor, GameMap map) {
        return target + ": " + sentence; // return random line from dialogues
    }

    /**
     * @see Action#menuDescription(Actor)
     */
    @Override
    public String menuDescription(Actor actor) {
        return actor + " talks to " + target;
    }
}
