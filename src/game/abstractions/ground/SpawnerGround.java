package game.abstractions.ground;

import edu.monash.fit2099.engine.positions.Location;
import game.abstractions.spawnable.SpawnRule;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * A specialized type of Ground that facilitates spawning items based on predefined rules.
 * Created by:
 *
 * @author Weize Yu
 */
public class SpawnerGround extends GroundBase {

    /**
     * List of rules for spawning items near the tree.
     */
    protected final List<SpawnRule> spawnRules = new ArrayList<>();

    /**
     * Constructor for SpawnerGround.
     *
     * @param symbol     The symbol representing this ground type.
     * @param spawnrules The rules for spawning items.
     */
    public SpawnerGround(char symbol, SpawnRule... spawnrules) {
        super(symbol);
        spawnRules.addAll(Arrays.asList(spawnrules));
    }

    /**
     * Checks for item spawning based on defined rules at a specific location.
     *
     * @param location The location at which to check for spawning.
     */
    public void checkSpawn(Location location) {
        for (SpawnRule rule : spawnRules) {
            rule.trySpawnItem(location);
        }
    }

    /**
     * Executes a tick, triggering the spawning check.
     *
     * @param location The location to perform the spawn check.
     */
    public void tick(Location location) {
        super.tick(location);
        checkSpawn(location);
    }
}
