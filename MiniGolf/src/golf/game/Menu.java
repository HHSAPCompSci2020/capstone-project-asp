package golf.game;

import java.awt.Point;
import java.awt.Rectangle;

/**
 * 
 * @author Savio
 *
 */
public class Menu extends Screen {

	private DrawingSurface surface;
	private Rectangle settings;
	private Rectangle levelSelect;
	private Music m = new Music();

	/*
	 * creates a new menu
	 * 
	 * @param the surface to draw on
	 */
	public Menu(DrawingSurface drawingSurface) {
		super(800, 800);
		surface = drawingSurface;

		settings = new Rectangle(300, 500, 200, 100);
		levelSelect = new Rectangle(300, 200, 200, 100);

		m.actionPerformed(null);
	}

	/*
	 * draw the menu
	 */
	public void draw() {

		surface.pushStyle();

		surface.background(255, 255, 255);

		surface.rect(settings.x, settings.y, settings.width, settings.height, 10, 10, 10, 10);
		surface.fill(0);
		String str = "Settings";
		float w = surface.textWidth(str);
		surface.text(str, settings.x + settings.width / 2 - w / 2, settings.y + settings.height / 2);

		surface.noFill();
		surface.rect(levelSelect.x, levelSelect.y, levelSelect.width, levelSelect.height, 10, 10, 10, 10);
		surface.fill(0);
		str = "levelSelect";
		w = surface.textWidth(str);
		surface.text(str, levelSelect.x + levelSelect.width / 2 - w / 2, levelSelect.y + levelSelect.height / 2);

		surface.popStyle();
	}

	/*
	 * switches the screen if if the screen2 rectangle is clicked
	 */
	public void mousePressed() {
		Point p = surface.actualCoordinatesToAssumed(new Point(surface.mouseX, surface.mouseY));
		if (settings.contains(p)) {
			surface.switchScreen(ScreenSwitcher.SCREEN2);
			m.songEnded();
		}
		if (levelSelect.contains(p))
			surface.switchScreen(ScreenSwitcher.SCREEN3);
	}

	@Override
	public void switchScreen(int i) {
		// TODO Auto-generated method stub

	}

}
