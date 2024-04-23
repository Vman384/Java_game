package game.objects.items;

import edu.monash.fit2099.engine.positions.Location;
import game.abstractions.item.ConsumableItem;
import game.abstractions.spawnable.Spawnable;


/**
 * A class representing a small fruit that inherits from Item and implements Spawnable.
 * Created by:
 *
 * @author Weize Yu
 */
public class SmallFruit extends ConsumableItem implements Spawnable {
    /**
     * Constructor.
     */
    public SmallFruit() {
        super("Small Fruit", 'o', true);
        healEffects = 1;
    }

    /**
     * Spawns the fruit at the specified location.
     *
     * @param location the location where the fruit will be spawned
     */
    @Override
    public void spawn(Location location) {
        location.addItem(this);
    }
}
