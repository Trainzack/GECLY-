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

import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;

import java.io.*;

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

    public static void writeSave(String save,Grid board){
        try {
            FileOutputStream fos = new FileOutputStream(save);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(board);
            oos.close();
        }
        catch(IOException X){
            System.out.println("The game could not be saved.");
        }
    }

    public static Grid readSave(File save){
        try{
            FileInputStream fis = new FileInputStream(save);
            ObjectInputStream ois = new ObjectInputStream(fis);
            return (Grid) ois.readObject();
        }
        catch(Exception X){
            System.out.println("Corrupt save.");
        }
        return null;
    }
}
