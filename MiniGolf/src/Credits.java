import java.awt.Point;
import java.awt.Rectangle;

public class Credits extends Screen{
	
	private DrawingSurface surface;
	private Rectangle back;

	public Credits(DrawingSurface drawingSurface) {
		super(800, 800);
		surface = drawingSurface;
		
		back = new Rectangle(100, 100, 100, 100);
	}
	
	public void draw() {

        surface.pushStyle();

        surface.background(255,255,255);

        surface.rect(back.x, back.y, back.width, back.height, 10, 10, 10, 10);
        surface.fill(0);
        String str = "back";
        float w = surface.textWidth(str);
        surface.text(str, back.x+back.width/2-w/2, back.y+back.height/2);
        surface.textSize(25);
        surface.text("Coded by Pranav, Ansel and Savio", 250, 300);
        surface.text("Inspired by Golf Peaks", 250, 400);
        
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
