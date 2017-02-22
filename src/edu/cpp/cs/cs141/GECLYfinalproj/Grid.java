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
    public Locatable getObject(Location l){
        return getObject(l.getRow(),l.getCol());
    }
    public Locatable getObject(Location l, Direction d){
        return getObject(l.getLocationByDirection(d));
    }
    public Player getPlayer(){
        for(Locatable[] L: boardState){
            for(Locatable Li : L){
                if (Li instanceof Player){
                    return (Player)Li;
                }
            }

        }
        return null;
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

    	removePos(item.getLocation().getRow(),item.getLocation().getCol());
    	this.boardState[row][col] = item;
    	item.getLocation().setPos(row, col);
    	item.getLocation().setLocale(this);
    	return true;
    }
    
    /**
     * Tests to see if a position is on the grid.
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
     * Tests to see if a location is on the grid.
     * 
     * @param l
     * @return
     */
    public boolean testValidPos(Location l) {
    	return testValidPos(l.getRow(), l.getCol());
    }
    
    /**
     * Tests to see if the position one square away from a {@link Location} in a given {@link Direction} is inside of the grid.
     * 
     * @param l
     * @param d
     * @return
     */
    public boolean testValidPos(Location l, Direction d) {
    	
    	return testValidPos(l.getLocationByDirection(d));//TODO: clean up this implementation; the non d method should also accept locations, and there should be a way to add directions to locations.
    	
    }

    /**
     * This method removes the object located at a set of coordinates.
     * @param Row First array index to search.
     * @param Col Second array to search.
     */
    public void removePos(int Row, int Col){
        this.boardState[Row][Col] = null;

    }

    /**
     * This method places the player, rooms, ninjas, powerups, and the briefcase onto the grid, and will be used when starting a brand new game.
     * @param player Player to be inserted into the grid.
     * @param ninjaList Ninjas to be inserted into the grid.
     * @param itemList Items to be inserted into the grid.
     */
    public void placeStartingObjects(Player player,ArrayList<Ninja> ninjaList ,ArrayList<WorldItem> itemList){
        Random randomGenerator = new Random();
        if (player == null) throw new java.lang.NullPointerException("Player must be set to a value!");
        
        setPos(8, 0, player);
        player.getLocation().setPos(8,0);
        player.getLocation().setLocale(this);
        
        ArrayList<Room> rooms = new ArrayList<Room>(); //This is used so that we can select a random room to put the briefcase in.
        
        for (int row = 1; row < 8; row += 3) {
        	for (int col = 1; col < 8; col += 3) {
        		Room addedRoom = new Room();
        		boardState[row][col] = addedRoom;
        		addedRoom.getLocation().setPos(row,col);
        		addedRoom.getLocation().setLocale(this);
        		rooms.add(addedRoom);
        	}
        }
        int briefno = randomGenerator.nextInt(9);
        rooms.get(briefno).setContents(new Briefcase());
        
        for (Ninja n : ninjaList) {
            addNinja(n, randomGenerator, player);
        }
        for (WorldItem item : itemList){
        	addItem(item, randomGenerator, player);
        }
        
    }
    
    /**
     * Selects a random valid position on the grid and places a specified {@link Ninja} there.
     * 
     * @param n the Ninja to place
     * @param randomGenerator the Random to use to get random numbers
     * @param player the player to avoid putting objects near
     */
    private void addNinja(Ninja n, Random randomGenerator, Player player) {
    	while (true) {
    		int Row = randomGenerator.nextInt(9);
            int Col = randomGenerator.nextInt(9);
            Locatable spot = boardState[Row][Col];
            if(spot == null) {
                if(!checkForNearLocatable(player, Row,Col,3)){
                    boardState[Row][Col] = n;
                    n.getLocation().setPos(Row,Col);
                    n.getLocation().setLocale(this);
                    break;
                }
            }
    	}
    }

    /**
     * Selects a random valid position on the grid and places a specified {@link WorldItem} there, also placing it in unoccupied rooms.
     * 
     * @param item the WorldItem to place
     * @param randomGenerator the Random to use to get random numbers
     * @param player the player to avoid putting objects near
     */
    private void addItem(WorldItem item, Random randomGenerator, Player player) {
    	while (true) {
	        int Row = randomGenerator.nextInt(9);
	        int Col = randomGenerator.nextInt(9);
	        Locatable spot = boardState[Row][Col];
	        if(spot == null){
	            if(!checkForNearLocatable(player, Row,Col,3)){
	                boardState[Row][Col] = item;
	                item.getLocation().setPos(Row,Col);
	                break;
	            }
	        }
	        else {
	            if (spot instanceof Room && ((Room) spot).getContents() == null){
	                ((Room) spot).setContents(item);
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

	/**
     * getter for {@link #boardState}
	 */
    public Locatable[][] getBoardState() {
        return boardState;
    }
}