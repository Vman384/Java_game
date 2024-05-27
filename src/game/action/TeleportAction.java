package game.action;


import edu.monash.fit2099.engine.actions.MoveActorAction;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Location;
import game.abstractions.item.Teleportable;

/**
 * Teleportport Action enables player to randomly teleport around the current game map
 */
public class TeleportAction extends MoveActorAction {
    /**
     * Teleportable item; THESUS
     */
    private Teleportable teleportable;
    private Location teleportLocation;

    /**
     * Constructor
     * @param teleportable, Item allowing player to teleport.
     */
    public TeleportAction(Location location, String destination, Teleportable teleportable) {
        super(location, destination);
        this.teleportable = teleportable;
    }

    /**
     * Execute function to display teleporting action to the player
     * @param actor The actor performing the action.
     * @param gameMap The map the actor is on.
     * @return String; describing the teleportation
     */
    @Override
    public String execute(Actor actor, GameMap gameMap) {
        teleportLocation = teleportable.teleport(actor, gameMap);
        if (teleportLocation.containsAnActor()) {
            return "Teleport Failed!";
        }
        gameMap.moveActor(actor, teleportLocation);
        return actor + " teleports to " + teleportLocation;
    }

    @Override
    public String menuDescription(Actor actor) { return actor + " teleports with " + this.teleportable; }


}
