package edu.cpp.cs.cs141.GECLYfinalproj;

/**
 * This class represents the location of a {@link Locatable} object for use with the engine.
 *
 * @author Gavin Kremer
 */
public class Location {


    /**
     * This field represents the locale of the {@link Locatable} object, AKA the {@link Grid} they are located in.
     */
    private Grid locale;

    /**
     * This field represents the first index of the {@link Grid} a {@link Locatable} object is in.
     */
    private int x;

    /**
     * This field represents the second index of the {@link Grid} a {@link Locatable} object is in.
     */
    private int y;

    /**
     * This is the constructor for {@link Location}.
     */
    Location(){

    }

    /**
     * Getter for {@link #locale}
     * @return value of {@link #locale}
     */
    public Grid getLocale() {
        return locale;
    }

    /**
     * Getter for {@link #x}
     * @return value of {@link #x}
     */
    public int getX() {
        return x;
    }

    /**
     * Getter for {@link #y}
     * @return value of {@link #y}
     */
    public int getY() {
        return y;
    }

    /**
     * This method sets the location of an object, by taking coordinates and resetting them.
     * @param x First index of {@link Grid} to set.
     * @param y Second index of {@link Grid} to set.
     */
    public void setPos(int x, int y){
        this.x = x;
        this.y = y;
    }
}
