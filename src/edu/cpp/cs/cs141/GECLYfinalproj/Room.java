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
 * This class represents a room which can contain the briefcase or an item in the game.
 *
 * @author Gavin Kremer
 */
public class Room implements Locatable{

    /**
     * This field represents the contents of the {@link Room}, which can be the {@link Briefcase} or
     * another {@link WorldItem}
     */
    private WorldItem contents;

    @Override
    public char getASCIIDisplayCharacter(boolean visible) {
        return 0;
    }

    @Override
    public char getUnicodeDisplayCharacter(boolean visible) {
        return 0;
    }

    /**
     * Getter for {@link #contents}
     * @return value of {@link #contents}
     */
    public WorldItem getContents() {
        return contents;
    }
}
