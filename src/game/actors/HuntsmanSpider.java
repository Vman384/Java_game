package game.actors;

import edu.monash.fit2099.engine.positions.Location;
import edu.monash.fit2099.engine.weapons.IntrinsicWeapon;
import game.abstractions.actor.NPC;
import game.abstractions.spawnable.Spawnable;
import game.behaviour.AttackBehaviour;
import game.behaviour.WanderBehaviour;

/**
 * A class representing a Huntsman Spider NPC in the game world.
 * Huntsman Spiders are aggressive creatures capable of attacking nearby actors.
 * Created by:
 *
 * @author Weize Yu
 */
public class HuntsmanSpider extends NPC implements Spawnable {
    /**
     * Constructor for HuntsmanSpider objects.
     */
    public HuntsmanSpider() {
        super("Huntsman Spider", '8', 1);
        this.behaviours.put(999, new WanderBehaviour());
        this.behaviours.put(100, new AttackBehaviour());
    }

    /**
     * Creates a new instance of the HuntsmanSpider.
     *
     * @return a new instance of HuntsmanSpider
     */
    @Override
    protected NPC createNewInstance() {
        return new HuntsmanSpider();
    }

    /**
     * Spawns a HuntsmanSpider at the specified location.
     *
     * @param location the location where the HuntsmanSpider will spawn
     */
    @Override
    public void spawn(Location location) {
        location.addActor(createNewInstance());
    }

    /**
     * Retrieves the intrinsic weapon of the HuntsmanSpider.
     *
     * @return the intrinsic weapon of the HuntsmanSpider
     */
    @Override
    public IntrinsicWeapon getIntrinsicWeapon() {
        return new IntrinsicWeapon(1, "bites", 25);
    }
}
