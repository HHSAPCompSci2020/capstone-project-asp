package golf.game;

import java.awt.Point;
/**
 * @author Ansel
 */
import java.awt.Rectangle;
import java.util.ArrayList;

import processing.core.PImage;

public class Settings extends Screen {

	private DrawingSurface surface;
	private Rectangle back;
	private PImage b, cbutton;
	private Rectangle credits;
	private ArrayList<Rectangle> colors = new ArrayList<Rectangle>();
	private ArrayList<PImage> c = new ArrayList<PImage>();

	
	
	public void setup() {
		c.add(surface.loadImage("Assets//ballBLACK.png"));
		c.add(surface.loadImage("Assets//ballBLUE.png"));
		c.add(surface.loadImage("Assets//ballGREEN.png"));
		c.add(surface.loadImage("Assets//ballRED.png"));
		c.add(surface.loadImage("Assets//ballSWAG.png"));
		c.add(surface.loadImage("Assets//ballWHITE.png"));
		c.add(surface.loadImage("Assets//ballYELLOW.png"));
		b = surface.loadImage("Assets//backbutton.png");
		cbutton = surface.loadImage("Assets//creditsbutton.png");
	}
	
	/**
	 * Creates a new settings screen
	 * @param drawingSurface the PApplet for the settings screen to use
	 */
	public Settings(DrawingSurface drawingSurface) {
		super(800, 800);
		surface = drawingSurface;

		back = new Rectangle(0, 0, 100, 100);
		credits = new Rectangle(300, 200, 200, 100);
		for (int i = 0; i < 7; i++) {
			colors.add(new Rectangle(50+(i*100), 400, 100, 100));
		}
	}

	/**
	 * draws the settings screen
	 */
	public void draw() {

		surface.pushStyle();

		surface.background(135, 206, 235);

		surface.image(b, back.x, back.y);

		surface.noFill();

		for (int i = 0; i < 7; i++) {
			surface.rect((float)colors.get(i).getX(), (float)colors.get(i).getY(), (float)colors.get(i).getWidth(), (float)colors.get(i).getHeight());
			surface.image(c.get(i), (float)colors.get(i).getX(), (float)colors.get(i).getY());
		}
		
		surface.image(cbutton, credits.x, credits.y);


		surface.popStyle();
	}

	/**
	 * changes the screen when the back rectangle is clicked
	 */
	public void mousePressed() {
		Point p = surface.actualCoordinatesToAssumed(new Point(surface.mouseX, surface.mouseY));
		if (back.contains(p))
			surface.switchScreen(ScreenSwitcher.SCREEN1);
		if (credits.contains(p))
			surface.switchScreen(ScreenSwitcher.SCREEN5);
		for (int i = 0; i < 7; i++) {
			if (colors.get(i).contains(p)) {
				Player.changeColor(i);
			}
		}
		
	}

	@Override
	public void switchScreen(int i) {
		// TODO Auto-generated method stub

	}

}
