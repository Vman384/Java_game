package game.objects.ground;

import edu.monash.fit2099.engine.positions.Location;
import game.abstractions.spawnable.SpawnRule;
import game.abstractions.transformable.Transformable;

/**
 * InheritreeSprout class representing the sprout stage of the inheritree.
 *
 * @author Dean Mascitti
 */
public class InheritreeSprout extends Tree implements Transformable {

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
     * Performs actions that occur on each game tick, such as aging and potentially transforming.
     *
     * @param location the location of the tree in the game world
     */
    @Override
    public void tick(Location location) {
        super.tick(location);

        if (canTransform()) {
            this.evolutionManager.evolve(location);
        }
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
