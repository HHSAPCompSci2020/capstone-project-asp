package golf.game;
import java.awt.Dimension;

import javax.swing.JFrame;

import processing.awt.PSurfaceAWT;
import processing.core.PApplet;
/**
 * 
 * @author Shelby
 *
 */

public class Main {

	/**
	 * Creates a window
	 */
    public static void main(String args[]) {

        DrawingSurface drawing = new DrawingSurface();
        PApplet.runSketch(new String[]{""}, drawing);
        PSurfaceAWT surf = (PSurfaceAWT) drawing.getSurface();
        PSurfaceAWT.SmoothCanvas canvas = (PSurfaceAWT.SmoothCanvas) surf.getNative();
        JFrame window = (JFrame)canvas.getFrame();

        Music m = new Music();
        m.actionPerformed(null);
        
        window.setTitle("Mini Golf");
        window.setSize(800, 600);
        window.setMinimumSize(new Dimension(100,100));
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setResizable(true);

        window.setVisible(true);


        canvas.requestFocus();
    }

}