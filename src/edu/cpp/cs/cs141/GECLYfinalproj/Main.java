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
		//GavinsPrinttest();
		//GavinsGridTest();
		//UserInterface.startGame();
	}

	//I left these methods in for now so you guys can test it if you want. Will delete for final release.
	public static void GavinsGridTest(){
		Engine engine = new Engine();
		engine.setupGrid(false);
		for(int i = 0;i<9;++i){
			for(int l = 0;l<9;++l){
				System.out.println(engine.getBoard().getObject(i,l));
			}
		}
	}
	public static void GavinsPrinttest(){
		ConsoleInterface GavinsInt = new ConsoleInterface();
		GavinsInt.startGame();
		GavinsInt.setDebugging(false);
		GavinsInt.displayGrid();
	}
}

