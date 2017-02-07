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
 * @author Clara Nguyen, Gavin Kremer
 */
public abstract class WorldItem implements Locatable {
	
	/**
	 * The String name field represents the name of the world item.
	 */
	private String name;

    /**
     * This field represents the ASCII character which represents the {@link WorldItem}.
     */
    private char ASCIIRep;

    /**
     * This field represents the Unicode character which represents the {@link WorldItem}.
     */
    private char UnicodeRep;

	/**
	 * This Grid object field represents the grid that the object's are on.
	 */
	private Grid locale;

    /**
     * This method applies the item to the character. It is abstract so that it can be applied uniquely
     * to the different classes that extend this abstract class.
     */
    public abstract void apply();

    /**
     * This is the constructor for {@link WorldItem}
     */
    WorldItem(){

    }

	/**
	 * Getter for {@link #name}
	 * @return value of {@link #name}
	 */
	public String getName() {
		return name;
	}

	/**
	 * Getter for {@link #ASCIIRep}
	 * @return value of {@link #ASCIIRep}
	 */
	public char getASCIIRep() {
		return ASCIIRep;
	}

	/**
	 * Getter for {@link #UnicodeRep}
	 * @return value of {@link #UnicodeRep}
	 */
	public char getUnicodeRep() {
		return UnicodeRep;
	}

	/**
	 * Getter for {@link #locale}
	 * @return value of {@link #locale}
	 */
	public Grid getLocale() {
		return locale;
	}



	@Override
	public char getASCIIDisplayCharacter(boolean visible) {
		return 0;
	}

	@Override
	public char getUnicodeDisplayCharacter(boolean visible) {
		return 0;
	}

	
}
