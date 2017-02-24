package edu.cpp.cs.cs141.GECLYfinalproj;

import java.io.File;
import java.io.OutputStreamWriter;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * CS 141: Intro to Programming and Problem Solving
 * Professor: Edwin Rodríguez
 *
 * Programming Final Project
 *
 * Ninja-Assassin Game
 *
 * Team GECLY Info:
 * Gavin Kremer
 * Eli Zupke
 * Clara Nguyen
 * Lucas Frias
 * Yan Huang (Lilli)
 *
 */

/**
 * This class represents the console based interface which will involve console elements like the Scanner and System.out.
 *
 * @author Gavin Kremer, Eli Zupke
 */
/**
 * @author eli
 *
 */
public class ConsoleInterface extends UserInterface{

    /**
     * This field represents the Scanner that the user will use to interact with the UI.
     */
    private Scanner userInput;
    
    /**
     * The PrintWriter that will be used for output (works the same as System.out). Note that we will need to make considerations for Unicode support by using an OutputStreamWriter with the right encoding as a first argument. If that doesn't work at runtime, we can default to ASCII by setting {@link #unicodeEnabled}.
     */
    private PrintStream systemOutput;
    
    /**
     * Whether or not output should use Unicode, as opposed to plain, ASCII characters.
     */
    private boolean unicodeEnabled;





	/**
     * Initializes this object's {@link #userInput}, {@link #systemOutput}, and whether {@link #unicodeEnabled}.
     */
    public ConsoleInterface() {
    	
    	userInput = new Scanner(System.in);
    	unicodeEnabled = true; //Debug value.
    	initializeSystemOutput();

    		
    }
    
    /**
     * This is a helper method for this class's constructor.
     * The default PrintStream System.out does not always support Unicode by default (particularly on Windows). 
     * If we don't need unicode, then this is fine and we can rely on System.out.
     * Otherwise, we attempt to enable a new OutputStreamWriter with the proper encoding.
     * TODO: Make sure that this work is actually necessary in some cases.
     **/
    private void initializeSystemOutput() {

    	systemOutput = System.out;
    	
    	if (unicodeEnabled) {
    		try {
				OutputStreamWriter writer = new OutputStreamWriter(System.out, "UTF-16");
				systemOutput = new PrintStream(systemOutput);
			} catch (UnsupportedEncodingException e) {
				//If we add some kind of log file or error warning, this spot needs a warning, that Unicode could not be enabled.
				unicodeEnabled = false;
			}
    	}
    }

    /* (non-Javadoc)
     * @see edu.cpp.cs.cs141.GECLYfinalproj.UserInterface#updateBoardState()
     */
    public void updateBoardState(){
    	
    }



    /**
     * This method will print a method in the console.
     */
    public void showMessage(String message){
    	systemOutput.println(message);
    }

    /**
	 * Creates a menu based off of an array of strings, and returns the array index of the string stat was selected.
	 * 
	 * @param choices the options that will be given to the player
	 * //@param query the text to prompt the player with
	 * @return the array index of the choice that was selected
	 */
	public int displayMenu(String[] choices) {
		
		for (int i = 0; i < choices.length; i++) {
			showMessage((i+1) + ". " + choices[i]);
		}
		
		return getInt(1,choices.length)-1;
	}
	
	/**
	 * Displays a yes/no choice to the player, and returns the result as a boolean.
	 * 
	 * @return true if 'yes', false if 'no'
	 */
	public boolean displayMenu() {
		String[] choices = {"Yes", "No"};
		return (displayMenu(choices) == 0);
	}
	
	/**
	 * Waits for the user to enter a valid number that is inside the specified range, then returns the result. Used for letting the player select menu choices.
	 * 
	 * @param min the smallest number that will be accepted
	 * @param max the largest number that will be accepted
	 * @return the int that the player selected
	 */
	private int getInt(int min, int max) {
		
		while (true) { //This loop will ensure the only way out of this method is for a valid option to be selected.
			try {
				int output = userInput.nextInt();
				if (output < min || output > max) {
					//This catches cases where the user inputs a number, but it is not within the allowed range.
					showMessage("Invalid number. Please enter a number from " + min + " to " + max + ".\n");
				} else {
					return output;
				}
			} catch (InputMismatchException e)  {
				//This catches cases where the user did not actually enter a number at all.
				showMessage("Invalid number. Please enter a valid number.\n");
				userInput.next(); //This line is required for the method to function, and I don't know why.
			}
		}
		
	}

