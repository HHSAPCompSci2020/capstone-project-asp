package golf.game;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import processing.core.PApplet;
import processing.core.PConstants;

/**
 * 
 * @author Pranav
 *
 */
/**
 * 
 * 
 *
 */
public class Level {

	public char[][] tiles = new char[20][20];
	public ArrayList<PowerUp> p = new ArrayList<PowerUp>();
	public ArrayList<Card> c = new ArrayList<Card>();
	public ArrayList<PowerUp> pclone = new ArrayList<PowerUp>();
	public ArrayList<Card> cclone = new ArrayList<Card>();

	public Level(String grid, String card, String powerup) {
		readData(grid, tiles);
		readData(card, c);
		readData(powerup, p, true);

		for (int i = 0; i < c.size(); i++) {

			cclone.add(new Card(c.get(i).getMagnitude(), c.get(i).getJMagnitude()));

		}
		for (int i = 0; i < p.size(); i++) {

			pclone.add(new PowerUp(p.get(i).getMagnitude(), p.get(i).getJMagnitude()));

		}

	}
/**
 * sets all of the values in c and p to their original states
 */
	public void reset() {
		
		c.clear();
		p.clear();
//		for (int i = 0; i < c.size(); i++) {
//
//			c.remove(i);
//
//		}
//		for (int i = 0; i < p.size(); i++) {
//
//			p.remove(i);
//
//		}
		for (int i = 0; i < cclone.size(); i++) {

			c.add(new Card(cclone.get(i).getMagnitude(), cclone.get(i).getJMagnitude()));

		}
		for (int i = 0; i < pclone.size(); i++) {

			p.add(new PowerUp(pclone.get(i).getMagnitude(), pclone.get(i).getJMagnitude()));

		}

	}

	/**
	 * Adds the stuff in the file to gamedata
	 * 
	 * @param filename The file to read from
	 * @param gameData the board of characters
	 */
	public void readData(String filename, char[][] gameData) {
		File dataFile = new File(filename);

		if (dataFile.exists()) {
			int count = 0;

			FileReader reader = null;
			Scanner in = null;
			try {
				reader = new FileReader(dataFile);
				in = new Scanner(reader);

				while (in.hasNext()) {
					String line = in.nextLine();
					for (int i = 0; i < line.length(); i++)
						if (count < gameData.length && i < gameData[count].length)
							gameData[count][i] = line.charAt(i);

					count++;
				}

			} catch (IOException ex) {
				throw new IllegalArgumentException("Data file " + filename + " cannot be read.");
			} finally {
				if (in != null)
					in.close();
			}

		} else {
			throw new IllegalArgumentException("Data file " + filename + " does not exist.");
		}
	}

	/**
	 * Loads in the cards depending on the file
	 * 
	 * @pre cards must be initialized
	 * @post cards will have cards added to it
	 * @param filename the name of the file which has all of the data needed
	 * @param cards    ArrayList of cards which has all the cards for this level
	 */
	public void readData(String filename, ArrayList<Card> cards) {
		File dataFile = new File(filename);

		if (dataFile.exists()) {

			FileReader reader = null;
			Scanner in = null;
			try {
				reader = new FileReader(dataFile);
				in = new Scanner(reader);

				while (in.hasNext()) {
					String line = in.nextLine();
					for (int i = 0; i < line.length(); i++) {
						if (line.charAt(i) == '1') {
							cards.add(new Card(1, 0));
						}

						if (line.charAt(i) == '2') {
							cards.add(new Card(2, 0));
						}
						if (line.charAt(i) == '3') {
							cards.add(new Card(3, 0));
						}

						if (line.charAt(i) == 'A') {
							cards.add(new Card(0, 2));
						}
						if (line.charAt(i) == 'B') {
							cards.add(new Card(1, 2));
						}
						if (line.charAt(i) == 'C') {
							cards.add(new Card(2, 2));
						}

					}

				}

			} catch (IOException ex) {
				throw new IllegalArgumentException("Data file " + filename + " cannot be read.");
			} finally {
				if (in != null)
					in.close();
			}

		} else {
			throw new IllegalArgumentException("Data file " + filename + " does not exist.");
		}

	}

	/**
	 * Loads in the Poweruups depending on the file
	 * 
	 * @pre powerups must be initialized
	 * @post powerups will have powerups added to it
	 * @param filename the name of the file which has all of the data needed
	 * @param powerups ArrayList of powerups which has all the powerups for this
	 *                 level
	 */
	public void readData(String filename, ArrayList<PowerUp> powerups, boolean is) {
		File dataFile = new File(filename);

		if (dataFile.exists()) {

			FileReader reader = null;
			Scanner in = null;
			try {
				reader = new FileReader(dataFile);
				in = new Scanner(reader);

				while (in.hasNext()) {
					String line = in.nextLine();
					for (int i = 0; i < line.length(); i++) {

						if (line.charAt(i) == 'A') {
							powerups.add(new PowerUp(1, 0));

						}
						if (line.charAt(i) == 'B') {
							powerups.add(new PowerUp(2, 0));

						}
						if (line.charAt(i) == 'C') {
							powerups.add(new PowerUp(0, 1));

						}

						if (line.charAt(i) == 'D') {
							powerups.add(new PowerUp(0, 2));

						}

					}

				}

			} catch (IOException ex) {
				throw new IllegalArgumentException("Data file " + filename + " cannot be read.");
			} finally {
				if (in != null)
					in.close();
			}

		} else {
			throw new IllegalArgumentException("Data file " + filename + " does not exist.");
		}

	}

