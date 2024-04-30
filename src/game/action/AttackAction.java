package game.action;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.weapons.Weapon;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * An action representing an attack performed by an actor against another actor.
 * This action calculates the outcome of the attack, including damage dealt and potential consequences.
 * Created by:
 *
 * @author Weize Yu
 */
public class AttackAction extends Action {

    /**
     * The actor that is to be attacked.
     */
    private Actor target;

    /**
     * The direction of the incoming attack (for display purposes).
     */
    private String direction;

    /**
     * Random number generator.
     */
    private Random rand = new Random();

    /**
     * The weapon used for the attack.
     */
    private Weapon weapon;

    /**
     * Constructor for AttackAction.
     *
     * @param target    the actor to attack
     * @param direction the direction where the attack should be performed (only used for display purposes)
     * @param weapon    the weapon used for the attack
     */
    public AttackAction(Actor target, String direction, Weapon weapon) {
        this.target = target;
        this.direction = direction;
        this.weapon = weapon;
    }

    /**
     * Constructor for AttackAction with intrinsic weapon as default.
     *
     * @param target    the actor to attack
     * @param direction the direction where the attack should be performed (only used for display purposes)
     */
    public AttackAction(Actor target, String direction) {
        this.target = target;
        this.direction = direction;
    }

    /**
     * Executes the attack action, calculating the outcome of the attack.
     *
     * @param actor the actor performing the attack
     * @param map   the GameMap where the attack is taking place
     * @return a message describing the outcome of the attack
     */
    @Override
    public String execute(Actor actor, GameMap map) {
        if (weapon == null) {
            weapon = actor.getIntrinsicWeapon();
        }

        if (!(rand.nextInt(100) <= weapon.chanceToHit())) {
            return actor + " misses " + target + ".";
        }

        int damage = weapon.damage();
        String result = actor + " " + weapon.verb() + " " + target + " for " + damage + " damage.";
        target.hurt(damage);
        if (!target.isConscious()) {
            List<Item> inventoryCopy = new ArrayList<>(target.getItemInventory());
            for (Item item : inventoryCopy) {
                String handle = item.getDropAction(target).execute(target, map);
                System.out.println(handle);
                target.removeItemFromInventory(item);
            }
            result += "\n" + target.unconscious(actor, map);
        }

        return result;
    }

    /**
     * Provides a description of the attack action for use in menus or displays.
     *
     * @param actor the actor performing the attack
     * @return a string describing the action
     */
    @Override
    public String menuDescription(Actor actor) {
        return actor + " attacks " + target + " at " + direction + " with " + (weapon != null ? weapon : "Intrinsic Weapon");
    }
}
