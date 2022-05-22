package game.items;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import game.actors.Drinker;
import game.terrain.Fountain;

/**
 * Class representing the Water from a fountain
 */
public class Water implements Consumable{
    /**
     * Fountain that water is from
     */
    Fountain fountain;

    /**
     * Constructor
     * @param fountain Fountain that water is from
     */
    public Water(Fountain fountain){
        this.fountain = fountain;

    }


    public String toString(){
        return fountain.toString() + " water";
    }

    /**
     * Reduces capacity of Fountain then gives the Drinker the effects of consuming the water from fountain
     * @see Consumable#consumedBy(Actor, GameMap)
     * @param actor actor who consumes the item
     * @param map map containing the actor
     */
    @Override
    public void consumedBy(Actor actor, GameMap map) {
        fountain.reduceCapacity();
        fountain.giveEffects((Drinker) actor);
    }

    /**
     * Gives the Drinker the effects of consuming the water
     * @param actor actor who drinks the water
     */
    public void consumedFromBottle(Actor actor){
        fountain.giveEffects((Drinker) actor);
    }

}
