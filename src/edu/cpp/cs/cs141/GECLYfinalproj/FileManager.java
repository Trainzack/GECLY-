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
 * This class deals with the saving and loading of a game. It will reference the class Grid which has the board of the
 * game and the positions of the players, enemies, and items. This class will transfer all of the data in the Grid
 * class and write it into a file that the user can specify. The file can then be reloaded by calling the FileManager and
 * passing the file into a parameter to reload the current status of the saved game.
 */
public class FileManager {

    /**
     * This method will use a FileOutputStream, FileInputStream, and RandomAccessFile in order to write the current
     * status of the game into the file that user writes. A string will taken in as a parameter which will be the file
     * the user wants to save their game in.
     */
    public static void loadSaveGame () {

    }

    /**
     * Method will prompt the user with strings indicating if they want to load or save the game. Their choice will be
     * saved as a integer and redirected to another method. Also, if user chooses to save file, they will write the name
     * of the file and it will be saved as a string.
     *
     */
    public static void loadSaveOptions() {

    }
}
