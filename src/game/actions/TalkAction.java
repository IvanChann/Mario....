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
    protected Actor target;

    /**
     * This list of lines that can be said
     */
    protected ArrayList<String> dialogues;

    /**
     * Random number generator
     */
    protected Random rand = new Random();

    /**
     * Constructor
     * @param target The actor being talked to
     * @param dialogues list of lines that can be said
     */
    public TalkAction(Actor target, ArrayList<String> dialogues){
        this.target = target;
        this.dialogues = dialogues;
    }

    /**
     * @see Action#execute(Actor, GameMap)
     */
    @Override
    public String execute(Actor actor, GameMap map) {
        return actor + ": " + dialogues.get(rand.nextInt(dialogues.size())); // return random line from dialogues
    }

    /**
     * @see Action#menuDescription(Actor)
     */
    @Override
    public String menuDescription(Actor actor) {
        return actor + " talks to " + target;
    }
}
