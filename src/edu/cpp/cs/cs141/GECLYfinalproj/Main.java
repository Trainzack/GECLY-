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
		//testDirectionArrays();
		GavinsPrinttest();
		//UserInterface.startGame();
	}

	//I left this method in for now so you guys can test it if you want. Will delete for final release. change line 39 to false to see without debug mode.
	public static void GavinsPrinttest(){
		ConsoleInterface gavinsInt = new ConsoleInterface();
		gavinsInt.startGame();
	//	gavinsInt.showMessage("Debug mode enabled?");
	//	gavinsInt.setDebugging(gavinsInt.displayMenu());
	//	gavinsInt.displayGrid();
	}
	
	public static void testDirectionArrays() {
		ConsoleInterface inter = new ConsoleInterface();
		inter.setDebugging(true);
		//inter.
		for (int i = 0; i < 9; i++) {
			inter.engine.setupGrid();
			Player p = inter.engine.getPlayer();
			Grid board = inter.testGetGrid();
			board.setPos(8, i, p);
			inter.displayGrid();
			System.out.println(p.getValidDirections());
		}
	}
}

