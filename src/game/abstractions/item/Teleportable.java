package game.abstractions.item;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Location;

public interface Teleportable {

    public Location teleport(Actor actor, GameMap gameMap);
}
