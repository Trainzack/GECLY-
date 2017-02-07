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
 * This class represents an agent in the game (enemies and the player) and is the parent class for
 * {@link Player} and {@link Ninja}.
 *
 * @author Gavin Kremer
 */

public abstract class Agent implements Locatable{

    /**
     * This field represents the ASCII character which represents the {@link Agent}.
     */
    private char ASCIIRep;

    /**
     * This field represents the Unicode character which represents the {@link Agent}.
     */
    private char UnicodeRep;

    /**
     * This field represents the locale of the {@link Agent}, AKA the {@link Grid} they are located in.
     */
    private Grid locale;

    /**
     * This method will handle the {@link Agent}'s movement, and return wether or not the move was successful
     * (for if they try to move out of bounds for example.)
     * @return if the move was successful or not.
     */
    public boolean move(){
        return true;
    }

    /**
     * This method will handle the {@link Agent}'s death, which will be radically different depending on which
     * agent is using it, so it is abstract.
     */
    public abstract void kill();


    /**
     *This is the constructor for {@link Agent} which basically assigns the representations and the {@link #locale}
     */
    Agent(){

    }
    /**
     * Getter for {@link #ASCIIRep}
     * @return value of {@link #ASCIIRep}
     */
    public char getASCIIRep() {
        return ASCIIRep;
    }

    /**
     * Getter for {@link #UnicodeRep}
     * @return value of {@link #UnicodeRep}
     */
    public char getUnicodeRep() {
        return UnicodeRep;
    }

    /**
     * Getter for {@link #locale}
     * @return value of {@link #locale}
     */
    public Grid getLocale() {
        return locale;
    }

    @Override
    public char getASCIIDisplayCharacter(boolean visible) {
        return 0;
    }

    @Override
    public char getUnicodeDisplayCharacter(boolean visible) {
        return 0;
    }
}
