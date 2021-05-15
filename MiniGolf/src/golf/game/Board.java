package golf.game;

import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.geom.Rectangle2D;
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
	private Rectangle back1;
	public ArrayList<Rectangle2D.Float> cardMenu = new ArrayList<Rectangle2D.Float>();
	private Player p;
	private int level;
	private boolean isCleared;
	private boolean[] cleared;

	/**
	 * Creates a new Board Screen
	 * 
	 * @param a drawing surface on which to draw on
	 */
	public Board(DrawingSurface s) {

		super(800, 800);
		surface = s;

	}

	public Board(DrawingSurface drawingSurface, int thislevel, boolean[] cleared) {
		super(800, 800);
		Level l = new Level("Levels//Level" + thislevel + "//Level" + thislevel + "board.txt",
				"Levels//Level" + thislevel + "//Level" + thislevel + "cards.txt",
				"Levels//Level" + thislevel + "//Level" + thislevel + "powerups.txt");
		surface = drawingSurface;
		this.level = thislevel;
		this.l = l;
		back = new Rectangle(700, 700, 100, 100);
		back1 = new Rectangle(0, 700, 100, 100);
		p = l.findPlayer();
		Music m = new Music();
		m.actionPerformed(null);
		instantiateCards();
		isCleared = false;
		this.cleared = cleared;
		System.out.println(cardMenu.size());

		System.out.println(cardMenu.get(0).getCenterX());
	}

	private void instantiateCards() {

		float startx = DRAWING_WIDTH / 22;
		float starty = DRAWING_HEIGHT * 4 / 5;

		float change = (DRAWING_WIDTH - DRAWING_WIDTH / 22) / l.c.size();

		for (int i = 0; i < l.c.size(); i++) {

			this.cardMenu.add(new Rectangle2D.Float(change * i + startx, starty, 100, 100));
		}

	}

	public void draw() {

		surface.pushStyle();
		
		surface.background(255, 255, 255);
		surface.fill(255, 0, 0);
		l.drawGrid(this, surface);
		l.drawCard(this, surface);
		p.draw(surface, this.DRAWING_WIDTH, this.DRAWING_HEIGHT);
		surface.rect(back.x, back.y, back.width, back.height, 10, 10, 10, 10);
		surface.rect(back1.x, back1.y, back1.width, back1.height);

		surface.fill(0);
		String str = "Next";
		float w = surface.textWidth(str);
		surface.text(str, back.x + back.width / 2 - w / 2, back.y + back.height / 2);
		str = "Back";
		w = surface.textWidth(str);
		surface.text(str, back1.x + back1.width / 2 - w / 2, back1.y + back1.height / 2);

		surface.fill(0, 255, 0);

		if (cardSelected != null) {

			if (surface.isPressed(KeyEvent.VK_LEFT)) {
				p.move(cardSelected, l, null, 4);

				l.c.remove(cardSelected);
				cardSelected = null;
			}
			if (surface.isPressed(KeyEvent.VK_RIGHT)) {
				p.move(cardSelected, l, null, 3);
				System.out.println("this");
				l.c.remove(cardSelected);
				cardSelected = null;
			}

			if (surface.isPressed(KeyEvent.VK_UP)) {
				p.move(cardSelected, l, null, 1);
				l.c.remove(cardSelected);
				cardSelected = null;

			}
			if (surface.isPressed(KeyEvent.VK_DOWN)) {
				p.move(cardSelected, l, null, 2);
				l.c.remove(cardSelected);
				cardSelected = null;
			}
			
		}
		if (p.isCleared()) {
			isCleared = true;
			cleared[level] = true;
		}
		if (!p.isCleared() && cardMenu.size() == 0) {
			l.reset();
			this.instantiateCards();
		}
		surface.popStyle();

	}

	public void mousePressed() {
		Point p = surface.actualCoordinatesToAssumed(new Point(surface.mouseX, surface.mouseY));
		if (back.contains(p) && this.p.isCleared()) {
			this.switchScreen(3);
		}
		if (back1.contains(p)) {
			this.switchScreen(2);
		}

		for (int i = 0; i < l.c.size(); i++) {

			if (cardMenu.get(i).contains(p)) {
				cardSelected = l.c.get(i);
				System.out.println("hit");
				if (cardSelected == null) {
					System.out.println("?");
				}

			}

		}
	}

	@Override
	/**
	 * goes to the next level
	 */
	public void switchScreen(int i) {
		if (i == 3) {

			Board b = new Board(surface, level + 1, cleared);
			surface.screens.add(3, b);

			surface.activeScreen = surface.screens.get(i);
			surface.screens.remove(4);

		} else {
			surface.activeScreen = surface.screens.get(i);
		}

	}

}
