package game.items;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Location;
import game.actions.ConsumeAction;
import game.statuses.Status;

import java.util.ArrayList;
import java.util.List;

public class PowerStar extends Item implements Consumable, Purchasable{
    private int timer = 10;
    private int price = 600;
    private boolean consumed = false;
    public static final int HEALING = 200;

    //private Actor actor;

    /***
     * Constructor.
     */
    public PowerStar() {

        super("Power Star", '*', true);


    }

    @Override
    public void tick(Location currentLocation, Actor actor) {
        if (consumed && !actor.hasCapability(Status.GLOWING)){
            actor.removeItemFromInventory(this);
            return;
        }
        this.timer -= 1;
        System.out.println(timer + " turns of power star remaining");
        if (this.timer == 0){
            actor.removeItemFromInventory(this);
        }


    }
    public void tick(Location currentLocation){
        this.timer -= 1;
        System.out.println(timer + " turns of power star remaining");
        if (this.timer == 0){
            currentLocation.removeItem(this);
        }

    }
    @Override
    public void consumedBy(Actor actor, GameMap map) {
        if (map.locationOf(actor).getItems().contains(this)) {
            map.locationOf(actor).removeItem(this);
            actor.addItemToInventory(this);
        }
        this.togglePortability();
        this.consumed = true;
        actor.heal(PowerStar.HEALING);
        actor.addCapability(Status.GLOWING);
        this.timer = 10;
    }

    @Override
    public void purchasedBy(Actor actor) {
        this.togglePortability();
        actor.addItemToInventory(this);
    }

    @Override
    public int getPrice() {
        return price;
    }

    @Override
    public List<Action> getAllowableActions() {
        if (!consumed) {
            ArrayList<Action> actions = new ArrayList<>();
            actions.add(new ConsumeAction(this));
            return actions;
        }
        return super.getAllowableActions();
    }
}





