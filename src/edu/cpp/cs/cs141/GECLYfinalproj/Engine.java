package edu.cpp.cs.cs141.GECLYfinalproj;
import edu.cpp.cs.cs141.GECLYfinalproj.powerups.*;
import java.io.File;
import java.util.ArrayList;
import java.util.Random;

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
	 * Random number generator for use with random things.
	 */
	Random RNG = new Random();
	
	
	/**
	 * Creates a new instance of the engine for a new game.
	 */
	public Engine() {
		setupGrid();
	}
	
	/**
	 * Creates a new instance of the engine from a save file.
	 * 
	 * @param save the save file to load from
	 */
	public Engine(File save) {
		setupGrid(save);
		
	}
	
	public Player getPlayer() {
		return player;//TODO: Should this be testing only?
	}
	
	
	/**
	 * Makes and returns an array of booleans, each representing whether that square is visible to the player. Used by a {@link UserInterface} to figure out what to display to the player.
	 * 
	 * It makes the array by asking the {@link #player} what squares it can see (probably by checking the player's powerups) and by calling the grid's getPosition method on the object to construct the array.
	 * 
	 * This array will then be used by the UI to construct a representation of the game state.
	 * 
	 * @param direction The direction the player is looking, or null if the player is not looking.
	 * 
	 * @return an array of booleans, with true meaning that square is visible to the player and false meaning that that square is not visible to the player.
	 */
	public boolean[][] getVisibilityArray(Direction direction,boolean isDebug) {
		
	    boolean[][] visibility = new boolean[9][9];
	    boolean isLooking = (direction != null);//If direction == null, then we aren't looking.
        for (int i =0;i<9;++i){
            for (int l =0;l<9;++l){
            	boolean thisSquareVisible = isDebug;
            	Locatable curObj = board.getObject(i,l);
                if (curObj == player) {
                	thisSquareVisible = true;
                } else if (curObj instanceof Room) {
                	thisSquareVisible = true;
                }
                visibility[i][l] = thisSquareVisible;
            }
        }
        int pRow = player.getLocation().getRow();//Store these method calls to save writing and speed up the program
        int pCol = player.getLocation().getCol();
        int[] Row = new int[4]; //This is the list of Row locations to check;
        int[] Col = new int[4]; //
        //312
        //.0.
        //.p.
        if (isLooking) {
	        switch (direction){
	
	            case UP://This should probably be covered by some enum function calls, rather than this switch statement hell.
	            	Row[0] = pRow -1;	Col[0] = pCol;			Row[1] = pRow-2;	Col[1] = pCol;
	            	//From here are coordinates covered by night vision
	            	Row[2] = pRow -2;	Col[2] = pCol +1;		Row[3] = pRow -2;	Col[3] = pCol -1;
	                break;
	            case RIGHT:
	            	Row[0] = pRow;		Col[0] = pCol + 1;		Row[1] = pRow;		Col[1] = pCol + 2;
	            	Row[2] = pRow +1;	Col[2] = pCol + 2;		Row[3] = pRow -1;	Col[3] = pCol + 2;
	            	break;
	            case DOWN:
	            	Row[0] = pRow +1;	Col[0] = pCol;			Row[1] = pRow +2;	Col[1] = pCol;
	            	Row[2] = pRow +2;	Col[2] = pCol +1;		Row[3] = pRow +2;	Col[3] = pCol -1;
	                break;
	            case LEFT:
	            	Row[0] = pRow;		Col[0] = pCol - 1;		Row[1] = pRow;		Col[1] = pCol - 2;
	            	Row[2] = pRow +1;	Col[2] = pCol - 2;		Row[3] = pRow -1;	Col[3] = pCol - 2;
	                break;
	        }
			int goal = (player.hasNightVision()) ? 4 : 2; //Don't check the night vision squares if we don't have night vision.
			for (int i = 0; i < goal; i++) {
				try {
					visibility[Row[i]][Col[i]] = true;
				} catch (IndexOutOfBoundsException ex) {/*nothing here*/}//We should probably get out of using this try/catch statement.
			}
		}
		return visibility;
	}

	public Grid getBoard(){
	    return this.board;
    }
	
	/**
	 * This method instantiates the {@link Grid} object for a new game. It also handles the placement of all {@link Locatable} objects.
	 */
	public void setupGrid() {
		player = new Player();
		for(int i = 0;i<6;++i){
			ninjas.add(new Ninja());
		}
		//items.add(new Camo());
		items.add(new ExtraBullet());
		items.add(new Invincibility());
		//items.add(new NightVision());
		items.add(new Radar());

		board = new Grid();
		board.placeStartingObjects(player,ninjas,items);
		
	}
	public void setupGrid(File save){
		board = FileManager.readSave(save);

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

	/**
	 * This method moves all of the ninjas at the end of turn.
	 */
	public void moveNinjas() {
		for (Ninja N : ninjas) {
			boolean hasMoved;
			int count = 0;
			do{
				hasMoved = randomMove(N);
				++count;
			}
			while(!hasMoved&&count<10);
		}
	}

	public boolean randomMove(Ninja N){
		if (!N.isAlive()) {
			return true;
		}
		if(N.getLocation().getLocale().checkForAdjacent(player,N.getLocation().getRow(),N.getLocation().getCol())&&!(player.getInvincibilityCount()>0)){
			player.kill();
			return true;
		}
		int randomDir = RNG.nextInt(4);
		Direction dir = null;
		switch (randomDir) {
			case 0:
				dir = Direction.LEFT;
				break;
			case 1:
				dir = Direction.UP;
				break;
			case 2:
				dir = Direction.RIGHT;
				break;
			case 3:
				dir = Direction.DOWN;
				break;
		}
		return N.move(dir);
	}


	/**
	 * Checks if the player won
	 * @return truth value
	 */
	public boolean checkWin() {
		//if(player.hasCase() && player.getLocation().getRow() == 8 && player.getLocation().getCol() == 0) {
		return player.hasCase();
	}

	/**
	 * Checks if the player lost
	 * @return truth value
	 */
	public boolean checkLose() {
		if(player.getLives() <= 0) {
			return true;
		}else{
			return false;
		}
	}

	/**
	 * Getter for ninjas
	 * @return ninjas
	 */
	public ArrayList<Ninja> getNinjas() {
		return ninjas;
	}
}
