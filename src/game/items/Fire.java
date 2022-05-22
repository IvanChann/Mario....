package game.items;

import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.positions.Location;
/**
 * Class representing Fire
 */

public class Fire  extends Item {

    private int turns;

    private final int damage = 20;
    /***
     * Constructor.
     */
    public Fire(int turns) {
        super("Fire", 'v', false);
        this.turns = turns;
    }
    /**
     * Fire disappears after 3 turns and actor will be damaged if they are standing on fire
     * @param currentLocation The location of the ground on which we lie.
     */

    @Override
    public void tick(Location currentLocation) {
        if (turns == 0){
            currentLocation.removeItem(this);
        }
        if (currentLocation.containsAnActor()){
            currentLocation.getActor().hurt(damage);
        }
        turns -= 1;
        super.tick(currentLocation);
    }
}
