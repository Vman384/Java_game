package game.objects.ground;

import game.abstractions.spawnable.SpawnRule;
import game.objects.items.LargeFruit;
import game.spawning.SimpleSpawner;

/**
 * Represents a non-mature Inheritree object in the game.
 * This class extends the Tree class.
 * Created by:
 *
 * @author Weize Yu
 */
public class InheritreeNonMature extends Tree {

    /**
     * Constructs a new InheritreeNonMature object.
     * Initializes its symbol and adds a fruit spawn rules.
     */
    public InheritreeNonMature(SpawnRule... spawnrules) {
        super('t', 0, spawnrules);
    }

    /**
     * Determines if the InheritreeNonMature can transform into a mature tree.
     *
     * @return True if the tree has reached the transformation age, otherwise false.
     */
    @Override
    public boolean canTransform() {
        return age > 5; // Adjust the transformation age as needed
    }

    /**
     * Transforms the InheritreeNonMature into a mature tree.
     *
     * @return A new InheritreeMature object.
     */
    @Override
    public Tree transform() {
        return new InheritreeMature(new SimpleSpawner(0.2, new LargeFruit()));
    }
}
