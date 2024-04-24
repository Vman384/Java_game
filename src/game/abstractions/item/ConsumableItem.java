package game.abstractions.item;

import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.actors.attributes.BaseActorAttributes;
import edu.monash.fit2099.engine.items.Item;
import game.action.ConsumeAction;

/**
 * An abstract class representing consumable items in the game world.
 * Consumable items can be consumed by actors to gain certain effects, such as healing.
 * Created by:
 *
 * @author Weize Yu
 */
public abstract class ConsumableItem extends Item {
    /**
     * The amount of health restored when this item is consumed.
     */
    protected int healEffects = 0;

    /**
     * Constructor for ConsumableItem objects.
     *
     * @param name        the name of the consumable item
     * @param displayChar the character representing the consumable item on the map
     * @param portable    indicates whether the item can be picked up and carried by actors
     */
    public ConsumableItem(String name, char displayChar, boolean portable) {
        super(name, displayChar, portable);
    }

    /**
     * Generates a list of allowable actions for this consumable item, which includes the action to consume it.
     *
     * @param owner the actor who owns or holds the item
     * @return list of allowable actions
     */
    @Override
    public ActionList allowableActions(Actor owner) {
        ActionList actionList = new ActionList();
        actionList.add(new ConsumeAction(this));
        return actionList;
    }

    /**
     * Applies the consumption effect of this consumable item to the given actor.
     *
     * @param actor the actor consuming the item
     * @return a message indicating the result of the consumption
     */
    public String consume(Actor actor) {
        int prevHealth = actor.getAttribute(BaseActorAttributes.HEALTH);
        actor.heal(healEffects);
        actor.removeItemFromInventory(this);
        int newHealth = actor.getAttribute(BaseActorAttributes.HEALTH);

        if (prevHealth == actor.getAttributeMaximum(BaseActorAttributes.HEALTH)) {
            return actor + " consumes " + this + ". Health is already at maximum.";
        }

        int healthIncrease = newHealth - prevHealth;
        return actor + " consumes " + this + ". Health increased by " + healthIncrease + "!";
    }
}
