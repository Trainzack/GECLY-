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
 * @author Gavin Kremer
 */
public class Engine {
	
	/**
	 * A reference to the player object that the player is controlling. 
	 */
	private Player player;

    /**
     * A list that will hold all of the ninjas, which will dynamically change over the course of the game and initialization.
     */
	private ArrayList<Ninja> ninjas = new ArrayList<>();

    /**
     * A list that will hold all of the items, which once again will dynamically change over the course of the game and initialization.
     */
	private ArrayList<WorldItem> items = new ArrayList<>();
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
	public boolean[][] getVisibilityArray(byte direction) {
		return null;
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
            for(int i = 0;i<9;++i){
                for(int l = 0;l<9;++l){
                    System.out.println(board.getObject(i,l));
                }
            }
            System.out.println(board.getBoardState().toString());
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
