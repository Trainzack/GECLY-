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
public class Engine {
	
	/**
	 * A reference to the player object that the player is controlling. 
	 */
	private Player player;
	
	/**
	 * A reference to the {@link Grid} that gameplay takes place on, instantiated by {@link #setupGrid()} or {@link Engine#loadGame()}. 
	 */
	private Grid grid;
	
	/**
	 * The number of turns that have taken place since play has started.
	 */
	private int turnCount;
	
	
	/**
	 * Creates a new instance of the engine for a new game.
	 */
	public Engine() {
		
	}
	
	/**
	 * Creates a new instance of the engine from a save file.
	 * 
	 * @param save the save file to load from
	 */
	public Engine(File save) {
		
	}
	
	
	/**
	 * Makes and returns an array of booleans, each representing whether that square is visible to the player. Used by a {@link UserInterface} to figure out what to display to the player.
	 * 
	 * It makes the array by asking the {@link #player} what squares it can see (probably by checking the player's powerups) and by calling the grid's getPosition method on the object to construct the array.
	 * 
	 * This array will then be used by the UI to construct a representation of the game state.
	 * 
	 * @param direction The direction the player is looking, represented as a byte. 0 = up, 1 = right, 2 = down, and 3 = left.
	 * 
	 * @return an array of booleans, with true meaning that square is visible to the player and false meaning that that square is not visible to the player.
	 */
	public boolean[][] getVisibilityArray(byte direction) {
		return null;
	}
	
	/**
	 * This method instantiates the {@link Grid} object for a new game. It also handles the placement of all {@link Locatable} objects.
	 */
	public void setupGrid() {
		
	}
	
	/**
	 * Saves the game-state by using the FileManager to record the {@link #grid}, and other miscellaneous attributes like {@link #turnCount}.
	 */
	public void saveGame() {
		
	}
	
	
	/**
	 * Loads the gamestate using the FileManager, and initializes the {@link #grid}, and other miscellaneous attributes like {@link #turnCount}.  
	 */
	public void loadGame() {
		
	}
	
	
	
}
