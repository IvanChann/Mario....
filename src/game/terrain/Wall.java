package game.terrain;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Ground;
import game.enums.Status;

public class Wall extends Ground {
import java.nio.file.StandardCopyOption;

	public class Wall extends Ground implements HighGround{

		public Wall() {
			super('#');
			this.addCapability(Status.JUMP);
		}

		@Override
		public boolean canActorEnter(Actor actor) {
			return false;
		}

		@Override
		public boolean blocksThrownObjects() {
			return true;
		}

		/**
		 * Accessor for damage done by this ground.
		 *
		 * @return the damage
		 */
		@Override
		public int damage() {
			return 20;
		}
		/**
		 * Accessor for success rate for each jump for this ground.
		 *
		 * @return the success rate.
		 */
		@Override
		public double successRate() {
			return 0.8;
		}
	}
