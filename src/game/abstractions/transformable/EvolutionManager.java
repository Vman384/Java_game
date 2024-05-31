package game.abstractions.transformable;

import edu.monash.fit2099.engine.positions.Location;
import game.objects.ground.Tree;

import java.util.Queue;

/**
 * Manages the evolution process of objects, specifically Trees in this context.
 * It maintains a queue of evolution stages and handles the transition to the next stage.
 */
public class EvolutionManager {
    private final Queue<Tree> evolutionStages;

    /**
     * Constructs an EvolutionManager with a sequence of evolution stages.
     *
     * @param evolutionStages A Queue containing the different stages of evolution.
     * @throws IllegalArgumentException If the evolution stages are null or empty.
     */
    public EvolutionManager(Queue<Tree> evolutionStages) {
        if (evolutionStages.isEmpty()) {
            throw new IllegalArgumentException("Evolution stages cannot be empty.");
        }
        this.evolutionStages = evolutionStages;
    }

    /**
     * Checks if there are more evolution stages available.
     *
     * @return True if there are more stages, false otherwise.
     */
    public boolean hasNextStage() {
        return !this.evolutionStages.isEmpty();
    }

    /**
     * Advances the object at the given location to its next evolution stage.
     *
     * @param location The location of the object to be evolved.
     * @throws IllegalStateException If there are no more evolution stages available.
     */
    public void evolve(Location location) {
        if (hasNextStage()) {
            Tree nextStageTree = evolutionStages.poll();
            assert nextStageTree != null;
            nextStageTree.assignEvolutionManager(this);
            location.setGround(nextStageTree);
        } else {
            throw new IllegalStateException("Cannot evolve: No more evolution stages available.");
        }
    }
}
