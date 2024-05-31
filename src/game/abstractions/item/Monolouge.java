package game.abstractions.item;

/**
 * This interface represents a monologue in the game.
 * It has a single method, monologue(), which is used to display a monologue.
 *
 * @author Vedansh Malhan
 */
public interface Monolouge {
    /**
     * This method is used to display a monologue in the game.
     * A monologue is a speech or text that is delivered by a single character in the game.
     * It is typically used to convey information or backstory to the player.
     * The monologue() method should be implemented by any class that needs to display a monologue.
     */
    void monologue();
}