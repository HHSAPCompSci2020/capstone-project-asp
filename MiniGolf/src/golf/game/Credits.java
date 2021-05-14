package golf.game;
import java.awt.Point;
import java.awt.Rectangle;
/**
 * 
 * 
 * @author Savio
 *
 */
public class Credits extends Screen{
		
	private DrawingSurface surface;
	private Rectangle back;

	/**
	 * creates new credits 
	 * @param the surface to draw the credits on
	 */
	public Credits(DrawingSurface drawingSurface) {
		super(800, 800);
		surface = drawingSurface;
		
		back = new Rectangle(0, 0, 100, 100);
	}
		
	public void draw() {

			surface.pushStyle();

	        surface.background(255,255,255);

	        surface.rect(back.x, back.y, back.width, back.height, 10, 10, 10, 10);
	        surface.fill(0);
	        String str = "Back";
	        float w = surface.textWidth(str);
	        surface.text(str, back.x+back.width/2-w/2, back.y+back.height/2);
	        surface.textSize(25);
	        surface.text("Pranav: Board, Level, Powerup", 100, 300);
	        surface.text("Savio: Player, Menu, Card", 100, 350);
	        surface.text("Ansel: Music, Level Select, Settings, Assets", 100, 400);
	        surface.text("Some code taken from: Proceessing screen switching demo", 100, 450);
	        surface.text("Music, and Recursion2D arrays", 100, 500);
	        surface.text("Uses Processing Library and JSound Library", 100, 550);
	        surface.text("Inspired by Golf Peaks", 100, 600);
	        
	        surface.popStyle();
	    }

	    public void mousePressed() {
	        Point p = surface.actualCoordinatesToAssumed(new Point(surface.mouseX,surface.mouseY));
	        if (back.contains(p))
	            surface.switchScreen(ScreenSwitcher.SCREEN2);
	    }

	@Override
	public void switchScreen(int i) {
		// TODO Auto-generated method stub
		
	}

}
