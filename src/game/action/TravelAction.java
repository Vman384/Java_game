package game.action;

import edu.monash.fit2099.engine.actions.MoveActorAction;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Location;
import game.abstractions.item.Teleportable;

public class TravelAction extends MoveActorAction {
    private GameMap travelgameMap;
    private Teleportable teleportable = null;
    private Location travelLocation;

    /**
     * If travel action is to another map
     * @param location
     * @param destination
     */
    public TravelAction(Location location, String destination) {
        super(location, destination);
        this.travelLocation = location;
        this.travelgameMap = location.map();
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
            return actor + " arrived at " + travelLocation + " in " + travelgameMap.toString();
        } else {
            gameMap.moveActor(actor, travelLocation);
            return actor + " arrived at " + travelLocation + " in " + travelgameMap.toString();
        }
    }

    @Override
    public String menuDescription(Actor actor) {
        return actor + " travels to the " + this.travelgameMap.toString();
    }

    public String gameMapName(GameMap gameMap) {
        return gameMap.getClass().getName();
    }
    public boolean containsActor(Location currentLocation) {
        return currentLocation.map() == this.travelgameMap;
    }
}
