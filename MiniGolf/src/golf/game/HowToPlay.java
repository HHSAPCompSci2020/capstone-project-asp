package golf.game;

import java.awt.Point;
/**
 * @author Pranav
 */
import java.awt.Rectangle;

import processing.core.PImage;

public class HowToPlay extends Screen {

	private DrawingSurface surface;
	private Rectangle back;
	private PImage backbutton, howtocards,howtocontrol,howtopowerups, howtotiles;
	private PImage controlinstruct, powerupinstruct, tileinstruct, cardinstruct;
	boolean card,control,powerup,tile;
	Rectangle cardbutton, controlsbutton,powerupsbutton, tilesbutton;
	


	
	
	public void setup() {
		backbutton = surface.loadImage("Assets//backbutton.png");
		howtocards = surface.loadImage("Assets//HowtoPlayCards.png");
		howtocontrol = surface.loadImage("Assets//HowToPlayControls.png");
		howtopowerups = surface.loadImage("Assets//HowToPlayPowerUps.png");
		howtotiles = surface.loadImage("Assets//HowToPlayTiles.png");
		
		controlinstruct = surface.loadImage("Assets//controlbutton.png");
		tileinstruct = surface.loadImage("Assets//tilebutton.png");
		powerupinstruct = surface.loadImage("Assets//powerupbutton.png");
		cardinstruct = surface.loadImage("Assets//cardbutton.png");
		howtotiles.resize(700, 700);
		howtopowerups.resize(700, 700);
		howtocards.resize(700, 700);
		howtocontrol.resize(700, 700);
	}
	
	/*
	 * Creates new settings
	 * 
	 * @param what to draw the settings on
	 */
	public HowToPlay(DrawingSurface drawingSurface) {
		super(800, 800);
		surface = drawingSurface;

		back = new Rectangle(0, 0, 100, 100);
		cardbutton = new Rectangle(300,100,200,100);
		controlsbutton = new Rectangle(300,250,200,100);
		powerupsbutton = new Rectangle(300,400,200,100);
		tilesbutton = new Rectangle(300,550,200,100);
		
		
		card = false;
		control = false;
		
		powerup = false;
		tile= false;
		
	}

	/*
	 * draws the settings
	 */
	public void draw() {

		surface.pushStyle();

		surface.background(255, 255, 235);
		if(!card && !powerup && !tile && !control) {
			
			surface.image(cardinstruct, 300, 100);
			surface.image(controlinstruct, 300, 250);
			surface.image(powerupinstruct, 300, 400);
			surface.image(tileinstruct, 300, 550);
			
			
			
			
		
			
			
		}
		
		if(card) {
			surface.image(howtocards, 100, 100);
		}
		if(control) {
			surface.image(howtocontrol, 100, 100);
		}
		if(powerup) {
			surface.image(howtopowerups, 100, 100);
		}
		if(tile) {
			surface.image(howtotiles, 100, 100);
		}
		surface.image(backbutton, 0,0);

		

		
		


		surface.popStyle();
	}

	/*
	 * changes the screen when the back rectangle is clicked
	 */
	public void mousePressed() {
		Point p = surface.actualCoordinatesToAssumed(new Point(surface.mouseX, surface.mouseY));
		if (back.contains(p)) {
			
		
		
		
		if(!card && !powerup && !tile && !control) {
			
			surface.switchScreen(ScreenSwitcher.SCREEN1);
			
		}
		else {
			card = false;
			control = false;
			tile = false;
			powerup = false;
		}
		
		}
		if(cardbutton.contains(p) && !card && !powerup && !tile && !control ) {
			card = true;
			
			
			
		}
       if(controlsbutton.contains(p) && !card && !powerup && !tile && !control) {
    	   control= true;
	 		
		}
       if(tilesbutton.contains(p) && !card && !powerup && !tile && !control) {
    	   tile = true;;
	
      }
      if(powerupsbutton.contains(p) && !card && !powerup && !tile && !control) {
    	  powerup = true;
      }     
	}

	@Override
	public void switchScreen(int i) {
		// TODO Auto-generated method stub
		
	}


	

}
