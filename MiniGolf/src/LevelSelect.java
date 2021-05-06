import java.awt.Point;
import java.awt.Rectangle;

public class LevelSelect extends Screen{

	private DrawingSurface surface;
	private Rectangle level1;
	
	/*
	 * Creates a new levelSelect 
	 * @param surface to draw on
	 */
	public LevelSelect(DrawingSurface drawingSurface) {
		super (800, 800);
		surface = drawingSurface;
		
		level1 = new Rectangle(400, 200, 200, 100);
	}

	/*
	 * Draws the Level Select
	 */
	public void draw() {

        surface.pushStyle();

        surface.background(255,255,255);

        surface.rect(level1.x, level1.y, level1.width, level1.height, 10, 10, 10, 10);
        surface.fill(0);
        String str = "Click me!";
        float w = surface.textWidth(str);
        surface.text(str, level1.x+level1.width/2-w/2, level1.y+level1.height/2);

        surface.popStyle();
    }

	/*
	 * switches the screen if the level1 rectangle is clicked on
	 */
    public void mousePressed() {
        Point p = surface.actualCoordinatesToAssumed(new Point(surface.mouseX,surface.mouseY));
        if (level1.contains(p))
            surface.switchScreen(ScreenSwitcher.SCREEN2);
    }
	
	@Override
	public void switchScreen(int i) {
		// TODO Auto-generated method stub
		
	}

}
