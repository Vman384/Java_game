package game.objects.ground;

import edu.monash.fit2099.engine.positions.Location;
import game.abstractions.spawnable.SpawnRule;
import game.abstractions.transformable.EvolutionManager;
import game.abstractions.transformable.Transformable;
import game.objects.items.LargeFruit;
import game.spawning.SimpleSpawner;

/**
 * Represents a sapling Inheritree object in the game.
 * This class extends the Tree class.
 * Created by:
 *
 * @author Weize Yu
 */
public class InheritreeSapling extends Tree implements Transformable {
    private int transformAge;
    private final static int NEXT_TRANSFORMATION = 6;
    private EvolutionManager evolutionManager;
    /**
     * Constructs a new InheritreeSapling object.
     * Initializes its symbol and adds a fruit spawn rules.
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
            this.evolutionManager.grow(location);
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


    @Override
    public void assignEvolutionManager(EvolutionManager evolutionManager) {
        this.evolutionManager = evolutionManager;
    }
}
