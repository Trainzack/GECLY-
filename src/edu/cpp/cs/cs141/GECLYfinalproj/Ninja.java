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
import java.util.Random;

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
    	this.alive = false;
    	this.getLocation().getLocale().removePos(curRow,curCol);
    }

    @Override
    public boolean doSpecificMove(Locatable currentOccupant, int Row, int Col, Grid board) {
        if (currentOccupant instanceof Player){
            if(((Player)currentOccupant).getInvincibilityCount()>0){
                this.kill();
                ((Player) currentOccupant).setLastEvent(Action.KILLED);
                return true;
            }
            else {
                ((Player) currentOccupant).kill();
                ((Player) currentOccupant).setLastEvent(Action.DIED);
                return true;
            }
        }
        return false;
    }

    @Override
	public boolean objectCanBeMovedOver(Locatable l, Direction d) {
      if (l == null || l instanceof Player) {
        	return true;
        }
        return false;
	}
    
	/**
	 * Figures out which ways it can move, and if it can move somewhere, it does. If it is next to the player, it will move in the direction of the player. Decision is made randomly.
	 * TODO: When the player is within a certain range, call an overloaded method with the {@link Location} of the player.
	 * @param random The {@link Random} that is used to make random decisions.
	 */
	public void makeMovementDecision(Random random) {
		Direction[] availableMoves = getValidDirections();
		if (availableMoves.length > 0) {
			Direction decision = availableMoves[random.nextInt(availableMoves.length)];
			Location here = getLocation();
			for (Direction d : availableMoves) {
				if (here.getLocale().getObject(here, d) instanceof Player) {
					decision = d;
					break;
				}
			}
			this.move(decision);
		}
		
	}
	
	/**
	 * Figures out which way this ninja can move, and if it can, it does. It will attempt to move towards the specified {@link Locatable}.
	 * 
	 * @param random The {@link Random} that is used to make random decisions.
	 * @param target the Locatable (probably the player) to move towards
	 */
	public void makeMovementDecision(Random random, Locatable target) {
		Direction[] availableMoves = getValidDirections();
		if (availableMoves.length > 0) {
			Location here = getLocation();
			Direction desiredDir = Direction.getDirectionByLocations(here, target.getLocation());
			Direction decision = availableMoves[random.nextInt(availableMoves.length)];
			
			for (Direction d : availableMoves) {//Move towards the target
				if (d == desiredDir) {
					decision = d;
				}
			}
			
			for (Direction d : availableMoves) {//Move if the player is close
				if (here.getLocale().getObject(here, d) instanceof Player) {
					decision = d;
					break;
				}
			}	
			
			

			this.move(decision);
		}
	}

    /**
     * Getter for {@link #alive}
     * @return value of {@link #alive}
     */
    public boolean isAlive() {
        return alive;
    }
}
