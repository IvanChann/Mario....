package game.terrain;

import edu.monash.fit2099.engine.positions.Ground;
import edu.monash.fit2099.engine.positions.Location;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Exit;
import game.actors.Koopa;
import game.actors.Player;
import game.statuses.Status;


public class Mature extends Ground implements HighGround{
    public int age;
    Exit exit;

    public Mature() {
        super('T');
        age = 0;
        this.addCapability(Status.JUMP);
    }


    @Override
    public void tick(Location location) {
        age++;
        if (getDisplayChar() != 'K') {
            if (Math.random() < 0.2) {
                location.setGround(new Dirt());
            }
            if (!(location.containsAnActor()) && Math.random() < 0.15) {
                location.addActor(new Koopa());
            }
        }

        if (!exit.getDestination().containsAnActor() && exit.getDestination().getGround().hasCapability(Status.FERTILE)){
            exit.getDestination().setGround(new Sprout());
        }
    }
    /**
     * Accessor for damage done by this ground.
     *
     * @return the damage
     */
    @Override
    public int damage() {
        return 30;
    }

    /**
     * Accessor for success rate for each jump for this ground.
     *
     * @return the success rate.
     */
    @Override
    public double successRate() {
        return 0.7;
    }
}


