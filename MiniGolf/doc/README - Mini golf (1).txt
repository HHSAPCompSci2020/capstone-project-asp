AP Computer Science Final Project - README Template


Card Mini Golf
Authors: Pranav Rawat, Savio Esmailzadeh, Ansel Liu
Revision: 5/13/2021


Introduction: 
Our program is a puzzle game that will require the player to get the golf ball to the hole. 
We are making this game because it sounds fun and doable in the given time frame.
The player will be given cards that they select from, and each hit the ball a different distance in a direction that they choose. Some have special effects on the ball, such as “jumping” or hitting it up and over an adjacent space. The objective is to get the ball to the goal, avoiding obstacles such as walls or water areas without running out of cards. People who like puzzle games that are extremely challenging, or people who are creative and want to make levels of their own. The game will have a menu with multiple levels that the player can unlock and progress through. We are also thinking of adding a level creator so the player can make something interesting of their own.
 
Instructions:
Which keyboard keys will do what? 
Arrow keys will indicate which direction the ball will go towards, with the distance the ball will traverse depending on the card selected.  
The player will need to click a menu with cards that the player will choose from. 
Will you have menus that need to be navigated? What will they look like? 
Level Select- Levels will be locked depending on your progression, and you can access levels that you have done previously
Level Creator- UI undecided (stretch)
Settings- customization (color of golf ball), mute background music 
Credits- Assets used, inspired by Golf Peaks, created by Savio, Pranav and Ansel
Do actions need to be taken in a certain order?
Yes, you first have to select a card by clicking on one, and then pressing an arrow key in order to move in the direction you want.
















Features List (THE ONLY SECTION THAT CANNOT CHANGE LATER):
Must-have Features:
*  Music and sound effects - Different themes for the menu and gameplay, sound effects for reaching the goal, hitting the ball etc. 
*  Level Select Screen and Main menu - It will have a menu screen with a start option and settings (that change resolution, fullscreen toggle etc.) Level select screen where levels will be locked until the previous one is completed. 
*  Multiple levels - For a puzzle game, level design is one of the most important aspects. This game will have around 20 levels, introducing and later combining game mechanics. 
* Power ups (selected from a separate menu) There will be a boost, that increases the distance of the next card used, a trampoline, that puts the ball in a jump state (maintaining its forward momentum) These power ups apply an effect to the cards and change their behavior. 
*  Different kinds of tiles that affect the player (the golf ball) ex. Water hazard (fails the level if landed on), sand pit (stops momentum of the player), ice tile (forces you to move 1 more space), a turn space (changes direction of momentum)


Want-to-have Features:
*  Animations - The ball moves in a fluid motion between spaces, rolls and bounces off walls. 
* Rebounds (physics animations and behavior)-The ball will be able to keep its momentum when it hits a wall, and go the opposite direction.
*  Jump (in a 2d space)-Because the game is hosted in a 2D space where the player is looking above the grid, when the ball ‘jumps’, it will appear bigger as it goes up, because it is ‘approaching’ the camera.
* Customization - In the settings menu, there will be an option to change the color of the ball. More colors will be unlocked as the player progresses in the game. 
* Save progress-Levels unlocked and created will be saved in the game,


Stretch Features:
* Level Creator- The player is able to create their own levels to play with a UI that is undecided.
* Puzzles that require timing (ex. A moving square blocks the ball from the hole) These could be puzzles that involve moving elements that change how the player needs to time their movements.
* Co-op levels (puzzles that require two players to complete) There are switch and door tiles, and players must cooperate in order to open the way forward. The players take turns moving (not both at the same time) and momentum can be transferred if they come into contact, allowing for puzzles that have the players bump into each other to reposition. 






Class List:
ScreenSwitcher
Changes the current screen.
Player
Can place itself on the board and has a method to move itself around the grid and a method that draws itself on a PApplet. It also does the calculations that determine the behavior of the ball based on tiles and power ups. 
Board
Contains a level and a menu for cards. Draws the UI and the grid. Detects when a card is selected and moves the player through method calls. 
Music
Plays Music and sound effects(?). 
LevelSelect
Allows you to choose which level you want to play
Settings
Allows you mute the game music and change your balls color and allows you to view the credits
Credits
Displays the credits in text form, including the authors, inspiration and the sources used. 
Level 
This class works for all levels, which are loaded from text files. It constructs the array for the level and places the appropriate characters for the tiles. It also keeps track of the available cards (with an arraylist) for each given level. 


LevelCreationUI //Least Priority (Stretch)
Menu
First screen shown when opened. Contains buttons to take you to settings, and level select.
MiniGolfMain
Runs the program.
PowerUp
Contains a list of methods that modify the behavior of the ball, called through Player which executes the change. 
Card
Contains fields that gives the distance to move the ball and whether it lifts the ball up or not (“jump”)


Credits:
[Gives credit for project components. This includes both internal credit (your group members) and external credit (other people, websites, libraries). To do this:
* List the group members and describe how each member contributed to the completion of the final program. This could be classes written, art assets created, leadership/organizational skills exercises, or other tasks. Initially, this is how you plan on splitting the work.
* Give credit to all outside resources used. This includes downloaded images or sounds, external java libraries, parent/tutor/student coding help, etc.]


Inspired by Golf Peaks
Uses the Processing Library and JSound Library
Uses code from parts of the Processing screen switching demo(Shelby) as well as code from Recursion 2D Arrays(previous lab)
Savio: Player, Menu, Card
Pranav: Board, Level, Powerup
Ansel: Music, Level Select, Settings






Work Distribution:


Hardest: Board, LevelMaker, LevelSelect


Medium: Player, Main, Music, Settings, level


Easy: Tile, PowerUp, Card, Credits


//THIS IS VERY INACCURATE
Ansel: LevelSelect, Menu, Settings, Assets(pictures)


Pranav: Board, Level, Credits,  PowerUp, LevelMaker(stretch)?


Savio: Player, Card, Main, Music, LevelMaker(stretch[a])? 


//ACTUAL CODE + PSEUDOCODE BEFORE CODING
public move(Card c, level l, PowerUp p , int dir){
if(p != null){
p.affect(c);
}
//power ups


//jump
for(i = 0; i< jmomentum; i++){
//move in the specified direction
//check current tile
//change behavior accordingly
//ex. If current tile is a wall, don’t do anything
}
//move
for(i = 0; i<momentum; i++){
//move in the specified direction
//check current tile
//change behavior accordingly
//ex. If current tile is a wall, change direction
}




// IN LEVELSELECT
Rectangle level1;
Int levelSelected
public void mousePressed() {
                Point p = surface.actualCoordinatesToAssumed(new Point(surface.mouseX,surface.mouseY));
                if (button.contains(p))
                        //Essentially, takes the number of the level
                        levelSelected = string parsed;
                        screenSwitch(7);
        }


//IN DRAWINGSURFACE
public void switchScreen(int i) {
        if(int i ==7){
        Level l = new Level(“level\\level””+levelSelected+”\\level”+levelSelected+”board” );
        
        Board  game= new Board(l);
screens.remove(whatever is board rn)
        screens.add(game);




activeScreen = screens.get(i);
}
                activeScreen = screens.get(i);
        }




//LEVEL PACKAGE
        //LEVEL 1
                //LEVEL1 BOARD
                //LEVEL 1 CARDS
                //LEVEL 1 POWERUPS
[a]Positive: I really like how you guys plan things out based on difficulties