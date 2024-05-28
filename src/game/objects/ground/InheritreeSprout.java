package game.objects.ground;

import edu.monash.fit2099.engine.positions.Location;
import game.abstractions.spawnable.SpawnRule;
import game.abstractions.transformable.Transformable;
import game.objects.items.SmallFruit;
import game.spawning.SimpleSpawner;

public class InheritreeSprout extends Tree implements Transformable {

    private int transformAge = 3;

    public InheritreeSprout(SpawnRule... spawnRules) {
        super(',', 0, spawnRules);
    }

    /**
     * Performs actions that occur on each game tick, such as aging and potentially transforming.
     *
     * @param location the location of the tree in the game world
     */
    @Override
    public void tick(Location location) {
        super.tick(location);
        checkTransform(location);
    }

    /**
     * Determines if the InheritreeSprout can transform into a mature tree.
     *
     * @return True if the tree has reached the transformation age, otherwise false.
     */
    @Override
    public boolean canTransform() {
        return age >= this.transformAge; // Adjust the transformation age as needed
    }

    /**
     * Transforms the InheritreeSprout into a mature tree.
     *
     * @return A new InheritreeSprout object.
     */
    @Override
    public void transform(Location location) {
        location.setGround(new InheritreeSapling(new SimpleSpawner(0.3, new SmallFruit())));
    }
}
