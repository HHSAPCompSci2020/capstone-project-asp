
public class PowerUp {

	private int magnitude;
	private int jumpMagnitude;
	private boolean doesJump;
	
	public PowerUp(int m, int Jm, boolean j) {
		magnitude = m;
		jumpMagnitude = Jm;
		doesJump = j;
	}
	
	public int getMagnitude() {
		return magnitude;
	}
	
	public boolean getDoesJump() {
		return doesJump;
	}
	
	public void affect(Card c) {
		
	
	}
	
}
