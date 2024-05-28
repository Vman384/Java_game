package game.application;

import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.positions.FancyGroundFactory;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.World;
import game.abstractions.item.Printable;
import game.action.TravelAction;
import game.actors.AlienBug;
import game.actors.HuntsmanSpider;
import game.actors.Player;
import game.actors.SuspiciousAlien;
import game.maps.Maps;
import game.objects.ground.*;
import game.objects.items.*;
import game.spawning.SimpleSpawner;

import java.util.ArrayList;
import java.util.List;

/**
 * The main class to start the game.
 * Created by:
 *
 * @author Adrian Kristanto
 * Modified by:
 * @author Weize Yu
 * @author Harvey Houlahan
 */
public class Application {

    public static void main(String[] args) {

        World world = new World(new Display());

        FancyGroundFactory groundFactoryMoons = new FancyGroundFactory(
                new Dirt(), new Wall(), new Floor(), new Puddle());
        FancyGroundFactory groundStaticFactory = new FancyGroundFactory(new Wall(), new Floor(), new Dirt());

        // Initialised all maps as GameMaps
        GameMap polymorphiaMap = new GameMap(groundFactoryMoons, Maps.POLYMORPHIA);
        GameMap connascenceMap = new GameMap(groundFactoryMoons, Maps.CONNASCENCE);
        GameMap staticFactoryMap = new GameMap(groundStaticFactory, Maps.STATICFACTORY);

        // Add all Game maps to World
        world.addGameMap(polymorphiaMap);
        world.addGameMap(connascenceMap);
        world.addGameMap(staticFactoryMap);

        for (String line : FancyMessage.TITLE.split("\n")) {
            new Display().println(line);
            try {
                Thread.sleep(200);
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        }

        Player player = new Player("Intern", '@', 4);
        world.addPlayer(player, polymorphiaMap.at(15, 6));

        // Add items to Computer Terminal
        List<Printable> printingOptions = new ArrayList<>();
        printingOptions.add(new EnergyDrink());
        printingOptions.add(new DragonSlayerSword());
        printingOptions.add(new ToiletRoll());
        printingOptions.add(new Teleporter("THESUS", '^'));

        // Add travel actions to computer terminal
        List<TravelAction> travelActions = new ArrayList<>();
        travelActions.add(new TravelAction(polymorphiaMap.at(15, 6), "", Maps.GameMapEnum.POLYMORPHIA));
        travelActions.add(new TravelAction(connascenceMap.at(15, 6), "", Maps.GameMapEnum.CONNASCENCE));
        travelActions.add(new TravelAction(staticFactoryMap.at(3, 3), "", Maps.GameMapEnum.STATICFACTORY));

        ComputerTerminal computerTerminal = new ComputerTerminal(printingOptions, travelActions);

        polymorphiaMap.at(15, 5).setGround(computerTerminal);
        connascenceMap.at(15, 5).setGround(computerTerminal);
        staticFactoryMap.at(3, 2).setGround(computerTerminal);



        player.addBalance(10000);


        int sproutInitialAge = 0;
        polymorphiaMap.at(8, 6).setGround(new InheritreeSprout(sproutInitialAge));


        polymorphiaMap.at(10, 10).setGround(new Crater(new SimpleSpawner(0.2, new HuntsmanSpider())));
        polymorphiaMap.at(1, 1).setGround((new Crater(new SimpleSpawner(0.1, new AlienBug()))));
        polymorphiaMap.at(15, 11).setGround((new Crater(new SimpleSpawner(0.05, new SuspiciousAlien()))));

        polymorphiaMap.at(3, 6).addActor(new AlienBug());
        polymorphiaMap.at(5, 6).addActor(new AlienBug());

        polymorphiaMap.at(2, 3).addItem(new MetalSheet());
        polymorphiaMap.at(4, 6).addItem(new LargeBolt());
        polymorphiaMap.at(5, 6).addItem(new LargeBolt());
        polymorphiaMap.at(6, 6).addItem(new LargeBolt());
        polymorphiaMap.at(7, 6).addItem(new LargeBolt());
        polymorphiaMap.at(10, 6).addItem(new LargeBolt());
        polymorphiaMap.at(11, 12).addItem(new MetalPipe());
        polymorphiaMap.at(10, 12).addItem(new PotOfGold());
        polymorphiaMap.at(12, 8).addItem(new JarOfPickles());
        polymorphiaMap.at(12, 8).addItem(new JarOfPickles());
        polymorphiaMap.at(12, 8).addItem(new JarOfPickles());


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
