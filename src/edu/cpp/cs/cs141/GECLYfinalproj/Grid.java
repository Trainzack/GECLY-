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

import java.util.ArrayList;
import java.util.Random;

/**
 * This class represents the grid that the game takes place on and all of the objects interact with each other in,
 * one of the fundamental parts of the game.
 *
 * @author Gavin Kremer
 */

public class Grid {

    /**
     * This field represents the size of the board and is a constant that will be used when creating the board.
     */
    final private int BOARDSIZE = 9;

    /**
     * This field represents the state of the board and will contain different objects that implement {@link Locatable}.
     * The contents of this array usually won't be visible to the player, and is mostly used for the system to locate
     * objects.
     */
    private Locatable[][] boardState = new Locatable[BOARDSIZE][BOARDSIZE];

    /**
     * This field represents a list of base objects that will be placed on the grid if it is being initialized
     * for the first time.
     */
    private static ArrayList<Locatable> baseObjects = new ArrayList<>(81);
    /**
     * This method takes in coordinated and then returns the object located at those coordinates.
     * @param pos1 First array index to search.
     * @param pos2 Second array index to search.
     * @return found object.
     */
    public Locatable getObject(int pos1, int pos2){
        return boardState[pos1][pos2];
    }

    /**
     * This method sets the object located at set of coordinates.
     * @param pos1 First array index to search.
     * @param pos2 Second array index to search.
     */
    public void setPos(int pos1, int pos2,Locatable item) {
        this.boardState[pos1][pos2] = item;
    }

    /**
     * This method removes the object located at a set of coordinates.
     * @param pos1 First array index to search.
     * @param pos2 Second array to search.
     */
    public void removePos(int pos1, int pos2){

    }

    public Locatable[][] getBoardState(){
        return this.boardState;
    }

    public void stack(Player player,ArrayList<Ninja> ninjalist ,ArrayList<WorldItem> itemlist){
        Random RNG = new Random();
        boardState[0][0] = player;
        boardState[1][2] = new Room();
        boardState[1][5] = new Room();
        boardState[1][8] = new Room();
        boardState[4][2] = new Room();
        boardState[4][5] = new Room();
        boardState[4][8] = new Room();
        boardState[7][2] = new Room();
        boardState[7][5] = new Room();
        boardState[7][8] = new Room();
        int briefno = RNG.nextInt(9);
        addbrief(briefno);
        for (int i = 0;i<ninjalist.size();++i){
            int pos1 = RNG.nextInt(9);
            int pos2 = RNG.nextInt(9);
            Locatable spot = boardState[pos1][pos2];
            if(spot == null){
                boardState[pos1][pos2] = ninjalist.get(i);
                }
            else{
                --i;
            }
        }
        for (int i = 0;i < itemlist.size();++i){
            int pos1 = RNG.nextInt(9);
            int pos2 = RNG.nextInt(9);
            Locatable spot = boardState[pos1][pos2];
            if(spot == null){
                boardState[pos1][pos2] = itemlist.get(i);
            }
            else{
                if (spot instanceof Room){
                    ((Room) spot).setContents(itemlist.get(0));
                }
                else{
                    --i;
                }
            }
        }
    }

    public void addbrief(int room){
        switch (room){
            case 0:
                ((Room) boardState[1][2]).setContents(new Briefcase());
                break;
            case 1:
                ((Room) boardState[1][5]).setContents(new Briefcase());
                break;
            case 2:
                ((Room) boardState[1][8]).setContents(new Briefcase());
                break;
            case 3:
                ((Room) boardState[4][2]).setContents(new Briefcase());
                break;
            case 4:
                ((Room) boardState[4][5]).setContents(new Briefcase());
                break;
            case 5:
                ((Room) boardState[4][8]).setContents(new Briefcase());
                break;
            case 6:
                ((Room) boardState[7][2]).setContents(new Briefcase());
                break;
            case 7:
                ((Room) boardState[7][5]).setContents(new Briefcase());
                break;
            case 8:
                ((Room) boardState[7][8]).setContents(new Briefcase());
                break;

        }
    }
}
