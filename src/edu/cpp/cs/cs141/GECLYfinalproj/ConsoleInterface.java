package edu.cpp.cs.cs141.GECLYfinalproj;

import java.io.PrintWriter;
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
 * @author Gavin Kremer
 */
public class ConsoleInterface extends UserInterface{

    /**
     * This field represents the Scanner that the user will use to interact with the UI.
     */
    private Scanner SWIFT = new Scanner(System.in);
    
    /**
     * The PrintWriter that will be used for output (works the same as System.out). Note that we will need to make considerations for Unicode support by using an OutputStreamWriter with the right encoding as a first argument. If that doesn't work at runtime, we can default to ASCII by setting {@link #UnicodeEnabled}.
     */
    private PrintWriter SystemOutput;
    
    /**
     * Whether or not output can contain Unicode.
     */
    private boolean UnicodeEnabled;

    /**
     * This method will print a method in the console.
     */
    public static void showMessage(){

    }



}
