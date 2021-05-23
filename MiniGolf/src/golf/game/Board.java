package golf.game;

import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;

import processing.core.PImage;

/**
 * 
 * @author Pranav
 *
 */

public class Board extends Screen {
	private Level l;
	private Card cardSelected;
	private PowerUp powerupSelected;
	private boolean isMoving;
	private DrawingSurface surface;
	private Rectangle next;
	private Rectangle back;
	private ArrayList<Rectangle2D.Float> cardMenu = new ArrayList<Rectangle2D.Float>();
	private Player p;
	private int level;
	private ArrayList<Rectangle2D.Float> powerUpMenu = new ArrayList<Rectangle2D.Float>();
	private PImage nextbutton;
	private PImage backbutton;
	private boolean[] cleared;
	private ArrayList<PImage> cards = new ArrayList<PImage>();
	private ArrayList<PImage> powerups = new ArrayList<PImage>();
	private ArrayList<PImage> playerImages = new ArrayList<PImage>();
	private int cardSelectedIndex;
	private int powerupIndex;


	/**
	 * Creates a new Board Screen
	 * 
	 * @param a drawing surface on which to draw on
	 */
	public Board(DrawingSurface s) {

		super(800, 800);
		surface = s;

	}

	public Board(DrawingSurface drawingSurface, int thislevel, boolean[] cleared) {
		super(800, 800);
		Level l = new Level("Levels//Level" + thislevel + "//Level" + thislevel + "board.txt",
				"Levels//Level" + thislevel + "//Level" + thislevel + "cards.txt",
				"Levels//Level" + thislevel + "//Level" + thislevel + "powerups.txt");
		surface = drawingSurface;
		//surface.setup();
		this.level = thislevel;
		this.l = l;
		next = new Rectangle(715, 715, 85, 85);
		back = new Rectangle(0, 715, 85, 85);
		p = l.findPlayer();

		isMoving = false;

		instantiateCards();
		instantiatePowerUps();
		this.cleared = cleared;
		System.out.println(cardMenu.size());

		System.out.println(cardMenu.get(0).getCenterX());
	}
	public void setup() {
	nextbutton = 	surface.loadImage("Assets//nextbutton.png");
	backbutton = surface.loadImage("Assets//backbutton.png");
	for(int i = 0; i<l.c.size(); i++) {
		cards.add(surface.loadImage("Assets//M"+l.c.get(i).getMagnitude()+"J"+l.c.get(i).getJMagnitude()+".png"));
	}
	
	for(int i = 0; i< l.p.size(); i++) {
		powerups.add(surface.loadImage("Assets//powerupm"+l.p.get(i).getMagnitude()+"j"+l.p.get(i).getJMagnitude()+".png"));
		
	}
	playerImages.add(surface.loadImage("Assets//ballBLACK.png"));
	playerImages.add(surface.loadImage("Assets//ballBLUE.png"));
	playerImages.add(surface.loadImage("Assets//ballGREEN.png"));
	playerImages.add(surface.loadImage("Assets//ballRED.png"));
	playerImages.add(surface.loadImage("Assets//ballSWAG.png"));
	playerImages.add(surface.loadImage("Assets//ballWHITE.png"));
	playerImages.add(surface.loadImage("Assets//ballYELLOW.png"));
	}

	private void instantiatePowerUps() {
		if (l.p.size() > 0) {
			powerUpMenu.clear();
			float startx = DRAWING_WIDTH / 5;
			float starty = DRAWING_HEIGHT * 9 / 10;

			float change = (DRAWING_WIDTH - DRAWING_WIDTH /5) / l.p.size();

			for (int i = 0; i < l.p.size(); i++) {

				this.powerUpMenu.add(new Rectangle2D.Float(change * i + startx, starty, 30, 30)); 
			
			}
		}
		
	}

	private void instantiateCards() {
		if (l.c.size() > 0) {
		cardMenu.clear();
		float startx = DRAWING_WIDTH / 22;
		float starty = DRAWING_HEIGHT * 4 / 5;

		float change = (DRAWING_WIDTH - DRAWING_WIDTH / 22) / l.c.size();

		for (int i = 0; i < l.c.size(); i++) {

			this.cardMenu.add(new Rectangle2D.Float(change * i + startx, starty, 50, 70));
		}
		}

	}

