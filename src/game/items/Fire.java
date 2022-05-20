package game.items;

import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.positions.Location;

public class Fire  extends Item {

    private int turns;

    private final int damage = 20;

    public Fire(int turns) {
        super("Fire", 'v', false);
        this.turns = turns;
    }

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
