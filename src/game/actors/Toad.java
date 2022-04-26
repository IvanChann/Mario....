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

import java.util.ArrayList;

public class Toad extends NPC{

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
        buyables.add(new PowerStar(false));
        buyables.add(new SuperMushroom(false));
        buyables.add(new Wrench());

        // manually add all buyable items into buyableItems
    }

    @Override
    public Action playTurn(ActionList actions, Action lastAction, GameMap map, Display display) {
        return new DoNothingAction();
    }



}
