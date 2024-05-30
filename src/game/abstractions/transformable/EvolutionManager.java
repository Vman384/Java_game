package game.abstractions.transformable;

import edu.monash.fit2099.engine.positions.Location;
import game.objects.ground.Tree;

import java.util.List;

public class EvolutionManager {
    private List<Tree> evolutionStages;
    public Tree subsequentStage;
    public int currentIndex = 0;

    public EvolutionManager(List<Tree> evolutionStages) {
        this.evolutionStages = evolutionStages;
        this.subsequentStage = evolutionStages.getFirst();
    }

    public void nextStage() {
        if ((currentIndex + 1) < this.evolutionStages.size()) {
            this.currentIndex++;
            this.subsequentStage = this.evolutionStages.get(this.currentIndex);
        }
    }

    public void grow(Location location) {
        this.subsequentStage.assignEvolutionManager(this);
        location.setGround(this.subsequentStage);
        nextStage();
    }
}
