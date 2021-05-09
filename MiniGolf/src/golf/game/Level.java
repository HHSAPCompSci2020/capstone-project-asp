package golf.game;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
/**
 * 
 * @author Pranav
 *
 */
public class Level {
	
	public char[][] tiles = new  char[20][20];
	public ArrayList<PowerUp> p = new ArrayList<PowerUp>();
	public ArrayList<Card> c = new ArrayList<Card>();
	public ArrayList<PowerUp> pclone = new ArrayList<PowerUp>();
	public ArrayList<Card> cclone = new ArrayList<Card>();
	
	public Level(String grid, String card, String powerup) {
		readData(grid, tiles);
		readData(card, c);
		readData(powerup, p,true);
		
		for(int i =0; i<c.size();i++) {
			
			cclone.add(c.get(i));
			
		}
		for(int i =0; i<p.size();i++) {
			
			pclone.add(p.get(i));
			
		}
		
		
	}
	
	public void reset() {
		
		for(int i =0; i<c.size();i++) {
			
			c.remove(i);
			
		}
		for(int i =0; i<p.size();i++) {
			
			p.remove(i);
			
		}
		for(int i =0; i<cclone.size();i++) {
			
			c.add(cclone.get(i));
			
		}
		for(int i =0; i<pclone.size();i++) {
			
			p.add(pclone.get(i));
			
		}
		
	}
	/**
	 * Adds the stuff in the file to gamedata
	 * @param filename The file to read from
	 * @param gameData the board of characters
	 */
	public void readData (String filename, char[][] gameData) {
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
						for(int i = 0; i < line.length(); i++)
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
	/**Loads in the cards depending on the file
	 * @pre cards must be initialized
	 * @post cards will have cards added to it
	 * @param filename the name of the file which has all of the data needed
	 * @param cards ArrayList of cards which has all the cards for this level
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
						for(int i = 0; i < line.length(); i++) {
							if(line.charAt(i) == '1') {
								cards.add(new Card(1,false,0));
							}
							
							if(line.charAt(i) == '2') {
								cards.add(new Card(2,false,0));
							}
							if(line.charAt(i) == '3') {
								cards.add(new Card(3,false,0));
							}
							
							if(line.charAt(i) == 'A') {
								cards.add(new Card(0,true,2));
							}
							if(line.charAt(i) == 'B') {
								cards.add(new Card(1,true,2));
							}
							if(line.charAt(i) == 'C') {
								cards.add(new Card(2,true,2));
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
	
	/**Loads in the Poweruups depending on the file
	 * @pre powerups must be initialized
	 * @post powerups will have powerups added to it
	 * @param filename the name of the file which has all of the data needed
	 * @param powerups ArrayList of powerups which has all the powerups for this level
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
						for(int i = 0; i < line.length(); i++) {
							
							if(line.charAt(i) == 'A') {
								powerups.add(new PowerUp(1,0,false));
								
							}
							if(line.charAt(i) == 'B') {
								powerups.add(new PowerUp(2,0,false));
								
							}
							if(line.charAt(i) == 'C') {
								powerups.add(new PowerUp(0,1,true));
								
							}
							
							if(line.charAt(i) == 'D') {
								powerups.add(new PowerUp(0,2,true));
								
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
}
