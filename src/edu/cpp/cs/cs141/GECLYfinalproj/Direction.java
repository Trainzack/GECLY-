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
 * This enum represents a direction for use with looking and moving, and each constant basically holds a set of cordinates to add.
 *
 * @author GECLY
 */
public enum Direction {
    UP(-1,0,"Up"), RIGHT(0,1,"Right"), DOWN(1,0,"Down"), LEFT(0,-1,"Left");
    
    /**
     * The change in row that this direction represents.
     */
    private int Row;
    
    /**
     * The change in column that this direction represents.
     */
    private int Col;
    
    
    /**
     * What this direction should be displayed as in the menus.
     */
    private String name;

    /**
     * This is the constructor for a direction.
     * @param Row Row to assign.
     * @param Col Col to assign.
     * @param name name of the direction.
     */
    Direction(int Row, int Col, String name) {
        this.Row = Row;
        this.Col = Col;
        this.name = name;
    }

    /**
     * Getter for {@link #Row}
     * @return value of {@link #Row}
     */
    public int getRow() {
        return Row;
    }

    /**
     * Getter for {@link #Col}
     * @return value of {@link #Row}
     */
    public int getCol() {
        return Col;
    }

    /**
     * To String method for this enum
     * @return String to show.
     */
    public String toString() {
    	return name;
    }

    /**
     *
     * @param source
     * @param target
     * @return
     */
    public static Direction getDirectionByLocations(Location source, Location target) {
    	int dRow = target.getRow() - source.getRow();
    	int dCol = target.getCol() - source.getCol();
    	
    	if (Math.abs(dRow) > Math.abs(dCol)) { //We should move up or down to get closest.
    		if (dRow > 0) {
    			return DOWN;
    		} else {
    			return UP;
    		}
    	} else { //We should move left or right to get closest
    		if (dCol > 0) {
    			return RIGHT;
    		} else {
    			return LEFT;
    		}
    	}
    }
}
