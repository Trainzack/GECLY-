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

/**
 * This class represents an agent in the game (enemies and the player) and is the parent class for
 * {@link Player} and {@link Ninja}.
 *
 * @author Gavin Kremer
 */

public abstract class Agent implements Locatable,Serializable{

    /**
     * This field represents the location of the object on the {@link Grid}
     */
    private Location location;

    /**
     * This field represents the ASCII character which represents the {@link Agent}.
     */
    private char ASCIIRep;

    /**
     * This field represents the Unicode character which represents the {@link Agent}.
     */
    private char UnicodeRep;

    /**
     * This method will handle the {@link Agent}'s movement, and return wether or not the move was successful
     * (for if they try to move out of bounds for example.)
     * @return if the move was successful or not.
     */
    public boolean move (Direction direction){
        Direction[] valids = this.getValidDirections();
        for(Direction D: valids){
            if(direction == D){
                //TODO make actual movement happen
                return true;
            }
        }
        return false;
    }
    public abstract Direction[] getValidDirections();

    /**
     * This method will handle the {@link Agent}'s death, which will be radically different depending on which
     * agent is using it, so it is abstract.
     */
    public abstract void kill();


    /**
     *This is the constructor for {@link Agent}.
     */
    Agent(){
        this.location = new Location();

    }

    /**
     * Getter for {@link #ASCIIRep}
     * @return value of {@link #ASCIIRep}
     */
    public char getASCIIRep() {
        return ASCIIRep;
    }

    /**
     * Setter for {@link #ASCIIRep}
     * @param c value of {@link #ASCIIRep}
     */
    public void setASCIIRep(char c){
        this.ASCIIRep = c;
    }

    /**
     * Setter for {@link #UnicodeRep}
     * @param c value for {@link #UnicodeRep}
     */
    public void setUnicodeRep(char c){
        this.UnicodeRep = c;
    }
    /**
     * Getter for {@link #UnicodeRep}
     * @return value of {@link #UnicodeRep}
     */
    public char getUnicodeRep() {
        return UnicodeRep;
    }

    @Override
    public Location getLocation() {
        return this.location;
    }

    @Override
    public char getASCIIDisplayCharacter(boolean visible) {
        if(visible){
            return this.getASCIIRep();
        }
        return '*';
    }

    @Override
    public char getUnicodeDisplayCharacter(boolean visible) {
        if(visible){
        return this.getUnicodeRep();
        }
        return '■';


    }
}
