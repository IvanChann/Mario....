package game.terrain;
import edu.monash.fit2099.engine.positions.Location;
import game.items.FireFlower;
import game.reset.Resettable;
import game.items.Coin;

/**
 * Class representing a Sapling
 */
public class Sapling extends Tree implements Resettable {

    /**
     * @see Tree#Tree(char, int, double, int)  Tree
     */
    public Sapling(){
        super('t', 20, 0.8, 0);
    }

    /**
     * Grows or spawns coins based on conditions
     * @see Tree#tick(Location)
     * @param location The location of the Ground
     */
    @Override
    public void tick(Location location) {
        age++;
        if (age == 10) {
            if (Math.random() < 0.5){
                location.addItem(new FireFlower());
            } else {
                location.setGround(new Mature());
            }
        }
        else if (Math.random() < 0.1) {
            location.addItem(new Coin(20));
        }
        super.tick(location);
    }
}
