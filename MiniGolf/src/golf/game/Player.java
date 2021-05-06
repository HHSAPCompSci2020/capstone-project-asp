package golf.game;
import java.awt.Color;

public class Player {

	private float x;
	private float y;
	private int color;
	
	/*
	 * creates a new player with the given location
	 *  @param x-location for the player
	 *  @param y-location for the player
	 */
	public Player(float x, float y, int color) {
		this.x = x;
		this.y = y;
		
		if(color == 1)
		{
			
		}
	}
	
	
	/*
	 * @return x-value of the player
	 */
	public float getX(){
		return x;
	}
	
	/*
	 * @return y-value of the player
	 */
	public float getY() {
		return y;
	}
	
	/*
	 *@param x-value of the player
	 */
	public void setX(float x) {
		this.x = x;
	}
	
	/*
	 * @param y-value of the player
	 */
	public void setY(float y) {
		this.y = y;
	}
	
	
	/*
	 * Moves the player according to the parameters, and executes
	 * the correct behavior based on the tiles it lands on.
	 */
	public void move(Card c, Level l, PowerUp p, int dir) {
		//sets values based on the direction, 1 is up, 2 is down, 3 is right, 4 is left
		int dx = 0;
		int dy = 0;
		if(dir == 1)
			dy = -1;
		else if (dir == 2)
			dy = 1;
		else if (dir == 3)
			dx = 1;
		else if (dir == 4)
			dx = -1;
		
		//applies powerup if applicable
		if(p != null)
			p.affect(c);

		//jumps
		if (c.getJMagnitude() != 0) {
			char here = l.tiles[(int) (x+dx)][(int) (y+dy)];
			
			
		}
		
		//move
		for(int i = 0; i < c.getMagnitude(); i++) {
			
		}
		
	}
//	public move(Card c, level l, PowerUp p , int dir){
//		if(p != null){
//		p.affect(c);
//		}
//		//power ups
//
//		//jump
//		for(i = 0; i< jmomentum; i++){
//		//move in the specified direction
//		//check current tile
//		//change behavior accordingly
//		//ex. If current tile is a wall, don’t do anything
//		}
//		//move
//		for(i = 0; i<momentum; i++){
//		//move in the specified direction
//		//check current tile
//		//change behavior accordingly
//		//ex. If current tile is a wall, change direction
//		}

}
