package game.actors;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actions.DoNothingAction;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.positions.GameMap;
import game.Monologue;
import game.MonologueList;
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

    /**
     * List of buyable items
     */
    private ArrayList<Purchasable> buyables = new ArrayList<>();

    /**
     * Constructor. Adds the items that Toad will sell to his list of Purchasable items
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
        createMonologues();

    }

    /**
     * Toad just stands still every turn and does nothing
     * @see Actor#playTurn(ActionList, Action, GameMap, Display)
     */
    @Override
    public Action playTurn(ActionList actions, Action lastAction, GameMap map, Display display) {
        return super.playTurn(actions, lastAction, map, display);
    }

    /**
     * Generates buy actions for each item in his shop, also allows player to speak with him
     * @see Actor#allowableActions(Actor, String, GameMap)
     */
    public ActionList allowableActions(Actor otherActor, String direction, GameMap map) {
        ActionList actions = new ActionList();
        for (Purchasable item : buyables) {
            actions.add(new BuyItemAction(item, item.getPrice()));
        }

            actions.add(new TalkAction(this, monologueList.getRandom(otherActor).getSentence()));
            return actions;
    }

    /**
     */
    public void createMonologues(){
        monologueList.add(new Monologue("You might need a wrench to smash Koopa's hard shells.", Status.CAN_DESTROY_SHELL));
        monologueList.add(new Monologue("You better get back to finding the Power Stars.", Status.GLOWING));
        monologueList.add(new Monologue("The Princess is depending on you! You are our only hope."));
        monologueList.add(new Monologue("Being imprisoned in these walls can drive a fungus crazy :("));

    }

}


