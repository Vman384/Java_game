package game.objects.ground;

import game.abstractions.spawnable.SpawnRule;

/**
 * InheritreeSprout class representing the sprout stage of the inheritree.
 *
 * @author Dean Mascitti
 */
public class InheritreeSprout extends Tree {

    private final static int NEXT_TRANSFORMATION = 3;
    private final int transformAge;

    /**
     * Constructor
     *
     * @param initialAge the initial age of the inheritree sprout
     * @param spawnRules rules for spawning its objects
     */
    public InheritreeSprout(int initialAge, SpawnRule... spawnRules) {
        super(',', initialAge, spawnRules);
        this.transformAge = initialAge + NEXT_TRANSFORMATION;
    }

    /**
     * Determines if the InheritreeSprout can transform into a young inheritree.
     *
     * @return True if the tree has reached the required transformation age, otherwise false.
     */
    @Override
    public boolean canTransform() {
        return age >= this.transformAge; // Adjust the transformation age as needed
    }

}
