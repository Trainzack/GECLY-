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
 * @author GECLY
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
	 * A reference to the {@link Grid} that gameplay takes place on, instantiated by {@link #setupGrid()} or {@link Engine#loadGame()}.
	 */
	private Grid board;

	/**
	 * Random number generator for use with random things.
	 */
	Random RNG = new Random();

	/**
	 * This represents the distance that ninjas have to be from the player before they will track the player. Set this to 0 to stop ninja tracking.
	 */
	private int NINJA_TRACKING_DISTANCE = 0;
	
	
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
	            	Row[2] = pRow -1;	Col[2] = pCol +1;		Row[3] = pRow -1;	Col[3] = pCol -1;
	                break;
	            case RIGHT:
	            	Row[0] = pRow;		Col[0] = pCol + 1;		Row[1] = pRow;		Col[1] = pCol + 2;
	            	Row[2] = pRow +1;	Col[2] = pCol + 1;		Row[3] = pRow -1;	Col[3] = pCol + 1;
	            	break;
	            case DOWN:
	            	Row[0] = pRow +1;	Col[0] = pCol;			Row[1] = pRow +2;	Col[1] = pCol;
	            	Row[2] = pRow +1;	Col[2] = pCol +1;		Row[3] = pRow +1;	Col[3] = pCol -1;
	                break;
	            case LEFT:
	            	Row[0] = pRow;		Col[0] = pCol - 1;		Row[1] = pRow;		Col[1] = pCol - 2;
	            	Row[2] = pRow +1;	Col[2] = pCol - 1;		Row[3] = pRow -1;	Col[3] = pCol - 1;
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

	/**
	 * Getter for {@link #board}
	 * @return value of {@link #board}
	 */
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
		items.add(new Camo());
		items.add(new ExtraBullet());
		items.add(new Invincibility());
		items.add(new NightVision());
		items.add(new Radar());

		board = new Grid();
		board.placeStartingObjects(player,ninjas,items);
		
	}

	/**
	 * This method does the same thing as {@link #setupGrid()}, but from a save.
	 * @param save save file to load from.
	 */
	public void setupGrid(File save){
		board = FileManager.readSave(save);
		player = board.getPlayer();
		ninjas = board.getNinjas();
		items.add(new Camo());
		items.add(new ExtraBullet());
		items.add(new Invincibility());
		items.add(new NightVision());
		items.add(new Radar());


	}

	/**
	 * This method moves all of the ninjas at the end of turn.
	 */
	public void moveNinjas() {
		for (Ninja n : ninjas) {
			if (!n.isAlive()) {
				continue;
			}
			if(n.getLocation().getLocale().checkForAdjacent(player,n.getLocation().getRow(),n.getLocation().getCol())&&!(player.getInvincibilityCount()>0)){
				player.kill();
				player.setLastEvent(Action.DIED);
				break;
			}
			boolean trackPlayer = board.checkForNearLocatable(player, n.getLocation().getRow(), n.getLocation().getCol(), NINJA_TRACKING_DISTANCE);
			if (player.hasCamo()) {
				trackPlayer = false;
			}
			
			if (trackPlayer) {
				n.makeMovementDecision(RNG,player);
			} else {
				n.makeMovementDecision(RNG);
			}
			
			
		}
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

	public void setNINJA_TRACKING_DISTANCE(int val){
		NINJA_TRACKING_DISTANCE = val;
	}
}
