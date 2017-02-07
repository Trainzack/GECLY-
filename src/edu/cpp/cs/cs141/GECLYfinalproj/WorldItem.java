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
 * This class represents all the items found in the game like the power ups and the briefcase. This
 * abstract class holds all the necessary attributes for the actual items' classes extending this class, like 
 * name, a char that represents the item, and the grid for the items' locations. 
 *
 * @author Clara Nguyen
 */
public abstract class WorldItem implements Locatable {
	
	/**
	 * The String name field represents the name of the world item.
	 */
	private String name;
	
	/**
	 * This Grid object field represents the grid that the object's are on .
	 */
	private Grid locale;
	
	/* (non-Javadoc)
	 * @see edu.cpp.cs.cs141.GECLYfinalproj.Locatable#getASCIIDisplayCharacter(boolean)
	 */
	@Override
	public char getASCIIDisplayCharacter(boolean visible) {
		// TODO Auto-generated method stub
		return 0;
	}

	/* (non-Javadoc)
	 * @see edu.cpp.cs.cs141.GECLYfinalproj.Locatable#getUnicodeDisplayCharacter(boolean)
	 */
	@Override
	public char getUnicodeDisplayCharacter(boolean visible) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	/**
	 * This method applies the item to the character. It is abstract so that it can be applied uniquely
	 * to the different classes that extend this abstract class.
	 */
	public abstract void apply();
	
}
