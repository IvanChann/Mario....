package game.terrain;
import game.actors.Goomba;
import edu.monash.fit2099.engine.positions.Location;
import game.reset.Resettable;


public class Sprout extends Tree implements Resettable {
    public Sprout() {
        super('+', 10, 0.9, 0);
    }

    @Override
    public void tick(Location location) {
        age++;
        if (age == 10) {
            location.setGround(new Sapling());
        }
        else if (!location.containsAnActor() && Math.random() < 0.1) {
            location.addActor(new Goomba());
        }
        super.tick(location);
    }
}

