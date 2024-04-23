package game.utility;

import java.util.List;
import java.util.Random;

/**
 * Utility class for probability-related operations.
 * Created by:
 *
 * @author Weize Yu
 */
public class Probability {

    /** Random number generator. */
    private static final Random random = new Random();

    /**
     * Picks a random element from the given list.
     *
     * @param list the list of objects to pick from
     * @param <T>  the type of objects in the list
     * @return a randomly selected element from the list, or null if the list is empty
     */
    public static <T> T pickRandom(List<T> list) {
        if (list == null || list.isEmpty()) {
            return null;
        }
        int randomIndex = random.nextInt(list.size());
        return list.get(randomIndex);
    }

    /**
     * Generates a boolean value based on the given probability.
     *
     * @param probability the probability of returning true (in range [0.0, 1.0])
     * @return true with the specified probability, false otherwise
     * @throws IllegalArgumentException if probability is not within [0.0, 1.0]
     */
    public static boolean generateBoolean(double probability) {
        if (probability < 0.0 || probability > 1.0) {
            throw new IllegalArgumentException("Probability must be between 0.0 and 1.0");
        }
        return random.nextDouble() < probability;
    }
}
