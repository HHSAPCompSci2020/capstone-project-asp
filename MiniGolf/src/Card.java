
public class Card {

	private int magnitude;
	private boolean doesJump;
	private int magnitudeJump;
	
	public Card(int m, boolean d, int mJ) {
		magnitude = m;
		doesJump = d;
		magnitudeJump = mJ;
	}
	
	
	public void setMagnitude(int change){
		magnitude += change;
	}
	
	public void setJMagnitude(int change) {
		magnitudeJump += change;
	}
	
	public int getMagnitude() {
		return magnitude;
	}
	
	public int getJMagnitude() {
		return magnitudeJump;
	}
	
}
