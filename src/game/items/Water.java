package game.items;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import game.actors.Drinker;
import game.terrain.Fountain;

public class Water implements Consumable{
    Fountain fountain;

    public Water(Fountain fountain){
        this.fountain = fountain;

    }


    public String toString(){
        return fountain.toString() + " water";
    }


    @Override
    public void consumedBy(Actor actor, GameMap map) {
        fountain.reduceCapacity();
        fountain.giveEffects((Drinker) actor);
    }

    public void consumedFromBottle(Actor actor){
        fountain.giveEffects((Drinker) actor);
    }

}
