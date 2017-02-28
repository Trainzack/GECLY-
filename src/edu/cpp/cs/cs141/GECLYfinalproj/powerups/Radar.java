package edu.cpp.cs.cs141.GECLYfinalproj.powerups;

import edu.cpp.cs.cs141.GECLYfinalproj.Location;
import edu.cpp.cs.cs141.GECLYfinalproj.Player;
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
 * The Radar class represents the character's radar power up. The radar power up will allow the user to 
 * see where the briefcase is.
 * 
 * @author GECLY
 */
public class Radar extends WorldItem{
	
	/**
	 * The Radar constructor employs the superclass constructor to set the values for all the attributes in the
	 * WorldItem abstract class.
	 */
	public Radar() {
		super();
		this.setName("Radar");
		this.setASCIIRep('R');
		this.setUnicodeRep('⚨');
	}

	@Override
	public void apply(Player player) {
		player.setHasRadar(true);
	}
}
