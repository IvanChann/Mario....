package game.items;

import edu.monash.fit2099.engine.actors.Actor;

public interface Purchasable {
    public void purchasedBy(Actor actor);
    public int getPrice();
}
