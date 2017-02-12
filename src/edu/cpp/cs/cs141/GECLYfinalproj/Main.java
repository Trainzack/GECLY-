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
 * This class is the main class where the game will start when the method
 * {@link UserInterface#startGame()} is called. This method will implement
 * UserInterface and all its methods.
 * 
 * @author Yan Huang
 *
 */
public class Main {

	public static void main(String[] args) {
		Engine engine = new Engine();
		engine.setupGrid(false);
	}

}

