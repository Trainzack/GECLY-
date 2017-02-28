package edu.cpp.cs.cs141.GECLYfinalproj;

import java.io.File;

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
 * This class represents the interface facilitating communication between the user and the game. This class is
 * abstract because there will be different interfaces for the console and GUI versions.
 *
 * @author Gavin Kremer
 */
public abstract class UserInterface {

	/**
	 * The {@link Engine} that this userInterface should query for gameState.
	 */
	protected Engine engine;
	
	/**
	 * This field represents whether debug mode is on or not.
	 */
	protected boolean isDebugging;

	/**
	 * Represents whetehr player looked on current turn or not
	 */
	protected boolean hasLooked;
	
	/**
	 * Setter for {@link #isDebugging}
	 * @param setting value of {@link #isDebugging}
	 */
	public void setDebugging(boolean setting){
    	this.isDebugging = setting;
	}
	
    /**
     * This method essentially updates the boardstate, which shows the new locations of objects and their
     * visibility.
     */
    public abstract void displayGrid(Direction direction);

	/**
	 * Abstract method that asks the player to look in some direction.
	 */
	public abstract void askLook();
	/**
	 * Abstract method that asks the player to move in some direction.
	 */
    public abstract void askMove();

	/**
	 * Abstract method that shows when the player wins
	 */
	public abstract void showWin();

	/**
	 * Abstract method that shows when the player loses
	 */
	public abstract void showLoss();
	/**
	 * Abstract method that asks the player what to do on their turn
	 */
	public abstract boolean turnMenu();

	/**
	 * Abstract method that shows the players life total
	 */
	public abstract void showLives();

	/**
	 * Abstract method that will display the last event to happen to the player if any.
	 */
	public abstract void showEvent();
	/**
	 * This method is the main loop in the game that makes everything come together.
	 */
	public void gameLoop(){
		while(!engine.checkWin()||!engine.checkLose()) {
			hasLooked = false;
			showLives();
			displayGrid(null);
			turnsLoop();
			showEvent();
			showWin();
			engine.moveNinjas();
			showLoss();
			if(engine.getPlayer().getInvincibilityCount()>0){
				engine.getPlayer().setInvincibilityCount(engine.getPlayer().getInvincibilityCount()-1);
			}
			engine.getPlayer().setLastEvent(null);
			engine.addTurnCount();
		}
	}

	public void turnsLoop() {
		if(!turnMenu()){
			turnsLoop();
		}
		else{
			return;
		}
	}

    /**
     * This method starts the game and is called from the {@link Main} method. It creates the engine, something that should be done the same in all subclasses. Subclasses should call Super() before implementing their methods.
     */
    public void startGame(){
    	engine = new Engine();
    	gameLoop();
    }
    
    /**
     * This method starts the game and is called from the {@link Main} method. It creates the engine, something that should be done the same in all subclasses. Subclasses should call Super() before implementing their methods.
     * Positions of objects in the saved file is loaded into the engine.
     * 
     * @param save of the saved game
     */
    public void startGame(File save){
    	engine = new Engine(save);
    	gameLoop();
    }

    /**
     * This method shows the options menu where players can change the setting of the game.
     */
    public void openOptions(){

    }

    /**
     * This method handles the user quitting the game, and essentially just terminates the program.
     */
    public void quitGame(){

    }
    
    
    
    /**
     * A debugging method that should only be used when the game is being tested.
     * 
     * @return the grid being used
     * @throws IllegalStateException if you try to use this when the game is not in debugging mode.
     */
    public Grid testGetGrid() {
    	if (!isDebugging) {
    		throw new IllegalStateException();//Not sure if this is the right exception
    	}
    	return engine.getBoard();
    }
}
