package golf.game;
import java.awt.Point;

import java.awt.Rectangle;
import java.util.ArrayList;


/**
 * 
 * @author Pranav
 *
 */


public class Board extends Screen{
	private Level l;
	private boolean isMoving;
	private DrawingSurface surface;
	private Rectangle back;
	private ArrayList<Rectangle> cardMenu;
	private Player p;
	/*
	 * Creates a new Board Screen
	 * @param a drawing surface on which to draw on
	 */
	public Board(DrawingSurface s) {
		
		
		super(800,800);
		surface = s;
		
		
	}
	public Board(DrawingSurface drawingSurface, Level l) {
		super(800, 800);
		surface = drawingSurface;

		this.l = l;
		back = new Rectangle(100, 100, 100, 100);
		p = l.findPlayer();
	}
	
	
	public void draw() {
		
        surface.pushStyle();

        surface.background(255,255,255);
        l.drawGrid(this, surface);
        l.drawCard(this, surface);
        p.draw(surface, 100, 100);
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
