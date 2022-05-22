package game.actors;

/**
 * Class representing the actors that are able to drink
 */
public interface Drinker {
    /**
     * Increases the Drinker's base/intrinsic attack by a specific amount of points
     * @param damage Integer representing how much damage the base attack should be increased by
     */
    void increaseBaseAttack(int damage);

    /**
     * Increases the Drinker's hit points by a specific amount of points
     * @param hitPoints Amount of points that the Drinker's health will be increased by
     */
    void increaseHitPoints(int hitPoints);
}
