package game.objects.items;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.Item;
import game.abstractions.item.PrintableItem;
import game.objects.ground.ComputerTerminal;
import game.utility.PrintValidation;

public class Teleporter extends Item implements PrintableItem {
    private int creditCost;

    public Teleporter() {
        super("THESEUS", '^', true);
        this.creditCost = 100;
    }

    @Override
    public String print(Actor actor, ComputerTerminal printGround) {
        return PrintValidation.validatePrinting(this.creditCost, this, actor, printGround);
    }

    @Override
    public int getCost() {
        return this.creditCost;
    }
}
