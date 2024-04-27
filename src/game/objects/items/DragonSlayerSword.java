package game.objects.items;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Location;
import edu.monash.fit2099.engine.weapons.WeaponItem;
import game.abstractions.item.PrintableItem;
import game.abstractions.spawnable.Spawnable;

public class DragonSlayerSword extends WeaponItem implements PrintableItem {
    private int creditCost;
    /**
     * Constructor.
     *
     */
    public DragonSlayerSword() {
        super("Dragon Slayer Sword", 'x', 50, "slices", 75);
        this.creditCost = 100;
    }

    @Override
    public String print(Actor actor) {
        return " ";
    }
}
