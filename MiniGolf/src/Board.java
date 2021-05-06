
public class Board extends Screen{
	
	private Player p;
	private Level l;
	private boolean isMoving;
	private DrawingSurface surface;
	
	public Board(DrawingSurface drawingSurface) {
		super(800, 800);
		surface = drawingSurface;
		
	}

	@Override
	public void switchScreen(int i) {
		// TODO Auto-generated method stub
		
	}
	
}
