package game.abstractions.actor;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.positions.GameMap;

import java.util.ArrayList;
import java.util.List;

/**
 * An abstract class representing characters in the game world.
 * This allows for shared functionality between all actors
 * Created by: Weize Yu
 */
public abstract class ActorBase extends Actor {
    /**
     * Display engine
     */
    protected final Display displayEngine = new Display();

    /**
     * The constructor of the Actor class.
     *
     * @param name        the name of the Actor
     * @param displayChar the character that will represent the Actor in the display
     * @param hitPoints   the Actor's starting hit points
     */
    public ActorBase(String name, char displayChar, int hitPoints) {
        super(name, displayChar, hitPoints);
    }

    /**
     * Handles the unconscious state of the Actor, dropping all items from its inventory and printing a message.
     *
     * @param actor the Actor responsible for causing the NPC to become unconscious
     * @param map   the current GameMap
     * @return a message describing the Actor's demise
     */
    @Override
    public String unconscious(Actor actor, GameMap map) {
        List<Item> inventoryCopy = new ArrayList<>(this.getItemInventory());
        for (Item item : inventoryCopy) {
            String handle = item.getDropAction(this).execute(this, map);
            displayEngine.print(handle + '\n');
            this.removeItemFromInventory(item);
        }
        return super.unconscious(actor, map);
    }
}