	/**
	 * This method displays the game board in the console. It will display the actual locations of all items or the visible state of the game
	 * based on whether debugging mode is on or not. Currently you must manually define the direction player is looking on line 183, but that
	 * will change once the actual game loop is implemented.
	 * 
	 * @param direction that the user wishes to look in
	 */
	public void displayGrid(Direction direction){
		Grid tempboard = this.engine.getBoard();
		
		boolean[][] visibility = engine.getVisibilityArray(direction,isDebugging);
		
		for (int i = 0;i<9;++i){
			for (int l = 0; l<9;++l){
				
				Locatable spotObject = tempboard.getObject(i, l);
				
				if(!visibility[i][l]){
					systemOutput.print(getObjectRep());
				}
				else{
					if((spotObject instanceof Room && ((Room) spotObject).getContents() instanceof Briefcase) && ((engine.getPlayer().hasRadar())||isDebugging)){
						systemOutput.print(getObjectRep(((Room) spotObject).getContents()));
						continue;
					}
					else if((spotObject instanceof Room && ((Room) spotObject).getContents() != null)&&isDebugging){
						systemOutput.print(getObjectRep(((Room) spotObject).getContents()));
						continue;
					}
					systemOutput.print(getObjectRep(spotObject));
				}
			}
			showMessage("");
		}
	}
	
	/**
	 * Decides what one square should look like, based on the contents of the {@link Grid} at this position. 
	 * 
	 * @param l The locatable to get the representation of 
	 * @return A string representing the entire square the object resides in
	 */
	private String getObjectRep(Locatable l) {
		
		char rep; //This stores what the inner part of the square should look like
		
		if (l == null) {	//This square is empty
			rep = ' ';
		} else {			//This square has something in it
			
			if(unicodeEnabled){
				rep = l.getUnicodeDisplayCharacter(true);
			}
			else{
				rep = l.getASCIIDisplayCharacter(true);
			}
		}

		return "[ " + rep + " ]";
	}
	
	/**
	 * Decides what one square should look like, under the assumption that the square cnnot be seen.
	 * 
	 * @return A string representing a blank square
	 */
	private String getObjectRep() {
		if(unicodeEnabled){
			return "[ ■ ]";
		}
		else{
			return "[ * ]";
		}
	}

	/* (non-Javadoc)
	 * @see edu.cpp.cs.cs141.GECLYfinalproj.UserInterface#startGame()
	 */
	@Override
	public void startGame() {
		showMessage("Welcome to the best game ever!\n\nMenu");
		String[] menu = {"Start Game", "Load Game", "Help", "Credits", "Exit"};
		int choice = displayMenu(menu);
		switch(choice){
			case 0: displayHelp();
					super.startGame();
					break;
			case 1: super.startGame(askFileName());
					break;
			case 2: displayHelp();
					startGame();
					break;
			case 3: displayCredits();
					startGame();
					break;
			case 4: showMessage("Bye!");
					System.exit(0);
		}
		
	}

	/* (non-Javadoc)
	 * @see edu.cpp.cs.cs141.GECLYfinalproj.UserInterface#openOptions()
	 */
	@Override
	public void openOptions() {
		showMessage("\nOPTIONS");
		String[] options = {"Debug Game", "Change Difficulty", "Help", "Exit Options", "Quit Game"};
		int choice = displayMenu(options);
		switch(choice) {
			case 0: showMessage("Debug Mode");
					String[] debugChoice = {"ON", "OFF"};
					int debugNum = displayMenu(debugChoice);
					if(debugNum == 0){
						setDebugging(true);
					}else{
						setDebugging(false);
					}
					showLives();
					displayGrid(null);
					break;
			case 1: //TODO: make a thing to change difficulty
					break;
			case 2: displayHelp();
					break;
			case 3: displayGrid(null);
					break;
            case 4: quitGame();

		}
		
	}

	/* (non-Javadoc)
	 * @see edu.cpp.cs.cs141.GECLYfinalproj.UserInterface#quitGame()
	 */
	@Override
	public void quitGame() {
		showMessage("Do you want to save the game?");
		boolean choice = displayMenu();
		if(choice == true){
			//TODO implement saving
			showMessage("File saved to: " + "\nBye.");
			System.exit(0);
		}else{
			showMessage("You did not save. Bye.");
			System.exit(0);
			
		}
	}
	
	/**
	 * Displays the game synopsis and includes game instructions. 
	 */
	public void displayHelp() {
		showMessage("\nYou are a spy in a pitch black building on a mission to save the world from Evil Incorporated.");
		showMessage("Dr. Doofenshmirtz has stolen a classified briefcase with super secret stuff in it.");
		showMessage("Your mission, should you choose to accept it, is to retrieve the breiefcase from Dr. D.");
		showMessage("BUT! Dr. D's evil robot ninjas will be in your way! You only have a harpoon gun with 1 harpoon and a flashlight.");
		showMessage("Good Luck, Agent P!");
		showMessage("\nThe powerups in the game are:");
        //showMessage("Camo - ✿  or C - Allows the player to be hidden from the ninja for a certain amount of turns.");
        showMessage("Extra Bullet - ➡  or E - Gives the player one more bullet for their gun.");
        showMessage("Invincibility - ⚡  or I - Allows the player to be invincible from the ninjas for 5 turns.");
        //showMessage("NighVision - ☪  or V - Enhances the player's line of vision and allow them to see more than the usual 2 blocks ahead.");
        showMessage("Radar - ⚨  or R - Allows the player to see where the briefcase is.\n");
	}
	
