package game;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.displays.Display;
import game.statuses.Status;

/**
 * This class represents a Monologue in which an Actor can say
 */
public class Monologue {
    /**
     * The sentence to speak
     */
    private final String sentence;

    /**
     * Condition to check for
     */
    private final Status condition;

    /**
     * Constructor
     * @param sentence sentence to speak
     */
    public Monologue(String sentence) {
        this.sentence = sentence;
        this.condition = null;
    }

    /**
     * Constructor
     * @param sentence sentence to speak
     * @param condition condition to check for in the Actor
     */
    public Monologue(String sentence, Status condition){
        this.sentence = sentence;
        this.condition = condition;
    }

    /**
     * Outputs the Monologue
     * @param actor Actor that is speaking
     * @param display Display
     */
    public void speak(Actor actor, Display display){
        display.println(actor + ": " + this.sentence);
    }

    /**
     * @return condition
     */
    public Status getCondition() {
        return condition;
    }

    /**
     * @return sentence
     */
    public String getSentence() {
        return sentence;
    }
}
