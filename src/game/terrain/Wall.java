package game.terrain;

public class Wall extends HighGround {

	public Wall() {
		super('#', 20, 0.8);
	}

	@Override
	public boolean blocksThrownObjects() {
		return true;
	}

}
