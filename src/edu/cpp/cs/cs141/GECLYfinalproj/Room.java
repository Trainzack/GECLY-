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
 * This class Room represents a room in the grid that can contain world items including a briefcase.
 */
public class Room implements Locatable{
    /**
     * This field will determine if there is a world item inside the room.
     */
    private boolean ContainedWorldItem;
    @Override
    public char getASCIIDisplayCharacter(boolean visible) {
        return 0;
    }

    @Override
    public char getUnicodeDisplayCharacter(boolean visible) {
        return 0;
    }
}
