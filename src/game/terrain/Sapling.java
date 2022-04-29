package game.terrain;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Ground;
import edu.monash.fit2099.engine.positions.Location;
import game.statuses.Status;
import game.items.Coin;


public class Sapling extends Ground implements HighGround {
    private int age;

    public Sapling(){
        super('t');
        age = 0;
        this.addCapability(Status.JUMP);
    }

    @Override
    public void tick(Location location) {
        age++;
        if (getDisplayChar() != '$') {
            if (age == 10) {
                location.setGround(new Mature());
            }
            if (Math.random() < 0.1) {
                location.addItem(new Coin(20));
            }
        }
    }
    /**
     * Accessor for damage done by this ground.
     *
     * @return the damage
     */
    @Override
    public int damage() {
        return 20;
    }

    /**
     * Accessor for success rate for each jump for this ground.
     *
     * @return the success rate.
     */
    @Override
    public double successRate() {
        return 0.8;
    }

}
