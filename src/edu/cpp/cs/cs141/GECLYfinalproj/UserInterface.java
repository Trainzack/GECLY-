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
     * This method essentially updates the boardstate, which shows the new locations of objects and their
     * visibility.
     */
    public void updateBoardState(){

    }

    /**
     * This method starts the game and is called from the {@link Main} method. It creates the engine, something that should be done the same in all subclasses. Subclasses should call Super() before implementing their methods.
     */
    public void startGame(){
    	engine = new Engine();
    }
    
    /**
     * This method starts the game and is called from the {@link Main} method. It creates the engine, something that should be done the same in all subclasses. Subclasses should call Super() before implementing their methods.
     */
    public void startGame(File save){
    	engine = new Engine(save);
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
}
