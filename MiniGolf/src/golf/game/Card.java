package golf.game;

/***
 * 
 * @author Savio
 *
 */
public class Card {

	private int magnitude;
	private int magnitudeJump;

	/***
	 * Creates a new card with the given magnitude, if its a card that lets you
	 * jump, and how big the jump is
	 * 
	 * @param magnitude of the card
	 * @param true      if the card lets you jump, false if it is just a normal card
	 * @param how       big the jump is
	 */
	public Card(int m, int mJ) {
		magnitude = m;
		magnitudeJump = mJ;
	}

	/**
	 * @param amount added to the magnitude
	 */
	public void setMagnitude(int change) {
		magnitude += change;
	}

	/**
	 * @param amount added to the magnitude of the jump
	 */
	public void setJMagnitude(int change) {
		magnitudeJump += change;
	}

	/**
	 * @return magnitude of the card
	 */
	public int getMagnitude() {
		return magnitude;
	}

	/**
	 * @return magnitude of the cards jump
	 */
	public int getJMagnitude() {
		return magnitudeJump;
	}

}
