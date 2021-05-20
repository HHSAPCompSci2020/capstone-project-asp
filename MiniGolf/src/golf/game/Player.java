package golf.game;

import java.awt.Point;
import java.util.ArrayList;

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
	private int movingX;
	private int movingY;
	private static int color;
	private boolean cleared;
	private ArrayList<Point> next;
	private int moveTimer;
	private boolean jump;
	float size;

	/*
	 * creates a new player with the given location
	 * 
	 * @param x-location for the player
	 * 
	 * @param y-location for the player
	 */
	public Player(int x, int y) {
		this.x = x;
		this.y = y;
		startX = x;
		startY = y;
		movingX = x;
		movingY = y;
		cleared = false;
		next = new ArrayList<Point>();
		moveTimer = 60;
		jump = false;
		size = 25;
	}

	/**
	 * @return x-value of the player
	 */
	public float getX() {
		return x;
	}

	/**
	 * @return y-value of the player
	 */
	public float getY() {
		return y;
	}

	/**
	 * @param x-value of the player
	 */
	public void setX(int x) {
		this.x = x;
	}

	/**
	 * @param y-value of the player
	 */
	public void setY(int y) {
		this.y = y;
	}

	/***
	 * Moves the player according to the parameters, and executes the correct
	 * behavior based on the tiles it lands on.
	 * 
	 * @param c   the card that is currently held
	 * @param l   the current level that the player is in
	 * @param p   Powerups that may affect the movement
	 * @param dir an integer value representing which direction the player moved in
	 */
	public Point move(Card c, Level l, PowerUp p, int dir) {
		// If it on a wall, don't move
		if (l.tiles[y][x] == '#')
			return new Point(x, y);

		next.add(new Point(x, y));
		
		// sets values based on the direction, 1 is up, 2 is down, 3 is right, 4 is left
		int dx = 0;
		int dy = 0;
		if (dir == 1)
			dy = -1;
		if (dir == 2)
			dy = 1;
		if (dir == 3)
			dx = 1;
		if (dir == 4)
			dx = -1;

		// applies powerup if applicable
		if (p != null)
			p.affect(c);

		int moveDist = c.getMagnitude();
		int jumpDist = c.getJMagnitude();

		// jumps
		if (jumpDist != 0) {
			if (x + (dx * jumpDist) < 0 || x + (dx * jumpDist) > 19 || y + (dy * jumpDist) < 0
					|| y + (dy * jumpDist) > 19) {
				// reset the level
				this.reset();
				return null;
			}
			char here = l.tiles[y + (dy * jumpDist)][x + (dx * jumpDist)];
			// Moves player to new location
			x = x + (dx * jumpDist);
			y = y + (dy * jumpDist);
			// Water tile or wall tile
			if (here == '~' || here == '\u0000') {
				// reset the level
				this.reset();
				return null;
			}
			// Ice tile
			if (here == '-')
				moveDist++;
			// Wall or sand pit
			if (here == '#' || here == '*')
				moveDist = 0;
			// Up tile
			if (here == '^') {
				dy = -1;
				dx = 0;
			}
			// Down tile
			if (here == 'v') {
				dy = 1;
				dx = 0;
			}
			// Right tile
			if (here == '>') {
				dy = 0;
				dx = 1;
			}
			// Left tile
			if (here == '<') {
				dy = 0;
				dx = -1;
			}
		}
		next.add(new Point(x, y));
		

		// move
		for (int i = 0; i < moveDist; i++) {
			x = x + dx;
			y = y + dy;
			char h = l.tiles[y][x];
			// Water tile
			if (h == '~' || h == '\u0000') {
				// Resets the level
				this.reset();
				return null;
			}
			// Ice tile
			if (h == '-')
				moveDist++;
			// Sand pit
			if (h == '*')
				break;
			// Wall
			if (h == '#') {
				next.add(new Point(x, y));
				x -= dx;
				y -= dy;
				dx *= -1;
				dy *= -1;

			}
			// Up tile
			if (h == '^') {
				dy = -1;
				dx = 0;
			}
			// Down tile
			if (h == 'v') {
				dy = 1;
				dx = 0;
			}
			// Right tile
			if (h == '>') {
				dy = 0;
				dx = 1;
			}
			// Left tile
			if (h == '<') {
				dy = 0;
				dx = -1;
			}
			next.add(new Point(x, y));
		}

		// Checks if you end up on a flag
		if (l.tiles[y][x] == 'X') {
			cleared = true;
		}
		return new Point(x, y);

	}

	/**
	 * Draws the player on the parameter PApplet
	 */
	public boolean draw(PApplet surface, float width, float height, boolean moving, PImage p) {
		moveTimer--;
		surface.pushStyle();
		surface.fill(color);
		float boxHeight = ((3 * height / 4) - (height / 22)) / 20;
		float boxWidth = width / 22;
		if (!jump) {
			if (boxHeight > boxWidth) {
				size = boxWidth;
			} else {
				size = boxHeight;
			} 
		}
		
		
	    if (next.size() == 0) {
	    	surface.imageMode(PConstants.CENTER);
	    	p.resize((int)size, (int)size);
	    	surface.image(p, (boxWidth) * (x + 1) + boxWidth / 2, (height / 22) + boxHeight * y + boxHeight / 2);
//	    	surface.ellipse((boxWidth) * (x + 1) + boxWidth / 2, (boxWidth) * (x + 1) + boxWidth / 2, size, size);
	    	surface.popStyle();
	    	return false;
	    }
	    if (moving == false) {
	    	movingX = (int) next.get(0).getX();
	    	movingY = (int) next.get(0).getY();	
	    	next.remove(0);
	    	jump = true;
	    }
	    if (jump && next.size() != 0) {
	    	if ((int) next.get(0).getX() != movingX && moveTimer <= 0){
	    		size += 10;
	    		if (movingX > (int) next.get(0).getX()) {
	    			movingX--;
	    		} else {
	    			movingX++;
	    		}
	    		moveTimer = 30;
	    	} 
	    	if ((int) next.get(0).getY() != movingY && moveTimer <= 0) {
	    		size += 10;
	    		if (movingY > (int) next.get(0).getY()) {
	    			movingY--;
	    		} else {
	    			movingY++;
	    		}
	    		moveTimer = 30;
	    	}
	    	
	    	if ((int) next.get(0).getY() == movingY && (int) next.get(0).getX() == movingX && moveTimer <= 0) {
	    		if (boxHeight > boxWidth) {
					size = boxWidth;
				} else {
					size = boxHeight;
				} 
	    		jump = false;
	    		moveTimer = 30;
	    		next.remove(0);
	    	}
	    }
		if (!jump) {
			if (moveTimer <= 0) {
				movingX = (int) next.get(0).getX();
				movingY = (int) next.get(0).getY();
				next.remove(0);
				moveTimer = 30;
			}
			
		}
	    
	    float hx = (boxWidth) * (movingX + 1) + boxWidth / 2;
		float hy = (height / 22) + boxHeight * movingY + boxHeight / 2;
		
		surface.imageMode(PConstants.CENTER);
		p.resize((int)size, (int)size);
    	surface.image(p, hx, hy);
//		surface.ellipse(hx, hy, size, size);

		surface.popStyle();
		return true;

		
		// surface.image(surface.loadImage("Assets/ballBLACK.png"), x, y);
	}

	/**
	 * Resets the player to the starting position
	 */
	public void reset() {
		x = startX;
		y = startY;
	}

	/**
	 * @return boolean true if level has been cleared, false otherwise
	 */
	public boolean isCleared() {
		return cleared;
	}
	
	
	/**
	 * Changes the color of the player
	 * @param c the number associated with the desired color
	 */
	public static void changeColor(int c) {
		color = c;
	}
	
	
	public int getColor() {
		return color;
	}
	
}
