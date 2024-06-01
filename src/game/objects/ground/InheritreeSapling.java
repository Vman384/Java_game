package game.objects.ground;

import game.abstractions.spawnable.SpawnRule;

/**
 * Represents a sapling Inheritree object in the game.
 * This class extends the Tree class.
 *
 * @author Dean Mascitti
 */
public class InheritreeSapling extends Tree {
    private final static int NEXT_TRANSFORMATION = 6;
    private final int transformAge;

    /**
     * Constructs a new InheritreeSapling object.
     *
     * @param initialAge the initial age of the sapling inheritree
     * @param spawnRules rules for its spawning objects
     */
    public InheritreeSapling(int initialAge, SpawnRule... spawnRules) {
        super('t', initialAge, spawnRules);
        this.transformAge = initialAge + NEXT_TRANSFORMATION;
    }

    /**
     * Determines if the InheritreeSapling can transform.
     *
     * @return True if the tree has reached the transformation age, otherwise false.
     */
    @Override
    public boolean canTransform() {
        return age >= this.transformAge; // Adjust the transformation age as needed
    }
}
