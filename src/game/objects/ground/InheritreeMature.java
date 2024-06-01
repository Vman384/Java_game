package game.objects.ground;

import game.abstractions.spawnable.SpawnRule;
import game.abstractions.transformable.Transformable;

/**
 * Represents a mature Inheritree object in the game.
 * Inherits from the Tree class.
 *
 * @author Weize Yu
 * @author Dean Mascitti
 */
public class InheritreeMature extends Tree implements Transformable {

    /**
     * Constructor for InheritreeMature objects.
     *
     * @param initialAge the initial age of the mature inheritree
     * @param spawnrules rules for spawning its objects
     */
    public InheritreeMature(int initialAge, SpawnRule... spawnrules) {
        super('T', initialAge, spawnrules);
    }


    @Override
    public boolean canTransform() {
        return false;
    }
}
