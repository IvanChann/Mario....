package game.items;

import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.positions.Location;

public class Fire extends Item {
    private int turns;
    private int damage = 20;
    /***
     * Constructor.

     */
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
            System.out.println(currentLocation.getActor() + " burns for " + damage + " damage!");
            currentLocation.getActor().hurt(damage);
        }
        turns -= 1;
    }
}
