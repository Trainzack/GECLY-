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
 * This class represents the Player of the game which is a subclass of the {@link Agent} abstract class.
 * There should only ever be one instance of this class in the game at a time.
 *
 * @author Gavin Kremer
 */
public class Player extends Agent implements Locatable,Serializable{

    /**
     * This field represents the amount of the lives the {@link Player} has, which will be modified by the {@link #kill()}
     * method.
     */
    private int lives;

    /**
     * This field represents the amount of ammo the {@link Player} has, which should never be greater than one.
     */
    private int ammo;

    /**
     * This field represents the amound of turns the {@link Player} has of invincibility, which is applied by {@link edu.cpp.cs.cs141.GECLYfinalproj.powerups.Invincibility}.
     */
    private int invincibilityCount;

    /**
     * This field represents if the {@link Player} has the effect of {@link edu.cpp.cs.cs141.GECLYfinalproj.powerups.Radar}.
     */
    private boolean hasRadar;

    /**
     * This field represents if the {@link Player} has the effect of {@link edu.cpp.cs.cs141.GECLYfinalproj.powerups.NightVision}.
     */
    private boolean hasAdvancedNight;

    /**
     * This field represents if the {@link Player} has the effect of {@link edu.cpp.cs.cs141.GECLYfinalproj.powerups.Camo}.
     */
    private boolean hasCamo;

    /**
     * This field represents if the {@link Player} has the {@link Briefcase}.
     */
    private boolean hasCase;

    /**
     * This is the constructor for {@link Player}, which will super the constructor from {@link Agent}.
     */
    Player(){
        this.lives = 3;
        this.ammo = 1;
        this.invincibilityCount = 0;
        this.hasRadar = false;
        this.hasAdvancedNight = false;
        this.hasCamo = false;
        this.hasCase = false;
        this.setASCIIRep('P');
        this.setUnicodeRep('★');
    }

    @Override
    public boolean doSpecificMove(Locatable currentOccupant, int newRow, int newCol,Grid board) {
        if (currentOccupant instanceof WorldItem) {
            ((WorldItem) currentOccupant).apply(this);
            board.removePos(newRow,newCol);
        }
        else if (currentOccupant instanceof Ninja){
            if(this.getInvincibilityCount() > 0){
                ((Ninja)currentOccupant).kill();
            }
            else {
                this.kill();
                return true;
            }
        }
        else if (currentOccupant instanceof Room){
            try{
                ((Room)currentOccupant).getContents().apply(this);
                ((Room) currentOccupant).setContents(null);
            }catch(NullPointerException X){}
            return true;
        }
        return false;
    }

    /**
     * This method handles the event of a {@link Player} shooting their gun
     */
    public boolean shoot(int direction){
	this.ammo = 0;
        int file;
        switch (direction){
            case 1:
                file = this.getLocation().getRow();
                for(int i =file;i>=0;--i){
                    Locatable spotIndex = this.getLocation().getLocale().getObject(i,this.getLocation().getCol());
                    if (spotIndex instanceof Ninja){
                        ((Ninja)spotIndex).kill();
                        return true;
                    }
                    else if (spotIndex instanceof Room){
                        return false;
                    }
                }
                break;
            case 2:
                file = this.getLocation().getCol();
                for(int i =file;i<=8;++i){
                    Locatable spotIndex = this.getLocation().getLocale().getObject(this.getLocation().getRow(),i);
                    if (spotIndex instanceof Ninja){
                        ((Ninja)spotIndex).kill();
                        return true;
                    }
                    else if (spotIndex instanceof Room){
                        return false;
                    }
                }
                break;
            case 3:
                file = this.getLocation().getRow();
                for(int i =file;i<=8;++i){
                    Locatable spotIndex = this.getLocation().getLocale().getObject(i,this.getLocation().getCol());
                    if (spotIndex instanceof Ninja){
                        ((Ninja)spotIndex).kill();
                        return true;
                    }
                    else if (spotIndex instanceof Room){
                        return false;
                    }
                }
                break;
            case 0:
                file = this.getLocation().getCol();
                for(int i =file;i>=0;--i){
                    Locatable spotIndex = this.getLocation().getLocale().getObject(this.getLocation().getRow(),i);
                    if (spotIndex instanceof Ninja){
                        ((Ninja)spotIndex).kill();
                        return true;
                    }
                    else if (spotIndex instanceof Room){
                        return false;
                    }
                }
                break;
        }
        return false;
    }
    /**
     * This method handles a {@link Player} entering a room and searching its contents.
     */
    public void enterRoom(){
    	
    }

	@Override
	public boolean objectCanBeMovedOver(Locatable l, Direction d) {
		//System.out.println("Testing " + l +" by " + d);
		if (l instanceof Room && d != Direction.DOWN) {
			return false;
		}
		return true;
	}
    

    /**
     * Getter for {@link #hasRadar}
     * @return value of {@link #hasRadar}
     */
    public boolean hasRadar(){
        return this.hasRadar;
    }

    /**
     * Getter for {@link #hasCamo}
     * @return value of {@link #hasCamo}
     */
    public boolean hasCamo(){
        return this.hasCamo;
    }

    /**
     * Getter for {@link #hasAdvancedNight}
     * @return value of {@link #hasAdvancedNight}
     */
    public boolean hasNightVision(){
        return this.hasAdvancedNight;
    }

    /**
     * Getter for {@link #hasCase}
     * @return value of {@link #hasCase}
     */
    public boolean hasCase(){
        return this.hasCase;
    }

    /**
     * Getter for {@link #invincibilityCount}
     * @return
     */
    public int getInvincibilityCount() {
        return invincibilityCount;
    }

    @Override
    public void kill() {
    	setLives(getLives()-1);
    	int curRow = this.getLocation().getRow();
    	int curCol = this.getLocation().getCol();
    	this.getLocation().getLocale().removePos(curRow,curCol);
    	if (this.hasCase()){
    	    this.getLocation().getLocale().setPos(curRow,curCol,new Briefcase());
    	    this.hasCase = false;
        }
        this.getLocation().getLocale().setPos(8,0,this);
    }

	/**
	 * @param lives the lives to set
	 */
	public void setLives(int lives) {
		this.lives = lives;
	}

	/**
	 * @return the lives
	 */
	public int getLives() {
		return lives;
	}

    public void setAmmo(int ammo) {
        this.ammo = ammo;
    }

    public void setInvincibilityCount(int invincibilityCount) {
        this.invincibilityCount = invincibilityCount;
    }

    public void setHasRadar(boolean hasRadar) {
        this.hasRadar = hasRadar;
    }

    public void setHasAdvancedNight(boolean hasAdvancedNight) {
        this.hasAdvancedNight = hasAdvancedNight;
    }

    public void setHasCamo(boolean hasCamo) {
        this.hasCamo = hasCamo;
    }

    public void setHasCase(boolean hasCase) {
        this.hasCase = hasCase;
    }

    public int getAmmo() {
        return ammo;
    }
}
