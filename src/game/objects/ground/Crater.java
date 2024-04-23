package game.objects.ground;

import game.abstractions.ground.SpawnerGround;
import game.abstractions.spawnable.SpawnRule;

/**
 * Represents a crater in the game world.
 * Craters are special types of ground tiles that may have specific rules for spawning entities.
 * This class extends the SpawnerGround class, which allows for entities to spawn on its tiles based on predefined rules.
 * Created by:
 *
 * @author Weize Yu
 */
public class Crater extends SpawnerGround {

    /**
     * Constructor for creating a Crater object.
     *
     * @param spawnrules rules for spawning entities within the crater
     */
    public Crater(SpawnRule... spawnrules) {
        super('u', spawnrules);
    }
}
