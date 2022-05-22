package game.items;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.positions.GameMap;
import game.actions.ConsumeAction;
import game.actors.Drinker;
import game.managers.BottleManager;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Class representing the Bottle that can hold Water
 */
public class Bottle extends Item implements PassableItem, Consumable{

    /**
     * Stack representing the different water that can be contained in the bottle
     */
    private Stack<Water> drinks = new Stack<>();
    /***
     * Constructor.
     */
    public Bottle() {
        super("Bottle", 'b', false);

    }

    /**
     * Fills bottle with water
     * @param water Water that will be poured into the bottle
     */
    public void fill(Water water){
        drinks.push(water);
    }

    /**
     * Checks if bottle is at a specific capacity
     * @param capacity Capacity to be checked
     * @return Boolean depending on whether the bottle is at the specific capacity or not
     */
    public boolean checkCapacity(int capacity){
        return drinks.size() == capacity;
    }

    /**
     * @see PassableItem#passItem(Actor, Actor)
     * @param receivingActor
     * @param passingActor
     */
    @Override
    public void passItem(Actor receivingActor, Actor passingActor) {
        BottleManager.getInstance().addBottle(receivingActor.toString(), this);
        receivingActor.addItemToInventory(this);

    }

    /**
     * Generates ConsumeAction for the water in the bottle if not empty
     * @return List containing ConsumeAction for the water in the bottle
     */
    @Override
    public List<Action> getAllowableActions() {
        List<Action> actions = new ArrayList<>();
        if (!drinks.empty()) {
            actions.add(new ConsumeAction(this));
        }
        return actions;
    }

    @Override
    public String toString() {
        return "Bottle"  + drinks;
    }

    /**
     * @see Consumable#consumedBy(Actor, GameMap)
     * @param actor actor who consumes the item
     * @param map map containing the actor
     */
    @Override
    public void consumedBy(Actor actor, GameMap map) {
        drinks.pop().consumedFromBottle(actor);
    }
}
