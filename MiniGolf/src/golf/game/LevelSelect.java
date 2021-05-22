package golf.game;

import java.awt.Point;
import java.awt.Rectangle;
import java.util.ArrayList;

import processing.core.PImage;

/**
 * 
 * @author Ansel
 *
 */

public class LevelSelect extends Screen {

	private DrawingSurface surface;
	private ArrayList<Rectangle> levelButton = new ArrayList<Rectangle>();
	private Rectangle back;
	private PImage b;
	private int thislevel;
	private boolean cleared[] = new boolean[20];

	
	public void setup() {
		b = surface.loadImage("Assets//backbutton.png");
	}
	
	/*
	 * Creates a new levelSelect
	 * 
	 * @param surface to draw on
	 */
	public LevelSelect(DrawingSurface drawingSurface) {
		super(800, 800);

		cleared[0] = true;
		surface = drawingSurface;

		back = new Rectangle(0, 0, 100, 100);
	}

	/*
	 * Draws the Level Select
	 */
	public void draw() {

		surface.pushStyle();

		surface.background(255, 255, 255);
		String str;
		float w;
		int j = 0;
		int row = 0;
		for (int i = 0; i < 20; i++) {
			if (j % 4 == 0) {
				j = 0;
				row++;
			}
			surface.fill(0);
			levelButton.add(new Rectangle(100 + 150 * j, 50+120*row, 150, 100));
			if (cleared[i]) {
				surface.noFill();
			}
			surface.rect(levelButton.get(i).x, levelButton.get(i).y, levelButton.get(i).width,
					levelButton.get(i).height, 10, 10, 10, 10);
			surface.fill(0);
			str = "level " + (i + 1);
			surface.text(str, levelButton.get(i).x + levelButton.get(i).width / 2 - surface.textWidth(str) / 2,
					levelButton.get(i).y + levelButton.get(i).height / 2);
			j++;
		}

		b.resize(b.width, b.height);
		surface.image(b, back.x, back.y);
		
		surface.popStyle();
	}

	/*
	 * switches the screen if the level1 rectangle is clicked on
	 */
	public void mousePressed() {
		Board b = new Board(surface);
		Point p = surface.actualCoordinatesToAssumed(new Point(surface.mouseX, surface.mouseY));
		for (int i = 0; i < 20; i++) {
//			if (levelButton.get(i).contains(p) && cleared[i]) {
//				thislevel = i + 1;
//				switchScreen(ScreenSwitcher.SCREEN4);
//			}
			if (levelButton.get(i).contains(p)) {
				thislevel = i + 1;
				switchScreen(ScreenSwitcher.SCREEN4);
			}
		}
		if (back.contains(p))
			surface.switchScreen(ScreenSwitcher.SCREEN1);
	}

	/**
	 * Loads up a new level depending on what has been selected
	 */
	@Override
	public void switchScreen(int i) {
		if (i == 3) {
			Board b = new Board(surface, thislevel, cleared);
			surface.screens.remove(3);
			surface.screens.add(3, b);
			surface.activeScreen = surface.screens.get(i);
			surface.setup();

		} else {
			surface.activeScreen = surface.screens.get(i);
		}

	}

}
