package game.objects.ground;

import edu.monash.fit2099.engine.positions.Location;
import game.abstractions.spawnable.SpawnRule;
import game.abstractions.transformable.Transformable;

/**
 * Represents a sapling Inheritree object in the game.
 * This class extends the Tree class.
 *
 * @author Dean Mascitti
 */
public class InheritreeSapling extends Tree implements Transformable {
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
     * Determines if the InheritreeSapling can transform.
     *
     * @return True if the tree has reached the transformation age, otherwise false.
     */
    @Override
    public boolean canTransform() {
        return age >= this.transformAge; // Adjust the transformation age as needed
    }
}
