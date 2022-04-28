package game.terrain;


import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Ground;
import edu.monash.fit2099.engine.positions.Location;
import game.items.Coin;
import game.statuses.Status;

public abstract class HighGround extends Ground {

    /**
     * Constructor.
     *
     * @param displayChar character to display for this type of terrain
     */
    public HighGround(char displayChar) {
        super(displayChar);
    }

    @Override
    public boolean canActorEnter(Actor actor) {
        if (actor.hasCapability(Status.GLOWING)){
            return true;
        }
        return false;
    }

    @Override
    public void tick(Location location) {
        if (location.containsAnActor() && location.getActor().hasCapability(Status.GLOWING)){
            location.setGround(new Dirt());
            location.addItem(new Coin(5));
        }
    }
}
