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
 * @author Gavin Kremer, Eli Zupke
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
     * This method returns the object located at certain coordinates.
     * @param row The row of the target square
     * @param col The column of the target square
     * @return found object.
     */
    public Locatable getObject(int row, int col){
        return boardState[row][col];
    }

    /**
     * This method sets the object to a set of coordinates, and updates that object's {@link Location}. Movement fails if the destination does not equal null or does not exist.
     * @param row The row of the target square
     * @param col The column of the target square
     * @return whether the object was moved successfully
     */
    public boolean setPos(int row, int col,Locatable item) {
        
    	if (!testValidPos(row, col)) return false;
        
    	if (boardState[row][col] != null) return false;
    	
    	this.boardState[row][col] = item;
    	item.getLocation().setPos(row, col);
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
     * This method places the player, rooms, ninjas, powerups, and the briefcase onto the grid, and will be used when starting a brand new game.
     * @param player Player to be inserted into the grid.
     * @param ninjaList Ninjas to be inserted into the grid.
     * @param itemlist Items to be inserted into the grid.
     */
    public void placeStartingObjects(Player player,ArrayList<Ninja> ninjaList ,ArrayList<WorldItem> itemlist){
        Random randomGenerator = new Random();
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
        int briefno = randomGenerator.nextInt(9);
        rooms.get(briefno).setContents(new Briefcase());
        
        for (Ninja n : ninjaList) {
            addNinja(n, randomGenerator, player);
        }
        for (int i = 0;i < itemlist.size();){
            int Row = randomGenerator.nextInt(9);
            int Col = randomGenerator.nextInt(9);
            Locatable spot = boardState[Row][Col];
            if(spot == null){
                if(!checkForNearLocatable(player, Row,Col,3)){
                    boardState[Row][Col] = itemlist.get(i);
                    i++;
                }
            }
            else{
                if (spot instanceof Room){
                    ((Room) spot).setContents(itemlist.get(0));
                    i++;
                }
            }
        }
        
    }
    
    private void addNinja(Ninja n, Random randomGenerator, Player player) {
    	while (true) {
    		int Row = randomGenerator.nextInt(9);
            int Col = randomGenerator.nextInt(9);
            Locatable spot = boardState[Row][Col];
            if(spot == null) {
                if(!checkForNearLocatable(player, Row,Col,3)){
                    boardState[Row][Col] = n;
                    break;
                }
            }
    	}
    }

    /**
     * This method checks if the given coordinates are a certain (Manhattan) distance away from a specified {@link Locatable} object or not. For example, a distance of 2 will return true if the square is within one square of the selected object.
     * @param row The row of the square to look at
     * @param col The column of the square to look at
     * @param d How big the search square should be
     * @return whether coordinates are near enough to the Locatable object or not.
     */
    public boolean checkForNearLocatable(Locatable loc, int row, int col, int d){
        Location targetPosition = loc.getLocation();
        int targetRow = targetPosition.getRow();
        int targetCol = targetPosition.getCol();
        
        if (Math.abs(row - targetRow) < d && Math.abs(col - targetCol) < d) {
        	return true;
        }
        
        return false;
    }
    
    
    /**
     * This method checks if the given coordinates are one square away from a specified {@link Locatable} object or not (including diagonally).
     * @param row The row of the square to look at
     * @param col The column of the square to look at
     * @return whether coordinates are next to the Locatable object or not.
     */
    public boolean checkForNearLocatable (Locatable loc, int row, int col) {
    	return checkForNearLocatable(loc, row, col, 2);
	}
}
