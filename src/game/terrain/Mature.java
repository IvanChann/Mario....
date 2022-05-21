package game.terrain;

import edu.monash.fit2099.engine.positions.Location;
import edu.monash.fit2099.engine.positions.Exit;
import game.actors.FlyingKoopa;
import game.actors.Koopa;
import game.actors.WalkingKoopa;
import game.reset.Resettable;
import game.statuses.Status;
import java.util.ArrayList;


/**
 * Class representing a Mature Tree
 */
public class Mature extends Tree implements Resettable {
    /**
     * Damage from failed jump
     */
    public static final int FALL_DAMAGE = 30;

    /**
     * Chance of success for jump
     */
    public static final double SUCCESS_RATE = 0.7;

    /**
     * Constructor
     * @see Tree#Tree(char, int, double, int)  Tree
     */
    public Mature() {
        super('T', Mature.FALL_DAMAGE, Mature.SUCCESS_RATE, 0);
    }

    /**
     * Spawn Koopa and Sprout or wilts based on conditions
     * @see Tree#tick(Location)
     * @param location The location of the Ground
     */
    @Override
    public void tick(Location location) {
        age++;
        if (!location.containsAnActor() && Math.random() < 0.15) {
            if (Math.random() < 0.5) {
                location.addActor(new WalkingKoopa());
            } else {
                location.addActor(new FlyingKoopa());
            }
        }
        if (age%5 == 0){
            ArrayList<Location> fertileGround = new ArrayList<>();
            for (Exit exits : location.getExits()){

                if (exits.getDestination().getGround().hasCapability(Status.FERTILE)){
                    fertileGround.add(exits.getDestination());
                }
            }

            Location randomFertile = fertileGround.get(random.nextInt(fertileGround.size()));
            randomFertile.setGround(new Sprout());
        }

        if (Math.random() < 0.2) {
            location.setGround(new Dirt());
        }
        super.tick(location);

    }
}







