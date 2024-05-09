package game.utility;

import edu.monash.fit2099.engine.positions.Location;

public class Mathematics {
    public static int distance(Location a, Location b) {
        return java.lang.Math.abs(a.x() - b.x()) + java.lang.Math.abs(a.y() - b.y());
    }
}
