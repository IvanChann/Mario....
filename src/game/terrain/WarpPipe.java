package game.terrain;

import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Location;
import game.actions.WarpAction;
import game.actors.PiranhaPlant;
import game.statuses.Status;

public class WarpPipe extends HighGround{
    /**
     * Constructor for High Ground's
     */
    private Location currentLocation;
    private WarpPipe connectingPipe;

    public WarpPipe(WarpPipe connectingPipe) {
        super('C', 0, 1);
        this.connectingPipe = connectingPipe;
        this.addCapability(Status.SPAWN_PIRANHA);
    }

    @Override
    public void tick(Location location) {
        this.currentLocation = location;
        if (this.hasCapability(Status.SPAWN_PIRANHA)){
            location.addActor(new PiranhaPlant());
            this.removeCapability(Status.SPAWN_PIRANHA);
        }
    }

    @Override
    public ActionList allowableActions(Actor actor, Location location, String direction) {
        ActionList actions = super.allowableActions(actor, location, direction);
        if (direction.equals("")){
            actions.add(new WarpAction(this, this.connectingPipe));
        }
        return actions;
    }

    public Location getCurrentLocation() {
        return currentLocation;
    }

    public void setConnectingPipe(WarpPipe connectingPipe) {
        this.connectingPipe = connectingPipe;
    }
}
