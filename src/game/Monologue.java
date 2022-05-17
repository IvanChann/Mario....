package game;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.displays.Display;
import game.statuses.Status;

public class Monologue {
    private final String sentence;
    private final Status condition;

    public Monologue(String sentence) {
        this.sentence = sentence;
        this.condition = null;
    }

    public Monologue(String sentence, Status condition){
        this.sentence = sentence;
        this.condition = condition;
    }

    public void speak(Actor actor, Display display){
        display.println(actor + ": " + this.sentence);
    }

    public Status getCondition() {
        return condition;
    }

    public String getSentence() {
        return sentence;
    }
}
