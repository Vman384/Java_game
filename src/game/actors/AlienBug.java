package game.actors;

import edu.monash.fit2099.engine.positions.Location;
import edu.monash.fit2099.engine.weapons.IntrinsicWeapon;
import game.abstractions.actor.NPC;
import game.abstractions.spawnable.Spawnable;
import game.behaviour.AttackBehaviour;
import game.behaviour.WanderBehaviour;
import game.constants.Status;

/**
 * A class representing an Alien Bug NPC in the game world.
 * Alien Bugs are aggressive creatures capable of attacking nearby actors.
 * Created by:
 *
 * @author Harvey Houlahan
 *
 */
public class AlienBug extends NPC implements Spawnable {

    public AlienBug() {
        super("Alien Bug", 'a', '2');
        this.behaviours.put(999, new WanderBehaviour());
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
