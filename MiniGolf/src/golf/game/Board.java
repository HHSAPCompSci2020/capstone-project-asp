package golf.game;

import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

/**
 * 
 * @author Pranav
 *
 */

public class Board extends Screen {
	private Level l;
	private Card cardSelected;
	private boolean isMoving;
	private DrawingSurface surface;
	private Rectangle back;
	public ArrayList<Rectangle> cardMenu = new ArrayList<Rectangle>();
	private Player p;
	private int level;
	private ArrayList<Integer> keys = new ArrayList<Integer>();

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

		System.out.println("" + l.c.get(0).getMagnitude());
		p.move(l.c.get(0), l, null, 1);

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

		if (cardSelected != null) {
			if (isPressed(KeyEvent.VK_LEFT)) {
				p.move(cardSelected, l, null, 4);
				l.c.remove(cardSelected);
			}
			if (isPressed(KeyEvent.VK_RIGHT)) {
				p.move(cardSelected, l, null, 3);
				l.c.remove(cardSelected);
			}

			if (isPressed(KeyEvent.VK_UP)) {
				p.move(cardSelected, l, null, 1);
				l.c.remove(cardSelected);

			}
			if (isPressed(KeyEvent.VK_DOWN)) {
				p.move(cardSelected, l, null, 2);
				l.c.remove(cardSelected);
			}

		}
		surface.popStyle();

	}

	public void mousePressed() {
		Point p = surface.actualCoordinatesToAssumed(new Point(surface.mouseX, surface.mouseY));
		if (back.contains(p)) {
			Music m = new Music();
			m.actionPerformed(null);
			this.switchScreen(3);
		}

		for (int i = 0; i < l.c.size(); i++) {
			if (cardMenu.get(i).contains(p)) {
				cardSelected = l.c.get(i);
			}

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

	public void keyPressed() {
		keys.add(surface.keyCode);
	}

	public void keyReleased() {
		while (keys.contains(surface.keyCode))
			keys.remove(new Integer(surface.keyCode));
	}

	public boolean isPressed(Integer code) {
		return keys.contains(code);
	}

}
