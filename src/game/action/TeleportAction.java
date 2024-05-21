package game.action;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import game.abstractions.item.Teleportable;

/**
 * Teleportport Action enables player to randomly teleport around the current game map
 */
public class TeleportAction extends Action {
    /**
     * Teleportable item; THESUS
     */
    private Teleportable teleportable;

    /**
     * Constructor
     * @param teleportable, Item allowing player to teleport.
     */
    public TeleportAction(Teleportable teleportable) {
        this.teleportable = teleportable;
    }

    /**
     * Execute function to display teleporting action to the player
     * @param actor The actor performing the action.
     * @param gameMap The map the actor is on.
     * @return String; describing the teleportation
     */
    @Override
    public String execute(Actor actor, GameMap gameMap) { return this.teleportable.teleport(actor); }

    @Override
    public String menuDescription(Actor actor) { return actor + " teleports with " + this.teleportable; }
}
