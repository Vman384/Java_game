package game.action.buying.modifiers;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.positions.GameMap;
import game.utility.Probability;

/**
 * A buying modifier that applies a random price adjustment to a transaction.
 * The price can either remain at the base price or be changed to a different adjusted price,
 * with the outcome determined by a probability check.
 */
public class RandomPriceModifier implements BuyingModifiers {
    private final double changeProbability;
    private final int adjustedPrice;
    private final DeductBalance baseDeduction;

    /**
     * Constructs a RandomPriceModifier with the specified prices and change probability.
     *
     * @param basePrice         The standard, unchanged price of the item.
     * @param changeProbability The probability (0.0 to 1.0) of the price being adjusted to the `adjustedPrice`.
     * @param adjustedPrice     The alternative price that may be used if the probability check passes.
     */
    public RandomPriceModifier(int basePrice, double changeProbability, int adjustedPrice) {
        this.changeProbability = changeProbability;
        this.adjustedPrice = adjustedPrice;
        this.baseDeduction = new DeductBalance(basePrice);
    }

    /**
     * Executes the buying modifier, potentially applying a random price adjustment.
     *
     * @param buyer   The Actor purchasing the item.
     * @param seller  The Actor selling the item.
     * @param item    The Item being purchased.
     * @param gameMap The GameMap the actors are in.
     * @return A message indicating the outcome of the transaction, including the final price.
     */
    @Override
    public String execute(Actor buyer, Actor seller, Item item, GameMap gameMap) {
        if (Probability.generateBoolean(changeProbability)) {
            return new DeductBalance(adjustedPrice).execute(buyer, seller, item, gameMap);
        }
        return baseDeduction.execute(buyer, seller, item, gameMap);
    }

    /**
     * Provides a description of the modifier's behavior, highlighting the potential for a price change.
     *
     * @return A string describing the price
     */
    @Override
    public String description() {
        return baseDeduction.description();
    }
}
