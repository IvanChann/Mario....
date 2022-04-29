package game.statuses;

/**
 * Use this enum class to give `buff` or `debuff`.
 * It is also useful to give a `state` to abilities or actions that can be attached-detached.
 */
public enum Status {
    HOSTILE_TO_ENEMY, // use this status to be considered hostile towards enemy (e.g., to be attacked by enemy)
    TALL, // use this status to tell that current instance has "grown".
    GLOWING, // effect from consuming Power Star
    CAN_DESTROY_SHELL,
    CANNOT_ENTER_FLOOR,
    FERTILE, // use this to check if the ground is fertile(which is dirt).
    JUMP, // use this status to check if the actor needs to jump.
    CAN_RESET,
}
