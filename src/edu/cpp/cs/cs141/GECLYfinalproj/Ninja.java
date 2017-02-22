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
import java.util.ArrayList;

/**
 * This class represents a Ninja Assassin, which is a subclass of the {@link Agent} abstract class. The game
 * will start by creating three instances of this class.
 *
 * @author Gavin Kremer
 */
public class Ninja extends Agent implements Locatable,Serializable{

    /**
     *Represents if the ninja is alive or not.
     */
    private boolean alive;

    /**
     * This is the constructor for {@link Ninja}.
     */
    Ninja(){
        this.alive = true;
        this.setASCIIRep('N');
        this.setUnicodeRep('♾');

    }
    @Override
    public void kill() {
    	int curRow = this.getLocation().getRow();
    	int curCol = this.getLocation().getCol();
    	this.getLocation().getLocale().removePos(curRow,curCol);
    	this.alive = false;
    }
    
	@Override
	public boolean objectCanBeMovedOver(Locatable l, Direction d) {
      if (l == null || l instanceof Player) {
        	return true;
        }
        return false;
	}

    /**
     * Getter for {@link #alive}
     * @return value of {@link #alive}
     */
    public boolean isAlive() {
        return alive;
    }
}
