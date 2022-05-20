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


}
