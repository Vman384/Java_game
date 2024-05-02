package game.objects.items;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.Item;
import game.abstractions.item.PrintableItem;
import game.objects.ground.ComputerTerminal;
import game.utility.PrintValidation;
import game.utility.Probability;

public class ToiletRoll extends Item implements PrintableItem {
    private int creditCost;
    /***
     * Constructor.
     */
    public ToiletRoll() {
        super("Toilet Paper Roll", 's', true);
        this.creditCost = 5;
    }

    @Override
    public String print(Actor actor, ComputerTerminal printGround) {
        int dummyCost = this.creditCost;

        if (Probability.generateBoolean(0.75)) {
            dummyCost = 1;
        }

        return PrintValidation.validatePrinting(dummyCost, this, actor, printGround);
    }

    @Override
    public int getCost() {
        return this.creditCost;
    }
}
