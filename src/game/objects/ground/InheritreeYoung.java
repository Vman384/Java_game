package game.objects.ground;

import game.abstractions.spawnable.SpawnRule;

/**
 * InheritreeYoung class represents the young stage of the inheritree.
 *
 * @author Dean Mascitti
 */
public class InheritreeYoung extends Tree {

    private final static int NEXT_TRANSFORMATION = 5;
    private final int transformAge;

    /**
     * Constructs a new InheritreeYoung object.
     * Initializes its symbol and adds a fruit spawn rules.
     */
    /**
     * Constructs a new InheritreeYoung object.
     *
     * @param initialAge ititial age of the young inheritree
     * @param spawnRules rules for its spawning objects
     */
    public InheritreeYoung(int initialAge, SpawnRule... spawnRules) {
        super('y', initialAge, spawnRules);
        this.transformAge = initialAge + NEXT_TRANSFORMATION;
    }

    /**
     * Determines if the InheritreeYoung can transform into a mature tree.
     *
     * @return True if the tree has reached the transformation age, otherwise false.
     */
    @Override
    public boolean canTransform() {
        return age >= this.transformAge; // Adjust the transformation age as needed
    }

}
