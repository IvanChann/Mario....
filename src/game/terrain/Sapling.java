package game.terrain;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Ground;
import edu.monash.fit2099.engine.positions.Location;
import game.reset.Resettable;
import game.statuses.Status;
import game.items.Coin;

import java.util.Random;


public class Sapling extends HighGround implements Resettable {
    private int age;
    private boolean remove = false;
    private final Random random = new Random();


    public Sapling(){
        super('t', 20, 0.8);
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
        if (getDisplayChar() != '$') {
            if (age == 10) {
                location.setGround(new Mature());
            }
            if (Math.random() < 0.1) {
                location.addItem(new Coin(20));
            }
        }
    }

    @Override
    public boolean resetInstance() {
        return remove = random.nextBoolean();
    }
}
