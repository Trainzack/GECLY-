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
 * This class represents a room which can contain the briefcase or an item in the game.
 *
 * @author Gavin Kremer
 */
public class Room implements Locatable,Serializable{

    /**
     * This field represents the contents of the {@link Room}, which can be the {@link Briefcase} or
     * another {@link WorldItem}
     */
    private WorldItem contents;

    /**
     * This field represents the ASCII character identifying the object.
     */
    private char ASCIIRep;

    /**
     * This field represents the Unicode character identifying the object.
     */
    private char UnicodeRep;

    /**
     * This is the constructor for {@link Room}
     */
    Room(){
        this.ASCIIRep = 'R';
        this.UnicodeRep = '◫';
    }

    /**
     * Getter for {@link #ASCIIRep}
     * @return value of {@link #ASCIIRep}
     */
    public char getASCIIRep(){
        return this.ASCIIRep;
    }

    /**
     * Getter for {@link #UnicodeRep}
     * @return value of {@link #UnicodeRep}
     */
    public char getUnicodeRep(){
        return this.UnicodeRep;
    }

    @Override
    public Location getLocation() {
        return null;
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
        if (visible) {
            return this.getUnicodeRep();
        }
        return '■';
    }

    /**
     * Setter for {@link #contents}
     * @param item value for {@link #contents}
     */
    public void setContents(WorldItem item){
        this.contents = item;
    }
    /**
     * Getter for {@link #contents}
     * @return value of {@link #contents}
     */
    public WorldItem getContents() {
        return contents;
    }
}