	/**
	 * Displays the credits of the game.
	 */
	public void displayCredits() {
		//TODO: add credits yo
		showMessage("Credits: \nGavin Kremer \nEli Zupke \nClara Nguyen \nLucas Frias \nYan (Lilli) Huang\n");
		
	}
	
	/**
	 * Asks user for a file to load a previously saved game.
	 * 
	 * @return A file to load the game.
	 */
	public File askFileName() {
		showMessage("Please enter the name of the saved file.");
		String filename;
		File save;
		do{
			filename = userInput.nextLine();
			save = new File(filename);
		}while(!save.exists());
		return save;
	}
	
	/**
	 * Asks user for a direction to either look, move, or shoot.
	 * 
	 * @param action will either be look, move, or shoot.
	 */
	public void askDirection(String action) {
		showMessage("Which direction do you want to " + action + "?");
	}
	
	/**
	 * Displays congratulatory message after a win is checked in Engine.
	 */
	public void showWin() {
		if(engine.checkWin()){
		showMessage("You win! You foiled the plans of Dr. Doofenshmirtz.");
		System.exit(0);
		}
	}
	
	/**
	 * Displays losing message after a loss is checked in Engine.
	 */
	public void showLoss() {
		if(engine.checkLose()){
		showMessage("You lost! Dr. Doofenshmirtz will now take over the world.");
		System.exit(0);
		}
	}
	

	
	/**
	 * Prompts the player to choose a direction to look ahead and displays an updated game board for the spaces chosen to see.
	 */
	public void askLook() {
		askDirection("look");
		String[] choices = new String[4];
		Direction[] directions = Direction.values();
		for (int i = 0; i < directions.length; i++) {
			choices[i] = directions[i].toString();
		}
		int direction = displayMenu(choices);
		showLives();
  	displayGrid(directions[direction]);
		hasLooked = true;
	}
	
	/**
	 * Prompts the player to choose a direction to move.
	 */
	public void askMove() {
		askDirection("move");
		String[] choices = new String[4];
		Direction[] directions = Direction.values();
		for (int i = 0; i < directions.length; i++) {
			choices[i] = directions[i].toString();
		}
		int direction = displayMenu(choices);
		if(!engine.getPlayer().move(directions[direction])){
			System.out.println("You cannot move there! Go somewhere else!");
			askMove();
		}
	}
	
	public void askShoot() {
		if(engine.getPlayer().getAmmo() == 0) {
			showMessage("You can not shoot. You have no harpoons.");
			return;
		}
		else{
			askDirection("shoot");
			String[] choices = {"Left", "Up", "Right", "Down"};
			int direction = displayMenu(choices);
				
			if(engine.getPlayer().shoot(direction)){
			    showMessage("You shot a robot ninja!");
            }
            else{
			    showMessage("You didn't hit anything!");
            }
			showMessage("\nYou have no harpoons left.");
			showLives();
			displayGrid(null);
		}
	}
	
	public boolean turnMenu() {
		showMessage("What would you like to do?\tThings you got:");
		String briefcase;
		if(engine.getPlayer().hasCase()) {
			briefcase = "Yes";
		}
		else {
			briefcase = "No";
		}
		int ammo = engine.getPlayer().getAmmo();
		int invincibility = engine.getPlayer().getInvincibilityCount();
		String radar;
		if(engine.getPlayer().hasRadar()) {
			radar = "Yes";
		}
		else {
			radar = "No";
		}
		String[] options = {"Look\t\t\t\tBriefcase: " + briefcase, "Move\t\t\t\tAmmo: " + ammo, 
				"Shoot\t\t\tInvincibility Count: " + invincibility, "Game Options\t\t\tRadar: " + radar};
		int choice = displayMenu(options);
		switch(choice) {
			case 0: if(!hasLooked){
						askLook();
					}
					else{
					showMessage("You already looked this turn!");
					}
					return false;
			case 1: askMove();
					return true;
			case 2: askShoot();
					return false;
			case 3: openOptions();
					return false;
		} return false;
	}
	
	public void showLives() {
		showMessage("\nLives: " + engine.getPlayer().getLives());
	}



}