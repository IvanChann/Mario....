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

public class Bottle extends Item implements PassableItem, Consumable{

    private Stack<Water> drinks = new Stack<>();
    /***
     * Constructor.
     */
    public Bottle() {
        super("Bottle", 'b', false);

    }

    public void fill(Water water){
        drinks.push(water);
    }

    public boolean checkCapacity(int capacity){
        return drinks.size() == capacity;
    }

    @Override
    public void passItem(Actor receivingActor, Actor passingActor) {
        BottleManager.getInstance().addBottle(receivingActor.toString(), this);
        receivingActor.addItemToInventory(this);

    }

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

    @Override
    public void consumedBy(Actor actor, GameMap map) {
        drinks.pop().consumedFromBottle(actor);
    }
}
