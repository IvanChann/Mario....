package game.items;

import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Location;
import game.actions.ConsumeAction;
import game.statuses.Status;

public class FireFlower extends Item implements Consumable{
    /**
     * A timer representing how many turns Fire Flower will last
     */
    private int timer = 20;
    /**
     * Whether the Fire Flower has been consumed yet
     */
    private boolean consumed = false;

    public FireFlower() {

        super("Fire Flower", 'f', true);
    }


}
