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
 * This class represents the object {@link Briefcase} that is to be collected by the
 * player's character in the game. {@link Briefcase} extends {@link WorldItem} because
 * it is an item in the game and implements {@link Locatable} which marks the item as
 * a locatable object.
 * 
 * @author Yan Huang
 *
 */
public class Briefcase extends WorldItem{
	
	/**
	 * This is the {@link Briefcase} constructor that uses {@link WorldItem}'s
	 * constructor.
	 */
	public Briefcase(){
		super();
	}


	@Override
	public Location getLocation() {
		return null;
	}

	@Override
	public void apply() {
		// TODO Auto-generated method stub
	}
	
}
