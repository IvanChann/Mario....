package game.managers;

import game.Utils;
import game.items.Bottle;
import game.items.Water;
import game.terrain.Fountain;

import java.util.HashMap;

/**
 * Singleton class BottleManager that manages the bottles held by all actors
 */
public class BottleManager{
    /**
     * Singleton instance
     */
    private static BottleManager instance;
    /**
     * HashMap storing the Bottle that each actor owns if they currently have one
     */
    private HashMap<String, Bottle> bottleHashMap = new HashMap<>();

    /***
     * Constructor.
     */
    private BottleManager(){}

    /**
     * @return The singleton instance of BottleManager
     */
    public static BottleManager getInstance(){
        if (instance == null){
            instance = new BottleManager();
        }
        return instance;
    }

    /**
     * Refills the bottle of a specific actor with Water from a specific fountain
     * @param actorString String representation of the actor whose bottle will be filled
     * @param fountain Fountain that the water is from
     */
    public void refill(String actorString, Fountain fountain){
        bottleHashMap.get(actorString).fill(new Water(fountain));
    }

    /**
     * Checks whether an actor has a bottle or not
     * @param actorString String representation of actor
     * @return Boolean representing whether an actor has a bottle
     */
    public boolean checkActorHasBottle(String actorString){
        return bottleHashMap.containsKey(actorString);
    }

    /**
     * Checks if an actor's bottle is at max capacity
     * @param actorString Actor whose bottle will be checked
     * @return Boolean representing if bottle is full
     */
    public boolean checkIfMaxCapacity(String actorString){
        return bottleHashMap.get(actorString).checkCapacity(Utils.BOTTLE_MAX_CAPACITY);
    }

    /**
     * Adds a bottle to the hash map for a specific actor
     * @param actorString String representation of the actor who will be given a bottle
     * @param bottle Bottle to be given
     */
    public void addBottle(String actorString, Bottle bottle){
        bottleHashMap.put(actorString, bottle);
    }


    public String toString(){
        return "Bottle";
    }
}
