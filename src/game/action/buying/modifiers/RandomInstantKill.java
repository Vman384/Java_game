package game.action.buying.modifiers;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.actors.attributes.BaseActorAttributes;
import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.weapons.IntrinsicWeapon;
import game.action.AttackAction;
import game.utility.Probability;

/**
 * A buying modifier that introduces a chance of instantly killing the seller
 * during a transaction.
 */
public class RandomInstantKill implements BuyingModifiers {

    /**
     * The probability (between 0.0 and 1.0) of the seller being instantly killed.
     */
    private final double killProbability;

    /**
     * Constructs a RandomInstantKill modifier with the given kill probability.
     *
     * @param killProbability The probability (0.0 to 1.0) of the seller being instantly killed.
     * @throws IllegalArgumentException If the probability is not within the valid range of 0.0 to 1.0.
     */
    public RandomInstantKill(double killProbability) {
        if (killProbability < 0.0 || killProbability > 1.0) {
            throw new IllegalArgumentException("Kill probability must be between 0.0 and 1.0");
        }
        this.killProbability = killProbability;
    }

    /**
     * Executes the buying modifier, potentially instantly killing the seller based on the kill probability.
     *
     * @param buyer   The Actor purchasing the item.
     * @param seller  The Actor selling the item.
     * @param item    The Item being purchased.
     * @param gameMap The GameMap the actors are in.
     * @return A message indicating the outcome of the transaction.
     * If the seller is killed, the message will include that information.
     * Otherwise, an empty string is returned.
     */
    @Override
    public String execute(Actor buyer, Actor seller, Item item, GameMap gameMap) {
        if (Probability.generateBoolean(killProbability)) {
            int currentHealth = seller.getAttribute(BaseActorAttributes.HEALTH);
            AttackAction attackAction = new AttackAction(seller, "selling ", new IntrinsicWeapon(currentHealth, "attack", 100));
            return attackAction.execute(buyer, gameMap);
        }
        return "";
    }

    /**
     * Provides a description of the modifier's behavior, mentioning the chance of instant death.
     *
     * @return A string describing the modifier's effect.
     */
    @Override
    public String description() {
        return String.format("The seller has a %.1f%% chance of being instantly killed.", killProbability * 100);
    }
}
