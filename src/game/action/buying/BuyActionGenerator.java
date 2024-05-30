package game.action.buying;

import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.positions.Exit;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Location;
import game.action.buying.modifiers.BuyingModifiers;
import game.utility.Mathematics;

import java.util.Map;
import java.util.stream.Collectors;

/**
 * A class responsible for generating BuyAction instances based on
 * proximity and item prices.
 */
public class BuyActionGenerator {

    // Dependency injection for item modifiers.
    private final Map<Class<? extends Item>, Iterable<BuyingModifiers>> itemModifiers;

    /**
     * Constructor to inject the modifiers mapping.
     *
     * @param itemModifiers A map of item types to their corresponding modifiers.
     */
    public BuyActionGenerator(Map<Class<? extends Item>, Iterable<BuyingModifiers>> itemModifiers) {
        this.itemModifiers = itemModifiers;
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
        if (buyerLocation.getExits().stream()
                .map(Exit::getDestination)
                .collect(Collectors.toList())
                .contains(sellerLocation)) { // within proximity
            for (Item item : seller.getItemInventory()) {
                Iterable<BuyingModifiers> modifiers = itemModifiers.get(item.getClass());
                if (modifiers != null) {
                    buyActions.add(new BuyAction(item, buyer, modifiers));
                }
            }
        }
        return buyActions;
    }
}
