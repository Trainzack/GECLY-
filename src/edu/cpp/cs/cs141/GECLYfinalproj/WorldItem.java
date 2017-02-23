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

import java.io.Serializable;

/**
 * This class represents all the items found in the game like the power ups and the briefcase. This
 * abstract class holds all the necessary attributes for the actual items' classes extending this class, like 
 * name, a char that represents the item, and the grid for the items' locations. 
 *
 * @author Clara Nguyen, Gavin Kremer
 */
public abstract class WorldItem implements Locatable,Serializable {
	
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
	 * This field represents the location of the object on the {@link Grid}
	 */
	private Location location;

    /**
     * This method applies the item to the character. It is abstract so that it can be applied uniquely
     * to the different classes that extend this abstract class.
     */
    public abstract void apply(Player player);

    /**
     * This is the constructor for {@link WorldItem}
     */
    public WorldItem(){
    	this.location = new Location();

    }

	/**
	 * Setter for {@link #ASCIIRep}
	 * @param c value for {@link #ASCIIRep}
	 */
	public void setASCIIRep(char c){
		this.ASCIIRep = c;
	}

	/**
	 * Setter for {@link #UnicodeRep}
	 * @param c value for {@link #UnicodeRep}
	 */
	public void setUnicodeRep(char c){
		this.UnicodeRep = c;
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

	@Override
	public Location getLocation() {
		return this.location;
	}

	@Override
	public char getASCIIDisplayCharacter(boolean visible) {
		if(visible){
			return this.getASCIIRep();
		}
		return '*';
	}

	@Override
	public char getUnicodeDisplayCharacter(boolean visible) {
		if (visible) {
			return this.getUnicodeRep();
		}
		return '■';
	}
}
