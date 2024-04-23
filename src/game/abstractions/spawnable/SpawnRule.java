package game.abstractions.spawnable;

import edu.monash.fit2099.engine.positions.Location;

/**
 * Interface for defining a spawn rule to determine item spawning conditions.
 * Created by:
 *
 * @author Weize Yu
 */
public interface SpawnRule {

    /**
     * Spawns the item at the given location.
     *
     * @param location The location where the item should be spawned
     * @return None
     */
    void trySpawnItem(Location location);
}
