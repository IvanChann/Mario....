package game;

import edu.monash.fit2099.engine.actors.Actor;

import java.util.ArrayList;
import java.util.Random;

/**
 * Class to store Monologues
 */
public class MonologueList {

    /**
     * The list of Monologues
     */
    private ArrayList<Monologue> monologues = new ArrayList<>();

    /**
     * Random number generator
     */
    private final Random rand = new Random();

    /**
     * Constructor
     */
    public MonologueList(){}

    /**
     * This function returns a random Monologue for the list
     * @return random Monologue
     */
    public Monologue getRandom(){
        return monologues.get(rand.nextInt(monologues.size()));
    }

    /**
     * This function returns a random Monologue for the list.
     * Checks for the Condition in otherActor
     * @param otherActor Actor being spoken to
     * @return random Monologue
     */
    public Monologue getRandom(Actor otherActor){
        ArrayList<Monologue> actorMonologues = new ArrayList<>();
        for (Monologue monologue: monologues) {
            if (!otherActor.hasCapability(monologue.getCondition())){
                actorMonologues.add(monologue);
            }
        }
        return actorMonologues.get(rand.nextInt(actorMonologues.size()));
    }

    /**
     * Add Monologue to list
     * @param monologue Monologue to add
     */
    public void add(Monologue monologue) {
        monologues.add(monologue);
    }
}

