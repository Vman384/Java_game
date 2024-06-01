package game.abstractions.ground;

import edu.monash.fit2099.engine.positions.Ground;
import game.abstractions.transformable.EvolutionManager;

/**
 * GroundBase class that all Ground types can inherit for extra functionality due to engine restrictions.
 *
 * @author Dean Mascitti
 */
public abstract class GroundBase extends Ground {

    /**
     * Constructor for GroundBase object.
     *
     * @param displayChar the display character of the object
     */
    public GroundBase(char displayChar) {
        super(displayChar);
    }

    /**
     * Assigns an evolution manager to a certain class, will be overriden in relevant classes.
     *
     * @param evolutionManager
     */
    public void assignEvolutionManager(EvolutionManager evolutionManager) {};
}
