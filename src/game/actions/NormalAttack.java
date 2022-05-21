package game.actions;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;

public class NormalAttack extends AttackAction{
    /**
     * Constructor.
     *
     * @param target    the Actor to attack
     * @param direction the direction of the target
     */
    public NormalAttack(Actor target, String direction) {
        super(target, direction);
    }

    @Override
    protected void effectsOfAttack(Actor actor, GameMap map) {}
}
