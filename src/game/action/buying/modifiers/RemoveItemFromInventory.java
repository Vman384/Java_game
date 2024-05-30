package game.action.buying.modifiers;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.Item;

/**
 * This buying modifier handles the transfer of an item from the seller's inventory
 * to the buyer's inventory as part of a purchase transaction.
 */
public class RemoveItemFromInventory implements BuyingModifiers {
    /**
     * Removes the purchased item from the seller's inventory and adds it to the buyer's inventory.
     *
     * @param buyer  The Actor making the purchase.
     * @param seller The Actor selling the item.
     * @param item   The Item being purchased.
     * @return A message indicating successful item transfer.
     */
    @Override
    public String execute(Actor buyer, Actor seller, Item item) {
        seller.removeItemFromInventory(item);
        buyer.addItemToInventory(item);
        return buyer + " received " + item + " from " + seller;
    }

    /**
     * Provides a description of the modifier's action.
     *
     * @return Currently an empty string, but can be customized to provide a detailed description if needed.
     */
    @Override
    public String description() {
        // This is where you would add a description of the modifier if you wanted one.
        // For example: "Removes the purchased item from the seller's inventory."
        return "";
    }
}
