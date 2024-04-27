package game.actors;

import edu.monash.fit2099.engine.positions.Location;
import edu.monash.fit2099.engine.weapons.IntrinsicWeapon;
import game.abstractions.actor.NPC;
import game.abstractions.spawnable.Spawnable;
import game.behaviour.AttackBehaviour;
import game.behaviour.WanderBehaviour;

/**
 * A class representing a Suspicious Alien NPC in the game world.
 * Huntsman Spiders are aggressive creatures capable of attacking nearby actors.
 * Created by:
 *
 * @author Harvey Houlahan
 *
 */
public class SuspiciousAlien extends NPC implements Spawnable {

    public SuspiciousAlien() {
        super("Suspicious Alien", 'ඞ', '3');
        this.behaviours.put(999, new WanderBehaviour());
        this.behaviours.put(100, new AttackBehaviour());
    }
    /**
     * Creates a new instance of the SuspiciousAlien.
     *
     * @return a new instance of SuspiciousAlien
     */
    @Override
    protected NPC createNewInstance() {
        return new SuspiciousAlien();
    }

    /**
     * Spawns a Suspicious Alien at the specified location.
     *
     * @param location the location where the Suspicious Alien will spawn
     */
    @Override
    public void spawn(Location location) {
        location.addActor(createNewInstance());
    }

    /**
     * Retrieves the intrinsic weapon of the Suspicious Alien.
     *
     * @return the intrinsic weapon of the Suspicious Alien
     */
    @Override
    public IntrinsicWeapon getIntrinsicWeapon() {
        return new IntrinsicWeapon(1, "susses", 25);
    }
}
