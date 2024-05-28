package game.objects.ground;

import game.abstractions.spawnable.SpawnRule;

/**
 * Represents a mature Inheritree object in the game.
 * Inherits from the Tree class.
 * Created by:
 *
 * @author Weize Yu
 */
public class InheritreeMature extends Tree {

    /**
     * Constructor for InheritreeMature objects.
     *
     * @param spawnrules rules for spawning its subjects
     */
    public InheritreeMature(int initialAge, SpawnRule... spawnrules) {
        super('T', initialAge, spawnrules);
    }
}
