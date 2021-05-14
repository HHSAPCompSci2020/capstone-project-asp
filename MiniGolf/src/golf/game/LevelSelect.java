package golf.game;

import java.awt.Point;
import java.awt.Rectangle;

/**
 * 
 * @author Ansel
 *
 */

public class LevelSelect extends Screen {

	private DrawingSurface surface;
	private Rectangle level1, level2;
	private Rectangle back;
	private int thislevel;
	private boolean cleared[] = new boolean[20];

	/*
	 * Creates a new levelSelect
	 * 
	 * @param surface to draw on
	 */
	public LevelSelect(DrawingSurface drawingSurface) {
		super(800, 800);

		cleared[0] = true;
		surface = drawingSurface;

		level1 = new Rectangle(100, 200, 150, 100);
		back = new Rectangle(0, 0, 100, 100);
		level2 = new Rectangle(250, 200, 150, 100);
	}

	/*
	 * Draws the Level Select
	 */
	public void draw() {

		surface.pushStyle();

		surface.background(255, 255, 255);

		surface.rect(level1.x, level1.y, level1.width, level1.height, 10, 10, 10, 10);
		surface.fill(0);
		String str = "level 1";
		float w = surface.textWidth(str);
		surface.text(str, level1.x + level1.width / 2 - w / 2, level1.y + level1.height / 2);

		surface.fill(0);
		if (cleared[1]) {
			surface.noFill();
		}
		surface.rect(level2.x, level2.y, level2.width, level2.height, 10, 10, 10, 10);
		surface.fill(0);
		str = "level 2";
		w = surface.textWidth(str);
		surface.text(str, level2.x + level2.width / 2 - w / 2, level2.y + level2.height / 2);

		surface.noFill();
		surface.rect(back.x, back.y, back.width, back.height, 10, 10, 10, 10);
		surface.fill(0);
		str = "Back";
		w = surface.textWidth(str);
		surface.text(str, back.x + back.width / 2 - w / 2, back.y + back.height / 2);

		surface.popStyle();
	}

	/*
	 * switches the screen if the level1 rectangle is clicked on
	 */
	public void mousePressed() {
		Board b = new Board(surface);
		Point p = surface.actualCoordinatesToAssumed(new Point(surface.mouseX, surface.mouseY));
		if (level1.contains(p)) {
			thislevel = 1;
			switchScreen(ScreenSwitcher.SCREEN4);
		}
		if (level2.contains(p) && cleared[1]) {
			thislevel = 2;
			switchScreen(ScreenSwitcher.SCREEN4);
		}
		if (back.contains(p))
			surface.switchScreen(ScreenSwitcher.SCREEN1);
	}

	/**
	 * Loads up a new level depending on what has been selected
	 */
	@Override
	public void switchScreen(int i) {
		// TODO Auto-generated method stub

		if (i == 3) {
			Level l = new Level("Levels//Level" + thislevel + "//Level" + thislevel + "board.txt",
					"Levels//Level" + thislevel + "//Level" + thislevel + "cards.txt",
					"Levels//Level" + thislevel + "//Level" + thislevel + "powerups.txt");
			Board b = new Board(surface, thislevel);
			surface.screens.remove(3);
			surface.screens.add(3, b);
			surface.activeScreen = surface.screens.get(i);

		} else {
			surface.activeScreen = surface.screens.get(i);
		}

	}

}
