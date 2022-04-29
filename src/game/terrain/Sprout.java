package game.terrain;
import game.actors.Goomba;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Ground;
import edu.monash.fit2099.engine.positions.Location;
import game.statuses.Status;

public class Sprout extends Ground implements HighGround{
    private int age;
    public Location location;

    public Sprout() {
        super('+');
        age = 0;
        this.addCapability(Status.JUMP);
    }

    @Override
    public void tick(Location location) {
        age++;
        if(getDisplayChar() != 'g') {
            if (age==10){
                location.setGround(new Sapling());
            }
            if (getDisplayChar() == '+' && Math.random()<0.1){
                location.addActor(new Goomba());
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
        return 10;
    }

    /**
     * Accessor for success rate for each jump for this ground.
     *
     * @return the success rate.
     */
    @Override
    public double successRate() {
        return 0.9;
    }
}
