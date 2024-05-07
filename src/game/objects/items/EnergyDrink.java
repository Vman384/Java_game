package game.objects.items;

import edu.monash.fit2099.engine.actors.Actor;
import game.abstractions.item.ConsumableItem;
import game.abstractions.item.PrintableItem;
import game.objects.ground.ComputerTerminal;
import game.utility.PrintValidation;
import game.utility.Probability;

/**
 * EnergyDrink class which represents an energy drink item that can be possessed and consumed by some actors.
 *
 * @author Dean Mascitti
 */
public class EnergyDrink extends ConsumableItem implements PrintableItem {
    private int creditCost;
    /**
     * Constructor for ConsumableItem subclass Energy Drink.
     *
     */
    public EnergyDrink() {
        super("Energy Drink", '*', true);
        this.creditCost = 10;
        healEffects = 1;
    }

    /**
     * Print method which implements the energy drinks printing to player inventory functionality.
     *
     * @param actor The actor doing the print action
     * @param printGround the ground type printing the item
     * @return
     */
    @Override
    public String print(Actor actor, ComputerTerminal printGround) {
        int dummyCost = this.creditCost;

        if (Probability.generateBoolean(0.2)) {
            dummyCost = 2 * this.creditCost;
        }

        return PrintValidation.validatePrinting(dummyCost, this, actor, printGround);

    }

    /**
     * Getter for cost of energy drink.
     *
     * @return cost of energy drink as an int.
     */
    @Override
    public int getCost() {
        return this.creditCost;
    }

}
