package game.abstractions.actor;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.actors.Behaviour;
import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.positions.GameMap;
import game.action.AttackAction;
import game.constants.Status;

import java.util.HashMap;
import java.util.Map;

/**
 * An abstract class representing non-playable characters (NPCs) in the game world.
 * NPCs have behaviours that dictate their actions during gameplay.
 * Created by:
 *
 * @author Weize Yu
 */
public abstract class NPC extends Actor {
    /**
     * A mapping of priorities to behaviours. Behaviours with higher priorities are executed first.
     */
    protected Map<Integer, Behaviour> behaviours = new HashMap<>();

    /**
     * Constructor for NPC objects.
     *
     * @param name        the name of the NPC
     * @param displayChar the character representing the NPC on the map
     * @param hitPoints    the hitPoints of the NPC, the NPC's starting hit points
     */
    public NPC(String name, char displayChar, int hitPoints) {
        super(name, displayChar, hitPoints);
    }

    /**
     * Selects an action for the NPC to perform during its turn.
     *
     * @param actions    collection of possible Actions for this Actor
     * @param lastAction The Action this Actor took last turn. Can do interesting things in conjunction with Action.getNextAction()
     * @param map        the map containing the Actor
     * @param display    the I/O object to which messages may be written
     * @return the valid action that can be performed in that iteration or null if no valid action is found
     */
    @Override
    public Action playTurn(ActionList actions, Action lastAction, GameMap map, Display display) {
        for (Behaviour behaviour : behaviours.values()) {
            Action action = behaviour.getAction(this, map);
            if (action != null)
                return action;
        }
        return null; // Default to no action
    }

    /**
     * Generates a list of allowable actions for this NPC, considering the capabilities of other actors.
     *
     * @param otherActor the Actor that might be performing attack
     * @param direction  String representing the direction of the other Actor
     * @param map        current GameMap
     * @return list of allowable actions
     */
    @Override
    public ActionList allowableActions(Actor otherActor, String direction, GameMap map) {
        ActionList actions = new ActionList();
        if (otherActor.hasCapability(Status.HOSTILE_TO_ENEMY)) {
            actions.add(new AttackAction(this, direction));
        }
        return actions;
    }

    // Abstract method to be implemented by subclasses to create new instances of themselves
    protected abstract NPC createNewInstance();
}
