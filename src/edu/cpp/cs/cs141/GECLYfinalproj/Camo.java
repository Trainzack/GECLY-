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
 * This class represents the object {@link Camo} that is to be used by the
 * player's character in the game. {@link Camo} extends {@link WorldItem} because
 * it is an item in the game and implements {@link Locatable} which marks the item as
 * a locatable object.
 * 
 * @author Yan Huang
 *
 */
public class Camo extends WorldItem{
	
	/**
	 * This is the {@link Camo} constructor that uses {@link WorldItem}'s
	 * constructor.
	 */
	public Camo(){
		super();
	}

	@Override
	public void apply() {
		// TODO Auto-generated method stub
		
	}
}
