package game.objects.items;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.Item;
import game.abstractions.item.PrintableItem;
import game.objects.ground.ComputerTerminal;
import game.utility.PrintValidation;
import game.utility.Probability;

/**
 * ToiletRoll class represents a toilet paper roll item that some actors can possess.
 *
 * @author Dean Mascitti
 */
public class ToiletRoll extends Item implements PrintableItem {
    private int creditCost;
    private double costProbability;
    /***
     * Constructor.
     */
    public ToiletRoll() {
        super("Toilet Paper Roll", 's', true);
        this.creditCost = 5;
        this.costProbability = 0.75;
    }

    /**
     * Print method which implements the toilet rolls printing to player inventory functionality.
     * @param actor The actor doing the print action
     * @param printGround the ground type printing the item
     * @return String describing the outcome of the print
     */
    @Override
    public String print(Actor actor, ComputerTerminal printGround) {
        int dummyCost = this.creditCost;

        if (Probability.generateBoolean(this.costProbability)) {
            dummyCost = 1;
        }

        return PrintValidation.validatePrinting(dummyCost, this, actor, printGround);
    }

    /**
     * Getter for the cost of the toilet roll.
     * @return Cost of the toilet roll as an int
     */
    @Override
    public int getCost() {
        return this.creditCost;
    }
}
