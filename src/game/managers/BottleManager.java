package game.managers;

import game.items.Bottle;
import game.items.Water;
import game.terrain.Fountain;

import java.util.HashMap;

public class BottleManager{
    public static final int MAX_CAPACITY = 10;
    private static BottleManager instance;
    private HashMap<String, Bottle> bottleHashMap = new HashMap<>();

    /***
     * Constructor.
     */
    private BottleManager(){}

    public static BottleManager getInstance(){
        if (instance == null){
            instance = new BottleManager();
        }
        return instance;
    }

    public void refill(String actorString, Fountain fountain){
        bottleHashMap.get(actorString).fill(new Water(fountain));
    }

    public boolean checkActorHasBottle(String actorString){
        return bottleHashMap.containsKey(actorString);
    }

    public boolean checkIfMaxCapacity(String actorString){
        return bottleHashMap.get(actorString).checkCapacity(MAX_CAPACITY);
    }

    public void addBottle(String actorString, Bottle bottle){
        bottleHashMap.put(actorString, bottle);
    }


    public String toString(){
        return "Bottle";
    }
}
