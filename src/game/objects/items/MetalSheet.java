package game.objects.items;

import edu.monash.fit2099.engine.items.Item;
import game.constants.Status;

/**
 * Represents a metal sheet item, which is a type of item that extends the base Item class.
 * Metal sheets can be used in crafting or other interactions within the game world.
 * Created by:
 *
 * @author Weize Yu
 */
public class MetalSheet extends Item {

    /**
     * Constructor for creating a MetalSheet object.
     * Initializes the metal sheet with the name "Metal Sheet", the symbol '%', and is portable.
     */
    public MetalSheet() {
        super("Metal Sheet", '%', true);
        addCapability(Status.SCRAP);
    }
}
