package game.objects.items;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Location;
import game.abstractions.item.ConsumableItem;
import game.abstractions.item.PrintableItem;
import game.abstractions.spawnable.Spawnable;

public class EnergyDrink extends ConsumableItem implements PrintableItem {
    private int creditCost;
    /**
     * Constructor for ConsumableItem subclass Energy Drink.
     *
     */
    public EnergyDrink() {
        super("Energy Drink", '*', true);
        this.creditCost = 10;
    }

    @Override
    public String print(Actor actor) {
        return null;
    }
}
