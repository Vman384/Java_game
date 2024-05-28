package game.spawning;

import edu.monash.fit2099.engine.positions.Exit;
import edu.monash.fit2099.engine.positions.Location;
import game.abstractions.spawnable.SpawnRule;
import game.abstractions.spawnable.Spawnable;
import game.utility.Probability;

import java.util.ArrayList;
import java.util.List;

/**
 * A concrete implementation of SpawnRule for spawning entities that implement the Spawnable interface.
 *
 * @author Weize Yu
 */
public final class SimpleSpawner implements SpawnRule {
    private final Spawnable entityToSpawn;
    private final double spawnProb;

    /**
     * Constructor for SimpleSpawner.
     *
     * @param spawnProb     The probability of spawning the entity.
     * @param entityToSpawn The entity to spawn.
     */
    public SimpleSpawner(double spawnProb, Spawnable entityToSpawn) {
        this.spawnProb = spawnProb;
        this.entityToSpawn = entityToSpawn;
    }

    /**
     * Attempts to spawn the entity at the specified location based on the spawn probability.
     *
     * @param location The location where the entity is to be spawned.
     */
    @Override
    public void trySpawnItem(Location location) {
        if (!Probability.generateBoolean(spawnProb)) {
            return;
        }

        List<Exit> exits = location.getExits();
        List<Exit> possibleSpawnLocation = new ArrayList<>();
        for (Exit exit : exits) {
            if (!exit.getDestination().containsAnActor()) {
                possibleSpawnLocation.add(exit);
            }
        }
        if (possibleSpawnLocation.isEmpty()) {
            return;
        }

        Exit exit = Probability.pickRandom(possibleSpawnLocation);
        Location spawnLocation = exit.getDestination();
        entityToSpawn.spawn(spawnLocation); // Spawn the entity at the specified location
    }
}
