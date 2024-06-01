package game.objects.ground;

import edu.monash.fit2099.engine.positions.Location;
import game.abstractions.ground.SpawnerGround;
import game.abstractions.spawnable.SpawnRule;

/**
 * class representing a tree in the game world.
 * Trees are entities in the game environment that can grow and potentially transform into different forms over time.
 * This abstract class extends the SpawnerGround class, providing functionality for spawning entities on its tiles.
 * Created by:
 *
 * @author Weize Yu
 */
public abstract class Tree extends SpawnerGround {

    /**
     * The age of the tree.
     */
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
     * Performs actions that occur on each game tick, such as aging
     *
     * @param location the location of the tree in the game world
     */
    @Override
    public void tick(Location location) {
        super.tick(location);
        age++;
    }

}
