package game.actors;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actions.DoNothingAction;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.positions.GameMap;
import game.actions.BuyItemAction;
import game.items.PowerStar;
import game.items.Purchasable;
import game.items.SuperMushroom;
import game.items.Wrench;
import game.actions.TalkAction;
import game.statuses.Status;

import java.util.ArrayList;

/**
 * Class representing Toad
 */
public class Toad extends NPC {

    private ArrayList<Purchasable> buyables = new ArrayList<>();

    /**
     * Constructor.
     *
     * @param name        the name of the Actor
     * @param displayChar the character that will represent the Actor in the display
     * @param hitPoints   the Actor's starting hit points
     */
    public Toad(String name, char displayChar, int hitPoints) {
        super(name, displayChar, hitPoints);
        buyables.add(new PowerStar());
        buyables.add(new SuperMushroom());
        buyables.add(new Wrench());

        // manually add all buyable items into buyableItems
    }

    /**
     * @see Actor#playTurn(ActionList, Action, GameMap, Display)
     */
    @Override
    public Action playTurn(ActionList actions, Action lastAction, GameMap map, Display display) {
        return new DoNothingAction();
    }

    /**
     * @see Actor#allowableActions(Actor, String, GameMap)
     */
    public ActionList allowableActions(Actor otherActor, String direction, GameMap map) {
        ActionList actions = new ActionList();
        for (Purchasable item : buyables) {
            actions.add(new BuyItemAction(item, item.getPrice()));
        }

            actions.add(new TalkAction(this, getDialogue(otherActor)));
            return actions;
    }

    /**
     * Returns a list of strings that Toad can say to otherActor
     * @param otherActor Actor that toad is talking to
     * @return the list of dialogue options
     */
    public ArrayList<String> getDialogue(Actor otherActor){
        ArrayList<String> dialogues = new ArrayList<>();

        if (!otherActor.hasCapability(Status.CAN_DESTROY_SHELL)) {
            dialogues.add("You might need a wrench to smash Koopa's hard shells.");
        }
        if (!otherActor.hasCapability(Status.GLOWING)) {
            dialogues.add("You better get back to finding the Power Stars.");
        }
        dialogues.add("The Princess is depending on you! You are our only hope.");
        dialogues.add("Being imprisoned in these walls can drive a fungus crazy :(");

        return dialogues;
    }

}


