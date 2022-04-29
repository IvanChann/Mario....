package game.terrain;


/**
 * Base class for all high ground's
 */
public interface HighGround {
    /**
     * The amount of damage the ground will inflict on an unsuccessful jump
     *
     * @return the damage, in hitpoints
     */
    int damage();

    /**
     * The success rate for each jump for this ground
     *
     * @return the success rate, in %/100
     */
    double successRate();
}
