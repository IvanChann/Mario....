package game.terrain;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Ground;
import edu.monash.fit2099.engine.positions.Location;
import game.statuses.Status;
import game.items.Coin;


public class Sapling extends HighGround {
    private int age;

    public Sapling(){
        super('t', 20, 0.8);
        age = 0;
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
