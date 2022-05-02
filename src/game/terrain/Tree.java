package game.terrain;

import edu.monash.fit2099.engine.positions.Location;
import game.reset.Resettable;

import java.util.Random;

/**
 * Abstract class representing a Tree
 */
public abstract class Tree extends HighGround implements Resettable {
    /**
     * Age of the Tree
     */
    protected int age;

    /**
     * Random number generator
     */
    protected final Random random = new Random();

    /**
     * boolean representing if the Tree should be removed from the map
     */
    private boolean remove = false;

    /**
     * @see HighGround#HighGround(char, int, double)  HighGround
     * @param displayChar display character
     * @param damage the damage taken when failing jump
     * @param successRate the successRate of jump
     * @param age the age of the tree
     */
    public Tree(char displayChar, int damage, double successRate, int age) {
        super(displayChar, damage, successRate);
        this.age = age;
        registerInstance();
    }

    /**
     * @see HighGround#tick(Location)
     * @param location The location of the Ground
     */
    @Override
    public void tick(Location location) {
        if (remove) {
            location.setGround(new Dirt());
        }
        super.tick(location);
    }

    /**
     * @see Resettable#resetInstance()
     */
    @Override
    public boolean resetInstance() {
        return remove = random.nextBoolean();
    }

}
