package game.action.buying.modifiers;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.Item;

/**
 * This modifier is responsible for deducting a specified price from the buyer's balance
 * and adding it to the seller's balance during a buying transaction.
 *
 * It ensures a proper transfer of funds in exchange for the item being purchased.
 */
public class DeductBalance implements BuyingModifiers {
    private final int price;

    /**
     * Constructs a DeductBalance modifier with the given price.
     *
     * @param price The amount of credits to be deducted from the buyer and added to the seller.
     */
    public DeductBalance(int price) {
        this.price = price;
    }

    /**
     * Executes the balance deduction and addition.
     *
     * @param buyer  The Actor making the purchase.
     * @param seller The Actor selling the item.
     * @param item   The Item being purchased (not used in this specific implementation).
     * @return A message indicating that the balance transfer was successful.
     */
    @Override
    public String execute(Actor buyer, Actor seller, Item item) {
        buyer.deductBalance(price);
        seller.addBalance(price);
        return buyer + " deducted " + price + " from balance and added to " + seller;
    }

    /**
     * Provides a description of the modifier's action.
     *
     * @return A string explaining that the modifier deducts and adds a specified amount.
     */
    @Override
    public String description() {
        return "Deducts " + price + " credits from the buyer's balance and adds to the seller's balance";
    }
}
