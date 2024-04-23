package game.abstractions.spawnable;

import edu.monash.fit2099.engine.positions.Location;

/**
 * Interface for defining spawnable entities that can be spawned at a location.
 * Created by:
 *
 * @author Weize Yu
 */
public interface Spawnable {

    /**
     * Spawns the entity at the specified location.
     *
     * @param location The location where the entity should be spawned
     */
    void spawn(Location location);
}