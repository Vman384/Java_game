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
    public InheritreeMature(SpawnRule... spawnrules) {
        super('T', 5, spawnrules);
    }

    /**
     * Determines if the InheritreeMature object can transform into another type of tree.
     *
     * @return Always returns false since InheritreeMature cannot transform.
     */
    @Override
    public boolean canTransform() {
        return false;
    }
}
