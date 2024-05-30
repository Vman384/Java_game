package game.action.buying;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.positions.GameMap;

/**
 * An action to buy an item from another actor.
 */
public class BuyAction extends Action {

    private final Item item;
    private final Actor buyer;
    private final int price;

    /**
     * Constructor.
     *
     * @param item  the item to be bought
     * @param buyer the actor buying the item
     * @param price the price of the item
     */
    public BuyAction(Item item, Actor buyer, int price) {
        this.item = item;
        this.buyer = buyer;
        this.price = price;
    }

    /**
     * Perform the Action.
     *
     * @param actor The actor performing the action.
     * @param map   The map the actor is on.
     * @return a description of what happened (the result of the action being performed) that can be displayed to the user.
     */
    @Override
    public String execute(Actor actor, GameMap map) {
        buyer.deductBalance(price);
        actor.addBalance(price);

        actor.removeItemFromInventory(item);
        buyer.addItemToInventory(item);

        return buyer + " bought " + item + " from " + actor + " for $" + price;
    }

    /**
     * Describe what action will be performed if this Action is chosen in the menu.
     *
     * @param actor The actor performing the action.
     * @return the action description to be displayed on the menu
     */
    @Override
    public String menuDescription(Actor actor) {
        return actor + " sells " + item + " for " + price + " credits, to " + buyer;
    }
}
