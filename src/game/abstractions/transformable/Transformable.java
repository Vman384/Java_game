package game.abstractions.transformable;

import edu.monash.fit2099.engine.positions.Location;

/**
 * Interface representing objects that can transform into different forms.
 * Created by:
 *
 * @author Weize Yu
 */
public interface Transformable {
    /**
     * Checks if the object can transform into another form based on certain conditions.
     *
     * @return true if the object can transform, false otherwise
     */
    boolean canTransform();
}
