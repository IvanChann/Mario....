package game.terrain;

import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Location;
import game.actions.JumpAction;
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

    @Override
    public ActionList allowableActions(Actor actor, Location location, String direction) {
        return new ActionList(new JumpAction((HighGround) location.getGround(), location, direction));
    }

    @Override
    public boolean canActorEnter(Actor actor) {
        return false;
    }
}
