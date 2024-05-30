package game.action.buying.modifiers;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.Item;

/**
 * An interface for defining buying modifiers that can alter the buying process
 * (e.g., adjusting prices, adding or removing items, providing special messages).
 *
 * This interface should be implemented by any class that needs to apply
 * specific modifications when an actor buys an item from another actor.
 */
public interface BuyingModifiers {
    /**
     * Applies the buying modifier to the transaction.
     *
     * @param buyer The Actor purchasing the item.
     * @param seller The Actor selling the item.
     * @param item The Item being purchased.
     * @return A string message describing the outcome of the modifier.
     */
    public String execute(Actor buyer, Actor seller, Item item);

    /**
     * Provides a description of the modifier's effect.
     *
     * This description can be used to inform the user of what the modifier does.
     *
     * @return A string describing the modifier.
     */
    String description();
}
