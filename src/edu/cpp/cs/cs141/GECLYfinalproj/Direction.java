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
 * @author Gavin Kremer
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

    Direction(int Row, int Col, String name) {
        this.Row = Row;
        this.Col = Col;
        this.name = name;
    }

    public int getRow() {
        return Row;
    }

    public int getCol() {
        return Col;
    }
    
    public String toString() {
    	return name;
    }
    
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
