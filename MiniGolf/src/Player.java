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
