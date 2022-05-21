package game;

import edu.monash.fit2099.engine.actors.Actor;

import java.util.ArrayList;
import java.util.Random;

public class MonologueList {
    private ArrayList<Monologue> monologues = new ArrayList<>();

    private final Random rand = new Random();

    public MonologueList(){}

    public Monologue getRandom(){
        return monologues.get(rand.nextInt(monologues.size()));
    }

    public Monologue getRandom(Actor otherActor){
        ArrayList<Monologue> actorMonologues = new ArrayList<>();
        for (Monologue monologue: monologues) {
            if (!otherActor.hasCapability(monologue.getCondition())){
                actorMonologues.add(monologue);
            }
        }
        return actorMonologues.get(rand.nextInt(actorMonologues.size()));
    }

    public void add(Monologue monologue) {
        monologues.add(monologue);
    }
}

