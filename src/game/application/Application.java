package game.application;

import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.positions.FancyGroundFactory;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.World;
import game.actors.HuntsmanSpider;
import game.actors.Player;
import game.objects.ground.*;
import game.objects.items.*;
import game.spawning.SimpleSpawner;

import java.util.Arrays;
import java.util.List;

/**
 * The main class to start the game.
 * Created by:
 *
 * @author Adrian Kristanto
 * Modified by:
 *
 * @author Weize Yu
 */
public class Application {

    public static void main(String[] args) {

        World world = new World(new Display());

        FancyGroundFactory groundFactory = new FancyGroundFactory(
                new Dirt(), new Wall(), new Floor(), new Puddle());

        List<String> map = Arrays.asList(
                "...~~~~.........~~~...........",
                "...~~~~.......................",
                "...~~~........................",
                "..............................",
                ".............#####............",
                ".............#___#...........~",
                ".............#___#..........~~",
                ".............##_##.........~~~",
                ".................~~........~~~",
                "................~~~~.......~~~",
                ".............~~~~~~~........~~",
                "......~.....~~~~~~~~.........~",
                ".....~~~...~~~~~~~~~..........",
                ".....~~~~~~~~~~~~~~~~........~",
                ".....~~~~~~~~~~~~~~~~~~~....~~");

        GameMap gameMap = new GameMap(groundFactory, map);
        world.addGameMap(gameMap);

        for (String line : FancyMessage.TITLE.split("\n")) {
            new Display().println(line);
            try {
                Thread.sleep(200);
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        }
        gameMap.at(8, 6).setGround(new InheritreeNonMature(new SimpleSpawner(0.3, new SmallFruit())));
        gameMap.at(1, 6).setGround(new InheritreeMature(new SimpleSpawner(0.2, new LargeFruit())));

        gameMap.at(10, 10).setGround(new Crater(new SimpleSpawner(0.02, new HuntsmanSpider())));

        gameMap.at(7, 9).addActor(new HuntsmanSpider());
        gameMap.at(2, 3).addItem(new MetalSheet());
        gameMap.at(4, 6).addItem(new LargeBolt());
        gameMap.at(10, 6).addItem(new LargeBolt());
        gameMap.at(11, 12).addItem(new MetalPipe());
        gameMap.at(10, 12).addItem(new PotofGold());


        Player player = new Player("Intern", '@', 4);
        world.addPlayer(player, gameMap.at(15, 6));

        world.run();
        // Display a message at the end of the game
        for (String line : FancyMessage.YOU_ARE_FIRED.split("\n")) {
            new Display().println(line);
            try {
                Thread.sleep(200);
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        }
    }
}
