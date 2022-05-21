package game.items;

import edu.monash.fit2099.engine.actors.Actor;

public interface PassableItem {
    public void passItem(Actor receivingActor, Actor passingActor);
}
