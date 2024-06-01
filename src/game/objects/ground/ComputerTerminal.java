package game.objects.ground;

import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Ground;
import edu.monash.fit2099.engine.positions.Location;
import game.abstractions.item.Purchasable;
import game.action.PurchaseAction;
import game.action.TravelAction;

import java.util.List;

/**
 * ComputerTerminal class which represents a terminal that has the capability to print items to the players inventory
 *
 * @author Dean Mascitti
 */
public class ComputerTerminal extends Ground {
    private final List<Purchasable> printingOptions;
    private final List<TravelAction> travelActions;

    /**
     * Class Constructor.
     *
     * @param printingOptions a list of all the printable items of the terminal
     * @param travelActions   a list of all travel action options
     */
    public ComputerTerminal(List<Purchasable> printingOptions, List<TravelAction> travelActions) {
        super('=');
        this.printingOptions = printingOptions;
        this.travelActions = travelActions;
    }

    /**
     * Returns an Action list containing all print actions for printable items including printable items and travel actions .
     *
     * @param actor     the Actor acting
     * @param location  the current Location
     * @param direction the direction of the Ground from the Actor
     * @return a new, empty collection of Actions
     */
    @Override
    public ActionList allowableActions(Actor actor, Location location, String direction) {
        ActionList actions = new ActionList();
        for (Purchasable purchasable : printingOptions) {
            actions.add(new PurchaseAction(purchasable, this));
        }
        for (TravelAction travelAction : travelActions) {
            if (!travelAction.containsActor(location)) {
                actions.add(travelAction);
            }
        }

        return actions;
    }

    /**
     * Method for printing class name.
     *
     * @return String of computer terminal
     */
    @Override
    public String toString() {
        return "Computer Terminal";
    }
}
