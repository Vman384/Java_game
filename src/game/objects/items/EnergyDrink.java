package game.objects.items;

import edu.monash.fit2099.engine.actors.Actor;
import game.abstractions.item.ConsumableItem;
import game.abstractions.item.PrintableItem;
import game.objects.ground.ComputerTerminal;
import game.utility.PrintValidation;
import game.utility.Probability;

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

    @Override
    public String print(Actor actor, ComputerTerminal printGround) {
        int dummyCost = this.creditCost;

        if (Probability.generateBoolean(0.2)) {
            dummyCost = 2 * this.creditCost;
        }

        return PrintValidation.validatePrinting(dummyCost, this, actor, printGround);

    }

    @Override
    public int getCost() {
        return this.creditCost;
    }

}
