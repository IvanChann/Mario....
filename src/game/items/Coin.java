package game.items;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.items.Item;
import game.actions.PickupCoinAction;

import java.util.ArrayList;
import java.util.List;

public class Coin extends Item {
    private Integer value;
    /***
     * Constructor.
     *  @param value The value of the coin
     */
    public Coin(Integer value) {
        super("Coin", '$', false);
        this.value = value;
    }


    public List<Action> getAllowableActions() {
        ArrayList<Action> actions = new ArrayList<>();
        actions.add(new PickupCoinAction(this));
        return actions;
    }
    public Integer getValue(){
        return this.value;
    }

}
