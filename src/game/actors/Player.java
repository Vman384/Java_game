package game.actors;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.displays.Menu;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.weapons.IntrinsicWeapon;
import game.constants.Ability;
import game.constants.Status;

/**
 * Class representing the Player in the game world.
 * The Player is controlled by the user and interacts with the game environment.
 * The Player can take actions during gameplay.
 * Created by:
 *
 * @author Kristanto
 * <p>
 * Modified by:
 * @author Weize Yu
 */
public class Player extends Actor {
    /**
     * Constructor for Player objects.
     *
     * @param name        the name to call the player in the user interface
     * @param displayChar the character representing the player in the user interface
     * @param hitPoints   the player's starting number of hitpoints
     */
    public Player(String name, char displayChar, int hitPoints) {
        super(name, displayChar, hitPoints);
        this.addCapability(Status.HOSTILE_TO_ENEMY);
        this.addCapability(Ability.ENTER_SHIP);
    }

    /**
     * Determines the action to be performed by the player during its turn.
     *
     * @param actions    collection of possible Actions for the player
     * @param lastAction the Action the player took last turn, if any
     * @param map        the map containing the player
     * @param display    the I/O object to which messages may be written
     * @return the action chosen by the player for this turn
     */
    @Override
    public Action playTurn(ActionList actions, Action lastAction, GameMap map, Display display) {
        // Handle multi-turn Actions
        if (lastAction.getNextAction() != null)
            return lastAction.getNextAction();

        // return/print the console menu
        Menu menu = new Menu(actions);
        return menu.showMenu(this, display);
    }

    /**
     * Retrieves the intrinsic weapon of the player.
     *
     * @return the intrinsic weapon of the player
     */
    @Override
    public IntrinsicWeapon getIntrinsicWeapon() {
        return new IntrinsicWeapon(1, "punches", 5);
    }
}
