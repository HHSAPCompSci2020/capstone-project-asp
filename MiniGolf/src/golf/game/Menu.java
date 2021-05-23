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
	private PImage lSelect, set;
	private PImage background;
	private Music m = new Music();
	
	public void setup() {
		lSelect = surface.loadImage("Assets//levelselect.png");
		set = surface.loadImage("Assets//settings.png");
		background = surface.loadImage("Assets//Background.png");
		background.resize(this.DRAWING_WIDTH, this.DRAWING_HEIGHT);
		
		
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
		m.musicStopped();
			}

	/*
	 * draw the menu
	 */
	
	public void draw() {

		surface.pushStyle();
		
		surface.background(255,255,255);
		surface.image(background, 0, 0);

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
		}
		if (levelSelect.contains(p))
			surface.switchScreen(ScreenSwitcher.SCREEN3);
	}

	@Override
	public void switchScreen(int i) {
		// TODO Auto-generated method stub

	}

}
