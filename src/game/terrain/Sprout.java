package game.terrain;
import game.actors.Goomba;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Ground;
import edu.monash.fit2099.engine.positions.Location;

public class Sprout extends Ground implements HighGround{
    private int age;
    public Location location;

    public Sprout() {
        super('+');
        age = 0;
    }

    @Override
    public void tick(Location location) {
        age++;
        if(getDisplayChar() != 'g') {
            if (age==10){
                location.setGround(new Sapling());
            }
            if (getDisplayChar() == '+' && Math.random()<0.1){
                location.addActor(new Goomba());
            }
        }

    }
}
