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
 * The Invincibility class represents the character's invincibility power up. The invincibility power up will allow the 
 * the player to be invulnerable to stabbing for five turns.
 * 
 * @author Clara Nguyen
 */
public class Invincibility extends WorldItem{
	
	/**
	 * The Invincibility constructor employs the superclass constructor to set the values for all the attributes in the
	 * WorldItem abstract class.
	 */
	public Invincibility() {
		super();
		this.setASCIIRep('I');
		this.setUnicodeRep('⚡');
	}

	@Override
	public void apply(Player player) {
		player.setInvincibilityCount(6);
		
	}
	
}
