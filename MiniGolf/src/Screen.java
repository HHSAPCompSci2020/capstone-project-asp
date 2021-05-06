
public abstract class Screen implements ScreenSwitcher{

    public final int DRAWING_WIDTH, DRAWING_HEIGHT;
    
    /*
     * Creates a new screen with given parameters
     * @param the width of the screen
     * @param the height of the screen
     */
    public Screen(int width, int height) {
        this.DRAWING_WIDTH = width;
        this.DRAWING_HEIGHT = height;
    }

    /*
     * Sets up the screen
     */
    public void setup() {

    }

    /*
     * Draws the screen
     */
    public void draw() {

    }

    /*
     * Checks when the mouse is pressed
     */
    public void mousePressed() {

    }

    /*
     * Checks when the mouse is moved
     */
    public void mouseMoved() {

    }

    /*
     * Checks when the mouse is dragged
     */
    public void mouseDragged() {

    }

    /*
     * Checks when the mouse is release
     */
    public void mouseReleased() {
    	
    }



}
