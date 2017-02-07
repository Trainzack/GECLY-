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
 * This class represents the grid that the game takes place on and all of the objects interact with each other in,
 * one of the fundamental parts of the game.
 *
 * @author Gavin Kremer
 */

public class Grid {

    /**
     * This field represents the state of the board and will contain different objects that implement {@link Locatable}.
     * The contents of this array usually won't be visible to the player, and is mostly used for the system to locate
     * objects.
     */
    Locatable[][] boardState = new Locatable[9][9];

    /**
     * This field represents the visible board, which is what the player can see while playing the game. Since this
     * array doesn't have to actually keep track of objects, but rather what represents the object, it is a char array.
     */
    char[][] visibleBoard = new char[9][9];

    /**
     * This method takes in coordinated and then returns the object located at those coordinates.
     * @param pos1 First array index to search.
     * @param pos2 Second array index to search.
     * @return found object.
     */
    public Locatable getObject(int pos1, int pos2){
        return boardState[pos1][pos2];
    }

    /**
     *This method is basically reverse {@link #getObject(int, int)}, in that is takes a {@link Locatable} object
     * and returns the coordinates of its location as an int array.
     * @param Item Object to find position of.
     * @return coordinates of found object.
     */
    public int[] getPos(Locatable Item){
        int [] found = new int[2];
        return found;
    }

    /**
     * This method sets the object located at set of coordinates.
     * @param pos1 First array index to search.
     * @param pos2 Second array index to search.
     */
    public void setPos(int pos1, int pos2){

    }

    /**
     * This method removes the object located at a set of coordinates.
     * @param pos1 First array index to search.
     * @param pos2 Second array to search.
     */
    public void removePos(int pos1, int pos2){

    }

    /**
     * This method will set a position on a grid as visible, which will essentially temporarily replace the given
     * position on the {@link #visibleBoard} with that of the {@link #boardState}.
     * @param pos1 First array index to search.
     * @param pos2 Second array index to search.
     */
    public void setVisiblePos(int pos1, int pos2){

    }

    /**
     * This method will set a position on a grid as invisible, which should only be used on the {@link #visibleBoard},
     * as it will essentially replace the item at the given location with an '*'.
     * @param pos1 First array index to search.
     * @param pos2 Second array index to search.
     */
    public void setInvisiblePos(int pos1, int pos2){

    }
}
