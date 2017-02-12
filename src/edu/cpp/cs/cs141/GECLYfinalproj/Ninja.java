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
 * This class represents a Ninja Assassin, which is a subclass of the {@link Agent} abstract class. The game
 * will start by creating three instances of this class.
 *
 * @author Gavin Kremer
 */
public class Ninja extends Agent implements Locatable{

    /**
     * This is the constructor for {@link Ninja}.
     */
    Ninja(){
        this.setASCIIRep('N');
        this.setUnicodeRep('♾');

    }
    @Override
    public void kill() {

    }
}
