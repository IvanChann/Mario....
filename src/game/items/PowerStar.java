package game.items;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.positions.Location;
import game.actions.ConsumeAction;
import game.statuses.Status;

import java.util.ArrayList;
import java.util.List;

public class PowerStar extends Item implements Consumable, Purchasable{
    private int timer = 10;
    private boolean consumed = false;

    //private Actor actor;

    /***
     * Constructor.
     * @param portable true if and only if the Item can be picked up
     */
    public PowerStar(boolean portable) {

        super("Power Star", '*', portable);


    }

    @Override
    public void tick(Location currentLocation, Actor actor) {
        this.timer -= 1;
        if (this.timer == 0){
            actor.removeItemFromInventory(this);
        }
        System.out.println(timer + " turns of power star remaining");

    }
    public void tick(Location currentLocation){
        this.timer -= 1;
        if (this.timer == 0){
            currentLocation.removeItem(this);
        }
    }





