package game.actions;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.weapons.Weapon;
import game.items.Fire;

/**
 * Class representing the Fire Attack that Bowser and Player can use
 */
public class FireAttack extends AttackAction{
    private int turns = 3;

    /**
     * Constructor.
     *
     * @param target    the Actor to attack
     * @param direction the direction of the target
     */
    public FireAttack(Actor target, String direction) {
        super(target, direction);
    }

    /**
     * @see AttackAction#effectsOfAttack(Actor, GameMap)
     * @param target Actor receiving the attack
     * @param map Map that actor is on
     */
    @Override
    protected void effectsOfAttack(Actor target, GameMap map) {
        map.locationOf(target).addItem(new Fire(turns));
    }
}


