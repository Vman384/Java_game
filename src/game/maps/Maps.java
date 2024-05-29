package game.maps;

import java.util.Arrays;
import java.util.List;

/**
 * The {@code Maps} class provides static lists representing different game maps.
 * Each map is represented as a list of strings, where each string corresponds to a row in the map.
 */
public class Maps {

    /**
     * Represents the Polymorphia game map.
     * Each string in the list represents a row in the map.
     */
    public static final List<String> POLYMORPHIA = Arrays.asList(
            "...~~~~.........~~~...........",
            "...~~~~.......................",
            "...~~~........................",
            "..............................",
            ".............#####............",
            ".............#___#...........~",
            ".............#___#..........~~",
            ".............##_##.........~~~",
            ".................~~........~~~",
            "................~~~~.......~~~",
            ".............~~~~~~~........~~",
            "......~.....~~~~~~~~.........~",
            ".....~~~...~~~~~~~~~..........",
            ".....~~~~~~~~~~~~~~~~........~",
            ".....~~~~~~~~~~~~~~~~~~~....~~"
    );

    /**
     * Represents the Connascence game map.
     * Each string in the list represents a row in the map.
     */
    public static final List<String> CONNASCENCE = Arrays.asList(
            "..........................~~~~",
            "..........................~~~~",
            "..........................~~~~",
            "~..........................~..",
            "~~...........#####............",
            "~~~..........#___#............",
            "~~~..........#___#............",
            "~~~..........##_##............",
            "~~~..................~~.......",
            "~~~~................~~~~......",
            "~~~~...............~~~~~......",
            "..~................~~~~.......",
            "....................~~........",
            ".............~~...............",
            "............~~~~.............."
    );

    /**
     * Represents the Static Factory game map.
     * Each string in the list represents a row in the map.
     */
    public static final List<String> STATICFACTORY = Arrays.asList(
            ".......",
            ".#####.",
            ".#___#.",
            ".#___#.",
            ".##_##.",
            ".......",
            ".......",
            ".......",
            ".......",
            "......."
    );

}
