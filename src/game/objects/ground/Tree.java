package game.objects.ground;

import edu.monash.fit2099.engine.positions.Location;
import game.abstractions.ground.SpawnerGround;
import game.abstractions.spawnable.SpawnRule;
import game.abstractions.transformable.Transformable;

/**
 * class representing a tree in the game world.
 * Trees are entities in the game environment that can grow and potentially transform into different forms over time.
 * This abstract class extends the SpawnerGround class, providing functionality for spawning entities on its tiles.
 * Created by:
 *
 * @author Weize Yu
 */
public class Tree extends SpawnerGround implements Transformable {

    /** The age of the tree. */
    protected int age = 0;

    /**
     * Constructor for creating a Tree object.
     *
     * @param displayChar character representing the tree when displayed on the game map
     * @param initialAge  the initial age of the tree
     * @param spawnRules  rules for spawning entities around the tree, can be none
     */
    public Tree(char displayChar, int initialAge, SpawnRule... spawnRules) {
        super(displayChar, spawnRules);
        age = initialAge;
    }

    /**
     * Performs actions that occur on each game tick, such as aging and potentially transforming.
     *
     * @param location the location of the tree in the game world
     */
    @Override
    public void tick(Location location) {
        super.tick(location);
        age++;
        if (canTransform()) {
            Tree transformedTree = transform();
            location.setGround(transformedTree);
        }
    }

    /**
     * Checks if the tree can transform into another form based on certain conditions.
     *
     * @return true if the tree can transform, false otherwise
     */
    public boolean canTransform() {
        return false;
    };

    /**
     * Transforms the tree into another form. Subclasses can override this method to implement specific transformation behavior.
     *
     * @return the transformed tree, which may be of a different type than the original tree
     */
    public Tree transform() {
        // By default, the tree does not transform and returns itself
        return this;
    }
}
