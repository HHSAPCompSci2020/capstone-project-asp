package golf.game;

import java.awt.Point;
/**
 * @author Ansel
 */
import java.awt.Rectangle;

public class Settings extends Screen {

	private DrawingSurface surface;
	private Rectangle back;
	private Rectangle credits;

	/*
	 * Creates new settings
	 * 
	 * @param what to draw the settings on
	 */
	public Settings(DrawingSurface drawingSurface) {
		super(800, 800);
		surface = drawingSurface;

		back = new Rectangle(0, 0, 100, 100);
		credits = new Rectangle(300, 200, 200, 100);
	}

	/*
	 * draws the settings
	 */
	public void draw() {

		surface.pushStyle();

		surface.background(255, 255, 255);

		surface.rect(back.x, back.y, back.width, back.height, 10, 10, 10, 10);
		surface.fill(0);
		String str = "Back";
		float w = surface.textWidth(str);
		surface.text(str, back.x + back.width / 2 - w / 2, back.y + back.height / 2);

		surface.noFill();
		surface.rect(credits.x, credits.y, credits.width, credits.height, 10, 10, 10, 10);
		surface.fill(0);
		str = "credits";
		w = surface.textWidth(str);
		surface.text(str, credits.x + credits.width / 2 - w / 2, credits.y + credits.height / 2);

		surface.popStyle();
	}

	/*
	 * changes the screen when the back rectangle is clicked
	 */
	public void mousePressed() {
		Point p = surface.actualCoordinatesToAssumed(new Point(surface.mouseX, surface.mouseY));
		if (back.contains(p))
			surface.switchScreen(ScreenSwitcher.SCREEN1);
		if (credits.contains(p))
			surface.switchScreen(ScreenSwitcher.SCREEN5);
	}

	@Override
	public void switchScreen(int i) {
		// TODO Auto-generated method stub

	}

}
