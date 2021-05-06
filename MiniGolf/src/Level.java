import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Level {

	public char[][] tiles;
	public ArrayList<PowerUp> p;
	public ArrayList<Card> c;
	
	public Level() {
		
	}
	
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
