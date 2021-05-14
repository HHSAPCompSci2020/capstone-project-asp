package golf.game;

import java.awt.Point;

import processing.core.PApplet;

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
	 * 
	 * @param x-location for the player
	 * 
	 * @param y-location for the player
	 */
	public Player(int x, int y, int color) {
		this.x = x;
		this.y = y;
		startX = x;
		startY = y;
		this.color = color;
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
	 * @param c the card that is currently held
	 * @param l the current level that the player is in
	 * @param p Powerups that may affect the movement
	 * @param dir an integer value representing which direction the player moved in
	 */
	public Point move(Card c, Level l, PowerUp p, int dir) {
		// If it on a wall, don't move
		if (l.tiles[y][x] == '#')
			return new Point(x, y);
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
				x-=dx;
				y-=dy;
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

		}
	

		// Checks if you end up on a flag
		if (l.tiles[y][x] == 'X') {
			
			
		}
			 // whatever it does when you win
		return new Point(x, y);

	}

	/*
	 * Draws the player on the parameter PApplet
	 */
	public void draw(PApplet surface, float width, float height) {
		float boxHeight = ((3*height/4) - (height/22))/20;
		float boxWidth = width/22;
		float size = 25;
		float hx = (boxWidth)*(x+1) + boxWidth/2;
		float hy = (height/22)+boxHeight*y + boxHeight/2;
		if (boxHeight > boxWidth) {
			size = boxWidth;
		} else {
			size = boxHeight;
		}
		surface.ellipse(hx, hy, size, size);
		// surface.image(surface.loadImage("Assets/ballBLACK.png"), x, y);
	}

	/*
	 * Resets the player to the starting position
	 */
	public void reset() {
		x = startX;
		y = startY;
	}

}
