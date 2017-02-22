package edu.cpp.cs.cs141.GECLYfinalproj.powerups;

import edu.cpp.cs.cs141.GECLYfinalproj.Location;
import edu.cpp.cs.cs141.GECLYfinalproj.WorldItem;

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
 * The NightVision class represents the character's night vision power up. This power up will enhance the player's
 * line of vision and allow them to see mmore than the usual 2 blocks ahead.
 * 
 * @author Clara Nguyen
 */
public class NightVision extends WorldItem{
	
	/**
	 * The NightVision constructor employs the superclass constructor to set the values for all the attributes in the
	 * WorldItem abstract class.
	 */
	public NightVision() {
		super();
		this.setASCIIRep('V');
		this.setUnicodeRep('☪');
	}

	@Override
	public void apply() {
		
	}
	
}
