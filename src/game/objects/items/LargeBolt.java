package game.objects.items;

import edu.monash.fit2099.engine.items.Item;
import game.constants.Status;

/**
 * Represents a large bolt item that extends the base Item class.
 * Large bolts are items that can be used in various crafting recipes or as ammunition.
 * This class provides specific characteristics for large bolts.
 * Created by:
 *
 * @author Weize Yu
 */
public class LargeBolt extends Item {

    /**
     * Constructs a new LargeBolt with the default attributes.
     * The large bolt is represented by the symbol '+' and is portable.
     */
    public LargeBolt() {
        super("Large Bolt", '+', true);
        addCapability(Status.SCRAP);
    }
}