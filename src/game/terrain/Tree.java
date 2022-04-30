package game.terrain;

import edu.monash.fit2099.engine.positions.Location;
import game.reset.Resettable;

import java.util.Random;

public abstract class Tree extends HighGround implements Resettable {
    protected int age;
    protected final Random random = new Random();
    private boolean remove = false;

    public Tree(char displayChar, int damage, double successRate, int age) {
        super(displayChar, damage, successRate);
        this.age = age;
        registerInstance();
    }

    @Override
    public void tick(Location location) {
        if (remove) {
            location.setGround(new Dirt());
        }
    }

    @Override
    public boolean resetInstance() {
        return remove = random.nextBoolean();
    }
}
