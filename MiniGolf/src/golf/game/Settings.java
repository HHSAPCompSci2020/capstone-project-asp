package golf.game;

import java.awt.Point;
/**
 * @author Ansel
 */
import java.awt.Rectangle;
import java.util.ArrayList;

public class Settings extends Screen {

	private DrawingSurface surface;
	private Rectangle back;
	private Rectangle credits;
	private ArrayList<Rectangle> colors = new ArrayList<Rectangle>();

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
		for (int i = 0; i < 7; i++) {
			colors.add(new Rectangle(50+(i*100), 400, 100, 100));
		}
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
		for (int i = 0; i < 7; i++) {
			surface.rect((float)colors.get(i).getX(), (float)colors.get(i).getY(), (float)colors.get(i).getWidth(), (float)colors.get(i).getHeight());
		}
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
