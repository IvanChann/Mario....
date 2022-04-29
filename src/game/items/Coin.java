package game.items;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.items.PickUpItemAction;
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
        super("Coin", '$', true);
        this.value = value;
        this.registerInstance();
    }

    @Override
    public PickUpItemAction getPickUpAction(Actor actor){
        return new PickupCoinAction(this);
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
    public boolean resetInstance() {
        return remove = true;
    }
}
