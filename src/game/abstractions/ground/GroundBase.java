package game.abstractions.ground;

import edu.monash.fit2099.engine.positions.Ground;
import edu.monash.fit2099.engine.positions.Location;
import game.abstractions.transformable.EvolutionManager;

/**
 * GroundBase class that all Ground types can inherit for extra functionality due to engine restrictions.
 *
 * @author Dean Mascitti
 */
public abstract class GroundBase extends Ground {
    protected EvolutionManager evolutionManager;

    /**
     * Constructor for GroundBase object.
     *
     * @param displayChar the display character of the object
     */
    public GroundBase(char displayChar) {
        super(displayChar);
    }

    /**
     * Performs actions that occur on each game tick, such as aging and potentially transforming.
     *
     * @param location the location of the tree in the game world
     */
    @Override
    public void tick(Location location) {
        super.tick(location);
        if (this.evolutionManager != null & canTransform()) {
            this.evolutionManager.evolve(location);
        }
    }

    /**
     * Sets the evolution manager
     *
     * @param evolutionManager the evoluation maanger
     */
    public void assignEvolutionManager(EvolutionManager evolutionManager) {
        this.evolutionManager = evolutionManager;
    }

    /**
     * Determines if the InheritreeYoung can transform into a mature tree.
     *
     * @return True if the tree has reached the transformation age, otherwise false.
     */
    public boolean canTransform() {
        return false; // Adjust the transformation age as needed
    }
}
