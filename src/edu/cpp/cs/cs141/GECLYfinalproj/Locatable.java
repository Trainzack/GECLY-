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
 * @author GECLY
 *
 */
public interface Locatable {


	/**
	 * Returns the ASCII character used to display this object when the game is played in the console. Whether the tile is visible to the player can be specified.
	 *
	 * Examples: 'A','r','*',' '.
	 *
	 * @param visible whether the player can see the grid square that contains this object
	 * @return the character used to display this object, or null if this object should not be displayed
	 */
	char getASCIIDisplayCharacter(boolean visible);

	/**
	 * Returns the Unicode character used to display this object when the game is played in the console. Whether the tile is visible to the player can be specified.
	 *
	 * Examples: '♕','♿','⚑','♦'.
	 *
	 * @param visible whether the player can see the grid square that contains this object
	 * @return the character used to display this object, or null if this object should not be displayed
	 */
	char getUnicodeDisplayCharacter(boolean visible);

	/**
	 * Returns a {@link Location} object that represents where the object is on a particular grid.
	 *
	 * @return the Location that this object is at
	 */
	Location getLocation();
}
