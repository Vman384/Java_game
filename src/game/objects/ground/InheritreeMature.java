package game.objects.ground;

import game.abstractions.spawnable.SpawnRule;
import game.abstractions.transformable.EvolutionManager;

/**
 * Represents a mature Inheritree object in the game.
 * Inherits from the Tree class.
 *
 * @author Weize Yu
 * @author Dean Mascitti
 */
public class InheritreeMature extends Tree {
    private EvolutionManager evolutionManager;

    /**
     * Constructor for InheritreeMature objects.
     *
     * @param initialAge the initial age of the mature inheritree
     * @param spawnrules rules for spawning its objects
     */
    public InheritreeMature(int initialAge, SpawnRule... spawnrules) {
        super('T', initialAge, spawnrules);
    }

    /**
     * Assigns the mature inheritree with the evolution manager managing its next evolution stages.
     *
     * @param evolutionManager the evolution manager object
     */
    @Override
    public void assignEvolutionManager(EvolutionManager evolutionManager) {
        this.evolutionManager = evolutionManager; // for if there are more stages in the future
    }
}
