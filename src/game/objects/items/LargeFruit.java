package game.objects.items;

import edu.monash.fit2099.engine.positions.Location;
import game.abstractions.item.ConsumableItem;
import game.abstractions.spawnable.Spawnable;

/**
 * A class representing a large fruit that inherits from Item and implements Spawnable.
 * Created by:
 *
 * @author Weize Yu
 */
public class LargeFruit extends ConsumableItem implements Spawnable {

    /**
     * Constructor.
     */
    public LargeFruit() {
        super("Large Fruit", 'O', true);
        healEffects = 2;
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
