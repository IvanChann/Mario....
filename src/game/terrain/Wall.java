package game.terrain;

/**
 * Class representing a Wall
 */
public class Wall extends HighGround {

	/**
	 * Constructor
	 * @see HighGround#HighGround(char, int, double)  HighGround
	 */
	public Wall() {
		super('#', 20, 0.8);
	}

	/**
	 *
	 * @see HighGround#blocksThrownObjects()
	 */
	@Override
	public boolean blocksThrownObjects() {
		return true;
	}

}
