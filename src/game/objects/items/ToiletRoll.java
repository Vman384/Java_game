package game.objects.items;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.positions.Location;
import game.abstractions.item.PrintableItem;
import game.abstractions.spawnable.Spawnable;

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
    public String print(Actor actor) {
        return " ";
    }
}
