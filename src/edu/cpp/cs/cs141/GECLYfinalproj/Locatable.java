package edu.cpp.cs.cs141.GECLYfinalproj;

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
 * Locatable is an interface designed for objects that appear on the main game grid. It contains methods for retrieving 
 * 
 * @author eli
 *
 */
public interface Locatable {


	/**
	 * This method represents the
	 */
	public Location getLocation(Locatable object);

	/**
	 * Returns the ASCII character used to display this object when the game is played in the console. Whether the tile is visible to the player can be specified.
	 * 
	 * Examples: 'A','r','*',' '.
	 * 
	 * @param visible whether the player can see the grid square that contains this object
	 * @return the character used to display this object, or null if this object should not be displayed
	 */
	public char getASCIIDisplayCharacter(boolean visible);
	
	/**
	 * Returns the Unicode character used to display this object when the game is played in the console. Whether the tile is visible to the player can be specified.
	 * 
	 * Examples: '♕','♿','⚑','♦'.
	 * 
	 * @param visible whether the player can see the grid square that contains this object
	 * @return the character used to display this object, or null if this object should not be displayed
	 */
	public char getUnicodeDisplayCharacter(boolean visible);
	
	//TODO: Add methods for retrieving images for these items
	
	//Question: Do we want methods for getting the location of this object, the distance to another object, and the grid that this object is currently on?
	
	
}
