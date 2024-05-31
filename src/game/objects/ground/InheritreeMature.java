package game.objects.ground;

import game.abstractions.spawnable.SpawnRule;
import game.abstractions.transformable.EvolutionManager;

/**
 * Represents a mature Inheritree object in the game.
 * Inherits from the Tree class.
 * Created by:
 *
 * @author Weize Yu
 */
public class InheritreeMature extends Tree {
    private EvolutionManager evolutionManager;

    /**
     * Constructor for InheritreeMature objects.
     *
     * @param spawnrules rules for spawning its subjects
     */
    public InheritreeMature(int initialAge, SpawnRule... spawnrules) {
        super('T', initialAge, spawnrules);
    }

    @Override
    public void assignEvolutionManager(EvolutionManager evolutionManager) {
        this.evolutionManager = evolutionManager; // for if there are more stages in the future
    }
}
