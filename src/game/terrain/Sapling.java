package game.terrain;
import edu.monash.fit2099.engine.positions.Location;
import game.reset.Resettable;
import game.items.Coin;

public class Sapling extends Tree implements Resettable {

    public Sapling(){
        super('t', 20, 0.8, 0);
    }

    @Override
    public void tick(Location location) {
        age++;
        if (age == 10) {
            location.setGround(new Mature());
        }
        else if (Math.random() < 0.1) {
            location.addItem(new Coin(20));
        }
        super.tick(location);
    }
}
