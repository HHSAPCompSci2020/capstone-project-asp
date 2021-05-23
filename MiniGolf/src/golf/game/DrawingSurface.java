package golf.game;
import java.awt.Point;
import java.util.ArrayList;

import processing.core.PApplet;
/**
 * 
 * @author Shelby
 *
 */

public class DrawingSurface extends PApplet implements ScreenSwitcher {

    public float ratioX, ratioY;

    private ArrayList<Integer> keys;

    public Screen activeScreen;
    public ArrayList<Screen> screens;

    /**
     * Creates a new Drawing surface and adds all the screens
     */
    public DrawingSurface() {


        screens = new ArrayList<Screen>();

        keys = new ArrayList<Integer>();


        Menu screen1 = new Menu(this);
        screens.add(screen1);

        Settings screen2 = new Settings(this);
        screens.add(screen2);
        
        LevelSelect screen3 = new LevelSelect(this);
        screens.add(screen3);
        
        Board screen4 = new Board(this , 1, null);
        screens.add(screen4);
        
        Credits screen5 = new Credits(this);
        screens.add(screen5);
        
        HowToPlay screen6 = new HowToPlay(this);
        screens.add(screen6);

        activeScreen = screens.get(0);

    }


    public void settings() {
        // size(DRAWING_WIDTH, DRAWING_HEIGHT, P2D);
        size(activeScreen.DRAWING_WIDTH, activeScreen.DRAWING_HEIGHT);
    }

    public void setup() {
        surface.setResizable(true);
        for (Screen s : screens)
            s.setup();
    }

    public void draw() {
        ratioX = (float)width/activeScreen.DRAWING_WIDTH;
        ratioY = (float)height/activeScreen.DRAWING_HEIGHT;

        pushMatrix();

        scale(ratioX, ratioY);

        activeScreen.draw();

        popMatrix();
    }

    /**
     * when a key is pressed add the key to the keys ArrayList
     */
    public void keyPressed() {
        keys.add(keyCode);
    }

    /**
     * when a key is released remove this key from the ArrayList
     */
    public void keyReleased() {
        while(keys.contains(keyCode))
        	keys.remove(new Integer(keyCode));
    }

    /**
     * Checks if a the key ArrayList contains a specific key
     * @param code The key to check if it is contained in the ArrayList
     * @return boolean true if the key is in the ArrayList
     */
    public boolean isPressed(Integer code) {
        return keys.contains(code);
    }

    /**
     * Calls the mousePressedMethod on the current screen
     */
    public void mousePressed() {
        activeScreen.mousePressed();
    }

    /**
     * calls the mouseMoved method on the current screen
     */
    public void mouseMoved() {
        activeScreen.mouseMoved();
    }

    /**
     * calls the mouseDragged method on the current screen
     */
    public void mouseDragged() {
        activeScreen.mouseDragged();
    }

    /**
     * calls the mouseReleased method on the current screen
     */
    public void mouseReleased() {
        activeScreen.mouseReleased();
    }

 
    public Point assumedCoordinatesToActual(Point assumed) {
        return new Point((int)(assumed.getX()/ratioX), (int)(assumed.getY()/ratioY));
    }

    public Point actualCoordinatesToAssumed(Point actual) {
        return new Point((int)(actual.getX()/ratioX) , (int)(actual.getY()/ratioY));
    }

    @Override
    public void switchScreen(int i) {
    
        activeScreen = screens.get(i);
    }

}
