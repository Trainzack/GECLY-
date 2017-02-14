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


import java.io.Serializable;
import java.util.ArrayList;
import java.util.Random;

/**
 * This class represents the grid that the game takes place on and all of the objects interact with each other in,
 * one of the fundamental parts of the game.
 *
 * @author Gavin Kremer
 */

public class Grid implements Serializable{

    /**
     * This field represents the size of the board and is a constant that will be used when creating the board.
     */
    final private int BOARDSIZE = 9;

    /**
     * This field represents the state of the board and will contain different objects that implement {@link Locatable}.
     * The contents of this array usually won't be visible to the player, and is mostly used for the system to locate
     * objects.
     */
    private Locatable[][] boardState = new Locatable[BOARDSIZE][BOARDSIZE];

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
     * This method sets the object to a set of coordinates, and updates that object's {@link Location}. Movement fails if the destination does not equal null or does not exist.
     * @param pos1 First array index to search.
     * @param pos2 Second array index to search.
     * @return whether the object was moved successfully
     */
    public boolean setPos(int pos1, int pos2,Locatable item) {
        
    	if (!testValidPos(pos1, pos2)) return false;
        
    	if (boardState[pos1][pos2] != null) return false;
    	
    	this.boardState[pos1][pos2] = item;
    	item.getLocation().setPos(pos1, pos2);
    	//set location locale?
    	return true;
        
    }
    
    /**
     * Tests to see if a position is a valid spot on the grid.
     * 
     * @param pos1
     * @param pos2
     * @return whether the position is a valid location on the array.
     */
    public boolean testValidPos(int pos1, int pos2) {
        if (pos1 >= BOARDSIZE || pos2 >= BOARDSIZE || pos1 < 0 || pos2 < 0) {
        	return false;
        }
        return true;
    }

    /**
     * This method removes the object located at a set of coordinates.
     * @param pos1 First array index to search.
     * @param pos2 Second array to search.
     */
    public void removePos(int pos1, int pos2){

    }

    /**
     * Gets a copy of the internal array used to represent the Grid's boardstate.
     * @return value of {@link #boardState}
     */
    public Locatable[][] getBoardState(){//TODO: Do we really need this?
        return this.boardState.clone();
    }

    /**
     * This method basically stacks the board with all of the default objects, and will be used when starting a brand new game.
     * @param player Player to be inserted into the grid.
     * @param ninjalist Ninjas to be inserted into the grid.
     * @param itemlist Items to be inserted into the grid.
     */
    public void stack(Player player,ArrayList<Ninja> ninjalist ,ArrayList<WorldItem> itemlist){
        Random RNG = new Random();
        boardState[8][0] = player;
        player.getLocation().setPos(8,0);
        
        ArrayList<Room> rooms = new ArrayList<Room>();
        
        for (int row = 1; row < 8; row += 3) {
        	for (int col = 1; col < 8; col += 3) {
        		Room addedRoom = new Room();
        		boardState[row][col] = addedRoom;
        		rooms.add(addedRoom);
        	}
        }
        int briefno = RNG.nextInt(9);
        rooms.get(briefno).setContents(new Briefcase());

        for (int i = 0;i<ninjalist.size();++i){
            int pos1 = RNG.nextInt(9);
            int pos2 = RNG.nextInt(9);
            int[] coords = {pos1, pos2};
            Locatable spot = boardState[pos1][pos2];
            if(spot == null){
                if(!checkForNearPlayer(pos1,pos2)){
                    boardState[pos1][pos2] = ninjalist.get(i);
                }
                else{--i;}
               }
            else{--i;}
        }
        for (int i = 0;i < itemlist.size();++i){
            int pos1 = RNG.nextInt(9);
            int pos2 = RNG.nextInt(9);
            Locatable spot = boardState[pos1][pos2];
            if(spot == null){
                if(!checkForNearPlayer(pos1,pos2)){
                    boardState[pos1][pos2] = itemlist.get(i);
                }
                else{--i;}
            }
            else{
                if (spot instanceof Room){
                    ((Room) spot).setContents(itemlist.get(0));
                }
                else{--i;}
            }
        }
    }

    /**
     * This method checks if the given coordinates are one square away from the player or not (including diagonally).
     * @param row The row of the square to look at
     * @param col The column of the square to look at
     * @return whether coordinates are next to player or not.
     */
    public boolean checkForNearPlayer(int row, int col, int d){
        for (int cRow = row - d; cRow <= row + d; cRow++) {
        	for (int cCol = col - d; cCol <= col + d; cCol++) {
        		if (testValidPos(cRow, cCol) && boardState[cRow][cCol] instanceof Player) {
        			return true;
        		}
        	}
        }
        return false;
    }
    
    public boolean checkForNearPlayer (int row, int col) {
    	return checkForNearPlayer(row, col, 1);
	}
}
