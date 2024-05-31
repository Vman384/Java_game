package game.objects.ground;

import edu.monash.fit2099.engine.positions.Location;
import game.abstractions.spawnable.SpawnRule;
import game.abstractions.transformable.EvolutionManager;
import game.abstractions.transformable.Transformable;


public class InheritreeSprout extends Tree implements Transformable {

    private int transformAge;
    private final static int NEXT_TRANSFORMATION = 3;
    private EvolutionManager evolutionManager;

    public InheritreeSprout(int initialAge, SpawnRule... spawnRules) {
        super(',', initialAge, spawnRules);
        this.transformAge = initialAge + NEXT_TRANSFORMATION;
    }

    /**
     * Performs actions that occur on each game tick, such as aging and potentially transforming.
     *
     * @param location the location of the tree in the game world
     */
    @Override
    public void tick(Location location) {
        super.tick(location);

        if(canTransform()) {
            this.evolutionManager.evolve(location);
        }
    }

    /**
     * Determines if the InheritreeSprout can transform into a mature tree.
     *
     * @return True if the tree has reached the transformation age, otherwise false.
     */
    @Override
    public boolean canTransform() {
        return age >= this.transformAge; // Adjust the transformation age as needed
    }


    @Override
    public void assignEvolutionManager(EvolutionManager evolutionManager) {
        this.evolutionManager = evolutionManager;
    }
}