	public void draw() {

		surface.pushStyle();

		surface.background(209, 214, 215);
		surface.fill(255, 0, 0);
		l.drawGrid(this, surface);
	
		isMoving = p.draw(surface, this.DRAWING_WIDTH, this.DRAWING_HEIGHT, isMoving, playerImages.get(p.getColor()));
		
		surface.noFill();
		surface.rect(next.x, next.y, next.width, next.height, 10, 10, 10, 10);
		surface.rect(back.x, back.y, back.width, back.height);

		surface.fill(0);
		String str = "Next";
		float w = surface.textWidth(str);
		surface.text(str, next.x + next.width / 2 - w / 2, next.y + next.height / 2);
		str = "Back";
		w = surface.textWidth(str);
		surface.text(str, back.x + back.width / 2 - w / 2, back.y + back.height / 2);

	//	surface.fill(0, 255, 0);
		surface.image(nextbutton, 715, 715);
		surface.image(backbutton, 0, 715);
		surface.fill(255,255,255);
		
		if(l.c.size()>0) {

			float startx = DRAWING_WIDTH / 22;
			float starty = DRAWING_HEIGHT * 4 / 5;

			float change = (DRAWING_WIDTH - DRAWING_WIDTH / 22) / l.c.size();

			for (int i = 0; i < l.c.size(); i++) {
				surface.noFill();
				if (l.c.get(i).equals(cardSelected)) {
					surface.fill(0, 255, 0);
				} 
				surface.rect(change * i + startx-5, starty-5, 60, 80);
				
				cards.get(i).resize(49, 69);
				surface.image(cards.get(i), change * i + startx, starty);
				
			}
		}
		if(l.p.size()>0) {
			
			
			float startx = DRAWING_WIDTH / 5;
			float starty = DRAWING_HEIGHT * 9 / 10;

			float change = (this.DRAWING_WIDTH - this.DRAWING_WIDTH / 5) / l.p.size();

			for (int i = 0; i < l.p.size(); i++) {
				
				surface.noFill();
				if (l.p.get(i).equals(powerupSelected)) {
					surface.fill(0, 255, 0);
				} 
				surface.rect(change * i + startx-5, starty-5, 40, 40);
				
				powerups.get(i).resize( 30, 30);
				surface.image(powerups.get(i), change*i+startx,starty);
				
				
			}
			
			
			
			
			
		}
		
		if (cardSelected != null && !isMoving) {
			

			if (surface.isPressed(KeyEvent.VK_A)) {
				p.move(cardSelected, l, powerupSelected, 4);
				l.p.remove(powerupSelected);
				l.c.remove(cardSelected);
				cards.remove(cardSelectedIndex);
				if (powerupSelected != null)
				powerups.remove(powerupIndex);
				cardSelected = null;
				powerupSelected = null;
				this.instantiateCards();
				this.instantiatePowerUps();
			}
			if (surface.isPressed(KeyEvent.VK_D)) {
				p.move(cardSelected, l, powerupSelected, 3);
				l.p.remove(powerupSelected);
				System.out.println("this");
				l.c.remove(cardSelected);
				cards.remove(cardSelectedIndex);
				if (powerupSelected != null)
					powerups.remove(powerupIndex);
				cardSelected = null;

				powerupSelected = null;
				this.instantiateCards();
				this.instantiatePowerUps();
			}

			if (surface.isPressed(KeyEvent.VK_W)) {
				p.move(cardSelected, l, powerupSelected, 1);
				l.p.remove(powerupSelected);
				l.c.remove(cardSelected);
				cards.remove(cardSelectedIndex);
				if (powerupSelected != null)
					powerups.remove(powerupIndex);
				cardSelected = null;
				powerupSelected = null;
				this.instantiateCards();
				this.instantiatePowerUps();

			}
			if (surface.isPressed(KeyEvent.VK_S)) {
				p.move(cardSelected, l, powerupSelected, 2);
				l.c.remove(cardSelected);
				l.p.remove(powerupSelected);
				cards.remove(cardSelectedIndex);
				if (powerupSelected != null)
					powerups.remove(powerupIndex);
				cardSelected = null;
				powerupSelected = null;
				this.instantiateCards();
				this.instantiatePowerUps();
			}

		}

		if (p.isCleared()) {

			cleared[level] = true;
		}
		if (!p.isCleared() && l.c.size() == 0) {
			l.reset();
			this.instantiateCards();
			this.instantiatePowerUps();
			p.reset();
			surface.setup();
			
		}
		surface.popStyle();

	}

	public void mousePressed() {
		Point p = surface.actualCoordinatesToAssumed(new Point(surface.mouseX, surface.mouseY));
		if (next.contains(p) && this.p.isCleared() && !isMoving) {
			this.switchScreen(3);
		}
		if (back.contains(p)) {
			this.switchScreen(2);
		}

		for (int i = 0; i < l.c.size(); i++) {

			if (cardMenu.get(i).contains(p)) {
				cardSelected = l.c.get(i);
				cardSelectedIndex = i;
				System.out.println("hit");
				if (cardSelected == null) {
					System.out.println("?");
				}

			}

		}
		for (int i = 0; i < l.p.size(); i++) {

			if (powerUpMenu.get(i).contains(p)) {
				powerupSelected = l.p.get(i);
				powerupIndex = i;
				System.out.println("powerup selected");

			}

		}
	}

	@Override
	/**
	 * goes to the next level
	 */
	public void switchScreen(int i) {
		if (i == 3) {
			//m.actionPerformed(new ActionEvent(null, 1, "level"));
			Board b = new Board(surface, level + 1, cleared);
			surface.screens.add(3, b);
			surface.activeScreen = surface.screens.get(i);
			surface.setup();
			surface.screens.remove(4);	
		} else {
			surface.activeScreen = surface.screens.get(i);
		}

	}

}
