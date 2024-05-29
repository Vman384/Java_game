package game.action;

import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Location;
import game.utility.Mathematics;

import java.util.Map;

/**
 * A class responsible for generating BuyAction instances based on
 * proximity and item prices.
 */
public class BuyActionGenerator {

    // Dependency injection for item prices.
    private final Map<Class<? extends Item>, Integer> itemPrices;

    /**
     * Constructor to inject the price mapping.
     *
     * @param itemPrices A map of item types to their corresponding prices.
     */
    public BuyActionGenerator(Map<Class<? extends Item>, Integer> itemPrices) {
        this.itemPrices = itemPrices;
    }

    /**
     * Generates a list of possible buy actions based on actor proximity and item prices.
     *
     * @param buyer  The actor who wants to buy.
     * @param seller The actor from whom the buyer wants to buy.
     * @param map    The game map.
     * @return A list of BuyAction instances.
     */
    public ActionList generateBuyActions(Actor buyer, Actor seller, GameMap map) {
        ActionList buyActions = new ActionList();
        Location buyerLocation = map.locationOf(buyer);
        Location sellerLocation = map.locationOf(seller);

        if (Mathematics.distance(buyerLocation, sellerLocation) <= 1) { // within proximity
            for (Item item : seller.getItemInventory()) {
                Integer price = itemPrices.get(item.getClass());
                if (price != null) {
                    buyActions.add(new BuyAction(item, buyer, price));
                }
            }
        }
        return buyActions;
    }
}
