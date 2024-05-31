package game.action;

import edu.monash.fit2099.engine.actions.MoveActorAction;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Location;
import game.abstractions.item.Teleportable;
import game.utility.GameMapEnum;

/**
 * TravelAction allows an actor to travel to a different location or map.
 * This can be done either by direct movement or through teleportation.
 */
public class TravelAction extends MoveActorAction {
    /**
     * The game map where the actor is traveling to.
     */
    private GameMap travelgameMap;

    /**
     * An item that allows the actor to teleport.
     */
    private Teleportable teleportable = null;

    /**
     * The location the actor is traveling to.
     */
    private Location travelLocation;

    /**
     * The enumeration representing the target game map.
     */
    private GameMapEnum gameMapEnum;

    /**
     * Constructor for travel action to another map via computerTerminal
     *
     * @param location     The destination location.
     * @param destination  A description of the destination.
     * @param gameMapEnum  The enumeration representing the target game map.
     */
    public TravelAction(Location location, String destination, GameMapEnum gameMapEnum) {
        super(location, destination);
        this.travelLocation = location;
        this.travelgameMap = location.map();
        this.gameMapEnum = gameMapEnum;
    }

    /**
     * Constructor for travel action within the same map via teleporter.
     *
     * @param location     The destination location.
     * @param destination  A description of the destination.
     * @param teleportable The item allowing the actor to teleport.
     */
    public TravelAction(Location location, String destination, Teleportable teleportable) {
        super(location, destination);
        this.teleportable = teleportable;
        this.travelgameMap = location.map();
    }

    /**
     * Executes the travel action, moving the actor to the specified location.
     *
     * @param actor    The actor performing the action.
     * @param gameMap  The map the actor is on.
     * @return A string describing the result of the action.
     */
    @Override
    public String execute(Actor actor, GameMap gameMap) {
        if (teleportable != null) {
            travelLocation = teleportable.teleport(actor, gameMap);
            if (travelLocation.containsAnActor()) {
                return "Teleport Failed!";
            }
        }
        gameMap.moveActor(actor, travelLocation);
        String mapName = (teleportable != null) ? "current map" : gameMapEnum.getName();
        return actor + " arrived at " + travelLocation + " in " + mapName;
    }

    /**
     * Provides a description of the travel action for display in a menu.
     *
     * @param actor The actor performing the action.
     * @return A string describing the action.
     */
    @Override
    public String menuDescription(Actor actor) {
        return (teleportable != null)
                ? actor + " travels with " + teleportable + " in current map"
                : actor + " travels to the " + gameMapEnum.getName();
    }

    /**
     * Checks if the given location contains the actor on the travel game map.
     *
     * @param currentLocation The location to check.
     * @return True if the location contains the actor, otherwise false.
     */
    public boolean containsActor(Location currentLocation) {
        return currentLocation.map() == this.travelgameMap;
    }
}

