package game.terrain;
import game.actors.Goomba;
import edu.monash.fit2099.engine.positions.Location;
import game.items.FireFlower;
import game.reset.Resettable;

/**
 * Class representing a Sprout
 */
public class Sprout extends Tree implements Resettable {

    /**
     * @see Tree#Tree(char, int, double, int)  Tree
     */
    public Sprout() {
        super('+', 10, 0.9, 0);
    }

    /**
     * Grows or spawns Goomba based on conditions
     * @see Tree#tick(Location)
     * @param location The location of the Ground
     */
    @Override
    public void tick(Location location) {
        age++;
        if (age == 10) {
            if (Math.random() < 0.5){
                location.addItem(new FireFlower());
                location.setGround(new Sapling());
            } else{
                location.setGround(new Sapling());
            }
        }
        else if (!location.containsAnActor() && Math.random() < 0.1) {
            location.addActor(new Goomba());
        }
        super.tick(location);
    }
}

