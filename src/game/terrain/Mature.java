package game.terrain;

import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.positions.Ground;
import edu.monash.fit2099.engine.positions.Location;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Exit;
import game.actions.JumpAction;
import game.actors.Koopa;
import game.actors.Player;
import game.reset.Resettable;
import game.statuses.Status;

import javax.print.attribute.standard.Destination;
import java.util.ArrayList;
import java.util.Random;


public class Mature extends HighGround implements Resettable {
    public int age;
    private int damage = 30;
    private final Random random = new Random();
    private boolean remove = false;

    public Mature() {
        super('T', 30, 0.7);
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
        if (getDisplayChar() != 'K') {
            if (Math.random() < 0.2) {
                location.setGround(new Dirt());
            }
            if (!(location.containsAnActor()) && Math.random() < 0.15) {
                location.addActor(new Koopa());
            }
        }
        if (age%5 == 0 && age != 0){
            ArrayList<Location> fertileGround = new ArrayList<>();
            for (Exit exits : location.getExits()){

                if (exits.getDestination().getGround().hasCapability(Status.FERTILE)){
                    fertileGround.add(exits.getDestination());
                }
            }

            Location randomFertile = fertileGround.get(random.nextInt(fertileGround.size()));
            randomFertile.setGround(new Sprout());
        }
    }

    @Override
    public ActionList allowableActions(Actor actor, Location location, String direction) {
        return new ActionList(new JumpAction((HighGround) location.getGround(), location, direction));
    }

    @Override
    public boolean canActorEnter(Actor actor) {
        return false;
    }

    @Override
    public boolean resetInstance() {
        return remove = random.nextBoolean();
    }

}







