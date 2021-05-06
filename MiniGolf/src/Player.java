import java.awt.Color;

public class Player {

	private float x;
	private float y;
	
	/*
	 * creates a new player with the given location
	 *  @param x-location for the player
	 *  @param y-location for the player
	 */
	public Player(float x, float y, Color playerColor) {
		this.x = x;
		this.y = y;
	}
	
	
	/*
	 * Returns X of the player
	 * @return x-value
	 */
	public float getX(){
		return x;
	}
	
	/*
	 * returns the Y of the player 
	 * @return y-value
	 */
	public float getY() {
		return y;
	}
	
	/*
	 * sets the x-value of the player
	 */
	public void setX(float x) {
		this.x = x;
	}
	
	/*
	 * sets the y-value of the player
	 */
	public void setY(float y) {
		this.y = y;
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
