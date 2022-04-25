package game.actors;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actions.DoNothingAction;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.positions.GameMap;
import game.actions.TalkAction;
import game.enums.Status;

import java.util.ArrayList;

public class Toad extends Actor {
    public Toad(){
        super("Toad", 'O', 50);

    }

    @Override
    public ActionList allowableActions(Actor otherActor, String direction, GameMap map) {
        ActionList actions = new ActionList();
        ArrayList<String> dialogues = new ArrayList<>();

        if (!otherActor.hasCapability(Status.HAS_WRENCH)){
            dialogues.add("You might need a wrench to smash Koopa's hard shells.");
        }
        if (!otherActor.hasCapability(Status.GLOWING)){
            dialogues.add("You better get back to finding the Power Stars.");
        }
        dialogues.add("The Princess is depending on you! You are our only hope.");
        dialogues.add("Being imprisoned in these walls can drive a fungus crazy :(");

        actions.add(new TalkAction(this, dialogues));
        return actions;
    }

    @Override
    public Action playTurn(ActionList actions, Action lastAction, GameMap map, Display display) {
        return new DoNothingAction();
    }
}
