package game.actions;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;

import java.util.ArrayList;
import java.util.Random;

public class TalkAction extends Action {
    protected Actor target;

    protected ArrayList<String> dialogues;

    protected Random rand = new Random();

    public TalkAction(Actor target, ArrayList<String> dialogues){
        this.target = target;
        this.dialogues = dialogues;
    }

    @Override
    public String execute(Actor actor, GameMap map) {
        return "Toad: " + dialogues.get(rand.nextInt(dialogues.size()));
    }

    @Override
    public String menuDescription(Actor actor) {
        return actor + " talks to " + target;
    }
}
