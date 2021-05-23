package golf.game;
import java.awt.Point;
import java.awt.Rectangle;

import processing.core.PImage;
/**
 * 
 * 
 * @author Savio
 *
 */
public class Credits extends Screen{
		
	private DrawingSurface surface;
	private PImage back;
	private Rectangle backbutton;
	private PImage Credits;
	

	/**
	 * creates new credits 
	 * @param the surface to draw the credits on
	 */
	public Credits(DrawingSurface drawingSurface) {
		super(800, 800);
		surface = drawingSurface;
		backbutton = new Rectangle(0,0,85,85);
		
		}
	
	public void setup() {
		back = surface.loadImage("Assets//backbutton.png");
		Credits = surface.loadImage("Assets//Credits.png");
	}
		
	public void draw() {

			surface.pushStyle();

	        surface.background(255,255,255);
	        surface.image(back,0,0);
	        Credits.resize(700, 700);
	        surface.image(Credits, 50, 80);
	   
	        
	        surface.popStyle();
	    }

	    public void mousePressed() {
	        Point p = surface.actualCoordinatesToAssumed(new Point(surface.mouseX,surface.mouseY));
	        if (backbutton.contains(p))
	            surface.switchScreen(ScreenSwitcher.SCREEN2);
	    }

	@Override
	public void switchScreen(int i) {
		// TODO Auto-generated method stub
		
	}

}
