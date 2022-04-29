package game.terrain;

import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.positions.Ground;
import edu.monash.fit2099.engine.positions.Location;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Exit;
import game.actions.JumpAction;
import game.actors.Koopa;
import game.actors.Player;
import game.statuses.Status;


public class Mature extends HighGround{
    public int age;
    Exit exit;

    public Mature() {
        super('T', 30, 0.7);
        age = 0;
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
    public int damage(int damage){
        return damage;
    };

    /**
     * Accessor for success rate for each jump for this ground.
     *
     * @return the success rate.
     */
    @Override
    public double successRate(double successRate) {
        return successRate;
    }


}


