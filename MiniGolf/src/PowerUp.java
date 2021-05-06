
public class PowerUp {

	private int magnitude;
	private int jumpMagnitude;
	private boolean doesJump;
	
	/*
	 * creates a new powerup with different magnitudes, jump magnitudes, and if it allows a jump
	 */
	public PowerUp(int m, int Jm, boolean j) {
		magnitude = m;
		jumpMagnitude = Jm;
		doesJump = j;
	}
	
	/*
	 * @return magnitude of the powerup
	 */
	public int getMagnitude() {
		return magnitude;
	}
	
	/*
	 * @return if it allows a jump
	 */
	public boolean getDoesJump() {
		return doesJump;
	}
	

	/*
	 * changes the card based on the powerup
	 */
	public void affect(Card c) {

		
	
	}
	
}
