package game.constants;

/**
 * An enumeration representing various statuses that can be applied to actors in the game world.
 * Use this enum class to represent a status.
 * Example #1: if the player is sleeping, you can attach a Status.SLEEP to the player class or whatever
 * Created by:
 * - Riordan D. Alfredo
 * Modified by:
 *
 * @author Weize Yu
 */
public enum Status {
    /**
     * Indicates that an actor is hostile towards enemies.
     */
    HOSTILE_TO_ENEMY,

    /**
     * Indicates that an actor is hostile towards the player.
     */
    HOSTILE_TO_PLAYER,
    /**
     * Indicates that this is the INTERN
     */
    INTERN,
    /**
     * Indicates that this is a SCRAP
     */
    SCRAP
}
