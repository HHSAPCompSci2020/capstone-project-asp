package golf.game;

import java.awt.Point;
import java.awt.Rectangle;
import java.util.ArrayList;

/**
 * 
 * @author Pranav
 *
 */

public class Board extends Screen {
	private Level l;
	private boolean isMoving;
	private DrawingSurface surface;
	private Rectangle back;
	private ArrayList<Rectangle> cardMenu;
	private Player p;
	private int level;

	/*
	 * Creates a new Board Screen
	 * 
	 * @param a drawing surface on which to draw on
	 */
	public Board(DrawingSurface s) {

		super(800, 800);
		surface = s;

	}

	public Board(DrawingSurface drawingSurface, int thislevel) {
		super(800, 800);
		Level l = new Level("Levels//Level" + thislevel + "//Level" + thislevel + "board.txt",
				"Levels//Level" + thislevel + "//Level" + thislevel + "cards.txt",
				"Levels//Level" + thislevel + "//Level" + thislevel + "powerups.txt");
		surface = drawingSurface;
		this.level = thislevel;
		this.l = l;
		back = new Rectangle(100, 100, 100, 100);
		p = l.findPlayer();
	}

	public void draw() {

		surface.pushStyle();

		surface.background(255, 255, 255);
		l.drawGrid(this, surface);
		l.drawCard(this, surface);
		p.draw(surface, this.DRAWING_WIDTH, this.DRAWING_HEIGHT);
		surface.rect(back.x, back.y, back.width, back.height, 10, 10, 10, 10);
		surface.fill(0);
		String str = "back";
		float w = surface.textWidth(str);
		surface.text(str, back.x + back.width / 2 - w / 2, back.y + back.height / 2);

		surface.popStyle();

	}

	public void mousePressed() {
		Point p = surface.actualCoordinatesToAssumed(new Point(surface.mouseX, surface.mouseY));
		if (back.contains(p)) {
			Music m = new Music();
			m.actionPerformed(null);
			this.switchScreen(3);
		}

	}

	@Override
	public void switchScreen(int i) {
		if (i == 3) {

			Board b = new Board(surface, level + 1);
			surface.screens.add(3, b);

			surface.activeScreen = surface.screens.get(i);
			surface.screens.remove(4);

		} else {
			surface.activeScreen = surface.screens.get(i);
		}

	}

	public Point findCoordinatePoint(int x, int y) {
		return new Point(this.DRAWING_WIDTH / 22 + (this.DRAWING_WIDTH / 22) / x,
				this.DRAWING_HEIGHT / 22 + (3 * this.DRAWING_HEIGHT / 4 - this.DRAWING_HEIGHT / 22) / y);
	}

}
