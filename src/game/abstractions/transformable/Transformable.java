package game.abstractions.transformable;

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

    /**
     * Transforms the object into another form.
     *
     * @return the transformed object
     */
    Transformable transform();
}
