package game.actions;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;

/**
 * Class representing the Attack that actors use by default
 */
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

    /**
     * No special effects for NormalAttack
     * @see AttackAction#effectsOfAttack(Actor, GameMap)
     * @param actor
     * @param map Map that actor is on
     */
    @Override
    protected void effectsOfAttack(Actor actor, GameMap map) {}
}
