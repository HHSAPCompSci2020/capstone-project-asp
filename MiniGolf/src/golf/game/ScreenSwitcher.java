package golf.game;
/**
 * 
 * @author Savio (changed from Shelby's demo)
 *
 */
public interface ScreenSwitcher {
    public static final int SCREEN1 = 0;
    public static final int SCREEN2 = 1;
    public static final int SCREEN3 = 2;
    public static final int SCREEN4 = 3;
    public static final int SCREEN5 = 4;
    public static final int SCREEN6 = 5;

    public void switchScreen(int i);
}
