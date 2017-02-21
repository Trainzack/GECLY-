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
    UP(-1,0,"up"), DOWN(1,0,"down"), LEFT(0,-1,"left"), RIGHT(0,1,"right");
    private int Row;
    private int Col;
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
}
