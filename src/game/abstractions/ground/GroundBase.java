package game.abstractions.ground;

import edu.monash.fit2099.engine.positions.Ground;
import game.abstractions.transformable.EvolutionManager;

public abstract class GroundBase extends Ground {
    protected EvolutionManager evolutionManager;

    public GroundBase(char displayChar) {
        super(displayChar);
    }

    public void assignEvolutionManager(EvolutionManager evolutionManager) {
        this.evolutionManager = evolutionManager;
    }
}
