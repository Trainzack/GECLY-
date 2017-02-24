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
     * (for if they try to move out of bounds for example.) THIS METHOD CAN DEFINITELY BE COMPACTED, BUT FOR NOW WE NEED
     * IT TO JUST WORK.
     * @return if the move was successful or not.
     */
    public boolean move (Direction direction){
        Direction[] valids = this.getValidDirections();
        for(Direction D: valids){
            if(direction == D){
                int currentRow = this.getLocation().getRow();
                int currentCol = this.getLocation().getCol();
                int newRow = currentRow+direction.getRow();
                int newCol = currentCol+direction.getCol();
                Grid board = this.getLocation().getLocale();
                Locatable currentOccupant= board.getObject(newRow,newCol);
                if(this instanceof Player){
                    if (currentOccupant instanceof WorldItem) {
                        ((WorldItem) currentOccupant).apply((Player)this);
                        board.removePos(newRow,newCol);
                    }
                    else if (currentOccupant instanceof Ninja){
                        if(((Player)this).getInvincibilityCount() > 0){
                            ((Ninja)currentOccupant).kill();
                        }
                        else {
                            this.kill();
                            return true;
                        }
                    }
                    else if (currentOccupant instanceof Room){
                        try{
                            ((Room)currentOccupant).getContents().apply((Player)this);
                            ((Room) currentOccupant).setContents(null);
                        }catch(NullPointerException X){}
                        return true;
                    }
                }
                else if (this instanceof Ninja){
                    if (currentOccupant instanceof Player){
                        if(((Player)currentOccupant).getInvincibilityCount()>0){
                            this.kill();
                            return true;
                        }
                        else {
                            ((Player) currentOccupant).kill();
                            return true;
                        }
                    }
                }
                board.setPos(newRow,newCol,this);
                board.removePos(currentRow,currentCol);
                this.getLocation().setPos(newRow,newCol);
                return true;
            }
        }
        return false;
    }
    
	/**
	 * Finds a list of all directions that trying to {@link #move(Direction)} are possible for this agent.
	 * 
	 * @return what directions are valid for movement
	 */
	public Direction[] getValidDirections() {//TODO: Test this method!!!
		ArrayList<Direction> dirList = new ArrayList<Direction>(4);
		
		Direction[] ds = Direction.values(); //This is the working list of directions we can go
		for (Direction d: ds){
            Grid board = this.getLocation().getLocale();
            if (!board.testValidPos(this.getLocation(), d)) {
            	continue; //We can't go this way because it is off the grid
            }
            Locatable objectToMoveTo = board.getObject(this.getLocation(),d);
            if (objectCanBeMovedOver(objectToMoveTo,d)) {
            	dirList.add(d);
            }
            
        }
        return dirList.toArray(new Direction[dirList.size()]);
	}
	
	/**
	 * Checks whether this agent can move to a certain object in a certain direction. Returns true for players moving down into rooms, even though that does not actually result in movement.
	 * 
	 * @param l the object to be moved over
	 * @param d the direction to move in
	 * @return whether a move in the specified direction to a spot on the grid containing the specified object is valid
	 */
	public abstract boolean objectCanBeMovedOver(Locatable l, Direction d);

    /**
     * This method will handle the {@link Agent}'s death, which will be radically different depending on which
     * agent is using it, so it is abstract.
     */
    public abstract void kill();


    /**
     *This is the constructor for {@link Agent}.
     */
    Agent(){
    	location = new Location();
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
