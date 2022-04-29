package game.items;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Location;
import game.actions.PickupCoinAction;
import game.reset.Resettable;

import java.util.ArrayList;
import java.util.List;

public class Coin extends Item implements Resettable {
    private boolean remove = false;
    private Integer value;
    /***
     * Constructor.
     *  @param value The value of the coin
     */
    public Coin(Integer value) {
        super("Coin", '$', false);
        this.value = value;
        this.registerInstance();
    }


    public List<Action> getAllowableActions() {
        ArrayList<Action> actions = new ArrayList<>();
        actions.add(new PickupCoinAction(this));
        return actions;
    }
    public Integer getValue(){
        return this.value;
    }

    @Override
    public void tick(Location currentLocation) {
        if (remove) {
            currentLocation.removeItem(this);
        }
    }

    @Override
    public boolean resetInstance(GameMap map) {
        return remove = true;
    }
}
