package golf.game;

import java.awt.Point;
import java.awt.Rectangle;

import processing.core.PImage;

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
	private PImage lSelect, set;
	
	public void setup() {
		lSelect = surface.loadImage("Assets//levelselect.png");
		set = surface.loadImage("Assets//settings.png");
	}
	
	
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

		set.resize(settings.width, settings.height);
		lSelect.resize(levelSelect.width, levelSelect.height);
		surface.image(set, settings.x, settings.y);
		surface.image(lSelect, levelSelect.x, levelSelect.y);

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
