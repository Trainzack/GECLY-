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

import java.io.*;

/**
 * This class deals with the saving and loading of a game. It will reference the class Grid which has the board of the
 * game and the positions of the players, enemies, and items. This class will transfer all of the data in the Grid
 * class and write it into a file that the user can specify. The file can then be reloaded by calling the FileManager and
 * passing the file into a parameter to reload the current status of the saved game.
 *
 * @author GECLY
 */
public class FileManager {

    /**
     * This method creates a save file by saving the boardstate to a file specified by the UI.
     * @param save filename to save to
     * @param board board to save
     */
    public static boolean writeSave(String save,Grid board){
        try {
            FileOutputStream fos = new FileOutputStream(save);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(board);
            oos.close();
        }
        catch(IOException X){
            return false;
        }
        return true;
    }

    /**
     * This method finds and returns a saved boardstate inside the given file.
     * @param save file to load from
     * @return board found.
     */
    public static Grid readSave(File save){
        try{
            FileInputStream fis = new FileInputStream(save);
            ObjectInputStream ois = new ObjectInputStream(fis);
            return (Grid) ois.readObject();
        }
        catch(Exception X){
            return null;
        }
    }
}
