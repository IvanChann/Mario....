package game;

import java.util.Arrays;
import java.util.List;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.positions.FancyGroundFactory;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.World;
import game.actors.*;
import game.items.Coin;
import game.items.PowerStar;
import game.items.SuperMushroom;
import game.terrain.*;

/**
 * The main class for the Mario World game.
 *
 */
public class Application {

	public static void main(String[] args) {

			World world = new World(new Display());

			FancyGroundFactory groundFactory = new FancyGroundFactory(new Dirt(), new Wall(), new Floor(), new Sprout(), new Lava());

			List<String> map = Arrays.asList(
				"..........................................##..........+.........................",
				"............+............+..................#...................................",
				"............................................#...................................",
				".............................................##......................+..........",
				"...............................................#................................",
				"................................................#...............................",
				".................+................................#.............................",
				".................................................##.............................",
				"................................................##..............................",
				".........+..............................+#____####.................+............",
				".......................................+#_____###++.............................",
				".......................................+#______###..............................",
				"........................................+#_____###..............................",
				"........................+........................##.............+...............",
				"...................................................#............................",
				"....................................................#...........................",
				"...................+.................................#..........................",
				"......................................................#.........................",
				".......................................................##.......................");

			GameMap gameMap = new GameMap(groundFactory, map);
			world.addGameMap(gameMap);

			Actor mario = new Player("Mario", 'm', 100);
			world.addPlayer(mario, gameMap.at(42, 10));

			gameMap.at(42, 17).setGround(new PowerFountain());
			gameMap.at(42, 17).addActor(new WalkingKoopa());
			gameMap.at(42, 14).setGround(new HealthFountain());

			gameMap.at(45, 11).addActor(new Toad());
			gameMap.at(42, 9).addItem(new PowerStar());

			gameMap.at(45, 18).addActor(new Bowser(gameMap.at(45, 18)));
			gameMap.at(46, 18).addActor(new Peach());


			gameMap.at(42, 11).addItem(new SuperMushroom());
			gameMap.at(42, 12).addItem(new Coin(1200));



			// Lava map
			List<String> lavaMap = Arrays.asList(
					".L...............LLLLLLLL..............................................",
					"L.................LLLLLLLL...................................+.........",
					"................LLLLLLLLLL.............................................",
					"..................LLLLLLLL.............................................",
					"...................LLLLLL..........+...............LL..................",
					"..................LLLLLL..........................LLLLL................",
					"..............LLLLLLLLLLLLLL.......................LLL.................",
					"...........LLLLLLLLLLLLLLLLL...........................................",
					"................LLLLLLL................................................",
					"....................................................+..................",
					"........................................+..............................",
					".................LLLLLL................................................",
					".....LLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLL",
					"......................+......................................+.........",
					"..................................................+....................",
					"...........+................+..........................................",
					".......................................................................");

			GameMap lavaGameMap = new GameMap(groundFactory, lavaMap);
			world.addGameMap(lavaGameMap);
			WarpPipe pipe = new WarpPipe(null);
			lavaGameMap.at(0, 0).setGround(pipe);
			gameMap.at(42,6).setGround(new WarpPipe(pipe));
			gameMap.at(44, 6).setGround(new WarpPipe(pipe));
			world.run();

	}
}
