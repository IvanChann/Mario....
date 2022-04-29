package game;

import java.util.Arrays;
import java.util.List;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.positions.FancyGroundFactory;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.World;
import game.actors.Goomba;
import game.actors.Koopa;
import game.actors.Player;
import game.actors.Toad;
import game.items.Coin;
import game.items.PowerStar;
import game.items.SuperMushroom;
import game.terrain.Dirt;
import game.terrain.Floor;
import game.terrain.Tree;
import game.terrain.Wall;

/**
 * The main class for the Mario World game.
 *
 */
public class Application {

	public static void main(String[] args) {

			World world = new World(new Display());

			FancyGroundFactory groundFactory = new FancyGroundFactory(new Dirt(), new Wall(), new Floor(), new Tree());

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

			Actor mario = new Player("Player", 'm', 100);
			world.addPlayer(mario, gameMap.at(42, 10));

			gameMap.at(45, 11).addActor(new Toad("Toad", 'o', 100));
			gameMap.at(0, 0).addActor(new Goomba());
			gameMap.at(1, 0).addActor(new Koopa());
			gameMap.at(42, 9).addItem(new PowerStar());

			gameMap.at(42, 11).addItem(new SuperMushroom());
			gameMap.at(42, 12).addItem(new Coin(69));
			gameMap.at(42, 13).addItem(new Coin(69));


		world.run();

	}
}
