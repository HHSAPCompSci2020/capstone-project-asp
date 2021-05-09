package golf.game;
import java.awt.Color;
import java.awt.Point;

import processing.core.PApplet;
import processing.core.PConstants;
import processing.core.PImage;
/**
 * 
 * @author Savio
 *
 */
public class Player {

	private int x;
	private int y;
	private int startX;
	private int startY;
	private int color;
	
	/*
	 * creates a new player with the given location
	 *  @param x-location for the player
	 *  @param y-location for the player
	 */
	public Player(int x, int y, int color) {
		this.x = x;
		this.y = y;
		startX = x;
		startY = y;
		this.color = color;
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
	public void setX(int x) {
		this.x = x;
	}
	
	/*
	 * @param y-value of the player
	 */
	public void setY(int y) {
		this.y = y;
	}
	
	
	/*
	 * Moves the player according to the parameters, and executes
	 * the correct behavior based on the tiles it lands on.
	 */
	public Point move(Card c, Level l, PowerUp p, int dir) {
		//If it on a wall, don't move
		if (l.tiles[x][y] == '#')
			return new Point(x, y);
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
		
		int moveDist = c.getMagnitude();
		int jumpDist = c.getJMagnitude();
		
		//jumps
		if (jumpDist != 0) {
			if (x+(dx*jumpDist) < 0 || x+(dx*jumpDist) > 19 || y+(dy*jumpDist) < 0 || y+(dy*jumpDist) > 19) {
				//reset the level
				this.reset();
				return null;
			}
			char here = l.tiles[x+(dx*jumpDist)][y+(dy*jumpDist)];
			//Moves player to new location
			x = x+(dx*jumpDist);
			y = y+(dy*jumpDist);
			//Water tile or wall tile
			if (here == '~' || here == '\u0000') {
				//reset the level
				this.reset();
				return null;
			}
			//Ice tile
			if (here == '-') 
				moveDist++;
			//Wall or sand pit
			if (here == '#' || here == '*')
				moveDist = 0;
			//Up tile
			if (here == '^') {
				dy = -1;
				dx = 0;
			}
			//Down tile
			if (here == 'v') {
				dy = 1;
				dx = 0;
			}
			//Right tile
			if (here == '>') {
				dy = 0;
				dx = 1;
			}
			//Left tile
			if (here == '<') {
				dy = 0;
				dx = -1;
			}

		}
		
		//move
		for(int i = 0; i < moveDist; i++) {
			x = x+dx;
			y = y+dy;
			char h = l.tiles[x][y];
			//Water tile
			if (h == '~' || h == '\u0000') {
				//Resets the level
				this.reset();
				return null;
			}
			//Ice tile
			if (h == '-')
				moveDist++;
			//Sand pit
			if (h == '*')
				break;
			//Wall
			if (h == '#') {
				dx *= -1;
				dy *= -1;
				moveDist++;
			}
			//Up tile
			if (h == '^') {
				dy = -1;
				dx = 0;
			}
			//Down tile
			if (h == 'v') {
				dy = 1;
				dx = 0;
			}
			//Right tile
			if (h == '>') {
				dy = 0;
				dx = 1;
			}
			//Left tile
			if (h == '<') {
				dy = 0;
				dx = -1;
			}
			
			
		}
		
		//Checks if you end up on a flag
		if (l.tiles[x][y] == 'X')
			; //whatever it does when you win
		return new Point(x, y);
		
	}
	
	
	public void draw(PApplet surface, float x, float y) {
		surface.ellipse(x, y, 100, 100);
//		surface.image(createImage("ballWHITE.png"), x, y);
	}
	
	/*
	 * Resets the player to the starting position
	 */
	public void reset() {
		x = startX;
		y = startY;
	}
	

}
