package game.abstractions.item;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Location;

/**
 * The Teleportable interface should be implemented by items that have the ability to teleport
 * actors within the game. Implementing this interface allows an item to define custom logic for teleportation.
 */
public interface Teleportable {

    /**
     * Teleports the specified actor to a new location within the provided game map.
     *
     * @param actor   The actor to be teleported.
     * @param gameMap The game map in which the teleportation will occur.
     * @return The new location within the game map to which the actor is teleported.
     */
    Location teleport(Actor actor, GameMap gameMap);
}
