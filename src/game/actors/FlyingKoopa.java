package game.actors;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.positions.GameMap;
import game.Monologue;
import game.statuses.Status;

public class FlyingKoopa extends Koopa{
    /**
     * Constructor. Makes all enemies unable to enter floors by using a capability
     *
     */
    public FlyingKoopa() {
        super("Flying Koopa", 'F', 150);
        this.addCapability(Status.CAN_FLY);
    }

    @Override
    public void createMonologues() {
       super.createMonologues();
       monologueList.add(new Monologue("Pam pam pam!"));
    }
}
