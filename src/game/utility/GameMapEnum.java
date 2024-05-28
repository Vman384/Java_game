package game.utility;

/**
 * The GameMapEnum enumeration represents the different game maps available in the game.
 * Each enum constant is associated with a name that describes the game map.
 */
public enum GameMapEnum {
    /**
     * Represents the Polymorphia game map.
     */
    POLYMORPHIA("Polymorphia"),

    /**
     * Represents the Connascence game map.
     */
    CONNASCENCE("Connascence"),

    /**
     * Represents the Static Factory game map.
     */
    STATICFACTORY("Static Factory");

    private final String name;

    /**
     * Constructor to create an enum constant with the specified name.
     *
     * @param name The name of the game map.
     */
    GameMapEnum(String name) {
        this.name = name;
    }

    /**
     * Returns the name of the game map associated with the enum constant.
     *
     * @return The name of the game map.
     */
    public String getName() {
        return name;
    }
}
