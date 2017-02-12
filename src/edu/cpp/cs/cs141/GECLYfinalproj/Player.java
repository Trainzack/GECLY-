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
 * This class represents the Player of the game which is a subclass of the {@link Agent} abstract class.
 * There should only ever be one instance of this class in the game at a time.
 *
 * @author Gavin Kremer
 */
public class Player extends Agent implements Locatable{

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
        super();
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

    /**
     * This method handles the event of a {@link Player} shooting their gun
     */
    public void shoot(){

    }

    /**
     * This method handles a {@link Player} entering a room and searching its contents.
     */
    public void enterRoom(){

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

    @Override
    public void kill() {

    }
}
