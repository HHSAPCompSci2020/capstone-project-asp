import java.awt.Point;
import java.awt.Rectangle;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Board extends Screen{
	
	private Player p;
	private Level l;
	private boolean isMoving;
	private DrawingSurface surface;
	private Rectangle back;
	
	public Board(DrawingSurface drawingSurface) {
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
        
        surface.popStyle();
    }

    public void mousePressed() {
        Point p = surface.actualCoordinatesToAssumed(new Point(surface.mouseX,surface.mouseY));
        if (back.contains(p))
            surface.switchScreen(ScreenSwitcher.SCREEN3);
    }

	@Override
	public void switchScreen(int i) {
		// TODO Auto-generated method stub
		
	}

	
}
