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
public interface Consumable {


    /**
     * Applies the consumption effect of this consumable item to the given actor.
     *
     * @param actor the actor consuming the item
     * @return a message indicating the result of the consumption
     */
    public String consume(Actor actor);
}
