
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
	
	
	
	/**
	 * changes the card based on the powerup
	 * @param Card c - the card that will be affected by this power
	 * @pre c must not be null
	 * @post c will have a different momentum and jmomentum via setter methods
	 **/
	public void affect(Card c) {
		
		
	}
	
}
