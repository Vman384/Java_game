package game.utility;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Utility class for probability-related operations.
 * Created by:
 *
 * @author Weize Yu
 */
public class Probability {

    /**
     * Random number generator.
     */
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
     * Picks a random non-null element from the given list.
     *
     * @param list the list of objects to pick from
     * @param <T>  the type of objects in the list
     * @return a randomly selected non-null element from the list, or null if all elements are null or the list is empty
     */
    public static <T> T pickRandomNonNull(List<T> list) {
        if (list == null || list.isEmpty()) {
            return null;
        }

        List<T> nonNullList = new ArrayList<>();
        for (T element : list) {
            if (element != null) {
                nonNullList.add(element);
            }
        }

        return pickRandom(nonNullList);
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

    /**
     * Generates a random numeric string with the specified number of digits.
     *
     * @param numDigits the number of digits in the generated string
     * @return a randomly generated numeric string with the specified number of digits
     * @throws IllegalArgumentException if numDigits is less than 1
     */
    public static String generateRandomNumericString(int numDigits) {
        final int MIN_DIGIT = 1;
        final int MAX_DIGIT = 9;

        if (numDigits < MIN_DIGIT) {
            throw new IllegalArgumentException("Number of digits must be at least " + MIN_DIGIT);
        }

        int min = (int) Math.pow(10, numDigits - 1); // Minimum value for the specified number of digits
        int max = (int) Math.pow(10, numDigits) - 1; // Maximum value for the specified number of digits
        int randomNumber = random.nextInt(max - min + 1) + min;
        return String.valueOf(randomNumber);
    }

}
