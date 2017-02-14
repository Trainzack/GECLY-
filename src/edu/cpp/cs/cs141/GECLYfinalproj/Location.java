package edu.cpp.cs.cs141.GECLYfinalproj;

import java.io.Serializable;

/**
 * This class represents the location of a {@link Locatable} object for use with the engine.
 *
 * @author Gavin Kremer
 */
public class Location implements Serializable {

    /**
     * This field represents the locale of the {@link Locatable} object, AKA the {@link Grid} they are located in.
     */
    private Grid locale;

    /**
     * This field represents the first index of the {@link Grid} a {@link Locatable} object is in.
     */
    private int Row;

    /**
     * This field represents the second index of the {@link Grid} a {@link Locatable} object is in.
     */
    private int Col;

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
     * Getter for {@link #Row}
     * @return value of {@link #Row}
     */
    public int getRow() {
        return Row;
    }

    /**
     * Getter for {@link #Col}
     * @return value of {@link #Col}
     */
    public int getCol() {
        return Col;
    }

    /**
     * This method sets the location of an object, by taking coordinates and resetting them.
     * @param row First index of {@link Grid} to set.
     * @param col Second index of {@link Grid} to set.
     */
    public void setPos(int row, int col){
        this.Row = row;
        this.Col = col;
    }
}
