package game.objects.ground;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Ground;

/**
 * Represents a wall in the game world.
 * Walls are impassable terrain that actors cannot enter.
 * Created by:
 *
 * @author Riordan D. Alfredo
 * Modified by:
 * @author Weize Yu
 */
public class Wall extends Ground {

    /**
     * Constructor for Wall objects.
     */
    public Wall() {
        super('#');
    }

    /**
     * Determines whether an actor can enter the wall.
     *
     * @param actor the actor attempting to enter
     * @return always returns false since actors cannot enter walls
     */
    @Override
    public boolean canActorEnter(Actor actor) {
        return false;
    }
}
