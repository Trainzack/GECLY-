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
	
	private String name;
	
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
	
	public abstract void apply();
	
}
