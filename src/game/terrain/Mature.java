package game.terrain;

import edu.monash.fit2099.engine.positions.Location;
import edu.monash.fit2099.engine.positions.Exit;
import game.actors.Koopa;
import game.reset.Resettable;
import game.statuses.Status;
import java.util.ArrayList;



public class Mature extends Tree implements Resettable {
    public Mature() {
        super('T', 30, 0.7, 0);
    }


    @Override
    public void tick(Location location) {
        age++;
        if (!location.containsAnActor() && Math.random() < 0.15) {
            location.addActor(new Koopa());
        }

        if (age%5 == 0){
            ArrayList<Location> fertileGround = new ArrayList<>();
            for (Exit exits : location.getExits()){

                if (exits.getDestination().getGround().hasCapability(Status.FERTILE)){
                    fertileGround.add(exits.getDestination());
                }
            }

            Location randomFertile = fertileGround.get(random.nextInt(fertileGround.size()));
            randomFertile.setGround(new Sprout());
        }

        if (Math.random() < 0.2) {
            location.setGround(new Dirt());
        }
        super.tick(location);

    }
}