	/**
	 * Draws the Grid in tiles
	 * 
	 * @param b board to draw on
	 * @param p surface to draw on
	 */

	public void drawGrid(Board b, PApplet p) {
		
		float width = b.DRAWING_WIDTH;
		float height = b.DRAWING_HEIGHT;

		float startx = width / 22;
		float starty = height / 22;
		float changey = ((3 * height / 4) - (height / 22)) / 20;

		for (int i = 0; i < tiles.length; i++) {
			for (int t = 0; t < tiles[0].length; t++) {
				boolean l = false;
				// ice tile
				if (tiles[i][t] == '-') {
					p.fill(203, 241, 250);
				}
				// wall
				if (tiles[i][t] == '#') {
					p.fill(73, 60, 43);
					p.stroke(0);
				}
				// sandpit
				if (tiles[i][t] == '*') {
					p.fill(255, 228, 196);

				}
				// change dir up
				if (tiles[i][t] == '^') {
					l = true;
					p.pushStyle();
					p.fill(0, 180, 0);
					p.textAlign(PConstants.CENTER);
					p.rect((width / 22) + t * startx, ((3 * height / 4 - height / 22) / 20) * i + starty, width / 22,
							(3 * height / 4 - height / 22) / 20);
					p.textSize(20);
					p.fill(0);
					p.text(tiles[i][t], (width / 22) + t * startx + (width / 22)/2, ((3 * height / 4 - height / 22) / 20) + changey * (i+1));
					
					p.popStyle();

				}
				// change dir right
				if (tiles[i][t] == '>') {
					l = true;
					p.pushStyle();
					p.fill(0, 180, 0);
					p.textAlign(PConstants.CENTER);
					p.rect((width / 22) + t * startx, ((3 * height / 4 - height / 22) / 20) * i + starty, width / 22,
							(3 * height / 4 - height / 22) / 20);
					p.textSize(20);
					p.fill(0);
					p.text(tiles[i][t], (width / 22) + t * startx + (width / 22)/2, ((3 * height / 4 - height / 22) / 20) + changey * (i+1));

					p.popStyle();
				}
				// change dir left
				if (tiles[i][t] == '<') {
					l = true;
					p.pushStyle();
					p.fill(0, 180, 0);
					p.textAlign(PConstants.CENTER);
					p.rect((width / 22) + t * startx, ((3 * height / 4 - height / 22) / 20) * i + starty, width / 22,
							(3 * height / 4 - height / 22) / 20);
					p.textSize(20);
					p.fill(0);
					p.text(tiles[i][t], (width / 22) + t * startx + (width / 22)/2, ((3 * height / 4 - height / 22) / 20) + changey * (i+1));

					p.popStyle();
				}
				// change dir down
				if (tiles[i][t] == 'v') {
					l = true;
					p.pushStyle();
					p.fill(0, 180, 0);
					p.textAlign(PConstants.CENTER);
					p.rect((width / 22) + t * startx, ((3 * height / 4 - height / 22) / 20) * i + starty, width / 22,
							(3 * height / 4 - height / 22) / 20);
					p.textSize(20);
					p.fill(0);
					p.text(tiles[i][t], (width / 22) + t * startx + (width / 22)/2, ((3 * height / 4 - height / 22) / 20) + changey * (i+1));

					p.popStyle();
				}
				// water
				if (tiles[i][t] == '~') {
					p.fill(51, 153, 255);

				}
				// hole
				if (tiles[i][t] == 'X') {
					p.fill(255);

				}
				// uninitialized
				if (tiles[i][t] == '\u0000') {
					p.noFill();
					p.noStroke();
				}
				if (tiles[i][t] == '.') {
					p.fill(0, 180, 0);
				}
				if (tiles[i][t] == 'p') {
					p.fill(0, 180, 0);
				}
				if (l == false) {
					p.rect((width / 22) + t * startx, ((3 * height / 4 - height / 22) / 20) * i + starty, width / 22,
							(3 * height / 4 - height / 22) / 20);

				}

			}
		}

	}
	/**Finds the Player and creates it at the position it is found
	 * 
	 * @return a player at the position where a p is found
	 */

	public Player findPlayer() {
		for (int i = 0; i < tiles.length; i++) {
			for (int p = 0; p < tiles[0].length; p++) {
				if (tiles[i][p] == 'p') {
					return new Player(p, i);
				}
			}
		}
		return null;
	}
}
