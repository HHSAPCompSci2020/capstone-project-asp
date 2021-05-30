package golf.game;

/***
 * 
 * @author Pranav & Savio
 *
 */
public class PowerUp {

	private int magnitude;
	private int jumpMagnitude;

	/*
	 * creates a new powerup with different magnitudes, jump magnitudes, and if it
	 * allows a jump
	 */
	public PowerUp(int m, int Jm) {
		magnitude = m;
		jumpMagnitude = Jm;
	}

	/**
	 * changes the card based on the powerup
	 * 
	 * @param Card c - the card that will be affected by this power
	 * @pre c must not be null
	 * @post c will have a different momentum and jmomentum via setter methods
	 **/
	public void affect(Card c) {
		c.setMagnitude(magnitude);
		c.setJMagnitude(jumpMagnitude);
	}
	/***
	 * 
	 * @return the movement magnitue of the powerup
	 */
	public int getMagnitude() {
		return magnitude;
		
	}
	/**
	 * 
	 * @return Jump magnitude of powerup
	 */
	
	public int getJMagnitude() {
		return jumpMagnitude;
		
	}

}
