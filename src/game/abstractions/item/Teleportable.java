package game.abstractions.item;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;

public interface Teleportable {

    public String teleport(Actor actor, GameMap gameMap);
}
