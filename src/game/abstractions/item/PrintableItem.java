package game.abstractions.item;

import edu.monash.fit2099.engine.actors.Actor;
import game.objects.ground.ComputerTerminal;

public interface PrintableItem {

    String print(Actor actor, ComputerTerminal printGround);

    int getCost();
}
