package edu.cpp.cs.cs141.GECLYfinalproj;

import java.io.PrintWriter;
import java.util.InputMismatchException;
import java.util.Scanner;

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
 * This class represents the console based interface which will involve console elements like the Scanner and System.out.
 *
 * @author Gavin Kremer, Eli Zupke
 */
public class ConsoleInterface extends UserInterface{

    /**
     * This field represents the Scanner that the user will use to interact with the UI.
     */
    private Scanner userInput = new Scanner(System.in);
    
    /**
     * The PrintWriter that will be used for output (works the same as System.out). Note that we will need to make considerations for Unicode support by using an OutputStreamWriter with the right encoding as a first argument. If that doesn't work at runtime, we can default to ASCII by setting {@link #UnicodeEnabled}.
     */
    private PrintWriter systemOutput;
    
    /**
     * Whether or not output can contain Unicode.
     */
    private boolean unicodeEnabled;

    /**
     * This method will print a method in the console.
     */
    public void showMessage(String message){
    	systemOutput.println(message);
    }
    
    /**
	 * Creates a menu based off of an array of strings, and returns the array index of the string stat was selected.
	 * 
	 * @param choices the options that will be given to the player
	 * @param query the text to prompt the player with
	 * @return the array index of the choice that was selected
	 */
	public int displayMenu(String[] choices) {
		
		for (int i = 0; i < choices.length; i++) {
			showMessage((i+1) + ". " + choices[i]);
		}
		
		return getInt(1,choices.length)-1;
	}
	
	/**
	 * Waits for the user to enter a valid number that is inside the specified range, then returns the result. Used for letting the player select menu choices.
	 * 
	 * @param min the smallest number that will be accepted
	 * @param max the largest number that will be accepted
	 * @return the int that the player selected
	 */
	private int getInt(int min, int max) {
		
		while (true) { //This loop will ensure the only way out of this method is for a valid option to be selected.
			try {
				int output = userInput.nextInt();
				if (output < min || output > max) {
					//This catches cases where the user inputs a number, but it is not within the allowed range.
					showMessage("Invalid number. Please enter a number from " + min + " to " + max + ".\n");
				} else {
					return output;
				}
			} catch (InputMismatchException e)  {
				//This catches cases where the user did not actually enter a number at all.
				showMessage("Invalid number. Please enter a valid number.\n");
				userInput.next(); //This line is required for the method to function, and I don't know why.
			}
		}
		
	}



}
