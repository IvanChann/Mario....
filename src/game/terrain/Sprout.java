package game.terrain;
import game.actors.Goomba;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Ground;
import edu.monash.fit2099.engine.positions.Location;
import game.reset.Resettable;
import game.statuses.Status;

import java.util.Random;

public class Sprout extends HighGround implements Resettable {
    private int age;
    private boolean remove = false;
    private final Random random = new Random();

    public Sprout() {
        super('+', 10, 0.9);
        age = 0;
        registerInstance();
    }

    @Override
    public void tick(Location location) {
        if (remove){
            location.setGround(new Dirt());
            return;
        }
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

    @Override
    public boolean resetInstance() {
        return remove = random.nextBoolean();
    }
}

