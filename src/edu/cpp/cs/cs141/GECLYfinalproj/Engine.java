package edu.cpp.cs.cs141.GECLYfinalproj;
import edu.cpp.cs.cs141.GECLYfinalproj.powerups.*;
import java.io.File;
import java.lang.reflect.Array;
import java.util.ArrayList;

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
 * This class represents the game engine and is where all of the game logic and operations take place in.
 *
 * @author Gavin Kremer, Eli Zupke
 */
public class Engine {
	
	/**
	 * A reference to the player object that the player is controlling. 
	 */
	private Player player;

    /**
     * A list that will hold all of the ninjas, which will dynamically change over the course of the game and initialization.
     */
	private ArrayList<Ninja> ninjas = new ArrayList<>();//TODO: Do we really need this after initialization? -EAZ

    /**
     * A list that will hold all of the items, which once again will dynamically change over the course of the game and initialization.
     */
	private ArrayList<WorldItem> items = new ArrayList<>();//TODO: Do we really need this after initialization? -EAZ
	/**
	 * A reference to the {@link Grid} that gameplay takes place on, instantiated by {@link #setupGrid(boolean fromSave)} or {@link Engine#loadGame()}.
	 */
	private Grid board;
	/**
	 * The number of turns that have taken place since play has started.
	 */
	private int turnCount;
	
	
	/**
	 * Creates a new instance of the engine for a new game.
	 */
	public Engine() {
		setupGrid(false);
	}
	
	/**
	 * Creates a new instance of the engine from a save file.
	 * 
	 * @param save the save file to load from
	 */
	public Engine(File save) {
		
	}
	
	
	/**
	 * Makes and returns an array of booleans, each representing whether that square is visible to the player. Used by a {@link UserInterface} to figure out what to display to the player.
	 * 
	 * It makes the array by asking the {@link #player} what squares it can see (probably by checking the player's powerups) and by calling the grid's getPosition method on the object to construct the array.
	 * 
	 * This array will then be used by the UI to construct a representation of the game state.
	 * 
	 * @param direction The direction the player is looking, represented as a byte. 0 = up, 1 = right, 2 = down, and 3 = left.
	 * 
	 * @return an array of booleans, with true meaning that square is visible to the player and false meaning that that square is not visible to the player.
	 */
	public boolean[][] getVisibilityArray(byte direction,boolean isDebug) {
		
	    boolean[][] visibility = new boolean[9][9];
        for (int i =0;i<9;++i){
            for (int l =0;l<9;++l){
            	boolean thisSquareVisible = isDebug;
                if (board.getObject(i, l) == player) {
                	thisSquareVisible = true;
                } else if (board.getObject(i, l) instanceof Room) {
                	thisSquareVisible = true;
                }
                visibility[i][l] = thisSquareVisible;
            }
        }
        int pX = player.getLocation().getX();//Store these method calls to save writing and speed up the program
        int pY = player.getLocation().getY();
        int[] x = new int[4]; //This is the list of x locations to check;
        int[] y = new int[4]; //
        //312
        //.0.
        //.p.
        switch (direction){//TODO: Javadoc description direction values don't match actual values?

            case 0://This should probably be covered by some math or looping, rather than this switch statement hell.
            	x[0] = pX -1;	y[0] = pY;			x[1] = pX-2;	y[1] = pY;
            	//From here are coordinates covered by night vision
            	x[2] = pX -2;	y[2] = pY +1;		x[3] = pX -2;	y[3] = pY -1;
                break;
            case 1:
            	x[0] = pX;		y[0] = pY + 1;		x[1] = pX;		y[1] = pY + 2;
            	x[2] = pX +1;	y[2] = pY + 2;		x[3] = pX -1;	y[3] = pY + 2;
            case 2:
            	x[0] = pX +1;	y[0] = pY;			x[1] = pX +2;	y[1] = pY;
            	x[2] = pX +2;	y[2] = pY +1;		x[3] = pX +2;	y[3] = pY -1;
                break;
            case 3:
            	x[0] = pX;		y[0] = pY - 1;		x[1] = pX;		y[1] = pY - 2;
            	x[2] = pX +1;	y[2] = pY - 2;		x[3] = pX -1;	y[3] = pY - 2;
                break;
              
        }
        int goal = (player.hasNightVision()) ? 4 : 2; //Don't check the night vision squares if we don't have night vision.
        for (int i = 0; i < goal; i++ ) {
        	try{visibility[x[i]][y[i]] = true;} catch(IndexOutOfBoundsException ex){/*nothing here*/}//We should probably get out of using this try/catch statement.
        }

	    
		return visibility;
	}

	public Grid getBoard(){
	    return this.board;
    }
	/**
	 * This method instantiates the {@link Grid} object for a new game. It also handles the placement of all {@link Locatable} objects.
	 */
	public void setupGrid(boolean fromSave) {
        if(!fromSave){
            player = new Player();
            for(int i = 0;i<6;++i){
                ninjas.add(new Ninja());
            }
            items.add(new Camo());
            items.add(new ExtraBullet());
            items.add(new Invincibility());
            items.add(new NightVision());
            items.add(new Radar());
            board = new Grid();
            board.stack(player,ninjas,items);
        }
        else{
            //TODO alternative when from a save.
        }
	}
	
	/**
	 * Saves the game-state by using the FileManager to record the {@link #board}, and other miscellaneous attributes like {@link #turnCount}.
	 */
	public void saveGame() {
		
	}
	
	
	/**
	 * Loads the gamestate using the FileManager, and initializes the {@link #board}, and other miscellaneous attributes like {@link #turnCount}.
	 */
	public void loadGame() {
		
	}
	
	
	
}
