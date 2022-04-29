package game.terrain;
import game.actors.Goomba;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Ground;
import edu.monash.fit2099.engine.positions.Location;
import game.statuses.Status;

public class Sprout extends HighGround {
    private int age;

    public Sprout() {
        super('+', 10, 0.9);
        age = 0;
    }

    @Override
    public void tick(Location location) {
        age++;
        if (getDisplayChar() != 'g') {
            if (age == 10) {
                location.setGround(new Sapling());
            }
            if (getDisplayChar() == '+' && Math.random() < 0.1) {
                location.addActor(new Goomba());
            }
        }
    }
}

