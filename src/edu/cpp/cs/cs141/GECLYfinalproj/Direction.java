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
    UP(-1,0), DOWN(1,0), LEFT(0,-1), RIGHT(0,1);
    private int Row;
    private int Col;

    Direction(int Row, int Col) {
        this.Row = Row;
        this.Col = Col;
    }

    public int getRow() {
        return Row;
    }

    public int getCol() {
        return Col;
    }
}
