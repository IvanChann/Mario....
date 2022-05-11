package game.statuses;

/**
 * Use this enum class to give `buff` or `debuff`.
 * It is also useful to give a `state` to abilities or actions that can be attached-detached.
 */
public enum Status {
    HOSTILE_TO_ENEMY, // use this status to be considered hostile towards enemy (e.g., to be attacked by enemy)
    TALL, // use this status to tell that current instance has "grown".
    GLOWING, // effect from consuming Power Star
    CAN_DESTROY_SHELL, // status that allows an actor to destroy Koopa shells
    CANNOT_ENTER_FLOOR, // status that prevents an actor from entering floors
    CAN_RESET, // status allowing the player to reset the game
    FERTILE, // status applied to ground that marks them as fertile
    REMOVE_STAR, // status for the PowerStar class to know if the player reset their status
    SPAWN_PIRANHA
}
