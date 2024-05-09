package game.utility;

import edu.monash.fit2099.engine.positions.Location;

/**
 * A utility class containing mathematical operations.
 */
public class Mathematics {

    /**
     * Calculates the Manhattan distance between two locations.
     *
     * @param a the first location
     * @param b the second location
     * @return the Manhattan distance between the two locations
     */
    public static int distance(Location a, Location b) {
        return java.lang.Math.abs(a.x() - b.x()) + java.lang.Math.abs(a.y() - b.y());
    }
}
