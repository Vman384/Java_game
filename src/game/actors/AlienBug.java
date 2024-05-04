package game.actors;

import edu.monash.fit2099.engine.positions.Location;
import game.abstractions.actor.NPC;
import game.abstractions.spawnable.Spawnable;
import game.behaviour.FollowAndWanderBehaviour;
import game.behaviour.PickUpScrapsBehaviour;

/**
 * A class representing an Alien Bug NPC in the game world.
 * Alien Bugs cannot attack the intern but can wander and follow and also pick up scraps.
 * Created by:
 *
 * @author Harvey Houlahan
 */
public class AlienBug extends NPC implements Spawnable {

    /**
     * Constructor for AlienBug Objects
     */
    public AlienBug() {
        super("Alien Bug", 'a', 2);
        this.behaviours.put(999, new FollowAndWanderBehaviour());
        this.behaviours.put(99, new PickUpScrapsBehaviour());
    }

    /**
     * Creates a new instance of the AlienBug.
     *
     * @return a new instance of AlienBug
     */
    @Override
    protected NPC createNewInstance() {
        return new AlienBug();
    }

    /**
     * Spawns a AlienBug at the specified location.
     *
     * @param location the location where the AlienBug will spawn
     */
    @Override
    public void spawn(Location location) {
        location.addActor(createNewInstance());
    }

}
