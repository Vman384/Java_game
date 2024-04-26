package game.objects.ground;

import edu.monash.fit2099.engine.positions.Ground;

/**
 * Represents a puddle on the ground in the game world.
 * Puddles are represented by the '~' character.
 * Created by:
 *
 * @author Riordan D. Alfredo
 * Modified by:
 * @author Weize Yu
 */
public class Puddle extends Ground {
    /**
     * Constructor for Puddle objects.
     */
    public Puddle() {
        super('~');
    }
}
