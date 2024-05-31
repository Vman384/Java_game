package game.application;

import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.positions.FancyGroundFactory;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.World;
import game.abstractions.item.Printable;
import game.abstractions.transformable.EvolutionManager;
import game.action.TravelAction;
import game.action.buying.BuyActionGenerator;
import game.action.buying.modifiers.BuyingModifiers;
import game.action.buying.modifiers.DeductBalance;
import game.action.buying.modifiers.RandomInstantKill;
import game.action.buying.modifiers.RandomPriceModifier;
import game.action.buying.modifiers.RemoveItemFromInventory;
import game.actors.AlienBug;
import game.actors.Humanoid;
import game.actors.HuntsmanSpider;
import game.actors.Player;
import game.actors.SuspiciousAlien;
import game.maps.Maps;
import game.objects.ground.ComputerTerminal;
import game.objects.ground.Crater;
import game.objects.ground.Dirt;
import game.objects.ground.Floor;
import game.objects.ground.InheritreeMature;
import game.objects.ground.InheritreeSapling;
import game.objects.ground.InheritreeSprout;
import game.objects.ground.InheritreeYoung;
import game.objects.ground.Puddle;
import game.objects.ground.Tree;
import game.objects.ground.Wall;
import game.objects.items.AiDevice;
import game.objects.items.DragonSlayerSword;
import game.objects.items.EnergyDrink;
import game.objects.items.JarOfPickles;
import game.objects.items.LargeBolt;
import game.objects.items.LargeFruit;
import game.objects.items.MetalPipe;
import game.objects.items.MetalSheet;
import game.objects.items.PotOfGold;
import game.objects.items.SmallFruit;
import game.objects.items.Teleporter;
import game.objects.items.ToiletRoll;
import game.spawning.SimpleSpawner;
import game.utility.GameMapEnum;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

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
        printingOptions.add(new Teleporter("THESEUS", '^'));
        printingOptions.add(new AiDevice());
        // Add travel actions to computer terminal
        List<TravelAction> travelActions = new ArrayList<>();
        travelActions.add(new TravelAction(polymorphiaMap.at(15, 6), "", GameMapEnum.POLYMORPHIA));
        travelActions.add(new TravelAction(connascenceMap.at(15, 6), "", GameMapEnum.CONNASCENCE));
        travelActions.add(new TravelAction(staticFactoryMap.at(3, 3), "", GameMapEnum.STATICFACTORY));

        ComputerTerminal computerTerminal = new ComputerTerminal(printingOptions, travelActions);

        polymorphiaMap.at(15, 5).setGround(computerTerminal);
        connascenceMap.at(15, 5).setGround(computerTerminal);
        staticFactoryMap.at(3, 2).setGround(computerTerminal);

        BuyActionGenerator buyActionGenerator;
        Map<Class<? extends Item>, Iterable<BuyingModifiers>> itemModifiers = new HashMap<>();

        List<BuyingModifiers> largeBoltModifiers = new ArrayList<>();
        largeBoltModifiers.add(new DeductBalance(25));
        itemModifiers.put(LargeBolt.class, largeBoltModifiers);

        List<BuyingModifiers> metalSheetModifiers = new ArrayList<>();
        metalSheetModifiers.add(new RandomPriceModifier(20, 0.6, 10));
        metalSheetModifiers.add(new RemoveItemFromInventory());
        itemModifiers.put(MetalSheet.class, metalSheetModifiers);

        List<BuyingModifiers> largeFruitModifiers = new ArrayList<>();
        largeFruitModifiers.add(new DeductBalance(30));
        largeFruitModifiers.add(new RemoveItemFromInventory());
        itemModifiers.put(LargeFruit.class, largeFruitModifiers);

        List<BuyingModifiers> jarOfPicklesModifiers = new ArrayList<>();
        jarOfPicklesModifiers.add(new RandomPriceModifier(25, 0.5, 50));
        jarOfPicklesModifiers.add(new RemoveItemFromInventory());
        itemModifiers.put(JarOfPickles.class, jarOfPicklesModifiers);

        List<BuyingModifiers> metalPipeModifiers = new ArrayList<>();
        metalPipeModifiers.add(new DeductBalance(35));
        metalPipeModifiers.add(new RemoveItemFromInventory());
        itemModifiers.put(MetalPipe.class, metalPipeModifiers);

        List<BuyingModifiers> potOfGoldModifiers = new ArrayList<>();
        potOfGoldModifiers.add(new RandomPriceModifier(500, 0.25, 0));
        potOfGoldModifiers.add(new RemoveItemFromInventory());
        itemModifiers.put(PotOfGold.class, potOfGoldModifiers);

        List<BuyingModifiers> toiletRollModifiers = new ArrayList<>();
        toiletRollModifiers.add(new DeductBalance(1));
        toiletRollModifiers.add(new RandomInstantKill(1));
        toiletRollModifiers.add(new RemoveItemFromInventory());
        itemModifiers.put(ToiletRoll.class, toiletRollModifiers);

        buyActionGenerator = new BuyActionGenerator(itemModifiers);
        staticFactoryMap.at(3, 9).addActor(new Humanoid(buyActionGenerator));

        player.addItemToInventory(new JarOfPickles());
        player.addItemToInventory(new JarOfPickles());
        player.addItemToInventory(new JarOfPickles());
        player.addItemToInventory(new PotOfGold());
        player.addItemToInventory(new PotOfGold());
        player.addItemToInventory(new PotOfGold());

        player.addBalance(10000);

        Queue<Tree> treeStages = new LinkedList<>();

        int sproutInitialAge = 0;
        int saplingInitialAge = sproutInitialAge + 3;
        int youngInitialAge = saplingInitialAge + 6;
        int matureInitialAge = youngInitialAge + 5;

        treeStages.add(new InheritreeSapling(saplingInitialAge, new SimpleSpawner(0.3, new SmallFruit())));
        treeStages.add(new InheritreeYoung(youngInitialAge));
        treeStages.add(new InheritreeMature(matureInitialAge, new SimpleSpawner(0.2, new LargeFruit())));

        EvolutionManager evolutionManager = new EvolutionManager(treeStages);
        InheritreeSprout initialInheritree = new InheritreeSprout(sproutInitialAge);
        initialInheritree.assignEvolutionManager(evolutionManager);

        polymorphiaMap.at(8, 6).setGround(initialInheritree);


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
