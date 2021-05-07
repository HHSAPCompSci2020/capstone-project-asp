package golf.game;

import java.awt.Point;
import java.awt.Rectangle;

import g4p_controls.GImageButton;

/**
 * 
 * @author Ansel
 *
 */

public class LevelSelect extends Screen {

	private DrawingSurface surface;
	private Rectangle level1;
	private Rectangle back;
	private GImageButton level;
	private String files[];

	/*
	 * Creates a new levelSelect
	 * 
	 * @param surface to draw on
	 */
	public LevelSelect(DrawingSurface drawingSurface) {
		super(800, 800);
		surface = drawingSurface;
		files = new String[] { "ballRED.png", "ballBLACK.png", "ballYELLOW.png" };
		level1 = new Rectangle(300, 200, 200, 100);
		back = new Rectangle(100, 100, 100, 100);
		level1 = new Rectangle(400, 200, 200, 100);
		level = new GImageButton(drawingSurface, 20, 14, files, "ballSWAG.png");
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
		Point p = surface.actualCoordinatesToAssumed(new Point(surface.mouseX, surface.mouseY));
		if (level1.contains(p))
			surface.switchScreen(ScreenSwitcher.SCREEN4);
		if (back.contains(p))
			surface.switchScreen(ScreenSwitcher.SCREEN1);
	}

	@Override
	public void switchScreen(int i) {
		// TODO Auto-generated method stub

	}

}
