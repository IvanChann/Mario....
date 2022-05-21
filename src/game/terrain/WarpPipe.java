package game.terrain;

import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Location;
import game.actions.WarpAction;
import game.actors.PiranhaPlant;
import game.reset.Resettable;
import game.statuses.Status;

/**
 * Class representing a WarpPipe
 */
public class WarpPipe extends HighGround implements Resettable {

    /**
     * Location the WarpPipe is at
     */
    private Location currentLocation;

    /**
     * The connecting WarpPipe
     */
    private WarpPipe connectingPipe;

    /**
     * Constructor
     * @param connectingPipe The connecting WarpPipe
     */
    public WarpPipe(WarpPipe connectingPipe) {
        super('C', 0, 1);
        this.connectingPipe = connectingPipe;
        this.addCapability(Status.SPAWN_PIRANHA);
    }

    /**
     * Spawns the Piranha plant if has the Status SPAWN_PIRANHA
     * @param location The location of the Ground
     */
    @Override
    public void tick(Location location) {
        this.currentLocation = location;
        if (this.hasCapability(Status.SPAWN_PIRANHA)){
            location.addActor(new PiranhaPlant());
            this.removeCapability(Status.SPAWN_PIRANHA);
        }
    }

    /**
     * @see HighGround#allowableActions(Actor, Location, String)
     * @param actor the Actor acting
     * @param location the current Location
     * @param direction the direction of the Ground from the Actor
     * @return list of actions
     */
    @Override
    public ActionList allowableActions(Actor actor, Location location, String direction) {
        ActionList actions = super.allowableActions(actor, location, direction);
        if (direction.equals("")){ // If the Actor is directly on top of the WarpPipe
            actions.add(new WarpAction(this, this.connectingPipe));
        }
        return actions;
    }

    /**
     * @return the Location of the WarpPipe
     */
    public Location getCurrentLocation() {
        return currentLocation;
    }

    /**
     * Sets the connectingPipe
     * This is needed as it can change based on the last Warp
     * @param connectingPipe the connecting pipe
     */
    public void setConnectingPipe(WarpPipe connectingPipe) {
        this.connectingPipe = connectingPipe;
    }

    /**
     * @see Resettable#resetInstance()
     */
    @Override
    public boolean resetInstance() {
        return false;
    }
}
