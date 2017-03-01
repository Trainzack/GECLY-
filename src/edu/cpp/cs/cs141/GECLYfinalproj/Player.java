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
 * @author GECLY
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
     * Represents the last thing that happened to the player. If null, then nothing important happened to them.
     */
    private Action lastEvent;


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
        this.lastEvent = null;
        this.setASCIIRep('P');
        this.setUnicodeRep('★');
    }

    @Override
    public boolean doSpecificMove(Locatable currentOccupant, int newRow, int newCol,Grid board) {
        if (currentOccupant instanceof WorldItem) {
            ((WorldItem) currentOccupant).apply(this);
            board.removePos(newRow,newCol);
            this.lastEvent = Action.GOTITEM;
            this.lastEvent.appendDesc(((WorldItem) currentOccupant).getName());
        }
        else if (currentOccupant instanceof Ninja){
            if(this.getInvincibilityCount() > 0){
                ((Ninja)currentOccupant).kill();
                this.lastEvent = Action.KILLED;

            }
            else {
                this.kill();
                this.lastEvent = Action.DIED;
                return true;
            }
        }
        else if (currentOccupant instanceof Room){
            this.lastEvent = Action.SEARCHROOM;
            try{
                ((Room)currentOccupant).getContents().apply(this);
                this.lastEvent.appendDesc("and you found "+((Room) currentOccupant).getContents().getName()+"!");
                ((Room) currentOccupant).setContents(null);
            }
            catch(NullPointerException X){
                this.lastEvent.appendDesc("but you found nothing!");
            }
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

    /**
     * setter for {@link #ammo}
     * @param ammo new value of {@link #ammo}
     */
    public void setAmmo(int ammo) {
        this.ammo = ammo;
    }

    /**
     * setter for {@link #invincibilityCount}
     * @param invincibilityCount new value for {@link #invincibilityCount}
     */
    public void setInvincibilityCount(int invincibilityCount) {
        this.invincibilityCount = invincibilityCount;
    }

    /**
     * setter for {@link #hasRadar}
     * @param hasRadar new value for {@link #hasRadar}
     */
    public void setHasRadar(boolean hasRadar) {
        this.hasRadar = hasRadar;
    }

    /**
     * setter for {@link #hasAdvancedNight}
     * @param hasAdvancedNight new value for {@link #hasAdvancedNight}
     */
    public void setHasAdvancedNight(boolean hasAdvancedNight) {
        this.hasAdvancedNight = hasAdvancedNight;
    }

    /**
     * setter for {@link #hasCamo}
     * @param hasCamo new value for {@link #hasCamo}
     */
    public void setHasCamo(boolean hasCamo) {
        this.hasCamo = hasCamo;
    }

    /**
     * setter for {@link #hasCase}
     * @param hasCase new value for {@link #hasCase}
     */
    public void setHasCase(boolean hasCase) {
        this.hasCase = hasCase;
    }

    /**
     * Getter for {@link #ammo}
     * @return value of {@link #ammo}
     */
    public int getAmmo() {
        return ammo;
    }

    /**
     * getter for {@link #lastEvent}
     * @return value of {@link #lastEvent}
     */
    public Action getLastEvent() {
        return lastEvent;
    }

    /**
     * Setter for {@link #lastEvent}
     * @param lastEvent new value for {@link #lastEvent}
     */
    public void setLastEvent(Action lastEvent) {
        this.lastEvent = lastEvent;
    }
}
