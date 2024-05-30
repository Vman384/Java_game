package game.objects.items;

import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actions.MoveActorAction;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Location;
import game.abstractions.item.Printable;
import game.abstractions.item.Teleportable;
import game.action.TravelAction;
import game.objects.ground.ComputerTerminal;
import game.utility.PrintValidation;
import game.utility.Probability;

/**
 * The teleporter class represents an item that can teleport an actor to a random location within the same game map.
 * It implements PrintableItem and Teleportable interfaces.
 */
public class Teleporter extends Item implements Printable, Teleportable {
    /**
     * Cost of teleporting device
     */
    private final int creditCost = 100;

    /**
     * Constructor to create a teleporter item.
     *
     * @param name The name of the teleporter item.
     * @param displayChar The character to display for the teleporter item.
     */
    public Teleporter(String name, char displayChar) {
        super(name, displayChar, true);
    }

    /**
     * Prints the teleporter's details using the provided computerterminal.
     *
     * @param actor The actor who is printing the item.
     * @param printGround The computer terminal used for printing.
     * @return A string indicating the result of the print action.
     */
    @Override
    public String print(Actor actor, ComputerTerminal printGround) {
        return PrintValidation.validatePrinting(this.creditCost, this, actor, printGround);
    }

    /**
     * Returns the cost of the teleporter in credits.
     *
     * @return The credit cost of the teleporter.
     */
    @Override
    public int getCost() {
        return this.creditCost;
    }

    /**
     * Returns the list of allowable actions for the teleporter at a given location.
     *
     * @param location The location where the teleporter is.
     * @return An {@link ActionList} of allowable actions.
     */
    @Override
    public ActionList allowableActions(Location location) {
        ActionList actionList = super.allowableActions(location);
        MoveActorAction teleportActor = new TravelAction(location, "", this);
        actionList.add(teleportActor);
        return actionList;
    }

    /**
     * Teleports the actor to a random location within the same game map.
     *
     * @param actor The actor to be teleported.
     * @param gameMap The game map in which the teleportation will occur.
     * @return The new location within the game map to which the actor is teleported.
     */
    @Override
    public Location teleport(Actor actor, GameMap gameMap) {
        int xValue = Probability.pickRandomLocation(gameMap.getXRange());
        int yValue = Probability.pickRandomLocation(gameMap.getYRange());
        return gameMap.at(xValue, yValue);
    }
}
