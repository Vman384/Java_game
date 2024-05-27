package game.action;

import edu.monash.fit2099.engine.actions.MoveActorAction;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Location;
import game.abstractions.item.Teleportable;
import game.maps.Maps;

public class TravelAction extends MoveActorAction {
    private GameMap travelgameMap;
    private Teleportable teleportable = null;
    private Location travelLocation;
    private Maps.GameMapEnum gameMapEnum;

    /**
     * If travel action is to another map
     * @param location
     * @param destination
     */
    public TravelAction(Location location, String destination, Maps.GameMapEnum gameMapEnum) {
        super(location, destination);
        this.travelLocation = location;
        this.travelgameMap = location.map();
        this.gameMapEnum = gameMapEnum;
    }

    /**
     * If player is travelling within same map via teleportation.
     * @param location
     * @param destination
     * @param teleportable
     */
    public TravelAction(Location location, String destination, Teleportable teleportable) {
        super(location, destination);
        this.teleportable = teleportable;
        this.travelgameMap = location.map();
    }

    @Override
    public String execute(Actor actor, GameMap gameMap) {
        if (teleportable != null) {
            travelLocation = teleportable.teleport(actor, gameMap);
            if (travelLocation.containsAnActor()) {
                return "Teleport Failed!";
            }
            gameMap.moveActor(actor, travelLocation);
            return actor + " arrived at " + travelLocation + " in current map";
        } else {
            gameMap.moveActor(actor, travelLocation);
            return actor + " arrived at " + travelLocation + " in " + gameMapEnum.getName();
        }
    }

    @Override
    public String menuDescription(Actor actor) {
        if (teleportable != null) {
            return actor + " travels with " + teleportable + " in current map";
        }
        return actor + " travels to the " + gameMapEnum.getClass().getName();
    }

    public boolean containsActor(Location currentLocation) {
        return currentLocation.map() == this.travelgameMap;
    }
}
